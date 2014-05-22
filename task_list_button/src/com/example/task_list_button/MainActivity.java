package com.example.task_list_button;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.GridView;

public class MainActivity extends Activity {
	MyAdapter myAdapter;
	static int times = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid);
		HashMap<String, Object> map;
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		;
		for (int i = 0; i < 30; i++) {
			map = new HashMap<String, Object>();
			map.put("text", "times: " + times++);
			map.put("image", R.drawable.ic_launcher);
			data.add(map);
		}
		String[] from = { "image", "text" };
		int[] to = { R.id.imageView1, R.id.textView1 };
		myAdapter = new MyAdapter(this, R.layout.activity_main, data, from, to);
		GridView gridView = (GridView) findViewById(R.id.grid);
		gridView.setAdapter(myAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
