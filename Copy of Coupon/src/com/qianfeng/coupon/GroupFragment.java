package com.qianfeng.coupon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cache.CacheFactory;
import com.example.cache.CacheInterfaceCallback;
import com.example.contants.Info_youhui;
import com.example.contants.JsonUtils;
import com.example.exception.BuilderException;
import com.example.qianfeng.task.Task_youhui;
import com.example.tools.NetworkUtils;

@SuppressLint("ValidFragment")
public class GroupFragment extends Fragment {
	private static final String TAG = "GroupFragment";

	private LinearLayout favorLayout;
	private Context context;
	private LayoutInflater inflater;
	private CacheInterfaceCallback imgCallback;
	private JsonUtils jsonUtils;
	private NetworkUtils networkUtils;

	// 最热团购，最新团购的布局：RelativeLayout
	private RelativeLayout hottestLayout;
	private RelativeLayout lastestLayout;

	// 最热团购，最新团购的显示
	private TextView hottestTextView;
	private TextView lastestTextView;

	// 内容展示区
	private LinearLayout containerLayout;

	// 包含ListView的LinearLayout，里面的ListView,对应的Adapter
	private LinearLayout hottestView;
	private ListView hottestListView;
	private HottestAdapter hottestAdapter = new HottestAdapter();

	private LinearLayout downloadFooter;

	private boolean isHottest = true;
	private boolean flag = true;

	private ArrayList<Info_youhui> data;

	public GroupFragment() {

	}

	public GroupFragment(Context context) {
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

		// 主要layout
		favorLayout = (LinearLayout) inflater.inflate(R.layout.favor, null);
		// download的循环
		downloadFooter = (LinearLayout) inflater.inflate(
				R.layout.download_list_footer, null);

		// 最热团购、最新团购，RelativeLayout--》TextView：显示上述两个个词
		hottestLayout = (RelativeLayout) favorLayout
				.findViewById(R.id.hottest_view);
		lastestLayout = (RelativeLayout) favorLayout
				.findViewById(R.id.lattest_view);

		// 上述的TextView
		hottestTextView = (TextView) favorLayout.findViewById(R.id.hottest_txt);
		lastestTextView = (TextView) favorLayout.findViewById(R.id.lattest_txt);

		// 内容展示区
		containerLayout = (LinearLayout) favorLayout
				.findViewById(R.id.container);

		// 包含ListView的LinearLayout
		hottestView = (LinearLayout) inflater.inflate(
				R.layout.hottest_favor_listview, null);

		// 上述的ListView
		hottestListView = (ListView) hottestView
				.findViewById(R.id.hottestListView);

		// 添加download循环图标
		hottestListView.addFooterView(downloadFooter);

		ListViewItemListener listListener = new ListViewItemListener();
		hottestListView.setOnItemClickListener(listListener);

		// hottestListView.setOnScrollListener(new ListViewScrollListener());

		TitleBarListener titleListener = new TitleBarListener();
		hottestTextView.setOnClickListener(titleListener);
		lastestTextView.setOnClickListener(titleListener);

		containerLayout.addView(hottestView);

		try {
			data = new Task_youhui().getZuires();
		} catch (BuilderException e) {
			e.printStackTrace();
		}
		Collections.sort(data, comparator_host);
		hottestAdapter.addData(data);
		hottestListView.setAdapter(hottestAdapter);

		return favorLayout;
	}

	// class ListViewScrollListener implements OnScrollListener {
	// private int temp;
	// private int current;
	//
	// @Override
	// public void onScroll(AbsListView view, int firstVisibleItem,
	// int visibleItemCount, int totalItemCount) {
	// current = firstVisibleItem;
	// if (firstVisibleItem + visibleItemCount == totalItemCount
	// && flag == true) {
	// temp = firstVisibleItem;
	// // System.out.println("����");
	// switch (view.getId()) {
	// case R.id.hottestListView:
	// hottestPi = hottestPi + 1;
	// String newPi1 = "pi=" + hottestPi;
	// String newZuire = url_zuire.replace("pi=0", newPi1);
	// networkUtils.textDownload(newZuire,
	// new OnNetworkDownloadCompletedCallback() {
	//
	// @Override
	// public void OnNetworkDownloadCompleted(
	// Bitmap result) {
	//
	// }
	//
	// @Override
	// public void OnNetworkDownloadCompleted(
	// byte[] result) {
	//
	// zuire_youhui = jsonUtils
	// .changeJsonToObject(result);// 第三个
	// info_zuire_youhui = zuire_youhui
	// .getResults();// 最新 最热
	// System.out.println(info_zuire_youhui.size());
	//
	// hottestAdapter.addNum(info_zuire_youhui);
	// hottestAdapter.notifyDataSetChanged();
	//
	// }
	// });
	// break;
	//
	// case R.id.lastestListView:
	// lastestPi = lastestPi + 1;
	// String newPi2 = "pi=" + lastestPi;
	// String newZuixin = url_zuixin.replace("pi=0", newPi2);
	// networkUtils.textDownload(newZuixin,
	// new OnNetworkDownloadCompletedCallback() {
	//
	// @Override
	// public void OnNetworkDownloadCompleted(
	// Bitmap result) {
	//
	// }
	//
	// @Override
	// public void OnNetworkDownloadCompleted(
	// byte[] result) {
	//
	// zuixin_youhui = jsonUtils
	// .changeJsonToObject(result);// 第三个
	// info_zuixin_youhui = zuixin_youhui
	// .getResults();// 最新
	// // 最热
	// System.out.println("最新"
	// + info_zuixin_youhui.size());
	//
	// // list_tuijian = tuijian.getResults();
	//
	// lastestAdapter.addNum(info_zuixin_youhui);
	//
	// lastestAdapter.notifyDataSetChanged();
	//
	// }
	// });
	// break;
	//
	// default:
	// break;
	// }
	//
	// flag = false;
	// }
	// }

