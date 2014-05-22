package com.example.task_sql;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends CursorAdapter {

	public MyAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bindView(View arg0, Context arg1, Cursor arg2) {
		int id = arg2.getInt(arg2.getColumnIndex("_id"));
		String name = arg2.getString(arg2.getColumnIndex("name"));
		int age = arg2.getInt(arg2.getColumnIndex("age"));
		int score = arg2.getInt(arg2.getColumnIndex("score"));
		
		String result = "id: "+id+" name: "+name+" age: "+age+" score: "+score;
		((TextView)arg0.findViewById(R.id.textView1)).setText(result+"");

	}

	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
		LayoutInflater inflater = LayoutInflater.from(arg0);
		
		return inflater.inflate(R.layout.list_item, null);
	}

}
