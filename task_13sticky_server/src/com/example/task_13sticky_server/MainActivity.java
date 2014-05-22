package com.example.task_13sticky_server;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void start(View view){
		System.out.println("start button is click");
		Intent intent = new Intent();
		intent.putExtra("Key", "Value");
		intent.setClass(this, MyServer.class);
		startService(intent);
	}
	
	public void stop(View view){
		System.out.println("Stop button is click");
		stopService(new Intent(this, MyServer.class));
	}

}
