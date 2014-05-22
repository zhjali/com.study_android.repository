package com.qianfeng.coupon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * 
 * @author Administrator
 *首页的Fragment
 */
@SuppressLint("ValidFragment")
public class SearchFragment extends Fragment {
	private RelativeLayout homepageLayout;
	private ScrollView scrollView;
	private LinearLayout scrollChildLayout;

	private LinearLayout innerLinearLayout;

	private LayoutInflater inflater;

	private Context context;
	ActivityInfo[] activitys = { new ActivityInfo(FoodActivity.class) };

	private String[] textArr = { "餐饮美食", "休闲娱乐", "生活服务", "电影票", "酒店", "摄影写真",
			"丽人", "最新活动" };

	Integer[] imageIds = { R.drawable.cat_1, R.drawable.cat_2,
			R.drawable.cat_3, R.drawable.cat_4, R.drawable.cat_5,
			R.drawable.cat_6, R.drawable.cat_7, R.drawable.cat_8 };

	private String[] classArr = { "火锅", "KTV", "酒吧", "足疗按摩", "蛋糕甜品", "ATM",
			"美发", "自助餐" };

	Integer[] otherImageIds = { R.drawable.ad_1, R.drawable.ad_2,
			R.drawable.ad_3, R.drawable.ad_4, R.drawable.ad_5, R.drawable.ad_6,
			R.drawable.ad_7, R.drawable.ad_8, R.drawable.ad_9,
			R.drawable.ad_10, R.drawable.ad_13, R.drawable.ad_14 };

	public SearchFragment() {

	}

	public SearchFragment(Context context) {
		this();
		this.context = context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater = inflater;
		//三个区域：首页北京一栏headLayout，搜索一栏searchLayout，scrollView
		homepageLayout = (RelativeLayout) inflater.inflate(R.layout.homepage,
				null);
		scrollView = (ScrollView) homepageLayout.findViewById(R.id.scrollView);
		//三个lineaLayout
		scrollChildLayout = (LinearLayout) inflater.inflate(
				R.layout.homepage_scroll_child, null);
		//imageView,textView
		makeLayout(R.id.imageOuterLayout, R.layout.image_gridview_item,
				textArr.length);
		//textView
		makeLayout(R.id.textOuterLayout, R.layout.text_gridview_item,
				textArr.length);
		//imageView
		makeLayout(R.id.hotOuterLayout, R.layout.hot_gridview_item,
				otherImageIds.length);
		scrollView.addView(scrollChildLayout);

		return homepageLayout;
	}

	public void makeLayout(int outerResId, int itemResId, int length) {

		LinearLayout outerLayout = (LinearLayout) scrollChildLayout
				.findViewById(outerResId);
		for (int i = 0; i < length / 4; i++) {
			System.out.println(i);
			innerLinearLayout = new LinearLayout(context);
			LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.WRAP_CONTENT);

			innerLinearLayout.setLayoutParams(layoutParams1);
			innerLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
			for (int j = 0; j < 4; j++) {

				LinearLayout itemLayout = (LinearLayout) inflater.inflate(
						itemResId, null);
				// 设置监听器
				int pos = i * 4 + j;
				itemLayout.setOnClickListener(new OnItemClickListener(
						outerResId, pos));

				addData(pos, itemResId, itemLayout);
				innerLinearLayout.addView(itemLayout);
				LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) itemLayout
						.getLayoutParams();
				lp.topMargin = 40;
				lp.leftMargin = 20;
				lp.width = 0;
				lp.weight = 1;
				itemLayout.setLayoutParams(lp);
			}
			outerLayout.addView(innerLinearLayout);
		}

	}

	class OnItemClickListener implements OnClickListener {
		private int outerResId;
		private int pos;

		OnItemClickListener(int outerResId, int pos) {
			this.outerResId = outerResId;
			this.pos = pos;
		}

		@Override
		public void onClick(View v) {
			switch (outerResId) {
			case R.id.imageOuterLayout:
				System.out.println("imageOuterLayout");
				Intent intent = new Intent(context,
						activitys[pos].activityClass);
				startActivity(intent);
				break;
			case R.id.textOuterLayout:
				System.out.println("textOuterLayout");
				break;
			case R.id.hotOuterLayout:
				System.out.println("hotOuterLayout");
				break;

			default:
				break;
			}
		}

	}

	public void addData(int pos, int itemResId, LinearLayout itemLayout) {
		switch (itemResId) {
		case R.layout.image_gridview_item:
			System.out.println("ddddddd");
			ImageView imageView = (ImageView) itemLayout
					.findViewById(R.id.imageView);
			TextView titleTextView = (TextView) itemLayout
					.findViewById(R.id.textView);
			imageView.setImageResource(imageIds[pos]);
			titleTextView.setText(textArr[pos]);
			break;

		case R.layout.text_gridview_item:
			TextView classTextView = (TextView) itemLayout
					.findViewById(R.id.classTextView);
			classTextView.setText(classArr[pos]);
			break;
		case R.layout.hot_gridview_item:

			ImageView hotImageView = (ImageView) itemLayout
					.findViewById(R.id.hotImageView);
			hotImageView.setImageResource(otherImageIds[pos]);
			break;
		default:
			break;
		}

	}

	class ActivityInfo {
		Class<? extends android.app.Activity> activityClass;

		ActivityInfo(Class<? extends android.app.Activity> cls) {
			this.activityClass = cls;
		}
	}

}
