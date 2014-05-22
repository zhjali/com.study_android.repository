package com.qianfeng.coupon;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class ViewAdapter<T> extends BaseAdapter{
	private List<T> list=new ArrayList<T>();
	private LayoutInflater inflater;
	
	public ViewAdapter(List<T> list,Context context){
		this.list=list;
		this.inflater=LayoutInflater.from(context);
	
	}
	
/*	public void addList(List<T> subList){
		this.list.addAll(subList);
	}*/
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int pos) {
		return pos;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parent) {
		
		return initView(pos, convertView);
	}
	
	public abstract View initView(int pos, View convertView);
		

}
