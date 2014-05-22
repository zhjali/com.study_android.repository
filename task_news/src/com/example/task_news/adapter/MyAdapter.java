package com.example.task_news.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.task_news.R;
import com.example.task_news.R.drawable;
import com.example.task_news.R.id;
import com.example.task_news.R.layout;
import com.example.task_news.bean.News;
import com.example.task_news_net.ImageLoad;

public class MyAdapter extends BaseAdapter {

	ArrayList<News> data = new ArrayList<News>();
	Context mContext;
	LayoutInflater mInflater;

	public MyAdapter(Context mContext) {
		super();
		this.mContext = mContext;
		this.mInflater = LayoutInflater.from(mContext);
	}

	public ArrayList<News> getData() {
		return data;
	}

	public void setData(ArrayList<News> data) {
		this.data = data;
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
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.imageView1);
			holder.subject = (TextView) convertView
					.findViewById(R.id.textView1);
			holder.summary = (TextView) convertView
					.findViewById(R.id.textView2);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.imageView.setImageResource(R.drawable.ic_launcher);
		holder.subject.setText("" + data.get(position).getData().getSubject());
		holder.summary.setText("" + data.get(position).getData().getSummary());
		new ImageLoad().loadBitmap(
				"http://litchiapi.jstv.com/"
						+ data.get(position).getData().getCover(),
				holder.imageView);
		return convertView;
	}

	public class ViewHolder {
		ImageView imageView;
		TextView subject;
		TextView summary;
	}
}
