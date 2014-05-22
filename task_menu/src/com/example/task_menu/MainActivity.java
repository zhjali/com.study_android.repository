package com.example.task_menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		MyResponse myResponse = new MyResponse(MainActivity.this);
		int group1 = 1;
		menu.add(group1, 1, 0, "append").setOnMenuItemClickListener(myResponse);
		menu.add(0, 2, 1, "item2").setOnMenuItemClickListener(myResponse);
		int group2 = 2;
		menu.add(group2, 3, 2, "item3").setOnMenuItemClickListener(myResponse);
		menu.add(group2, 4, 3, "item4").setOnMenuItemClickListener(myResponse);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		String display = null;
		switch (item.getItemId()) {
		case 1:
			display = "1";
			break;
		case 2:
			display = "2";
			break;
		case 3:
			display = "3";
			break;
		case 4:
			display = "4";
			break;

		default:
			return super.onOptionsItemSelected(item);
		}
		Toast.makeText(MainActivity.this, display, Toast.LENGTH_SHORT).show();
		return true;
	}
}
