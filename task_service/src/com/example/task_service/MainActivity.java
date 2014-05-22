package com.example.task_service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	private LocalService mBoundServices;
	private boolean mIsBound = true;
	private static final String TAG = "MainActivity";

	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			mBoundServices = null;
			Toast.makeText(MainActivity.this,
					R.string.local_service_disconnected, Toast.LENGTH_SHORT)
					.show();
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mBoundServices = ((LocalService.LocalBinder) service).getService();
			Toast.makeText(MainActivity.this, R.string.local_service_connected,
					Toast.LENGTH_SHORT).show();
			System.out.println(mBoundServices);
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void doBindService(View view) {
		Log.d(TAG, "bind service");

		Intent intent = new Intent(MainActivity.this, LocalService.class);
		boolean result = bindService(intent, mConnection,
				Context.BIND_AUTO_CREATE);
	}

	public void unBindService() {
		if (mIsBound) {
			unbindService(mConnection);
			mIsBound = false;
		}
	}

	@Override
	protected void onDestroy() {
		unBindService();
		super.onDestroy();
	}

}
