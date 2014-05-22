package com.example.task_bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class ActyB extends Activity {
	MyApp myApp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actb);
		myApp = (MyApp) getApplication();
		System.out.println("X: " + myApp.getX());
		System.out.println("Y: " + myApp.getY());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.acty_b, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		Intent intent = new Intent();
		intent.putExtra("A", "A");
		setResult(54321, intent);
		finish();
	}
}
