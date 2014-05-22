package com.example.taskbutton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
	private RadioGroup group;
	private RadioButton r1;
	private RadioButton r2;
	private RadioButton r3;
	private RadioButton r4;
	private CheckBox c1;
	private CheckBox c2;
	private CheckBox c3;
	private CheckBox c4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		group = (RadioGroup) findViewById(R.id.radioGroup1);
		c1 = (CheckBox) findViewById(R.id.checkBox1);
		c2 = (CheckBox) findViewById(R.id.checkBox2);
		c3 = (CheckBox) findViewById(R.id.checkBox3);
		c4 = (CheckBox) findViewById(R.id.checkBox4);
		group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				String message = null;
				switch (checkedId) {
				case R.id.radio0:
					message = "a is checked";
					break;
				case R.id.radio1:
					message = "b is checked";
					break;
				case R.id.radio2:
					message = "c is checked";
					break;
				case R.id.radio3:
					message = "d is checked";
					break;

				}
				Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT)
						.show();
			}
		});
		findViewById(R.id.button1).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						c1.setChecked(true);
						c2.setChecked(true);
						c3.setChecked(true);
						c4.setChecked(true);
					}
				});
		findViewById(R.id.button2).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						c1.setChecked(false);
						c2.setChecked(false);
						c3.setChecked(false);
						c4.setChecked(false);
					}
				});
		findViewById(R.id.button2).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						c1.setChecked(false);
						c2.setChecked(false);
						c3.setChecked(false);
						c4.setChecked(false);
					}
				});
		findViewById(R.id.button3).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						Toast.makeText(
								MainActivity.this,
								(c1.isChecked() ? "A is checked" : "")
										+ (c2.isChecked() ? "B is checked" : "")
										+ (c3.isChecked() ? "C is checked" : "")
										+ (c4.isChecked() ? "D is checked" : ""),
								Toast.LENGTH_SHORT).show();
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
