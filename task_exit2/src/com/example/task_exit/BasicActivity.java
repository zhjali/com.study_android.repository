package com.example.task_exit;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class BasicActivity extends Activity {
	SubApplication subApplication;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		subApplication = (SubApplication) getApplication();
		System.out.println(" basic: " + this);
		subApplication.add(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.basic_activiy, menu);
		return true;
	}

	public void exit() {
		subApplication.exit();
	}
}
