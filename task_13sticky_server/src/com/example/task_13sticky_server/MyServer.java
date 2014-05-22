package com.example.task_13sticky_server;

import java.util.ArrayList;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;

public class MyServer extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("___________Create---------------");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("------------OnDestroy-------------");
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("+++++++onStartCommand");
		System.out.println("flags: "+ flags);
		System.out.println("statId: "+ startId);
		
		String extraString = intent.getStringExtra("Key");
		System.out.println("extra-------"+extraString);
		
		new Thread(
				new Runnable() {
					ArrayList<Bitmap> data = new ArrayList<Bitmap>();
					@Override
					public void run() {
						while(true){
							data.add(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
						}
					}
				}).start();
		
		return Service.START_REDELIVER_INTENT;
	}
	
	@Override
	public void onTaskRemoved(Intent rootIntent) {
		System.out.println("__+__+__+TaskRemove");
		super.onTaskRemoved(rootIntent);
	}
	
	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		System.out.println("=====ONstart");
		super.onStart(intent, startId);
	}
}
