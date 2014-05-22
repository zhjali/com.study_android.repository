package com.example.task48;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class TaskToast extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);
		Toast toast = new Toast(this);
		toast.setDuration(10000);
		View view = getLayoutInflater().inflate(R.layout.flat, null);
		toast.setView(view);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.show();
	}

}
