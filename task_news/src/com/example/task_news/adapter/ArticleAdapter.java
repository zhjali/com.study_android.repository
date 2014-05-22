package com.example.task_news.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.task_news.R;
import com.example.task_news.bean.Contens;
import com.example.task_news_net.ImageLoad;

public class ArticleAdapter extends BaseAdapter {
	ArrayList<Contens> artDatas = new ArrayList<Contens>();
	LayoutInflater inflater;
	Context context;

	public ArticleAdapter(Context context) {
		super();
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	public ArrayList<Contens> getArtDatas() {
		return artDatas;
	}

	public void setArtDatas(ArrayList<Contens> artDatas) {
		this.artDatas = artDatas;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return artDatas.size();
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
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.article_item, null);
			holder.textView = (TextView) convertView
					.findViewById(R.id.artical_text);
			holder.imageView = (ImageView) convertView
					.findViewById(R.id.imageView1);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Contens contents = artDatas.get(position);
		System.out.println("================" + contents);
		String category = contents.getCategory();
		if (category.equals("txt")) {
			holder.imageView.setVisibility(View.GONE);
			holder.textView.setText(contents.getText());
		} else if (category.equals("image")) {
			holder.textView.setVisibility(View.GONE);
			RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
					contents.getWidth(), contents.getHeight());
			holder.imageView.setLayoutParams(lp);
			new ImageLoad().loadBitmap(
					"http://litchiapi.jstv.com/" + contents.getLink(),
					holder.imageView);
		}
		return convertView;
	}

	public class ViewHolder {
		TextView textView;
		ImageView imageView;
	}
}
