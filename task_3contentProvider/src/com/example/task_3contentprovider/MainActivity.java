package com.example.task_3contentprovider;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.app.Activity;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		String name = null;
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");
		Cursor cursor1 = getContentResolver().query(uri, new String[]{"_id","display_name"}, "contact_id != ?", new String[]{"<null>"}, null);
		while (cursor1.moveToNext()) {
			String id = cursor1.getString(cursor1.getColumnIndex("_id"));
			name = cursor1.getString(cursor1.getColumnIndex("display_name"));
			System.out.println(id+" display name: "+name);

			Uri uri2 = Uri.parse("content://com.android.contacts/data/phones");
			Cursor cursor2 = getContentResolver().query(uri2, 
					new String[]{"data1"}, "raw_contact_id = ?",
					new String[]{id}, null);
			System.out.println(cursor2.getCount());
			while(cursor2.moveToNext()){
				String phone = cursor2.getString(cursor2.getColumnIndex("data1"));
				System.out.println("phone num: "+phone);
			}

			cursor2.close();

		}
		cursor1.close();
		System.out.println("--------------------");
		 ContentValues values = new ContentValues();
		 values.put(RawContacts.ACCOUNT_TYPE, "null");
		 values.put(RawContacts.ACCOUNT_NAME, "null");
		 Uri rawContactUri = getContentResolver().insert(RawContacts.CONTENT_URI, values);
		 long rawContactId = ContentUris.parseId(rawContactUri);
		 values.clear();
		 values.put(Data.RAW_CONTACT_ID, rawContactId);
		 values.put(Data.MIMETYPE, StructuredName.CONTENT_ITEM_TYPE);
		 values.put(StructuredName.DISPLAY_NAME, "2Mike Sullivan");
		 Uri uri2 =  getContentResolver().insert(Data.CONTENT_URI, values);
		 System.out.println("++++"+ContentUris.parseId(uri2));
	}
	
	private void getContactById(int index) {
		Uri uri = Uri.parse("content://com.android.contacts/raw_contacts/"+index);
		Cursor cursor = getContentResolver()
				.query(uri, new String[] { "contact_id", "display_name" },
						null, null, null);

		cursor.moveToNext();

		String contact_id = cursor.getString(cursor
				.getColumnIndex("contact_id"));
		String display_name = cursor.getString(cursor
				.getColumnIndex("display_name"));

		System.out.println(contact_id + "==========" + display_name);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
