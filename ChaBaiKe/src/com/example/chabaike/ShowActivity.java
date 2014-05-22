package com.example.chabaike;

import java.util.ArrayList;

import Utils.UriPath;
import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.example.adapter.MyFragmentPgAdapt;
import com.example.adapter.TabAdapter;
import com.example.adapter.TabAdapter.IOperateDrawer;
import com.example.database.TeaProviderMetaData.TableMaindataMetaData;
import com.example.fragment.ShowBaiKe;
import com.example.fragment.ShowJingYing;
import com.example.fragment.ShowShuJv;
import com.example.fragment.ShowTouTiao;
import com.example.fragment.ShowZiXun;

/**
 * 
 * @author Administrator 欢迎界面跳转后的主显示页面
 */
public class ShowActivity extends FragmentActivity {
	private static String TAG = "ShowActivity";
	private ViewPager mViewPager;
	private TabAdapter mTabAdapter;
	private DrawerLayout drawerLayout;
	private long span = System.currentTimeMillis();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show);
		ArrayList<Fragment> fragments = new ArrayList<Fragment>();

		mViewPager = (ViewPager) findViewById(R.id.show_Viewpager);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

		final ActionBar bar = getActionBar();
		bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		bar.setDisplayOptions(0, ActionBar.DISPLAY_SHOW_TITLE);

		mTabAdapter = new TabAdapter(this, mViewPager);

		mTabAdapter.addTab(bar.newTab().setText("头条"), ShowTouTiao.class, null);
		mTabAdapter.addTab(bar.newTab().setText("百科"), ShowBaiKe.class, null);
		mTabAdapter.addTab(bar.newTab().setText("咨询"), ShowZiXun.class, null);
		mTabAdapter
				.addTab(bar.newTab().setText("经营"), ShowJingYing.class, null);
		mTabAdapter.addTab(bar.newTab().setText("数据"), ShowShuJv.class, null);
		// 最后加入的是icon，是用来打开抽屉
		mTabAdapter.addTab(bar.newTab().setIcon(R.drawable.more), Object.class,
				null);
		mTabAdapter.setIOperateDrawer(new IOperateDrawer() {

			@Override
			public void openDrawer() {
				drawerLayout.openDrawer(Gravity.RIGHT);
			}

			@Override
			public void closeDrawer() {

				if (drawerLayout.isDrawerOpen(Gravity.RIGHT)) {
					drawerLayout.closeDrawer(Gravity.RIGHT);
				}
			}
		});

		fragments.add(new ShowTouTiao());
		fragments.add(ShowBaiKe.newInstance(UriPath.BAI_KE,
				TableMaindataMetaData.CATEGORY_BAI_KE));
		fragments.add(ShowZiXun.newInstance(UriPath.ZI_XUN,
				TableMaindataMetaData.CATEGORY_ZI_XUN));
		fragments.add(ShowJingYing.newInstance(UriPath.JING_YING,
				TableMaindataMetaData.CATEGORY_JING_YING));
		fragments.add(ShowShuJv.newInstance(UriPath.SHU_JU,
				TableMaindataMetaData.CATEGORY_SHU_JU));
		mViewPager.setAdapter(new MyFragmentPgAdapt(
				getSupportFragmentManager(), fragments));

		if (savedInstanceState != null) {
			bar.setSelectedNavigationItem(savedInstanceState.getInt("tab"));
		}
		// 只显示tab，隐藏ActionBar的Home和Title
		bar.setDisplayShowHomeEnabled(false);
		bar.setDisplayShowTitleEnabled(false);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt("tab", getActionBar().getSelectedNavigationIndex());
	}

	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.close_Drawer:
			drawerLayout.closeDrawer(Gravity.RIGHT);
			break;

		default:
			break;
		}
	}

	@Override
	public void onBackPressed() {
		Log.d(TAG, "before span: " + span);
		span = System.currentTimeMillis() - span;
		Log.d(TAG, "after span: " + span);

		if (span < 1000) {
			finish();
			super.onBackPressed();
		} else {
			Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
		}
		span = System.currentTimeMillis();
	}
}
