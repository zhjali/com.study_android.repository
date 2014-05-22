package com.example.bmi;

import java.text.DecimalFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends Activity {
	Double height; // the value of height
	Double result;
	String sex;
	String status;
	TextView text;
	ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_layout);
		text = (TextView) findViewById(R.id.textView2);
		image = (ImageView) findViewById(R.id.imageView1);

		DecimalFormat myFormate = new DecimalFormat("#####0.00");
		Intent intent = getIntent();
		result = intent.getDoubleExtra("result", 0);
		height = intent.getDoubleExtra("height", 0);
		sex = intent.getStringExtra("sex");

		float low = (float) ((height / 100) * (height / 100) * 20);
		float hei = (float) ((height / 100) * (height / 100) * 25);

		String string = "您的BMI指数为：<font color=\"#ff00\">result</font><br/>"
				+ "您的体重情况为：<font color=\"#f0f0\">status<\font><br/>"
				+ "您的健康体重为：lowkg~heikg";
		if (result < 20) {
			image.setImageResource(R.drawable.demo1_1);
			status = "偏瘦";
		} else if (result < 25) {
			image.setImageResource(R.drawable.demo1_2);
			status = "正常";
		} else if (result < 30) {
			image.setImageResource(R.drawable.demo1_3);
			status = "过重";
		} else if (result < 35) {
			image.setImageResource(R.drawable.demo1_4);
			status = "肥胖";
		} else {
			status = "您的输入有误";
		}

		string = string.replace("result", myFormate.format(result))
				.replace("status", status).replace("low", String.valueOf(low))
				.replace("hei", String.valueOf(hei));
		text.setText(Html.fromHtml(string));
	}
}
