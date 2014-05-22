package com.example.task_broadcast;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TestReceiver extends BroadcastReceiver {
	private static final String TAG = "TestReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Utils.longThreadSignature(TAG);

		Notification notification = new Notification.Builder(context)
				.setTicker("BroadCast comming").setAutoCancel(true)
				.setContentText("Receive a broadcast").setContentInfo("info")
				.setContentTitle("Broadcast").build();
		NotificationManager manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		manager.notify(1, notification);
	}
}
