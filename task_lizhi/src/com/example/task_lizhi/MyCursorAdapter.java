package com.example.task_lizhi;


import com.example.utils.ImageLoader;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
	
public class MyCursorAdapter extends CursorAdapter {

	LayoutInflater inflater;
	
	public MyCursorAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		inflater = LayoutInflater.from(context);
	}

	@Override
	public void bindView(View arg0, Context arg1, Cursor arg2) {
		TextView textView1 = (TextView) arg0.findViewById(R.id.textView1);
		TextView textView2 = (TextView) arg0.findViewById(R.id.textView2);
		ImageView imageView = (ImageView) arg0.findViewById(R.id.imageView1);
		
		textView1.setText(""+arg2.getString(arg2.getColumnIndex("subject")));
		textView2.setText(""+arg2.getString(arg2.getColumnIndex("summary")));
		
		String url = arg2.getString(arg2.getColumnIndex("cover"));
		ImageLoader.loadImage("http://litchiapi.jstv.com"+url,imageView);
	}

	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
		return inflater.inflate(R.layout.list_item, null);
	}
	

}
