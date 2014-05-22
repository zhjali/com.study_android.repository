package com.example.task_kaoshi_2;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	public static String NAME = "name";
	public static String URL = "url";
	ArrayList<Data> datas = new ArrayList<Data>();
	Context context;
	LayoutInflater inflater;
	
	
	public ArrayList<Data> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<Data> datas) {
		this.datas = datas;
	}

	public MyAdapter(Context context) {
		super();
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	public MyAdapter(ArrayList<Data> datas, Context context) {
		super();
		this.datas = datas;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		
		if(convertView == null){
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.list_item, null);
			holder.imageView = (ImageView) convertView.findViewById(R.id.imageView1);
			holder.textView = (TextView) convertView.findViewById(R.id.textView1);
			convertView.setTag(holder);
		}else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		holder.textView.setText(""+datas.get(position).getName());
		holder.imageView.setImageResource(R.drawable.ic_launcher);
		new DownLoad(holder.imageView).execute(DownLoad.URL,datas.get(position).getUrl());
		
		return convertView;
	}
	
	public class ViewHolder{
		ImageView imageView;
		TextView textView;
	}
}
