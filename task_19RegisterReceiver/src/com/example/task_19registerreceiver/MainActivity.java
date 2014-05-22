package com.example.task_19registerreceiver;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	RegisterReceiver registerReceiver;
	
	@Override
	protected void onStart() {
		super.onStart();
		registerReceiver = new RegisterReceiver();
		IntentFilter filter = new IntentFilter("hello");
		
		registerReceiver(registerReceiver, filter);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void send(View view){
		Intent intent = new Intent();
		intent.setAction("hello");
		intent.putExtra("key", "GO");
		
		sendBroadcast(intent);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver(registerReceiver);
		super.onDestroy();
	}
}
