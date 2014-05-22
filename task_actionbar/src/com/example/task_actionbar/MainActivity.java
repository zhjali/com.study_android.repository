package com.example.task_actionbar;

import android.R.menu;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar();
	}
	ProgressBar bar;
	Menu menu;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		this.menu = menu;
		getMenuInflater().inflate(R.menu.main, menu);
		
		MenuItem menuItem = menu.findItem(R.id.progressBar);
		bar = (ProgressBar) menuItem.getActionView();
		
		SearchView searchView =	(SearchView)menu.findItem(R.id.search).getActionView();
		searchView.setOnQueryTextListener(new OnQueryTextListener() {
			
			@Override
			public boolean onQueryTextSubmit(String query) {
				System.out.println("query: "+query);
				return false;
			}
			
			@Override
			public boolean onQueryTextChange(String newText) {
				System.out.println("new: "+newText);
				return false;
			}
		});
		
		View view = (View) menu.findItem(R.id.menu_layout).getActionView();
		Button button1 = (Button) view.findViewById(R.id.button1);
		button1.setOnClickListener( new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("be click");
			}
		});
		
		menu.findItem(R.id.menu_layout).setOnActionExpandListener(new OnActionExpandListener() {
			
			@Override
			public boolean onMenuItemActionExpand(MenuItem item) {
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public boolean onMenuItemActionCollapse(MenuItem item) {
				// TODO Auto-generated method stub
				return true;
			}
		});
		return true;
		
	}

	public void beClicked(View view){
		Intent intent = new Intent();
		intent.setClass(this, SecondActivity.class);
		startActivity(intent);
	}
}
