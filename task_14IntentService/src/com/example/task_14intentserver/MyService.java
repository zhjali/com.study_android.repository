package com.example.task_14intentserver;


import android.app.IntentService;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;

public class MyService extends IntentService{

	
	public MyService() {
		this("task");
		// TODO Auto-generated constructor stub
	}
	public MyService(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		Builder builder = new Builder(this)
						.setContentText("正在下载")
						.setContentTitle("下载")
						.setSmallIcon(R.drawable.ic_launcher);
		NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		int pro = 0;
		while (pro < 100) {
			pro++;
			builder.setProgress(100, pro, false);
			manager.notify(4, builder.build());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		builder.setContentText("下载完毕");
		builder.setProgress(100, pro, false);
		manager.notify(4, builder.build());
		manager.cancel(4);
		}

	
}
