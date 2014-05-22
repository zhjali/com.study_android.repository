package com.example.task_bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

public class ActyB extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.actb);
		Intent intent = getIntent();
		MyData data = (MyData) intent.getSerializableExtra("data");
		System.out.println("ActyB: " + data);
		System.out.println("X: " + data.x + "Y: " + data.y);
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
