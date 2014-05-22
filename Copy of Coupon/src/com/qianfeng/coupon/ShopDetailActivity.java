package com.qianfeng.coupon;

import java.util.List;
import java.util.Map;

import merchantDetail.Params;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.contants.Demo_youhui;
import com.example.contants.Info_youhui;
import com.example.contants.JsonUtils;
import com.example.contants.ground.Comment;
import com.example.contants.ground.Head;
import com.example.contants.ground.Icons;
import com.example.contants.ground.ShopInfo;
import com.example.contants.ground.ground_pinglun;
import com.example.tools.NetworkUtils;
import com.example.tools.OnNetworkDownloadCompletedCallback;

import com.example.tools.PullXmlHelper;

public class ShopDetailActivity extends Activity {
	private LayoutInflater inflater;
	private NetworkUtils networkUtils;
	private Demo_youhui youhui;
	private JsonUtils jsonUtils;
	private List<Info_youhui> nums;
	private String url_zuire = "http://www.doujiao.com/search/coupon/v5?city=%E5%8C%97%E4%BA%AC&pi=0&psize=10&type=hot&devID=null&token=000000000000000&couponVer=4.2.1&personID=";
	private String url_merchantDetail = "http://www.doujiao.com/search/detail?id=395693&city=%E5%8C%97%E4%BA%AC&ver=13&cv=A34&devID=ac:f7:f3:c3:0f:4b&token=860310024932933&couponVer=4.2.1&personID=";
	private String url_gpinglun = "http://www.doujiao.com/customer/action/signin/signincomment/v3?sid=456200&cid=&c=%E5%8C%97%E4%BA%AC&devID=ac:f7:f3:c3:0f:4b&token=860310024932933&couponVer=4.2.1&personID=";
	private PullXmlHelper pullXmlHelper;
	private Params params;
	private ground_pinglun gPinglun;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_shop_detail);
		inflater = LayoutInflater.from(this);
		Intent intent=getIntent();
		String id=intent.getStringExtra("shopId");
		String newUrl=url_merchantDetail.replace("id=395693", "id="+id);
		System.out.println("id.."+id);
		jsonUtils = new JsonUtils();
		networkUtils = new NetworkUtils();
		pullXmlHelper = new PullXmlHelper();
		params = new Params();
		networkUtils.textDownload(newUrl,
				new OnNetworkDownloadCompletedCallback() {

					@Override
					public void OnNetworkDownloadCompleted(Bitmap result) {

					}

					@Override
					public void OnNetworkDownloadCompleted(byte[] result) {
						// youhui = jsonUtils.changeJsonToObject(result);
						// nums = youhui.getResults();
						List<String> groups = params.getParams_groundList();
						List<Map<String, Object>> bankCoupons = pullXmlHelper
								.getXmlList(result, "result",
										params.getParams_bankCoupons());
						System.out.println("bankCoupons---->"+bankCoupons);
						List<Map<String, Object>> groupList = pullXmlHelper
								.getXmlList(result, "result", groups);
						System.out.println("group:------>"+groupList);
						List<Map<String, Object>> coupons = pullXmlHelper
								.getXmlList(result, "result",
										params.getParams_Coupon());
						List<Map<String, Object>> books = pullXmlHelper
								.getXmlList(result, "result",
										params.getParams_books());
						System.out.println("books--->"+books);
						List<String> result1s = params.getParams_Result1();
						List<Map<String, Object>> results = pullXmlHelper
								.getXmlList(result, "result", result1s);
						TextView shop_name = (TextView) findViewById(R.id.shop_name);
						TextView renjun = (TextView) findViewById(R.id.save_value);
						TextView shopAdress = (TextView) findViewById(R.id.shop_address);
						TextView shoptel = (TextView) findViewById(R.id.shop_tel);
						TextView introduction = (TextView) findViewById(R.id.introduction);
						TextView cai_num = (TextView) findViewById(R.id.cai_num);
						TextView cai_introduce = (TextView) findViewById(R.id.cai_introduce);
						// TextView sign_num = (TextView)
						// findViewById(R.id.sign_num);
						ImageView jtImageView = (ImageView) findViewById(R.id.jtImage_cai);
						Map<String, Object> nums = results.get(0);
						shop_name.setText((String) (nums.get("name")));
						shopAdress.setText((String) (nums.get("address")));
						shoptel.setText((String) (nums.get("telno")));
						introduction.setText((String) (nums.get("introduction")));
						// shop_name.setText((String) (nums.get("name")));
						renjun.setText("人均 : " + (String) (nums.get("price"))
								+ "元");
						String features = (String) nums.get("features");
						if (!features.equals("")) {
							cai_introduce.setText(features);
						} else {
							cai_introduce.setText("暂无");
							jtImageView.setVisibility(View.GONE);
						}
						LinearLayout list = (LinearLayout) findViewById(R.id.list);
						if (bankCoupons.get(0)!=null) {
							System.out.println("bank:"+bankCoupons.size());
							for (int i = 0; i < bankCoupons.size(); i++) {
								RelativeLayout lily = (RelativeLayout) inflater
										.inflate(
												R.layout.ground_shopdetail_bank,
												null);
								ImageView ka = (ImageView) lily
										.findViewById(R.id.imageLeft);
								TextView diacount = (TextView) lily
										.findViewById(R.id.address_);
								TextView source = (TextView) lily
										.findViewById(R.id.source_);
								ImageView right = (ImageView) lily
										.findViewById(R.id.jt22);
								ka.setImageResource(R.drawable.d_ka);
								right.setImageResource(R.drawable.jt2);
								diacount.setText((String) bankCoupons.get(i)
										.get("discount"));
								source.setText((String) bankCoupons.get(i).get(
										"bank"));
								list.addView(lily);
							}
						}
						if (books.get(0)!=null) {

							for (int i = 0; i < books.size(); i++) {
								RelativeLayout lily = (RelativeLayout) inflater
										.inflate(
												R.layout.ground_shopdetail_bank,
												null);
								ImageView ka = (ImageView) lily
										.findViewById(R.id.imageLeft);
								TextView diacount = (TextView) lily
										.findViewById(R.id.address_);
								TextView source = (TextView) lily
										.findViewById(R.id.source_);
								ImageView right = (ImageView) lily
										.findViewById(R.id.jt22);
								ka.setImageResource(R.drawable.d_tuan);
								right.setImageResource(R.drawable.jt2);
								diacount.setText((String) books.get(i).get(
										"title"));
								source.setText((String) bankCoupons.get(i).get(
										"source"));
								list.addView(lily);
							}
						}
						if (groupList.get(0)!=null) {
							System.out.println("groupList:"+groupList.size());
							for (int i = 0; i < groupList.size(); i++) {
								RelativeLayout lily = (RelativeLayout) inflater
										.inflate(
												R.layout.ground_shopdetail_bank,
												null);
								ImageView ka = (ImageView) lily
										.findViewById(R.id.imageLeft);
								TextView diacount = (TextView) lily
										.findViewById(R.id.address_);
								TextView source = (TextView) lily
										.findViewById(R.id.source_);
								ImageView right = (ImageView) lily
										.findViewById(R.id.jt22);
								ka.setImageResource(R.drawable.d_tuan);
								right.setImageResource(R.drawable.jt2);
								diacount.setText((String) groupList.get(i).get(
										"title"));
								source.setText((String) bankCoupons.get(i).get(
										"website"));
								list.addView(lily);
							}
						}
						// String endTime = num.getEndTime();
						// Date date = new Date(Long.parseLong(endTime));
						// String mode = "yyyy-MM-dd";
						// SimpleDateFormat sdFormat = new
						// SimpleDateFormat(mode);
						// String dateString = sdFormat.format(date);
						// System.out.println(dateString);
						// time.setText("有效期至: " + dateString);
						// useless.setText("(" + num.getUseless() + ")");
						// description.setText(num.getDescription());
					}
				});
		networkUtils.textDownload(url_gpinglun,
				new OnNetworkDownloadCompletedCallback() {

					@Override
					public void OnNetworkDownloadCompleted(Bitmap result) {

					}

					@Override
					public void OnNetworkDownloadCompleted(byte[] result) {
						gPinglun = jsonUtils
								.changeJsonToObject_gpingjun(result);
						System.out.println(gPinglun);
						RatingBar itemRating = (RatingBar) findViewById(R.id.item_rating_avg);
						TextView like = (TextView) findViewById(R.id.like);
						TextView save = (TextView) findViewById(R.id.save);
						TextView saveNum = (TextView) findViewById(R.id.savenum);
						TextView name_pinglun = (TextView) findViewById(R.id.name);
						TextView date_pinglun = (TextView) findViewById(R.id.date);
						TextView content_pinglun = (TextView) findViewById(R.id.content);
						// TextView sign_num = (TextView)
						// findViewById(R.id.sign_num);
						Comment comment = gPinglun.getComment();
						ShopInfo shopInfo = gPinglun.getShopinfo();
						Head head = gPinglun.getHead();
						Icons icons = gPinglun.getIcons();
						itemRating.setRating(Float.parseFloat(comment.getStar()));
						like.setText(shopInfo.getLike());
						save.setText(shopInfo.getSave() + "人");
						saveNum.setText(shopInfo.getSavenum());
						content_pinglun.setText(comment.getDatas().get(0)
								.getContent());
						String ss = comment.getDatas().get(0).getDate();
						name_pinglun.setText(comment.getDatas().get(0)
								.getName());
						date_pinglun.setText(ss);
					}
				});
	}
		
}




