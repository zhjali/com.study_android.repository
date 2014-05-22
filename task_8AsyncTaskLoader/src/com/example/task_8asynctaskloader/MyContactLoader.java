package com.example.task_8asynctaskloader;

import java.util.*;

import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.RawContacts;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MyContactLoader extends AsyncTaskLoader<List<Map<String,Object>>>{
	private ListView listView;
	private List<Map<String, Object>> data;
	private SimpleAdapter adapter;
	
	public MyContactLoader(Context context,ListView listView){
		super(context);
		this.listView = listView;
		data = new ArrayList<Map<String,Object>>();
		adapter = new SimpleAdapter(context,
				data,
				R.layout.list_item, 
				new String[]{"name","phone","address"},
				new int[]{R.id.textView1,R.id.textView2,R.id.textView3});
		this.listView.setAdapter(adapter);
	}
	
	@Override
	protected void onStartLoading() {
		super.onStartLoading();
		forceLoad();
	}
	
	@Override
	public List<Map<String, Object>> loadInBackground() {
		return getContacts();
	}

	private List<Map<String, Object>> getContacts() {
	    List<Map<String, Object>> data = new ArrayList<Map<String,Object>>();
		
		ContentResolver resolver = getContext().getContentResolver();
		Cursor cursor = resolver.query(RawContacts.CONTENT_URI, new String[]{"_id","display_name"}, null, null,null, null);
		while(cursor.moveToNext()){
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			String name = getColumnString(cursor, "display_name");
			String raw_id = getColumnString(cursor, "_id");
			map.put("name", name);
			map.put("raw_id", raw_id);
			
			if (name == null || name.equals("")) {
				continue;
			}
			 
			String phone = null;
			Cursor cursor2 = resolver.query(Phone.CONTENT_URI,
				new String[]{Phone.NUMBER}, 
				Phone.RAW_CONTACT_ID+" = ?", 
				new String[]{raw_id},
				null);
			while(cursor2.moveToNext()){
			 phone = getColumnString(cursor2, Phone.NUMBER);
			}
			map.put("phone", phone);
			cursor2.close();
			
			String address = null;
			Cursor cursor3 = resolver.query(Email.CONTENT_URI, 
					new String[]{Email.ADDRESS,Email.TYPE}, 
					Email.RAW_CONTACT_ID + " = ?", 
					new String[]{raw_id}, 
					null);
			while(cursor3.moveToNext()){
			address = getColumnString(cursor3, Email.ADDRESS);
			}
			map.put("address", address);
			cursor3.close();
			
			
			data.add(map);
			System.out.println("DisplayName: "+name+" PhoneNum: "+phone+" Address: "+address);
//			System.out.println("DisplayName: "+name+" PhoneNum: "+phone);
		}
		cursor.close();
		return data;
	}
	
	public String getColumnString(Cursor cursor,String columnName){
		return cursor.getString(cursor.getColumnIndex(columnName));
	}
	
	@Override
	public void deliverResult(List<Map<String, Object>> data) {
		// TODO Auto-generated method stub
		super.deliverResult(data);
		this.data.addAll(data);
		adapter.notifyDataSetChanged();
	}

}
