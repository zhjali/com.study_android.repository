package com.example.task48;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TaskWindow extends Activity {
	private final String tag = "A";
	static int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			String success = savedInstanceState.getString("key");
			Log.i("**#&$(@(*&@&#((", success);
		}
		Log.i(tag, "---Oncreate-----");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lifecycle);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("key", "success");
	}

	@Override
	protected void onStart() {
		Log.i(tag, "-----OnStart++++++--");
		super.onStart();
	}

	@Override
	protected void onRestart() {
		Log.i(tag, "-------OnRestart-----");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		Log.i(tag, "++++OnResume....---");
		super.onResume();
		Intent intent = new Intent();
		intent.setClass(this, TaskWindow2.class);
		if (i == 0) {
			startActivity(intent);
			i++;
		}
	}

	@Override
	protected void onPause() {
		Log.i(tag, ".....OnPause-----");
		super.onPause();
	}

	@Override
	protected void onStop() {
		Log.i(tag, "******OnStop-----");
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		Log.i(tag, ">>>>>>>OnDestory-----");
		super.onDestroy();
	}

	public void popupWindow(View view) {

	}
}
