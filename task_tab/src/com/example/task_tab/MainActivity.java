package com.example.task_tab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;

public class MainActivity extends FragmentActivity implements OnCheckedChangeListener, OnClickListener, OnTabChangeListener {
	FragmentTabHost tabHost;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost); 
		tabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);
		
		TabSpec tabSpecA = tabHost.newTabSpec("0").setIndicator("A");
		TabSpec tabSpecB = tabHost.newTabSpec("1").setIndicator("B");
		TabSpec tabSpecC = tabHost.newTabSpec("2").setIndicator("C");
		TabSpec tabSpecD = tabHost.newTabSpec("3").setIndicator("D");
		
		tabHost.addTab(tabSpecA,FragmentA.class,null);
		tabHost.addTab(tabSpecB, FragmentB.class, null);
		tabHost.addTab(tabSpecC, FragmentC.class, null);
		tabHost.addTab(tabSpecD, FragmentD.class, null);
		
		RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
		group.setOnCheckedChangeListener(this);
		
		tabHost.getTabWidget().setVisibility(View.GONE);
		tabHost.setOnTabChangedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.radio0:
			tabHost.setCurrentTab(0);
			break;
		case R.id.radio1:
			tabHost.setCurrentTab(1);
			break;
		case R.id.radio2:
			tabHost.setCurrentTab(2);
			break;
		case R.id.radio3:
			tabHost.setCurrentTab(3);
			break;
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabChanged(String tabId) {
		if (tabId.equals("0")) {
			Toast.makeText(this, "Change to A", Toast.LENGTH_SHORT).show();
		}
		if (tabId.equals("1")) {
			Toast.makeText(this, "Change to B", Toast.LENGTH_SHORT).show();
		}
		if (tabId.equals("2")) {
			Toast.makeText(this, "Change to C", Toast.LENGTH_SHORT).show();
		}
		if (tabId.equals("3")) {
			Toast.makeText(this, "Change to D", Toast.LENGTH_SHORT).show();
		}
	}

}
