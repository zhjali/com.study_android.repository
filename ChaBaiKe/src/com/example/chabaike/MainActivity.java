package com.example.chabaike;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.example.adapter.MyPagerAdapter;

/**
 * 
 * @author Administrator »¶Ó­Ò³Ãæ
 */
public class MainActivity extends Activity {

	ArrayList<View> views;
	Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ViewPager vPager = (ViewPager) findViewById(R.id.Cover_viewPager);
		LayoutInflater inflater = LayoutInflater.from(this);

		views = new ArrayList<View>();
		views.add(inflater.inflate(R.layout.cover_1, null));
		views.add(inflater.inflate(R.layout.cover_2, null));
		views.add(inflater.inflate(R.layout.cover_3, null));
		vPager.setAdapter(new MyPagerAdapter(views));

		intent = new Intent(this, ShowActivity.class);

	}

	public void jumpMainAc(View view) {
		startActivity(intent);
		finish();
	}

}
