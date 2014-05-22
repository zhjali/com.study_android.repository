package com.qianfeng.coupon;

import java.util.Date;
import java.util.EmptyStackException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cache.CacheFactory;
import com.example.cache.CacheInterfaceCallback;
import com.example.contants.JsonUtils;
import com.example.contants.Result;
import com.example.contants.shop1;
import com.example.tools.NetworkUtils;
import com.example.tools.OnNetworkDownloadCompletedCallback;

public class FavorShopActivity extends Activity {
	private Result rs;
	
	private CacheInterfaceCallback imgCallback;
	private NetworkUtils networkUtils;
	private JsonUtils jsonUtils;
	
	private TextView shopEmptyText;
	
	private LinearLayout groupShopItemLayout;
	
	private LayoutInflater inflater;
	private LinearLayout shopsLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_group_detail);
		inflater=LayoutInflater.from(FavorShopActivity.this);
		networkUtils = new NetworkUtils();
		imgCallback = CacheFactory.getCacheManager();
		final ImageView couponimage = (ImageView)findViewById(R.id.couponimage);
		TextView price = (TextView) findViewById(R.id.price);
		TextView value = (TextView) findViewById(R.id.value_text);
		TextView bought = (TextView) findViewById(R.id.bought);
	
		
		TextView title = (TextView)findViewById(R.id.description);
		TextView shengyu = (TextView) findViewById(R.id.left);
		shopEmptyText=(TextView)findViewById(R.id.shop_empty);
		shopsLayout=(LinearLayout)findViewById(R.id.shops);
		
		Intent intent=getIntent();
		rs=(Result)intent.getSerializableExtra("result");
		
		
		price.setText("￥" + rs.getPrice());
		value.setText("￥" + rs.getValue());
		value.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
		bought.setText(rs.getBought() + "人");
		
		String endTime = rs.getEndTime();
		String mode = "yyyy天MM小时dd分";
		// SimpleDateFormat sdFormat = new SimpleDateFormat(mode);
		Date dat = new Date();
		
		long curTime = dat.getTime();
		System.out.println(endTime);
		System.out.println(curTime);
		long upTime = Long.parseLong(endTime) * 1000 - curTime;
		// String dateString = sdFormat.format(date);
		long day = upTime / (24 * 3600 * 1000);
		long hour = upTime % (24 * 3600 * 1000) / (3600 * 1000);
		long minus = upTime % (24 * 3600 * 1000) % (3600 * 1000)
				/ (60 * 1000);
		shengyu.setText("剩余" + day + "天" + hour + "小时" + minus + "分");
		
		if(rs.getShops().size()==0){
			shopEmptyText.setVisibility(View.VISIBLE);
		}else{
			groupShopItemLayout=(LinearLayout)inflater.inflate(R.layout.group_shop_item, null);
			RatingBar ratingBar = (RatingBar)groupShopItemLayout.findViewById(R.id.rating_);
			TextView renjun = (TextView) groupShopItemLayout.findViewById(R.id.renjun_);
			TextView adress = (TextView) groupShopItemLayout.findViewById(R.id.adress_);
			TextView shopName = (TextView)groupShopItemLayout. findViewById(R.id.name_);
			TextView name = (TextView)groupShopItemLayout. findViewById(R.id.title_);
			adress.setText(rs.getShops().get(0).getAddress());
			shopName.setText(rs.getShops().get(0).getName());
			name.setText(rs.getShops().get(0).getName());
			name.setText(rs.getShops().get(0).getName());
			renjun.setText(" 人均 : " + rs.getPrice() + ".0元");
			ratingBar.setRating(Float
					.parseFloat(rs.getShops().get(0).getStar()));
			shopsLayout.addView(groupShopItemLayout);
		}
		title.setText(rs.getTitle());
		String imgUrl = rs.getImage();

		if (imgUrl != null) {
			networkUtils.imageDownload(imgUrl,null, imgCallback,
					new OnNetworkDownloadCompletedCallback() {

						@Override
						public void OnNetworkDownloadCompleted(Bitmap result) {
							//System.out.println(111111);
							couponimage.setImageBitmap(result);
							
						}

						@Override
						public void OnNetworkDownloadCompleted(byte[] result) {

						}
					});
		} else {
			Toast.makeText(FavorShopActivity.this, "图片地址没找到", Toast.LENGTH_SHORT)
					.show();
		}
	}

	

}
