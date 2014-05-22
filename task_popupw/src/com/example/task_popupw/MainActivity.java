package com.example.task_popupw;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.PopupWindow;

public class MainActivity extends Activity {
	PopupWindow window;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		window = new PopupWindow(this);
		DisplayMetrics metrics = new DisplayMetrics();

		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		window.setHeight(metrics.heightPixels / 3 * 2);
		window.setWidth(metrics.widthPixels / 5 + 3);

		View view = getLayoutInflater().inflate(R.layout.task_popup, null);
		window.setContentView(view);
		// i don't know of that
		window.setFocusable(true);
		window.setAnimationStyle(R.style.window);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void popup(View view) {
		window.showAtLocation(view, Gravity.CENTER_HORIZONTAL, 0, 0);

	}

	public void next(View view) {
		Intent intent = new Intent();
		intent.setClass(this, Second.class);
		startActivity(intent);
		overridePendingTransition(R.anim.lefttoright_in, R.anim.lefttoright_out);
	}
}
