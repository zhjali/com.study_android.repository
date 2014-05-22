package com.qianfeng.coupon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cache.CacheFactory;
import com.example.cache.CacheInterfaceCallback;
import com.example.contants.Demo_youhui;
import com.example.contants.Info_youhui;
import com.example.contants.JsonUtils;
import com.example.exception.BuilderException;
import com.example.qianfeng.task.Task_youhui;
import com.example.tools.NetworkUtils;
import com.example.tools.OnNetworkDownloadCompletedCallback;

@SuppressLint("ValidFragment")
public class Orignial_GroupFragment extends Fragment {
	private LinearLayout favorLayout;
	private Context context;
	private LayoutInflater inflater;

	private TextView hottestTextView;
	private TextView lastestTextView;

	private RelativeLayout hottestLayout;
	private RelativeLayout lastestLayout;

	private NetworkUtils networkUtils;
	private Demo_youhui zuire_youhui;
	private Demo_youhui zuixin_youhui;

	private Info_youhui zuire;
	private List<Info_youhui> info_zuire_youhui = new ArrayList<Info_youhui>();

	private Info_youhui zuixin;
	private List<Info_youhui> info_zuixin_youhui;

	private List<Info_youhui> hottestNums;
	private List<Info_youhui> lastestNums;

	private String IP = "http://192.168.56.1/";
	private String url_zuire1 = "http://www.doujiao.com/search/coupon/v5?city=%E5%8C%97%E4%BA%AC&pi=0&psize=10&type=hot&devID=null&token=000000000000000&couponVer=4.2.1&personID=";
	private String url_zuire = IP+"pi=0&psize=10&type=hot";
	private String url_zuixin = "http://www.doujiao.com/search/coupon/v5?city=%E5%8C%97%E4%BA%AC&pi=0&psize=10&type=new&devID=null&token=000000000000000&couponVer=4.2.1&personID=";
	private String url_tuijian = "http://www.doujiao.com/search/coupon/v3?city=%E5%8C%97%E4%BA%AC&pi=0&psize=5&lat=0.0&lng=0.0&cid=&devID=null&token=000000000000000&couponVer=4.2.1&personID=";
	private String url_tuangou = "http://www.doujiao.com/search/deal/v2?pi=0&cat=255&sort=3&city=%E5%8C%97%E4%BA%AC&ver=13&cv=A34&devID=null&token=000000000000000&couponVer=4.2.1&personID=";

	private ListView listView;
	private HottestAdapter hottestAdapter;
	private CacheInterfaceCallback imgCallback;
	private JsonUtils jsonUtils;
	private LastestAdapter lastestAdapter;

	private ListView hottestListView;
	private ListView lastestListView;

	private LinearLayout hottestView;
	private LinearLayout lastestView;

	private LinearLayout containerLayout;

	private LinearLayout downloadFooter;

	private boolean flag = true;

	private int hottestPi = -1;
	private int lastestPi = -1;

	public Orignial_GroupFragment() {

	}

	public Orignial_GroupFragment(Context context) {
		this();
		this.context = context;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater = inflater;

		networkUtils = new NetworkUtils();
		jsonUtils = new JsonUtils();
		imgCallback = CacheFactory.getCacheManager();
		
		//主要layout
		favorLayout = (LinearLayout) inflater.inflate(R.layout.favor, null);
		//download的循环
		downloadFooter = (LinearLayout) inflater.inflate(
				R.layout.download_list_footer, null);
		
		//最热团购、最新团购，RelativeLayout--》TextView：显示上述两个个词
		hottestLayout = (RelativeLayout) favorLayout
				.findViewById(R.id.hottest_view);
		lastestLayout = (RelativeLayout) favorLayout
				.findViewById(R.id.lattest_view);

		
		//内容展示区
		containerLayout = (LinearLayout) favorLayout
				.findViewById(R.id.container);
		
		//上述的TextView
		hottestTextView = (TextView) favorLayout.findViewById(R.id.hottest_txt);
		lastestTextView = (TextView) favorLayout.findViewById(R.id.lattest_txt);

		
		//包含ListView的LinearLayout
		hottestView = (LinearLayout) inflater.inflate(
				R.layout.hottest_favor_listview, null);
		lastestView = (LinearLayout) inflater.inflate(
				R.layout.lastest_favor_listview, null);

		
		//上述的ListView
		hottestListView = (ListView) hottestView
				.findViewById(R.id.hottestListView);
		lastestListView = (ListView) lastestView
				.findViewById(R.id.lastestListView);

		
		//添加download循环图标
		hottestListView.addFooterView(downloadFooter);
		lastestListView.addFooterView(downloadFooter);

		ListViewListener listListener = new ListViewListener();
		hottestListView.setOnItemClickListener(listListener);
		lastestListView.setOnItemClickListener(listListener);

		hottestListView.setOnScrollListener(new ListViewScrollListener());
		lastestListView.setOnScrollListener(new ListViewScrollListener());

		TitleBarListener titleListener = new TitleBarListener();
		hottestTextView.setOnClickListener(titleListener);
		lastestTextView.setOnClickListener(titleListener);

		containerLayout.addView(hottestView);
		hottestAdapter = new HottestAdapter();
		//task
		try {
			info_zuire_youhui.addAll(new Task_youhui().getZuires());
		} catch (BuilderException e) {
			e.printStackTrace();
		}
		hottestAdapter.addNum(info_zuire_youhui);
		hottestListView.setAdapter(hottestAdapter);

		lastestAdapter = new LastestAdapter();
		lastestListView.setAdapter(lastestAdapter);

		return favorLayout;
	}

