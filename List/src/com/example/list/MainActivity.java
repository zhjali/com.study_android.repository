package com.example.list;

import android.app.ListActivity;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity implements OnItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView lv = getListView();
		Cursor c = managedQuery(Contacts.CONTENT_URI, null, null, null,
				Contacts.DISPLAY_NAME + " ASC");
		String[] cols = new String[] { Contacts.DISPLAY_NAME };
		int[] views = new int[] { android.R.id.text1 };
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_dropdown_item_1line, c, cols, views);
		this.setListAdapter(adapter);
		lv.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Log.v("ListViewAcivity",
				"in on ItemClick with" + ((TextView) view).getText()
						+ ". Position = " + position + ".Id= " + id);
		Uri selectedPersonUri = ContentUris.withAppendedId(
				Contacts.CONTENT_URI, id);
		Intent intent = new Intent(Intent.ACTION_VIEW, selectedPersonUri);
		startActivity(intent);
	}
}
