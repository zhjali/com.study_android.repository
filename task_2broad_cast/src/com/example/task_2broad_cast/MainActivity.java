package com.example.task_2broad_cast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	BroadcastReceiver receiver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		receiver = new ConnectivityReceiver();
	}

	@Override
	protected void onResume() {
		super.onResume();
		IntentFilter filter = new IntentFilter();
		filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		registerReceiver(receiver, filter);
	}

	@Override
	protected void onPause() {
		super.onPause();
		unregisterReceiver(receiver);
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.normal:
			Intent intent = new Intent("abc");
			sendBroadcast(intent);
			break;
		case R.id.order:
			Intent intent2 = new Intent("abc");
			sendOrderedBroadcast(intent2, null);
			break;
		default:
			break;
		}
	}

	private class ConnectivityReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (NetUtils.isNetWorkConnectivity(context)) {
				Toast.makeText(context, "网络连接正常", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(context, "网络连接异常", Toast.LENGTH_SHORT).show();
			}
		}
	}

}
