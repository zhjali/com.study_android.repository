package com.qianfeng.coupon;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.example.contants.Info_youhui;

import android.os.Bundle;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;

public class GroupDetailActivity extends Activity {
	private Info_youhui zuire;
	private Info_youhui zuixin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favor_shop);
		
		 TextView useful = (TextView) findViewById(R.id.haoyong);
		 TextView useless = (TextView) findViewById(R.id.buhaoyong);
		 TextView title = (TextView) findViewById(R.id.title);
		 TextView ticktTitle = (TextView)findViewById(R.id.ticket_title);
		 TextView souce = (TextView)findViewById(R.id.source);
		 TextView time=(TextView)findViewById(R.id.time);
		 TextView description = (TextView)findViewById(R.id.description);
		 
		 
		Intent intent=getIntent();
		String model=intent.getStringExtra("model");
		if(model.equals("hottest")){
			zuire=(Info_youhui)intent.getSerializableExtra("zuire");
			 title.setText(zuire.getShopName());
			 ticktTitle.setText(zuire.getCouponTitle());
			 souce.setText("来源 : "+zuire.getSource());
			 useful.setText("("+zuire.getUseful()+")");
			 String endTime=zuire.getEndTime();
			 Date date = new Date(Long.parseLong(endTime));
			 String mode="yyyy-MM-dd";
			 SimpleDateFormat sdFormat=new SimpleDateFormat(mode);
			 String dateString=sdFormat.format(date);
			 System.out.println(dateString);
			 time.setText("有效期至: "+dateString);
			 useless.setText("("+zuire.getUseless()+")");
			 description.setText(zuire.getDescription());
		}else if(model.equals("lastest")){
			zuixin=(Info_youhui)intent.getSerializableExtra("zuixin");
			 title.setText(zuixin.getShopName());
			 ticktTitle.setText(zuixin.getCouponTitle());
			 souce.setText("来源 : "+zuixin.getSource());
			 useful.setText("("+zuixin.getUseful()+")");
			 String endTime=zuixin.getEndTime();
			 Date date = new Date(Long.parseLong(endTime));
			 String mode="yyyy-MM-dd";
			 SimpleDateFormat sdFormat=new SimpleDateFormat(mode);
			 String dateString=sdFormat.format(date);
			 System.out.println(dateString);
			 time.setText("有效期至: "+dateString);
			 useless.setText("("+zuixin.getUseless()+")");
			 description.setText(zuixin.getDescription());
		}		
		
		
		
	}

	

}
