package com.qianfeng.coupon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultActivity extends Activity {
	private ListView listView;
	private ListView leftListView;
	private ListView rightListView;
	private LinearLayout view;

	private LeftListViewAdapter leftAdapter;

	private LayoutInflater inflater;

	private RelativeLayout actionLayout;
	private PopupWindow mPopupWindow;

	private RelativeLayout classLayout;
	private RelativeLayout distanceLayout;
	private RelativeLayout totalLayout;
	private View popupWindow;
	private ImageView arrow;
	
	private AlertDialog dialog;
	private int selectedFruitIndex = 0;
	
	
	private String[] arr = new String[6];

	private boolean flag = false;

	//餐饮美食的popupWindow下的leftListView：菜单项
	private String[] foodArr = { "全部分类", "餐饮美食", "休闲娱乐", "生活服务", "酒店", "摄影写真",
			"丽人" };
	//餐饮美食的popupWindow下的rightListView：菜单项
	private String[] allArr = { "全部分类" };
	
	private String[] foodSubArr = { "餐饮美食", "快餐小吃", "火锅", "烧烤", "香锅", "自助餐",
			"蛋糕甜品", "川菜", "日本美食", "韩国料理", "西餐国际", "粤菜", "湘菜", "海鲜", "江浙菜",
			"东北菜", "云南菜", "湖北菜", "台湾菜", "香锅", "贵州菜" };

	private String[] relaxArr = { "休闲娱乐", "KTV", "足疗按摩", "洗浴", "酒吧", "桌面游戏",
			"游艺电玩", "咖啡厅", "茶楼", "台球厅", "网吧" };

	private String[] beautyArr = { "丽人", "美容/SPA", "美发", "瘦身纤体", "瑜伽舞蹈", "美甲",
			"丽人" };

	private String[] filmArr = { "摄影写真", "个人写真", "婚纱摄影", "儿童" };

	private String[] pubArr = { "酒店", "五星级", "四星级", "三星级", "连锁/快捷酒店", "更多酒店 宾馆" };

	private String[] serviceArr = { "生活服务", "银行/ATM", "加油站" };
	
	//综合排序AlertDialog下拉菜单：菜单项
	String[] itemArray = new String[] { "综合排序", "按距离排序", "按人气排序", "有优惠的优先", "有团购的优先"  };
	
	

	private List<Object> list = new ArrayList<Object>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search_result);
		initData();
		inflater = LayoutInflater.from(this);
		
		popupWindow = inflater.inflate(R.layout.popupwindow, null);
		arrow=(ImageView)popupWindow.findViewById(R.id.arrow);
		leftListView = (ListView) popupWindow.findViewById(R.id.leftListView);
		rightListView = (ListView) popupWindow.findViewById(R.id.rightListView);
		
		//搜索出来的内容 listview
		listView = (ListView) findViewById(R.id.listView);
		leftListView.setItemChecked(1, false);
		
		//三个排序的：餐饮美食排序、附近三公里、综合排序
		classLayout = (RelativeLayout) findViewById(R.id.class_view);
		distanceLayout = (RelativeLayout) findViewById(R.id.distance_view);
		totalLayout = (RelativeLayout) findViewById(R.id.total_view);
		ViewOnclickListener listener = new ViewOnclickListener();

		classLayout.setOnClickListener(listener);
		distanceLayout.setOnClickListener(listener);
		totalLayout.setOnClickListener(listener);

		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view,
					int pos, long id) {

			}

		});
		
		PopListViewListener itemListener = new PopListViewListener();
		leftListView.setOnItemClickListener(itemListener);
		rightListView.setOnItemClickListener(itemListener);
		leftAdapter = new LeftListViewAdapter(Arrays.asList(foodArr), this);
		leftListView.setAdapter(leftAdapter);
		rightListView.setAdapter(new RightListViewAdapter(Arrays.asList(arr),
				this));
		
		listView.setAdapter(new ListViewAdapter(Arrays.asList(arr), this));

	}

	class PopListViewListener implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> adapterView, View view, int pos,
				long id) {

			if (adapterView.getId() == R.id.leftListView) {
				System.out.println("left");
				String[] curArr = (String[]) list.get(pos);
				RightListViewAdapter adapter = new RightListViewAdapter(
						Arrays.asList(curArr), SearchResultActivity.this);
				leftAdapter.setSelectedPosition(pos);
				rightListView.setAdapter(adapter);
				leftAdapter.notifyDataSetInvalidated();
				adapter.notifyDataSetChanged();
			} else {
				System.out.println("right");
			}

		}

	}

	class ViewOnclickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int id = v.getId();
			switch (id) {
			case R.id.class_view:
				getPopupWindowInstance();
				showArrow(v);
				show(v);
				break;

			case R.id.distance_view:
				
				break;

			case R.id.total_view:
				initDiaolog();
				dialog.show();
				break;

			default:
				break;
			}
		}

	}
	
	public void showArrow(View v){
		int[] location=new int[2];
		v.getLocationOnScreen(location);
		Rect rect=new Rect(location[0], location[1],location[0]+v.getWidth(), location[1]+v.getHeight());
		int total=rect.centerX();
		final int arrowWidth = arrow.getMeasuredWidth();
		arrow.setVisibility(View.VISIBLE);
		ViewGroup.MarginLayoutParams param = (ViewGroup.MarginLayoutParams) arrow
				.getLayoutParams();
		param.leftMargin = total - arrowWidth / 2;
		arrow.setLayoutParams(param);
	}

	private void getPopupWindowInstance() {
		if (null != mPopupWindow) {
			//
			
			return;
		} else {
			initPopuptWindow();
		}
		
	}

	public void show(View v) {
		
		if (flag == false) {
			mPopupWindow.setFocusable(true);
			mPopupWindow.showAsDropDown(v, 40, 40);
			flag = true;
		} else {
			
			mPopupWindow.dismiss();
			flag = false;
		}
	}

	/*
	 * 创建PopupWindow
	 */
	private void initPopuptWindow() {

		mPopupWindow = new PopupWindow(popupWindow, 700, 600);
		mPopupWindow.setOutsideTouchable(true);
		mPopupWindow.getContentView().setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				mPopupWindow.setFocusable(false);
				mPopupWindow.dismiss();
				return true;
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
				convertView = inflater.inflate(R.layout.food_result_item, null);
			}

			return convertView;
		}

	}

	class LeftListViewAdapter extends ViewAdapter<String> {
		private List<String> list;

		private int selectedPosition = -1;

		public void setSelectedPosition(int position) {
			this.selectedPosition = position;
		}

		public LeftListViewAdapter(List<String> list, Context context) {
			super(list, context);
			this.list = list;
		}

		@Override
		public View initView(int pos, View convertView) {
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.popup_listview_item,
						null);
			}
			ImageView rangeImageView=(ImageView)convertView.findViewById(R.id.rangeImageView);
			TextView menuItemText = (TextView) convertView
					.findViewById(R.id.menuItemText);
			if (selectedPosition == pos) {
				rangeImageView.setImageResource(R.drawable.range_seek_bar_progress);
				menuItemText.setBackgroundColor(Color.GRAY);
			} else {
				rangeImageView.setImageDrawable(null);
				menuItemText.setBackgroundColor(Color.TRANSPARENT);
			}
			menuItemText.setText(list.get(pos));
			return convertView;
		}

	}

	class RightListViewAdapter extends ViewAdapter<String> {
		private List<String> list;

		public RightListViewAdapter(List<String> list, Context context) {

			super(list, context);
			this.list = list;
		}

		@Override
		public View initView(int pos, View convertView) {
			if (convertView == null) {
				convertView = inflater.inflate(R.layout.popup_listview_item,
						null);
			}
			TextView menuItemText = (TextView) convertView
					.findViewById(R.id.menuItemText);
			menuItemText.setText(list.get(pos));
			return convertView;
		}

	}

	public void initData() {
		list.add(allArr);
		list.add(foodSubArr);
		list.add(relaxArr);
		list.add(beautyArr);
		list.add(filmArr);
		list.add(pubArr);
		list.add(serviceArr);
	}
	
	public void initDiaolog(){

		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle("请选择排序方式");
		view=(LinearLayout)inflater.inflate(R.layout.search_result_dialog,null);
		initDialogView();
		builder.setView(view);
		dialog=builder.create();
	}
	
	public void initDialogView(){
		for(int i=0;i<itemArray.length;i++){
			RelativeLayout itemLayout=(RelativeLayout)inflater.inflate(R.layout.dialog_item,null);
			TextView itemTextView=(TextView)itemLayout.findViewById(R.id.itemTextView);
			itemTextView.setText(itemArray[i]);
			itemLayout.setOnClickListener(new DialogItemListener());
			view.addView(itemLayout);
		}
	}
	
	class DialogItemListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			v.setBackgroundColor(Color.YELLOW);
		}
		
	}

}