	class ListViewScrollListener implements OnScrollListener {
		private int temp;
		private int current;

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			current = firstVisibleItem;
			if (firstVisibleItem + visibleItemCount == totalItemCount
					&& flag == true) {
				temp = firstVisibleItem;
				// System.out.println("����");
				switch (view.getId()) {
				case R.id.hottestListView:
					hottestPi = hottestPi + 1;
					String newPi1 = "pi=" + hottestPi;
					String newZuire = url_zuire.replace("pi=0", newPi1);
					networkUtils.textDownload(newZuire,
							new OnNetworkDownloadCompletedCallback() {

								@Override
								public void OnNetworkDownloadCompleted(
										Bitmap result) {

								}

								@Override
								public void OnNetworkDownloadCompleted(
										byte[] result) {

									zuire_youhui = jsonUtils
											.changeJsonToObject(result);// 第三个
									info_zuire_youhui = zuire_youhui
											.getResults();// 最新 最热
									System.out.println(info_zuire_youhui.size());

									hottestAdapter.addNum(info_zuire_youhui);
									hottestAdapter.notifyDataSetChanged();

								}
							});
					break;

				case R.id.lastestListView:
					lastestPi = lastestPi + 1;
					String newPi2 = "pi=" + lastestPi;
					String newZuixin = url_zuixin.replace("pi=0", newPi2);
					networkUtils.textDownload(newZuixin,
							new OnNetworkDownloadCompletedCallback() {

								@Override
								public void OnNetworkDownloadCompleted(
										Bitmap result) {

								}

								@Override
								public void OnNetworkDownloadCompleted(
										byte[] result) {

									zuixin_youhui = jsonUtils
											.changeJsonToObject(result);// 第三个
									info_zuixin_youhui = zuixin_youhui
											.getResults();// 最新
									// 最热
									System.out.println("最新"
											+ info_zuixin_youhui.size());

									// list_tuijian = tuijian.getResults();

									lastestAdapter.addNum(info_zuixin_youhui);

									lastestAdapter.notifyDataSetChanged();

								}
							});
					break;

				default:
					break;
				}

				flag = false;
			}
		}

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			// System.out.println("onScrollStateChanged"+scrollState);
			if (flag == false && temp != current) {
				flag = true;
			}
		}

	}

	// 设置ListView Item 监听器
	class ListViewListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int pos,
				long id) {
			int viewId = adapterView.getId();
			System.out.println("被点击了");
			switch (viewId) {
			case R.id.hottestListView:
				System.out.println("hot被点击了");
				Info_youhui zuire = info_zuire_youhui.get(pos);
				Intent intent1 = new Intent();
				intent1.putExtra("zuire", zuire);
				intent1.putExtra("model", "hottest");
				intent1.setClass(context, GroupDetailActivity.class);
				startActivity(intent1);
				break;

			case R.id.lastestListView:
				System.out.println(lastestNums.size());
				Info_youhui zuixin = lastestNums.get(pos);
				Intent intent2 = new Intent();
				intent2.putExtra("zuixin", zuixin);
				intent2.putExtra("model", "lastest");
				intent2.setClass(context, GroupDetailActivity.class);
				startActivity(intent2);
				break;

			default:
				break;
			}
		}

	}

	// 设置标题栏监听器
	class TitleBarListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			System.out.println("tttt");
			switch (id) {
			case R.id.hottest_txt:
				lastestLayout
						.setBackgroundResource(R.drawable.right_tab_normal);
				hottestLayout
						.setBackgroundResource(R.drawable.left_tab_selected);
				containerLayout.removeAllViews();
				containerLayout.addView(hottestView);
				break;
			case R.id.lattest_txt:
				lastestLayout
						.setBackgroundResource(R.drawable.right_tab_selected);
				hottestLayout.setBackgroundResource(R.drawable.left_tab_normal);
				containerLayout.removeAllViews();
				containerLayout.addView(lastestView);

				break;

			default:
				break;
			}
		}
	}

	// 最热优惠adapter
	class HottestAdapter extends BaseAdapter {
//		private List<Info_youhui> nums = new ArrayList<Info_youhui>();
		private List<Info_youhui> nums = new ArrayList<Info_youhui>();

		@Override
		public int getCount() {
			return nums.size();
		}

		public void addNum(List<Info_youhui> nums) {
			this.nums.addAll(nums);
			Orignial_GroupFragment.this.hottestNums = this.nums;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = null;
			if (convertView == null) {
				view = inflater.inflate(R.layout.hottest_list_item, null);
			} else {
				view = convertView;
			}
			TextView shopName = (TextView) view.findViewById(R.id.text11);
			TextView couponTitle = (TextView) view.findViewById(R.id.text12);
			TextView downLoad = (TextView) view.findViewById(R.id.text13);
			// ImageView image = (ImageView) view.findViewById(R.id.imageitem1);
			Info_youhui num = nums.get(position);
			shopName.setText(num.getShopName());
			couponTitle.setText(num.getCouponTitle());
			String counts = num.getDownload();
			downLoad.setText("已下载" + counts + "次");

			return view;
		}
	}

	// 最新adapter
	class LastestAdapter extends BaseAdapter {
		private List<Info_youhui> nums = new ArrayList<Info_youhui>();

		@Override
		public int getCount() {
			return nums.size();
		}

		public void addNum(List<Info_youhui> nums) {
			this.nums.addAll(nums);
			Orignial_GroupFragment.this.lastestNums = this.nums;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = null;
			if (convertView == null) {
				view = inflater.inflate(R.layout.lastest_list_item, null);
			} else {
				view = convertView;
			}
			TextView t1 = (TextView) view.findViewById(R.id.text21);
			TextView t2 = (TextView) view.findViewById(R.id.text22);
			TextView t3 = (TextView) view.findViewById(R.id.text23);
			ImageView image = (ImageView) view.findViewById(R.id.imageitem2);
			Info_youhui num = nums.get(position);
			t1.setText(num.getShopName());
			t2.setText(num.getCouponTitle());
			String startTime = num.getStartTime();
			String endTime = num.getEndTime();
			Date date = new Date();
			long curTime = date.getTime();
			long upTime = curTime - Long.parseLong(startTime);
			long day = upTime / (24 * 3600 * 1000);
			long hour = upTime % (24 * 3600 * 1000) / (3600 * 1000);
			long minus = upTime % (24 * 3600 * 1000) % (3600 * 1000)
					/ (60 * 1000);
			t3.setText("更新时间：" + day + "天" + hour + "小时" + minus + "分钟前");
			return view;
		}
	}
	
	private List<Info_youhui> data = new ArrayList<Info_youhui>();

	/**
	 * couponID相同则不加入，downLoad多的排在前边，downLoad相同的后来者排在后边
	 */
	Comparator<Info_youhui> comparator_host = new Comparator<Info_youhui>() {

		@Override
		public int compare(Info_youhui arg0, Info_youhui arg1) {
			
			if(arg0.getCouponId() == arg1.getCouponId() ){
				return 0;
			}else if (Integer.parseInt(arg0.getDownload()) > Integer.parseInt(arg1.getDownload()) ) {
				return 1;
			}else if(Integer.parseInt(arg0.getDownload()) < Integer.parseInt(arg1.getDownload())){
				return -1;
			}
			return -1;
		}
	};
	
	/**
	 * couponID相同则不加入，startTime大的排在前边，相同的后来着排在后边
	 */
	Comparator<Info_youhui> comparator_latest = new Comparator<Info_youhui>() {

		@Override
		public int compare(Info_youhui arg0, Info_youhui arg1) {
			if(arg0.getCouponId() == arg1.getCouponId()){
				return 0;
			}else if (Integer.parseInt(arg0.getStartTime()) > Integer.parseInt(arg1.getStartTime()) ) {
				return 1;
			}else if(Integer.parseInt(arg0.getStartTime()) < Integer.parseInt(arg1.getStartTime()) ){
				return -1;
			}
			return -1;
		}
	};
}
