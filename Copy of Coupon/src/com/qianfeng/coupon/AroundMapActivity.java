package com.qianfeng.coupon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.Ground;
import com.baidu.mapapi.map.GroundOverlay;
import com.baidu.mapapi.map.ItemizedOverlay;
import com.baidu.mapapi.map.LocationData;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationOverlay;
import com.baidu.mapapi.map.OverlayItem;
import com.baidu.mapapi.map.PopupClickListener;
import com.baidu.mapapi.map.PopupOverlay;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.qianfeng.map.BMapUtil;
import com.qianfeng.map.MyApplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class AroundMapActivity extends Activity {
	// 定位相关
	LocationClient mLocClient;
	LocationData locData = null;

	// 定位图层
	locationOverlay myLocationOverlay = null;
	// 弹出泡泡图层
	private PopupOverlay pop = null;// 弹出泡泡图层，浏览节点时使用
	private TextView popupText = null;// 泡泡view
	private View viewCache = null;

	// 覆盖物。。。。
	private MyOverlay mOverlay = null;
	// private PopupOverlay pop = null;
	private ArrayList<OverlayItem> mItems = null;

	// 地图相关，使用继承MapView的MyLocationMapView目的是重写touch事件实现泡泡处理
	// 如果不处理touch事件，则无需继承，直接使用MapView即可
	MapView mMapView = null; // 地图View
	private MapController mMapController = null;

	// UI相关
	OnCheckedChangeListener radioButtonListener = null;
	Button requestLocButton = null;
	boolean isRequest = false;// 是否手动触发请求定位
	boolean isFirstLoc = true;// 是否首次定位

	private TextView titleTextView;
	private TextView priceTextView;
	private RatingBar ratingBar;
	private TextView couponTextView;

	List<Map<String, Object>> aroundList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		MyApplication app = (MyApplication) this.getApplication();
		setContentView(R.layout.activity_around_map);
		initMap();
		/**
		 * 设定地图中心点
		 */
		double cLat;
		double cLon;
		String curPoint;
		GeoPoint curP;
		Intent intent = getIntent();
		aroundList = (List<Map<String, Object>>) intent
				.getSerializableExtra("aroundList");
		curPoint = intent.getStringExtra("curPoint");
		String[] str = curPoint.split(",");
		cLat = Double.parseDouble(str[0]);
		cLon = Double.parseDouble(str[1]);
		 locData.latitude = cLat;
         locData.longitude = cLon;
		System.out.println("lat:" + cLat + "lon:" + cLon);
		curP = new GeoPoint((int) (cLat * 1E6), (int) (cLon * 1E6));
		initOverlay();
		mMapController.setCenter(curP);

	}

	// 继承MyLocationOverlay重写dispatchTap实现点击处理
	public class locationOverlay extends MyLocationOverlay {

		public locationOverlay(MapView mapView) {
			super(mapView);
			// TODO Auto-generated constructor stub
		}

		@Override
		protected boolean dispatchTap() {
			// TODO Auto-generated method stub
			// 处理点击事件,弹出泡泡
			/*
			 * popupText.setBackgroundResource(R.drawable.popup);
			 * popupText.setText("我的位置");
			 * pop.showPopup(BMapUtil.getBitmapFromView(popupText), new
			 * GeoPoint((int)(locData.latitude*1e6),
			 * (int)(locData.longitude*1e6)), 8);
			 */
			return true;
		}

	}

	public void initMap() {
		// 地图初始化
		mMapView = (MapView) findViewById(R.id.bmapView);
		mMapController = mMapView.getController();
		mMapView.getController().setZoom(14);
		mMapView.getController().enableClick(true);
		mMapView.setBuiltInZoomControls(true);
		locData = new LocationData();
		
		// 定位图层初始化
		myLocationOverlay = new locationOverlay(mMapView);
		myLocationOverlay.setMarker(getResources().getDrawable(R.drawable.mylocation));
		// 设置定位数据
		myLocationOverlay.setData(locData);
		// 添加定位图层
		mMapView.getOverlays().add(myLocationOverlay);
	
		mMapView.refresh();
	
	}

	public void initOverlay() {
		/**
		 * 创建自定义overlay
		 */
		mOverlay = new MyOverlay(getResources().getDrawable(
				R.drawable.iconmarka), mMapView);
		if (aroundList != null) {
			for (int i = 0; i < aroundList.size(); i++) {
				Map<String, Object> results = aroundList.get(i);
				double mLon = Double.parseDouble((String) (results.get("x")));
				double mLat = Double.parseDouble((String) (results.get("y")));
				GeoPoint p = new GeoPoint((int) (mLat * 1E6),
						(int) (mLon * 1E6));
				OverlayItem item = new OverlayItem(p, "覆盖物1", "");
				item.setMarker(getResources().getDrawable(R.drawable.iconmarka));
				mOverlay.addItem(item);
			}
		}
		mItems = new ArrayList<OverlayItem>();
		mItems.addAll(mOverlay.getAllItem());

		mMapView.getOverlays().add(mOverlay);

		mMapView.refresh();

		/**
		 * 向地图添加自定义View.
		 */

		viewCache = getLayoutInflater().inflate(R.layout.cum_map_pop, null);
		titleTextView = (TextView) viewCache.findViewById(R.id.title);
		priceTextView = (TextView) viewCache.findViewById(R.id.price);
		ratingBar = (RatingBar) viewCache.findViewById(R.id.star);
		couponTextView=(TextView)viewCache.findViewById(R.id.coupon_tag);

		/**
		 * 创建一个popupoverlay
		 */
		PopupClickListener popListener = new PopupClickListener() {
			@Override
			public void onClickedPopup(int index) {
				System.out.println("pop");
				System.out.println("index:"+index);
				String  shopId=(String)aroundList.get(index).get("id");
				Intent intent=new Intent();
				intent.putExtra("shopId",shopId);
				intent.setClass(AroundMapActivity.this, ShopDetailActivity.class);
				startActivity(intent);
			}
		};
		pop = new PopupOverlay(mMapView, popListener);

	}

	// 自定义图层
	public class MyOverlay extends ItemizedOverlay {

		public MyOverlay(Drawable defaultMarker, MapView mapView) {
			super(defaultMarker, mapView);
		}

		@Override
		public boolean onTap(int index) {
			OverlayItem item = getItem(index);
			Map<String, Object> results = aroundList.get(index);
			String title = (String) results.get("name");
			String price = (String) results.get("price");
			String star = (String) results.get("view");
			String coupon = (String) results.get("trade_name");
			titleTextView.setText(title);
			priceTextView.setText("人均:" + price+"元");
			ratingBar.setRating(Float.parseFloat(star));
			couponTextView.setText(coupon);
			GeoPoint p = item.getPoint();
			// 弹出自定义View
			mMapController.animateTo(p);
			pop.showPopup(viewCache, p, 32);
			
			return true;
		}

		@Override
		public boolean onTap(GeoPoint pt, MapView mMapView) {
			if (pop != null) {
				pop.hidePop();
				// mMapView.removeView(button);
			}
			return false;
		}

	}

}
