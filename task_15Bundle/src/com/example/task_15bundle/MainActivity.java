package com.example.task_15bundle;

import com.example.task_15bundle.MyService.MyBind;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	MyBind bind;
	
	private ServiceConnection conn = new ServiceConnection(
	) {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("disaconnect");
			return;
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("service connecte");
			
			bind = (MyBind) service;
			bind.main();
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void bind(View view){
		Intent  i =new Intent();
		i.setClass(this, MyService.class);
		bindService(i,	conn,Context.BIND_AUTO_CREATE);
	}
	
	public void unBind(View view){
		
		super.unbindService(conn);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbindService(conn);
	}
}
