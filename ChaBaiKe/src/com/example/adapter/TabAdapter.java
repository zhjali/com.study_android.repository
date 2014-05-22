package com.example.adapter;

import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;

public class TabAdapter extends FragmentPagerAdapter implements
		ActionBar.TabListener, OnPageChangeListener {
	private final String TAG = "TabAdapter";

	private final Context mcontext;
	private final ActionBar mActionBar;
	private final ViewPager mViewPager;
	private final ArrayList<TabInfo> mTabs = new ArrayList<TabAdapter.TabInfo>();
	private IOperateDrawer iDrawer = new IOperateDrawer() {

		@Override
		public void openDrawer() {
			// TODO Auto-generated method stub

		}

		@Override
		public void closeDrawer() {
			// TODO Auto-generated method stub

		}
	};

	public IOperateDrawer getIOperateDrawer() {
		return iDrawer;
	}

	public void setIOperateDrawer(IOperateDrawer drawer) {
		this.iDrawer = drawer;
	}

	static final class TabInfo {
		private final Class<?> clss;
		private final Bundle arg;

		public TabInfo(Class<?> clss, Bundle args) {
			super();
			this.clss = clss;
			this.arg = args;
		}
	}

	public TabAdapter(FragmentActivity activity, ViewPager pager) {
		super(activity.getSupportFragmentManager());
		mcontext = activity;
		mViewPager = pager;
		mActionBar = activity.getActionBar();
		mViewPager.setAdapter(this);
		mViewPager.setOnPageChangeListener(this);
	}

	public void addTab(ActionBar.Tab tab, Class<?> clss, Bundle args) {
		TabInfo info = new TabInfo(clss, args);
		tab.setTag(info);
		tab.setTabListener(this);
		mTabs.add(info);
		mActionBar.addTab(tab);
		notifyDataSetChanged();

	}

	@Override
	public Fragment getItem(int arg0) {
		TabInfo info = mTabs.get(arg0);
		return Fragment.instantiate(mcontext, info.clss.getName(), info.arg);
	}

	@Override
	public int getCount() {
		return mTabs.size();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int arg0) {
		mActionBar.setSelectedNavigationItem(arg0);
	}

	@Override
	public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
		Log.d(TAG, "TabSelected");

		Object tag = tab.getTag();
		// 不匹配最后一个用于打开抽屉的tab
		for (int i = 0; i < mTabs.size() - 1; i++) {
			if (mTabs.get(i) == tag) {
				Log.d(TAG, "the Tab id:" + i);
				mViewPager.setCurrentItem(i);
				iDrawer.closeDrawer();
				return;
			}
		}
		// 执行到此处表示，用户点击的是最后一个用于打开抽屉的tab
		iDrawer.openDrawer();
	}

	/**
	 * 
	 * ActionBar的Tab对DrawLayout的处理。
	 */
	public interface IOperateDrawer {

		public void openDrawer();

		public void closeDrawer();
	}

	@Override
	public void onTabUnselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabReselected(Tab tab, android.app.FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

}
