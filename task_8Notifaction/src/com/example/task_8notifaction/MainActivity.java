package com.example.task_8notifaction;

import android.app.Activity;
import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends Activity {

	NotificationManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add(Menu.CATEGORY_SYSTEM, Menu.CATEGORY_SYSTEM + 1, 1,
				"Send broadcast");
		menu.add(Menu.CATEGORY_SYSTEM, Menu.CATEGORY_SYSTEM + 2, 2,
				"Open contact");
		menu.add(Menu.CATEGORY_SYSTEM, Menu.CATEGORY_SYSTEM + 3, 4,
				"Open private Activiy");
		return true;
	}

	public void onClick(View view) {
		Notification notification = new Notification(R.drawable.ic_launcher,
				"Hello World", System.currentTimeMillis());

		Intent intent = new Intent();
		intent.setClass(this, OtherActivity.class);
		PendingIntent pendIntent = PendingIntent.getActivity(this, 0, intent,
				PendingIntent.FLAG_UPDATE_CURRENT);

		notification.flags = Notification.FLAG_AUTO_CANCEL;
		notification.setLatestEventInfo(this, "title", "content", pendIntent);

		manager.notify(0, notification);
	}

	public void normal(View view) {
		Intent intent = new Intent(this, OtherActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				intent, PendingIntent.FLAG_CANCEL_CURRENT);

		Builder builder = new Builder(this).setAutoCancel(true)
				.setContentTitle("title").setContentInfo("info")
				.setContentText("text").setUsesChronometer(true)
				.setSmallIcon(R.drawable.ic_launcher)
				.setContentIntent(pendingIntent);

		manager.notify(1, builder.build());
	}

	public void bigImage(View view) {
		Builder builder = new Builder(this);

		builder.setContentText("text").setContentTitle("title")
				.setTicker("Big Picture is coming")
				.setSmallIcon(R.drawable.ic_launcher);

		BigPictureStyle style = new BigPictureStyle(builder);
		style.bigPicture(BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher));

		manager.notify(2, builder.build());
	}

	public void custom(View view) {
		Builder builder = new Builder(this);
		RemoteViews views = new RemoteViews(getPackageName(),
				R.layout.notification_item);
		builder.setContent(views);

		views.setTextViewText(R.id.textView1, "custom");
		views.setTextColor(R.id.textView1, Color.WHITE);
		views.setImageViewResource(R.id.imageView1, R.drawable.qzone_guide_sign);

		builder.setSmallIcon(R.drawable.ic_launcher);

		manager.notify(3, builder.build());
	}

	public void progress(View view) {
		System.out.println("hlejeljle");
		final Builder builder = new Builder(this);
		builder.setContentText("text")
				.setContentTitle("title")
				.setTicker("progress coming")
				.setProgress(100, 0, false)
				.setSmallIcon(R.drawable.ic_launcher)
				.setLargeIcon(
						(BitmapFactory.decodeResource(getResources(),
								R.drawable.qzone_guide_sign)));
		manager.notify(4, builder.build());

		new Thread(new Runnable() {

			@Override
			public void run() {
				int pro = 0;
				while (pro < 100) {
					pro++;
					builder.setProgress(100, pro, false);
					manager.notify(4, builder.build());
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				builder.setContentText("Download Success");
				builder.setProgress(100, pro, false);
				manager.notify(4, builder.build());
				manager.cancel(4);
			}
		}).start();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case Menu.CATEGORY_SYSTEM + 2:
			Intent intent = new Intent(Intent.ACTION_CALL,
					Uri.parse("tel://123"));
			startActivity(intent);
			break;
		case Menu.CATEGORY_SYSTEM + 3:
			Intent intent2 = new Intent();
			intent2.setClassName("com.example.task_broadcast",
					"com.example.task_broadcast.PrivActivity");
			startActivity(intent2);
			break;
		}
		return true;
	}
}
