package com.example.adapter;

import java.util.ArrayList;

import Utils.LoadCache;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chabaike.R;
import com.example.entity.TouTiaoLVEntity;

public class MyListViewAdapter extends BaseAdapter {
	private Context mContext;
	private LayoutInflater mInflater;
	private ArrayList<TouTiaoLVEntity> datas = new ArrayList<TouTiaoLVEntity>();

	public ArrayList<TouTiaoLVEntity> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<TouTiaoLVEntity> datas) {
		this.datas = datas;
	}

	public MyListViewAdapter(Context mContext) {
		super();
		this.mContext = mContext;
		mInflater = LayoutInflater.from(this.mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (datas != null) {
			return datas.size();
		}
		return 0;
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
			convertView = mInflater.inflate(R.layout.show_list_item, null);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.title);
			holder.source = (TextView) convertView.findViewById(R.id.source);
			holder.nickName = (TextView) convertView
					.findViewById(R.id.nick_name);
			holder.createTime = (TextView) convertView
					.findViewById(R.id.create_time);
			holder.wapThumb = (ImageView) convertView
					.findViewById(R.id.wap_thumb);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		TouTiaoLVEntity lvEntity = datas.get(position);
		holder.title.setText(lvEntity.getTitle());
		holder.source.setText(lvEntity.getSource());
		holder.nickName.setText(lvEntity.getNickName());
		holder.createTime.setText(lvEntity.getCreateTime());
		holder.wapThumb.setImageResource(R.drawable.defaultcovers);
		LoadCache.setBitmapToView(lvEntity.getWapThumb(), holder.wapThumb);
		return convertView;
	}

	class ViewHolder {
		TextView title;
		TextView source;
		TextView nickName;
		TextView createTime;
		ImageView wapThumb;
	}

}