	// @Override
	// public void onScrollStateChanged(AbsListView view, int scrollState) {
	// // System.out.println("onScrollStateChanged"+scrollState);
	// if (flag == false && temp != current) {
	// flag = true;
	// }
	// }
	//
	// }

	// 设置ListView Item 监听器
	class ListViewItemListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int pos,
				long id) {
			int viewId = adapterView.getId();
			System.out.println("被点击了");
			switch (viewId) {
			case R.id.hottestListView:
				Log.d(TAG, "hot被点击了");
				Info_youhui zuire = data.get(pos);
				Intent intent1 = new Intent();
				intent1.putExtra("zuire", zuire);
				intent1.putExtra("model", "hottest");
				intent1.setClass(context, GroupDetailActivity.class);
				startActivity(intent1);
				break;

			case R.id.lastestListView:
				System.out.println(hottestAdapter.getData().size());
				Info_youhui zuixin = hottestAdapter.getData().get(pos);
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
			System.out.println("ttt+");
			System.out.println("id ------> " + id);
			switch (id) {
			case R.id.hottest_txt:
				isHottest = true;
				lastestLayout
						.setBackgroundResource(R.drawable.right_tab_normal);
				hottestLayout
						.setBackgroundResource(R.drawable.left_tab_selected);

				Collections.sort(data, comparator_host);
				Log.d(TAG, "resort the data order");

				hottestAdapter.setData(data);
				System.out.println("change data sort2");
				hottestAdapter.notifyDataSetChanged();
				break;
			case R.id.lattest_txt:
				isHottest = false;
				lastestLayout
						.setBackgroundResource(R.drawable.right_tab_selected);
				hottestLayout.setBackgroundResource(R.drawable.left_tab_normal);

				for (Info_youhui task_data : data) {
					Log.d(TAG, "lattest befor:--" + task_data.toString());
				}
				Collections.sort(data, comparator_latest);
				for (Info_youhui task_data : data) {
					Log.d(TAG, "lattest after:--" + task_data.toString());
				}
				hottestAdapter.setData(data);
				hottestAdapter.notifyDataSetChanged();
				break;

			default:
				break;
			}
		}
	}

	// 最热优惠adapter
	class HottestAdapter extends BaseAdapter {
		private List<Info_youhui> data = new ArrayList<Info_youhui>();

		// private Context context;
		// private LayoutInflater inflater;
		//
		//
		//
		// public HottestAdapter(Context context) {
		// super();
		// this.context = context;
		// this.inflater = LayoutInflater.from(context);
		// }

		public List<Info_youhui> getData() {
			return data;
		}

		public void setData(List<Info_youhui> data) {
			this.data = data;
		}

		public void addData(List<Info_youhui> data) {
			this.data.addAll(data);
		}

		@Override
		public int getCount() {
			return data.size();
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
			TextView t3 = (TextView) view.findViewById(R.id.text13);
			// ImageView image = (ImageView) view.findViewById(R.id.imageitem1);
			Info_youhui num = data.get(position);
			shopName.setText(num.getShopName());
			couponTitle.setText(num.getCouponTitle());
			if (isHottest) {
				String counts = num.getDownload();
				t3.setText("已下载" + counts + "次");

			} else {
				System.out.println("--------------change adapter");
				String startTime = num.getStartTime();
				// String endTime = num.getEndTime();
				Date date = new Date();
				long curTime = date.getTime();
				long upTime = curTime - Long.parseLong(startTime);
				long day = upTime / (24 * 3600 * 1000);
				long hour = upTime % (24 * 3600 * 1000) / (3600 * 1000);
				long minus = upTime % (24 * 3600 * 1000) % (3600 * 1000)
						/ (60 * 1000);
				t3.setText("更新时间：" + day + "天" + hour + "小时" + minus + "分钟前");
			}
			return view;
		}
	}

	/**
	 * couponID相同则不加入，downLoad多的排在前边，downLoad相同的后来者排在后边
	 */
	Comparator<Info_youhui> comparator_host = new Comparator<Info_youhui>() {

		@Override
		public int compare(Info_youhui arg0, Info_youhui arg1) {
			Log.d(TAG, "call comparator_host");

			if (Long.parseLong(arg0.getDownload()) > Long.parseLong(arg1
					.getDownload())) {
				return -1;
			} else if (Long.parseLong(arg0.getDownload()) < Long.parseLong(arg1
					.getDownload())) {
				return +1;
			}
			return 1;
		}
	};

	/**
	 * couponID相同则不加入，startTime大的排在前边，相同的后来着排在后边
	 */
	Comparator<Info_youhui> comparator_latest = new Comparator<Info_youhui>() {

		@Override
		public int compare(Info_youhui arg0, Info_youhui arg1) {
			Log.d(TAG, "call comparator_latest");

			if (Long.parseLong(arg0.getStartTime()) > Long.parseLong(arg1
					.getStartTime())) {
				Log.d(TAG, "return 1");
				return -1;
			} else if (Long.parseLong(arg0.getStartTime()) < Long
					.parseLong(arg1.getStartTime())) {
				Log.d(TAG, "return -1");
				return 1;
			}
			Log.d(TAG, "2return -1");
			return 1;
		}
	};
}
