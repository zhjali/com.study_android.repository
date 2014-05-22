package com.example.task_2servicve;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.task_2servicve.MyService.MyBinder;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	public static final String url = "http://developer.android.com/wear/images/laptop-bridge.png";
	private ToggleButton toggle;
	private MyService myService;
	private Intent serviceIntent;
	private static ProgressBar bar;
	private MyReceiver receiver;
	private IntentFilter filter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		serviceIntent = new Intent(this, MyService.class);

		bar = (ProgressBar) findViewById(R.id.progressBar1);
		bar.setMax(100);
		toggle = (ToggleButton) findViewById(R.id.toggle_service);
		toggle.setOnCheckedChangeListener(new ToggleButton.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					Log.d(TAG, "点击toggle开始绑定服务");

					MainActivity.this.bindService(serviceIntent, connection,
							MainActivity.BIND_AUTO_CREATE);

				} else {
					myService.setFlag(false);
				}
			}
		});
	}

	@Override
	protected void onResume() {
		receiver = new MyReceiver();
		filter = new IntentFilter(MyReceiver.ACTION);
		registerReceiver(receiver, filter);
		Log.d(TAG, "注册广播");
		super.onResume();
	}

	@Override
	protected void onPause() {
		unregisterReceiver(receiver);
		super.onPause();
	}

	public ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Toast.makeText(MainActivity.this, "与服务器断开连接", Toast.LENGTH_SHORT)
					.show();
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			myService = (MyService) ((MyBinder) service).getService();
			myService.down(url);
			Log.d(TAG, "客户端请求下载图片");

		}
	};

	protected void onDestroy() {
		unbindService(connection);
		super.onDestroy();
	};

	public static class MyReceiver extends BroadcastReceiver {
		public static final String ACTION = MyReceiver.class.getName();

		@Override
		public void onReceive(Context context, Intent intent) {
			Log.d(TAG, "on Receive");

			// 接收到更新广播
			int update = intent.getIntExtra(MyService.KEY_UPDATE, -1);
			if (update != -1) {
				bar.setProgress(update);
				return;
			}

			// 接收到非更新广播
			int result = intent.getIntExtra(MyService.KEY_RESULT, -1);
			switch (result) {
			case MyService.VALUE_SUCCESS:
				Log.d(TAG, "result : success");

				break;
			case MyService.VALUE_FAILURE:
				Log.d(TAG, "result : failure");
				break;
			}
		}
	}
}
