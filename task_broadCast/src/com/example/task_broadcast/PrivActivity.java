package com.example.task_broadcast;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PrivActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_priv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.priv, menu);
		return true;
	}

}
