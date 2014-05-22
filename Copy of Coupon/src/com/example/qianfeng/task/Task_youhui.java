package com.example.qianfeng.task;

import java.util.ArrayList;

import com.example.contants.Info_youhui;
import com.example.exception.BuilderException;

public class Task_youhui {

	private ArrayList<Info_youhui> zuires = new ArrayList<Info_youhui>();

	// public Task_youhui() {
	// zuire.setShopName("四川饭店");
	// zuire.setCouponTitle("水煮肉片");
	// zuire.setSource("美团网");
	// zuire.setUseful("有用");
	// zuire.setEndTime("1399096640463");
	// zuire.setUseless("不能用");
	// zuire.setDescription("仅限一人使用");
	// //只在第一级列表中使用
	// zuire.setDownload("4");
	// }

	public ArrayList<Info_youhui> getZuires() throws BuilderException {
		Info_youhui.Builder youhuiBuilder = new Info_youhui.Builder();
		zuires.add(youhuiBuilder.setStartTime("1389095640463")
				.setCouponTitle("水煮肉片").setDescription("仅178元，享受价值385元[巫山烤全鱼]")
				.setDownload("4").setEndTime("1399096640463").setSource("美团网")
				.setUseful("能使用").setUseless("不能使用").build());
		zuires.add(youhuiBuilder.setStartTime("1399075640463")
				.setCouponTitle("猫山王榴莲").setDescription("仅售32元，价值48元榴莲冰激凌一份")
				.setDownload("8").setEndTime("1399096640463").setSource("百度糯米")
				.setUseful("能使用").setUseless("不能使用").build());
		zuires.add(youhuiBuilder.setStartTime("1099095640463")
				.setCouponTitle("鲜芋仙").setDescription("仅售88元，价值114元甜品套餐")
				.setDownload("8").setEndTime("1399096640463").setSource("百度糯米")
				.setUseful("能使用").setUseless("不能使用").build());
		zuires.add(youhuiBuilder.setStartTime("1329095640463")
				.setCouponTitle("奶奶南锣阳光消除").setDescription("仅售68元，价值248元2人套餐")
				.setDownload("3").setEndTime("1399096640463").setSource("百度糯米")
				.setUseful("能使用").setUseless("不能使用").build());
		zuires.add(youhuiBuilder.setStartTime("1399005640463")
				.setCouponTitle("水煮肉片").setDescription("仅限一人使用")
				.setDownload("4").setEndTime("1399096640463").setSource("美团网")
				.setUseful("能使用").setUseless("不能使用").build());
		zuires.add(youhuiBuilder.setStartTime("1009095640463")
				.setCouponTitle("水煮肉片").setDescription("仅限一人使用")
				.setDownload("4").setEndTime("1399096640463").setSource("美团网")
				.setUseful("能使用").setUseless("不能使用").build());
		zuires.add(youhuiBuilder.setStartTime("399095640463")
				.setCouponTitle("水煮肉片").setDescription("仅限一人使用")
				.setDownload("4").setEndTime("1399096640463").setSource("美团网")
				.setUseful("能使用").setUseless("不能使用").build());
		return zuires;
	}

}
