package com.example.task_lizhi;

import com.example.utils.DataHelper;
import com.example.utils.NetUtils;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	MyCursorAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Cursor cursor = DataHelper.getInstance(this).query("20,20");
		adapter = new MyCursorAdapter(this, cursor, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		
		String uri = "http://litchiapi.jstv.com/api/GetFeeds?column=0&PageSize=20&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41";
		NetUtils.getData(this, uri, new NetUtils.NetWorkOK() {
			
			@Override
			public void ok() {
				System.out.println("download success______");
				Cursor cursor = DataHelper.getInstance(MainActivity.this).query("0,20");
				adapter.swapCursor(cursor);
			}
		}, new NetUtils.NetWorkError(){
			@Override
			public void error() {
				// TODO Auto-generated method stub
				System.out.println("JSON parsing error");
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onDestroy() {
		DataHelper.getInstance(this).close();
		super.onDestroy();
	}

}
