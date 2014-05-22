package com.qianfeng.coupon;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter{
	private Context context;
	
	public ViewPagerAdapter(FragmentManager fm,Context context) {
		super(fm);
		this.context=context;
		
	}

	@Override
	public Fragment getItem(int pos) {
		System.out.println("viewpagerAdapter:"+pos);
		Fragment fragment=new MyFragment(pos, context);
		return fragment;
	}

	public int getCount() {
		return 4;
	}

}
