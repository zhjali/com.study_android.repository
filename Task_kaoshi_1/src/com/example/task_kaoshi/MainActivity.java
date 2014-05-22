package com.example.task_kaoshi;

import android.os.Bundle;
import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.res.TypedArray;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class MainActivity extends Activity {
	public static final String POSITION = "position";
	GridView gridView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		int[] task = getResources().getIntArray(R.array.picture);
		for(int i:task){
			System.out.println(task[i]);
		}
		TypedArray datas = getResources().obtainTypedArray(R.array.picture);
		MyAdapter adapter = new MyAdapter(this,datas);
		
		gridView = (GridView) findViewById(R.id.gridView1);
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.putExtra(MainActivity.POSITION, position);
				intent.setClass(MainActivity.this, SinglePic.class);
				startActivity(intent);
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
