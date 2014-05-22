package com.qianfeng.coupon;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;

import android.view.View;

import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class FoodActivity extends Activity {
	private ListView listView;
	private TextView headTextView;
	private LayoutInflater inflater;

	private String[] sortArr = { "全部", "快餐小吃", "火锅", "烧烤", "香锅", "自助餐", "蛋糕甜品",
			"川菜", "日本美食", "韩国料理", "西餐国际", "粤菜", "湘菜", "海鲜", "江浙菜", "东北菜",
			"云南菜", "湖北菜", "台湾菜", "香锅", "贵州菜" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_food);
		inflater = LayoutInflater.from(this);
		listView = (ListView) findViewById(R.id.listView);
		headTextView = (TextView) findViewById(R.id.classTextView);

		listView.setAdapter(new ListViewAdapter(Arrays.asList(sortArr), this));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int pos, long id) {
				Intent intent=new Intent();
				intent.setClass(FoodActivity.this, SearchResultActivity.class);
				startActivity(intent);
			}
		});
	}

	class ListViewAdapter extends ViewAdapter<String> {

		public ListViewAdapter(List<String> list, Context context) {
			super(list, context);
		}

		@Override
		public View initView(int pos, View convertView) {
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.food_sort_item, null);
			}
			TextView sortTextView = (TextView) convertView
					.findViewById(R.id.sortTextView);
			sortTextView.setText(sortArr[pos]);
			return convertView;
		}

	}

}
