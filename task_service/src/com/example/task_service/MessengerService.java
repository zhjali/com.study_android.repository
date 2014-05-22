package com.example.task_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MessengerService extends Service {

	public static final int MSG_SET_VALUE = 0;
	protected static final Runnable MSG_REGISTER_CLIENT = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	};
	public static final Runnable MSG_UNREGISTER_CLIENT = null;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

}
