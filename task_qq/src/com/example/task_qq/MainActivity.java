package com.example.task_qq;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ArrayList<HashMap<String, Object>> data;
	ListView listView;
	Button button0;
	Button button1;
	TextView textView;
	MyAdater myAdater;
	Calendar date;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myAdater = new MyAdater(this);
		listView = (ListView) findViewById(R.id.listView1);
		button0 = (Button) findViewById(R.id.button0);
		button1 = (Button) findViewById(R.id.button1);
		textView = (TextView) findViewById(R.id.editText1);
		data = myAdater.getData();
		listView.setAdapter(myAdater);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {
		HashMap<String, Object> columns = new HashMap<String, Object>();
		date = Calendar.getInstance();
		String dateString = date.get(Calendar.AM_PM) + " "
				+ date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE);
		columns.put(MyAdater.date, dateString);
		switch (view.getId()) {
		case R.id.button0:
			columns.put(MyAdater.person, 0);
			columns.put(MyAdater.content, textView.getText() + "");
			break;
		case R.id.button1:
			columns.put(MyAdater.person, 1);
			columns.put(MyAdater.content, textView.getText() + "");
			break;
		default:
			break;
		}
		data.add(columns);
		textView.setText("");
		myAdater.notifyDataSetChanged();
		listView.setSelection(data.size());
	}
}
