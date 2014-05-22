package com.example.adapter;

import java.util.ArrayList;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPgAdapt extends FragmentPagerAdapter {
	ArrayList<Fragment> datas = new ArrayList<Fragment>();

	public MyFragmentPgAdapt(FragmentManager fragmentManager,
			ArrayList<Fragment> fragments) {
		super(fragmentManager);
		datas.addAll(fragments);
	}

	@Override
	public Fragment getItem(int arg0) {
		return datas.get(arg0);
	}

	@Override
	public int getCount() {
		return datas.size();
	}

}
