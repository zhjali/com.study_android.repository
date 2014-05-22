package com.example.task_fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class BActivity extends FragmentActivity{


	@Override
	protected void onCreate(Bundle arg0) {
		setContentView(R.layout.activity_3);
		
		String content = getIntent().getStringExtra("data");
		TextView textView = (TextView) findViewById(R.id.textView1);
		textView.setText(content);

	}
}
