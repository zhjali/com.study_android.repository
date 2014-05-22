package com.example.adapter;

import java.util.ArrayList;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public class MyPagerAdapter extends PagerAdapter {
	private ArrayList<? extends View> datas;

	public ArrayList<? extends View> getDatas() {
		return datas;
	}

	public void setDatas(ArrayList<? extends View> datas) {
		this.datas = datas;
	}

	public MyPagerAdapter(ArrayList<? extends View> datas) {
		super();
		this.datas = datas;
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		datas.get(position);
		container.addView(datas.get(position));
		return datas.get(position);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(datas.get(position));
	}

}
