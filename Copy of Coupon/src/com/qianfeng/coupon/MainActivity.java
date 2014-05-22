package com.qianfeng.coupon;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;

public class MainActivity extends FragmentActivity {
	private static final String TAG = "MainActivity";

	private RadioGroup radioGroup;
	private FragmentManager fragmentManager;
	private LinearLayout mainLayout;
	private RelativeLayout homepageLayout;
	private SearchFragment searchFragment;
	private GroupFragment groupFragment;
	private FragmentTransaction transaction;
	private FavorFragment favorFragment;
	private AroundFragment aroundFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		initView();

		fragmentManager = getSupportFragmentManager();
		transaction = fragmentManager.beginTransaction();
		if (searchFragment == null) {
			searchFragment = new SearchFragment(MainActivity.this);
		}
		transaction.replace(R.id.fragment_container, searchFragment);
		transaction.commit();

		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				// 主页
				case R.id.homepageButton:
					Log.d(TAG, "homePageButton");
					transaction = fragmentManager.beginTransaction();
					if (searchFragment == null) {
						searchFragment = new SearchFragment(MainActivity.this);
					}
					transaction
							.replace(R.id.fragment_container, searchFragment);
					transaction.commit();
					break;
				// 周边
				case R.id.rimButton:
					// System.out.println("favor");
					transaction = fragmentManager.beginTransaction();
					if (aroundFragment == null) {
						aroundFragment = new AroundFragment(MainActivity.this);
					}

					transaction
							.replace(R.id.fragment_container, aroundFragment);
					transaction.commit();
					break;
				// 团购
				case R.id.groupbuyButton:
					System.out.println("favor");
					transaction = fragmentManager.beginTransaction();
					if (groupFragment == null) {
						groupFragment = new GroupFragment(MainActivity.this);
					}

					transaction.replace(R.id.fragment_container, groupFragment);
					transaction.commit();
					break;
				// 优惠
				case R.id.privilegeButton:
					transaction = fragmentManager.beginTransaction();
					if (favorFragment == null) {
						favorFragment = new FavorFragment(MainActivity.this);
					}
					transaction.replace(R.id.fragment_container, favorFragment);
					transaction.commit();
					break;

				default:
					break;
				}
			}
		});

	}

	public void initView() {
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		// viewPager = (ViewPager) findViewById(R.id.viewPager);
		mainLayout = (LinearLayout) findViewById(R.id.mainLayout);

	}

}
