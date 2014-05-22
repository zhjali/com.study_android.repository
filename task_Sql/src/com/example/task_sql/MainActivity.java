package com.example.task_sql;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.Menu;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		DataHelper dataHelper = new DataHelper(this);
		
		Cursor cursor = dataHelper.getCursor();
		
		MyAdapter adapter = new MyAdapter(this, cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		getListView().setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
