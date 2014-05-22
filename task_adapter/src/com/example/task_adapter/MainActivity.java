package com.example.task_adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView listView = (ListView) findViewById(R.id.listView1);
		String[] texts = { "zhao", "jia", "liang" };
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				R.layout.list_item, R.id.textView1, texts);
		listView.setAdapter(arrayAdapter);
		// ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1);
		// arrayAdapter2.add("nihao");
		// for (int i = 0; i < 10; i++) {
		// arrayAdapter2.add("item: " + i);
		// }
		// listView.setAdapter(arrayAdapter2);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
