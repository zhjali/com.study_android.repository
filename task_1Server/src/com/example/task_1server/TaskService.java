package com.example.task_1server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TaskService extends Service {
	private static final String TAG = "TaskService";

	@Override
	public void onCreate() {
		Log.v(TAG, "Service on Create");

		super.onCreate();
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.v(TAG, intent.getStringExtra("key") + " is Unbind in service");

		return super.onUnbind(intent);
	}

	@Override
	public void onDestroy() {
		Log.v(TAG, "service onDstroy");

		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.v(TAG, "service onBind");
		return new MyBinder();
	}

	public class MyBinder extends IQueryInterface.Stub {

		public double query(String fruit) {
			return 2.0;
		}
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.v(TAG, "on Start command");

		return super.onStartCommand(intent, flags, startId);
	}

}
