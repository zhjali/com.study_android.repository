package com.example.task_15bundle;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("create_________-------");
	}
	@Override
	public IBinder onBind(Intent intent) {
		return new MyBind();
	}
	
	public class MyBind extends Binder{
		public void main(){
			methodB();
		};
	}
	
	public void methodB(){
		System.out.println("hello world i'm b");
	}

	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("on Unbind");
		return super.onUnbind(intent);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("already destory");
	}
}
