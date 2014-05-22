package com.example.task_2server;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.task_1server.IQueryInterface;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private Intent intent;
	private ToggleButton toggleButton;
	private Button query;
	private IQueryInterface queryInterface;
	private ServiceConnection conn = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.v(TAG, "on service Connected");
			queryInterface = IQueryInterface.Stub.asInterface(service);
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.v(TAG, "service disconnected");
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		intent = new Intent("com.example.task_1server.TaskService");
		intent.putExtra("key", "value");
		toggleButton = (ToggleButton) findViewById(R.id.toggleButton1);
		query = (Button) findViewById(R.id.query);

	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.toggleButton1:
			Log.v(TAG, "toggle check");
			if (toggleButton.isChecked()) {
				bindService(intent, conn, Context.BIND_AUTO_CREATE);
				query.setEnabled(true);
				return;
			} else {
				Log.v(TAG, "unbined");
				unbindService(conn);
				query.setEnabled(false);
			}
			break;
		case R.id.query:
			Log.v(TAG, "query check");

			double result = 0.0;
			try {
				result = queryInterface.query("banana");
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Toast.makeText(this, "banana price is " + result,
					Toast.LENGTH_SHORT).show();
			break;
		}
	}

	@Override
	protected void onDestroy() {
		Log.v(TAG, "client onDestroy ");
		super.onDestroy();
	}
}
