package com.example.task_16downloadserver;

import java.util.Timer;
import java.util.TimerTask;

import com.example.task_16downloadserver.DownloadService.MyBind;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.widget.ProgressBar;

public class MainActivity extends Activity {
	public MyBind myBind;
	private ProgressBar bar;
	
	private ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("Service disconnected");
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("Service name: "+name.getClassName());
			myBind = (MyBind) service;
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bar = (ProgressBar) findViewById(R.id.progressBar1);
		bar.setMax(100);
		
		bindService(new Intent(this,DownloadService.class), conn, Context.BIND_AUTO_CREATE);
		
		new Timer().schedule(new TimerTask() {
			
			@Override
			public void run() {
				if (myBind != null) {
					bar.setProgress((int) myBind.getPro());
				}
			}
		}, 0, 300);
		
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbindService(conn);
	}
	
}
