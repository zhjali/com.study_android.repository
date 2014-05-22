package com.example.task_picture_list;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	Context mContext;
	LayoutInflater mInflater;
	ArrayList<ItemData> datas = new ArrayList<ItemData>();

	public MyAdapter(Context mContext, ArrayList<ItemData> datas) {
		super();
		this.mContext = mContext;
		this.datas = datas;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();
			holder.textView = (TextView) convertView
					.findViewById(R.id.textView1);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.imageView1);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText("" + datas.get(position).getName());
		String url = datas.get(position).getImageUrl();
		System.out.println(url);
		ImageLoader.loadImage(holder.imageView, url);
		// holder.imageView.setImageBitmap(getBitmap(url));
		return convertView;
	}

	class ViewHolder {
		TextView textView;
		ImageView imageView;
	}

}
