package com.example.task48;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class TaskWindow2 extends Activity {
	private final String tag = "B";

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

}
