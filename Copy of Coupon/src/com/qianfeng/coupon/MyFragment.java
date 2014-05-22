package com.qianfeng.coupon;

import java.util.Arrays;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {
	private int pos;
	private View view;
	private ScrollView scrollView;
	private LinearLayout scrollViewChildLayout;
	private GridView imageGridView;
	private GridView textGridView;
	private GridView hotGridView;
	private LayoutInflater inflater;

	private Context context;
	
	private String[] textArr={"餐饮美食","休闲娱乐","生活服务","电影票","酒店","摄影写真","丽人","最新活动"};
	
	Integer[] imageIds = { R.drawable.cat_1, R.drawable.cat_2,
			R.drawable.cat_3, R.drawable.cat_4,
			R.drawable.cat_5, R.drawable.cat_6,
			R.drawable.cat_7, R.drawable.cat_8 };

	public MyFragment(int pos,Context context) {
		this.pos = pos;
		this.context=context;
	}

	@Override 
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater=inflater;
		
		view=inflater.inflate(R.layout.homepage, null);
		
		scrollView=(ScrollView)view.findViewById(R.id.scrollView);
		scrollViewChildLayout=(LinearLayout)inflater.inflate(R.layout.homepage_scroll_child,null);
		
		//imageGridView=(GridView)scrollViewChildLayout.findViewById(R.id.imageGridView);
		/*textGridView=(GridView)scrollViewChildLayout.findViewById(R.id.textGridView);
		hotGridView=(GridView)scrollViewChildLayout.findViewById(R.id.hotGridView);
		*/
		//imageGridView.setAdapter(new ImageGridViewAdapter(Arrays.asList(textArr), context));
		scrollView.addView(scrollViewChildLayout);
		return view;
	}
	
	class ImageGridViewAdapter extends ViewAdapter<String>{

		public ImageGridViewAdapter(List<String> list, Context context) {
			super(list, context);
		}

		@Override
		public View initView(int pos, View convertView) {
			System.out.println("gridview"+pos);
			if(convertView==null){
				convertView=inflater.inflate(R.layout.image_gridview_item, null);
			}
			ImageView imageView=(ImageView)convertView.findViewById(R.id.imageView);
			//TextView titleTextView=(TextView)convertView.findViewById(R.id.textView);
			imageView.setImageResource(imageIds[pos]);
			//titleTextView.setText(textArr[pos]);
			return convertView;
		}
		
	}

}
