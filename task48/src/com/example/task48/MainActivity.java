package com.example.task48;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Dialog dialog = new Dialog(this);
		dialog.setTitle("aaa");
		TextView tView = new TextView(this);
		tView.setText("bbb");
		dialog.setContentView(tView);
		dialog.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void showPopupWindow(View v) {
		final PopupWindow window = new PopupWindow();
		// get screen dimension
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		window.setWidth(metrics.widthPixels / 5 * 4);
		window.setHeight(metrics.heightPixels / 5 * 4);
		View view = getLayoutInflater().inflate(R.layout.flat, null);

		window.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.ic_launcher));
		window.setContentView(view);
		window.setFocusable(true);
		view.setOnKeyListener(new View.OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (keyCode == KeyEvent.KEYCODE_MENU)
					window.showAsDropDown(v, 10, 0, Gravity.CENTER);
				return false;
			}

		});
		// window.showAtLocation(v, Gravity.CENTER, 10, 0);
		// window.showAsDropDown(v, 10, 0, Gravity.CENTER);
		window.setContentView(view);
		// 可以获得焦点
		window.setFocusable(true);
		window.showAsDropDown(v, 0, 0);
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		System.out.println("---------onkeyup---" + keyCode);
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			showPopupWindow(findViewById(R.id.button1));
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		System.out.println("------keydown");
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}
}
