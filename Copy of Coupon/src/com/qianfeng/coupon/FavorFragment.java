package com.qianfeng.coupon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.example.cache.CacheInterfaceCallback;
import com.example.contants.JsonUtils;
import com.example.tools.NetworkUtils;

@SuppressLint("ValidFragment")
public class FavorFragment extends Fragment {
	private Context context;
	private LayoutInflater inflater;
	private NetworkUtils networkUtils;
	private JsonUtils jsonUtils;
	private CacheInterfaceCallback imgCallback;

	private LinearLayout innerLinearLayout;
	private String url_tuangou = "http://www.doujiao.com/search/deal/v2?pi=0&cat=255&sort=3&city=%E5%8C%97%E4%BA%AC&ver=13&cv=A34&devID=null&token=000000000000000&couponVer=4.2.1&personID=";

	Integer[] otherImageIds = { R.drawable.ad_1, R.drawable.ad_2,
			R.drawable.ad_3, R.drawable.ad_4, R.drawable.ad_5, R.drawable.ad_6,
			R.drawable.ad_7, R.drawable.ad_8, R.drawable.ad_9,
			R.drawable.ad_10, R.drawable.ad_13, R.drawable.ad_14 };

	private LinearLayout groupLayout;

	public FavorFragment() {

	}

	public FavorFragment(Context context) {
		this();
		this.context = context;
	}

	// @Override
	// public View onCreateView(LayoutInflater inflater, ViewGroup container,
	// Bundle savedInstanceState) {
	// this.inflater = inflater;
	// networkUtils = new NetworkUtils();
	// jsonUtils = new JsonUtils();
	//
	// imgCallback = CacheFactory.getCacheManager();
	// groupLayout = (LinearLayout) inflater.inflate(R.layout.group, null);
	// // downloadFooter = (LinearLayout) inflater.inflate(
	// // R.layout.download_list_footer, null);
	// makeLayout(R.id.hotOuterLayout2, R.layout.hot_gridview_item,
	// otherImageIds.length);
	// return groupLayout;
	// }
	//
	// public void makeLayout(int outerResId, int itemResId, int length) {
	//
	// LinearLayout outerLayout = (LinearLayout) scrollChildLayout
	// .findViewById(outerResId);
	// for (int i = 0; i < length / 4; i++) {
	// System.out.println(i);
	// innerLinearLayout = new LinearLayout(context);
	// LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(
	// LinearLayout.LayoutParams.MATCH_PARENT,
	// LinearLayout.LayoutParams.WRAP_CONTENT);
	//
	// innerLinearLayout.setLayoutParams(layoutParams1);
	// innerLinearLayout.setOrientation(LinearLayout.HORIZONTAL);
	// for (int j = 0; j < 4; j++) {
	//
	// LinearLayout itemLayout = (LinearLayout) inflater.inflate(
	// itemResId, null);
	// // 设置监听器
	// int pos = i * 4 + j;
	// itemLayout.setOnClickListener(new OnItemClickListener(
	// outerResId, pos));
	//
	// addData(pos, itemResId, itemLayout);
	// innerLinearLayout.addView(itemLayout);
	// LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) itemLayout
	// .getLayoutParams();
	// lp.topMargin = 40;
	// lp.leftMargin = 20;
	// lp.width = 0;
	// lp.weight = 1;
	// itemLayout.setLayoutParams(lp);
	// }
	// outerLayout.addView(innerLinearLayout);
	// }
	//
	// }
}
