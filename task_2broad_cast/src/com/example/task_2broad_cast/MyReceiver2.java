package com.example.task_2broad_cast;

import android.annotation.TargetApi;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class MyReceiver2 extends BroadcastReceiver {
	private NotificationManager manager;
	private Builder builder;

	@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
	@Override
	public void onReceive(Context context, Intent intent) {
		manager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		builder = new Builder(context);
		builder.setContentTitle("Message tiltle")
				.setContentText("Message is delivery2")
				.setSmallIcon(R.drawable.ic_launcher);
		manager.notify(2, builder.build());

	}

}
