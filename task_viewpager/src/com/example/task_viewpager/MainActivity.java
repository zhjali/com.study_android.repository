package com.example.task_viewpager;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends Activity {
	Intent intent;
	ViewPager pager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		pager = (ViewPager) findViewById(R.id.viewPager);

		ArrayList<View> views = new ArrayList<View>();

		views.add(findViewById(R.id.view1));
		views.add(findViewById(R.id.view2));
		views.add(findViewById(R.id.view3));
		views.add(findViewById(R.id.view4));
		views.add(findViewById(R.id.view5));
		MyPagerAdapter adapter = new MyPagerAdapter(views);

		pager.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private long time;

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			time = System.currentTimeMillis();
			break;
		case MotionEvent.ACTION_UP:
			time = System.currentTimeMillis() - time;
		default:
			break;
		}
		if (time > 300) {

		}
		return super.onTouchEvent(event);
	}
}
