package com.qianfeng.coupon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.map.LocationData;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationOverlay;
import com.baidu.mapapi.map.PopupClickListener;
import com.baidu.mapapi.map.PopupOverlay;
import com.baidu.mapapi.map.MyLocationOverlay.LocationMode;
import com.baidu.mapapi.search.MKAddrInfo;
import com.baidu.mapapi.search.MKBusLineResult;
import com.baidu.mapapi.search.MKDrivingRouteResult;
import com.baidu.mapapi.search.MKPoiResult;
import com.baidu.mapapi.search.MKSearch;
import com.baidu.mapapi.search.MKSearchListener;
import com.baidu.mapapi.search.MKShareUrlResult;
import com.baidu.mapapi.search.MKSuggestionResult;
import com.baidu.mapapi.search.MKTransitRouteResult;
import com.baidu.mapapi.search.MKWalkingRouteResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.example.cache.CacheFactory;
import com.example.cache.CacheInterfaceCallback;
import com.example.contants.JsonUtils;
import com.example.tools.NetworkUtils;
import com.example.tools.OnNetworkDownloadCompletedCallback;
import com.example.tools.Params;
import com.example.tools.PullXmlHelper;
import com.qianfeng.map.BMapUtil;
import com.qianfeng.map.MyApplication;

/**
 * 
 * @author Administrator
 * @category 优惠区域的fragment
 * 
 */
@SuppressLint("ValidFragment")
public class AroundFragment extends Fragment {
	private Context context;
	private LayoutInflater inflater;
	private AroundListAdapter aroundAdapter;

	private String url_groundsList = "http://www.doujiao.com/search/all/near?sort2=0&lng=116.35689544677734&cat=255&sort=2&pi=0&lat=40.04120635986328&city=%E5%8C%97%E4%BA%AC&ver=13&cv=A34&devID=ac:f7:f3:c3:0f:4b&token=860310024932933&couponVer=4.2.1&personID=";
	private ListView aroundListView;

	private RelativeLayout mapLayout;
	private LinearLayout downloadFooter;
	private TextView locationTextView;


	private CacheInterfaceCallback imgCallback;
	private JsonUtils jsonUtils;
	private NetworkUtils networkUtils;

	private PullXmlHelper pullXmlHelper;
	private Params params;

	private LinearLayout aroundLayout;

	List<Map<String, Object>> aroundList;
	private boolean flag = true;
	private int pi = -1;

	// 定位相关
	LocationClient mLocClient;
	LocationData locData = null;
	public MyLocationListenner myListener = new MyLocationListenner();
	MKSearch mSearch = null;
	boolean isFirstLoc = true;// 是否首次定位
	private String curPoint;

	public AroundFragment() {

	}

