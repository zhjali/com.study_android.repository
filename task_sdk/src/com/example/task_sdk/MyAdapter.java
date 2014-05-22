package com.example.task_sdk;

import java.io.File;
import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	File[] data;
	Context context;
	LayoutInflater inflater;
	
	
	public MyAdapter(Context context) {
		super();
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	public File[] getData() {
		return data;
	}

	public void setData(File[] data) {
		this.data = data;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data[position];
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if(convertView == null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.list_item, null);
			holder.imageView = (ImageView) convertView.findViewById(R.id.imageView1);
			holder.textView = (TextView) convertView.findViewById(R.id.textView1);
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		File file = data[position];
		holder.textView.setText(""+file.getName());
		
		int resourceID = 0;
		if (file.isDirectory()) {
			resourceID = R.drawable.format_folder;
		}if (file.isFile()) {
			if (isPicture(file.getName())) {
				resourceID = R.drawable.format_picture;
			}else{
			resourceID = R.drawable.format_unkown;
			}
		}
		holder.imageView.setImageResource(resourceID);
		return convertView;
	}
	
	public class ViewHolder{
		
		ImageView imageView;
		TextView textView;
	}
	
	public boolean isPicture(String fileName){
		if (!fileName.endsWith(".png")){
			if(!fileName.endsWith(".jpeg")) {
				return false;
			}
		}
		return true;
	}
}
