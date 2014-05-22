package com.example.task_exit;

import android.os.Bundle;
import android.view.Menu;

public class ActC extends BasicActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println(" ActC: " + this);
		setContentView(R.layout.activity_act_c);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.act_c, menu);
		return true;
	}

	@Override
	public void onBackPressed() {
		exit();

	}

}
