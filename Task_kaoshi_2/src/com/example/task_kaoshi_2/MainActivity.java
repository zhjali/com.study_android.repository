package com.example.task_kaoshi_2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	String url = "http://192.168.56.1/mydata.json";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		MyAdapter myAdapter = new MyAdapter(this);
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(myAdapter);
		
		new DownLoad(myAdapter).execute(DownLoad.DATA,url);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
