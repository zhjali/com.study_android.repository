package com.example.task_bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends Activity {
	public MyData data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		data = new MyData();
		data.setX(8);
		data.setY(6);
		System.out.println("Main: " + data);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_UP:

			Intent intent = new Intent();
			intent.setClass(MainActivity.this, ActyB.class);
			intent.putExtra("data", data);
			startActivityForResult(intent, 12345);
			return true;
		}
		return super.onTouchEvent(event);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 12345 && resultCode == 54321) {
			Toast.makeText(MainActivity.this, data.getStringExtra("A"),
					Toast.LENGTH_LONG).show();
		}
	}
}
