package com.example.task_list_button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context mContext;
	private int layout;
	private ArrayList<HashMap<String, Object>> data;
	private String[] from;
	private int[] to;
	private LayoutInflater mInflater;

	public MyAdapter(Context mContext, int layout,
			ArrayList<HashMap<String, Object>> data, String[] from, int[] to) {
		super();
		this.mContext = mContext;
		this.layout = layout;
		this.data = data;
		this.from = from;
		this.to = to;
		this.mInflater = LayoutInflater.from(mContext);
	}

	public MyAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {

		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(layout, null);
		}
		Map<String, Object> map = data.get(position);

		for (int i = 0; i < to.length; i++) {
			View view = convertView.findViewById(to[i]);
			if (view instanceof TextView) {
				((TextView) view).setText((String) map.get(from[i]));
			}
			if (view instanceof ImageView) {
				((ImageView) view).setImageResource((Integer) map.get(from[i]));
			}
		}
		return convertView;
	}
}
