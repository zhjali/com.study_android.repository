package com.example.list;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class Task extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView lv = getListView();
		// content://com.android.contacts/contacts
		Cursor c = managedQuery(Contacts.CONTENT_URI, null, null, null,
				Contacts.DISPLAY_NAME + " ASC");
		String[] colns = new String[] { Contacts.DISPLAY_NAME };
		int[] views = { R.id.text1 };
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
				R.layout.task1, c, colns, views);
		this.setListAdapter(adapter);
	}
}
