package com.example.task_sharepreference;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView name;
	TextView password;
	CheckBox saveBox;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name = (TextView) findViewById(R.id.editText1);
		password = (TextView) findViewById(R.id.editText2);
		saveBox = (CheckBox) findViewById(R.id.checkBox1);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		SharedPreferences sharedPreferences = getSharedPreferences("myData", MODE_PRIVATE);
		if(sharedPreferences.getBoolean("check", false)){
			name.setText(getSharedPreferences("myData", MODE_PRIVATE).getString("user", ""));
			password.setText(getSharedPreferences("myData", MODE_PRIVATE).getString("password", ""));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onPause() {
		super.onPause();
		SharedPreferences sharedPreferences = getSharedPreferences("myData", Context.MODE_PRIVATE);
		System.out.println("onPause "+saveBox.isChecked());
		sharedPreferences.edit().putBoolean("check", saveBox.isChecked()).commit();
		sharedPreferences.edit().putString("user",""+ name.getText()).commit();
		sharedPreferences.edit().putString("password",""+ password.getText()).commit();
	}
}
