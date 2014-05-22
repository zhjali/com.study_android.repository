package com.example.task_16downloadserver;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;

public class DownloadService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		dowThread.start();
		return new MyBind();
	}
	@Override
	public void unbindService(ServiceConnection conn) {
		// TODO Auto-generated method stub
		super.unbindService(conn);
	}
	
	private long pro = 0;
	
	Thread dowThread = new Thread(){
		public void run() {
			while( pro < 100 ){
				pro++;
				try {
					Thread.sleep(300);
					setPro(pro);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	};

	public class MyBind extends Binder{
		public MyBind(){
		}
		public long getPro(){
			return pro;
		}
		
	}
	
	public void setPro(long pro){
		this.pro = pro;
	}
}
