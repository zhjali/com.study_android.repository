package com.example.bmi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText height;
	EditText weight;
	TextView sex;
	Double hValue; // the value of height
	Double wValue;
	String sString;
	Double result;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		height = (EditText) findViewById(R.id.height);
		weight = (EditText) findViewById(R.id.weight);
		sex = (TextView) findViewById(R.id.sex);
		// 如果正常则发送 Double result；Double height，String sex;

		findViewById(R.id.cancel).setOnClickListener(
				new Button.OnClickListener() {

					@Override
					public void onClick(View v) {
						height.setText(null);
						weight.setText(null);
					}
				});

		findViewById(R.id.man).setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				sString = "man";
				sex.setText("您选择了男性");
			}
		});
		findViewById(R.id.women).setOnClickListener(
				new Button.OnClickListener() {

					@Override
					public void onClick(View v) {
						sString = "women";
						sex.setText("您选择了女性");
					}
				});

		findViewById(R.id.caculate).setOnClickListener(
				new Button.OnClickListener() {

					@Override
					public void onClick(View v) {

						if (height.getText() != null
								&& weight.getText() != null) {
							hValue = Double.parseDouble(height.getText()
									.toString());
							wValue = Double.parseDouble(weight.getText()
									.toString());
							result = (wValue / Math.pow(hValue / 100, 2));
							Toast.makeText(MainActivity.this,
									result.toString(), Toast.LENGTH_LONG)
									.show();
							Intent intent = new Intent();
							intent.putExtra("result", result);
							intent.putExtra("height", hValue);
							intent.putExtra("sex", sString);
							intent.setClass(MainActivity.this,
									SecondActivity.class);
							startActivity(intent);
						} else {
							return;
						}
					}
				});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