	public AroundFragment(Context context) {
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
		pullXmlHelper = new PullXmlHelper();
		params = new Params();
		initMap();
		initLocation();
		mLocClient.requestLocation();
		aroundLayout = (LinearLayout) inflater.inflate(R.layout.around_view,
				null);
		downloadFooter = (LinearLayout) inflater.inflate(
				R.layout.download_list_footer, null);
		
		locationTextView=(TextView)aroundLayout.findViewById(R.id.location);

		aroundListView = (ListView) aroundLayout
				.findViewById(R.id.aroundListview);
		mapLayout = (RelativeLayout) aroundLayout.findViewById(R.id.map_mode);
		mapLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("地图");
				Intent intent=new Intent();
				intent.setClass(context, AroundMapActivity.class);
				intent.putExtra("aroundList",(Serializable)aroundList);
				intent.putExtra("curPoint", curPoint);
				startActivity(intent);
			}
		});
		
		aroundListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int pos,
					long id) {
				String  shopId=(String)aroundList.get(pos).get("id");
				Intent intent=new Intent();
				intent.putExtra("shopId",shopId);
				intent.setClass(context, ShopDetailActivity.class);
				startActivity(intent);
			}
		});

		aroundListView.addFooterView(downloadFooter);
		aroundListView.setOnScrollListener(new ListViewScrollListener());
		aroundAdapter = new AroundListAdapter();
		aroundListView.setAdapter(aroundAdapter);

		return aroundLayout;
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
				pi = pi + 1;
				String newPi = "pi=" + pi;
				String newUrl = url_groundsList.replace("pi=0", newPi);
				networkUtils.textDownload(newUrl,
						new OnNetworkDownloadCompletedCallback() {

							@Override
							public void OnNetworkDownloadCompleted(Bitmap result) {

							}

							@Override
							public void OnNetworkDownloadCompleted(byte[] result) {
								List<Map<String, Object>> groundsList = pullXmlHelper
										.getXmlList(result, "result",
												params.getParams_groundList());
								//System.out.println(groundsList);
								aroundAdapter.addNum(groundsList);
								aroundAdapter.notifyDataSetChanged();

							}
						});
				flag = false;
			}
		}

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			if (flag == false && temp != current) {
				flag = true;
			}
		}
	}

	class AroundListAdapter extends BaseAdapter {
		private List<Map<String, Object>> nums = new ArrayList<Map<String, Object>>();

		@Override
		public int getCount() {
			return nums.size();
		}

		public void addNum(List<Map<String, Object>> nums) {
			this.nums.addAll(nums);
			AroundFragment.this.aroundList = this.nums;
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
				view = inflater.inflate(R.layout.around_list_item, null);
			} else {
				view = convertView;
			}
			TextView shopName = (TextView) view.findViewById(R.id.name_shop);
			RatingBar star = (RatingBar) view.findViewById(R.id.star00);
			TextView renjun = (TextView) view.findViewById(R.id.price_renjun);
			TextView view0 = (TextView) view.findViewById(R.id.view00);
			TextView contentText = (TextView) view.findViewById(R.id.content_);
			TextView trade_name0 = (TextView) view
					.findViewById(R.id.trade_name0);
			TextView distance = (TextView) view.findViewById(R.id.distance0);
			ImageView huiImageView = (ImageView) view
					.findViewById(R.id.imageHui);
			ImageView bankImageView = (ImageView) view
					.findViewById(R.id.imageKa);
			ImageView tuanImageView = (ImageView) view
					.findViewById(R.id.imageTuan);
			ImageView bookImageView = (ImageView) view
					.findViewById(R.id.imageDing);

			Map<String, Object> results = nums.get(position);
			shopName.setText((String) (results.get("name")) + "  ");
			renjun.setText("人均 : " + (String) (results.get("price")) + "元");
			view0.setText("看过: " + (String) (results.get("view")) + "人");
			String addStr = (String) (results.get("address"));
			String content = (String) (results.get("content"));
			String hasCoupon = (String) results.get("hasCoupon");
			System.out.println(hasCoupon);
			String hasGroup = (String) results.get("hasGroup");
			String hasBank = (String) results.get("hasBank");
			String hasBook = (String) results.get("hasBook");
			String onlyShop = (String) results.get("onlyShop");
			if (hasCoupon.equals("true")) {
				huiImageView.setVisibility(View.VISIBLE);
			}
			if (hasBank.equals("true")) {
				bankImageView.setVisibility(View.VISIBLE);
			}
			if (hasGroup.equals("true")) {
				tuanImageView.setVisibility(View.VISIBLE);
			}
			if (hasBook.equals("true")) {
				bookImageView.setVisibility(View.VISIBLE);
			}
			if (content == null) {
				contentText.setText(addStr);
			} else {
				contentText.setText((String) (results.get("content")));
			}

			trade_name0.setText((String) (results.get("trade_name")));
			distance.setText((String) (results.get("distance")) + "米");
			star.setRating(Float.parseFloat((String) (results.get("star"))));
			return view;
		}
	}

	// 地图定位。。。。

	// 地图定位功能初始化

	public void initLocation() {
		mLocClient = new LocationClient(context);
		locData = new LocationData();
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);
		option.setCoorType("bd09ll");
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		mLocClient.start();
	}

	/**
	 * 定位SDK监听函数
	 */
	public class MyLocationListenner implements BDLocationListener {

		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location == null)
				return;
			if (isFirstLoc == true) {
				isFirstLoc = false;
				locData.latitude = location.getLatitude();
				locData.longitude = location.getLongitude();

				System.out.println(" locData.latitude:" + locData.latitude);
				System.out.println(" locData.longitude:" + locData.longitude);
				
				GeoPoint ptCenter = new GeoPoint((int) (location
 						.getLatitude() * 1e6), (int) (location
 						.getLongitude() * 1e6));
				
				curPoint = location.getLatitude() + ","
 						+ location.getLongitude();
				
				mSearch.reverseGeocode(ptCenter);
			}
		

		}

		public void onReceivePoi(BDLocation poiLocation) {
			if (poiLocation == null) {
				return;
			}
		}
	}

	public void initMap() {
		if(context==null){
			System.out.println("adsfs");
		}
	
		MyApplication app = (MyApplication)	AroundFragment.this.getActivity().getApplication();
		mSearch = new MKSearch();
		mSearch.init(app.mBMapManager, new MKSearchListener() {
			@Override
			public void onGetPoiDetailSearchResult(int type, int error) {
			}

			public void onGetAddrResult(MKAddrInfo res, int error) {
				if (error != 0) {
					String str = String.format("error,.....��%d", error);
					System.out.println("错误ixinxi" + str);
					locationTextView.setText("定位失败！");
					return;
				}

				if (res.type == MKAddrInfo.MK_REVERSEGEOCODE) {
					// System.out.println("ddddddd");

					String addInfo = res.strAddr;
					System.out.println("我的位置：" + addInfo);
					locationTextView.setText("我的位置：" + addInfo);
					
				}

			}

			public void onGetPoiResult(MKPoiResult res, int type, int error) {

			}

			public void onGetDrivingRouteResult(MKDrivingRouteResult res,
					int error) {
			}

			public void onGetTransitRouteResult(MKTransitRouteResult res,
					int error) {
			}

			public void onGetWalkingRouteResult(MKWalkingRouteResult res,
					int error) {
			}

			public void onGetBusDetailResult(MKBusLineResult result, int iError) {
			}

			@Override
			public void onGetSuggestionResult(MKSuggestionResult res, int arg1) {
			}

			@Override
			public void onGetShareUrlResult(MKShareUrlResult result, int type,
					int error) {
				// TODO Auto-generated method stub

			}

		});
	}

}
