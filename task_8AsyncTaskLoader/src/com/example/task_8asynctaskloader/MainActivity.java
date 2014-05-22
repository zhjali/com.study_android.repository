package com.example.task_8asynctaskloader;

import java.util.List;
import java.util.Map;
import android.os.Bundle;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity implements LoaderCallbacks<List<Map<String,Object>>>{
	ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.listView1);
		
		getLoaderManager().initLoader(1, null, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public Loader<List<Map<String, Object>>> onCreateLoader(int id, Bundle args) {
		return new MyContactLoader(this, listView);
	}

	@Override
	public void onLoadFinished(Loader<List<Map<String, Object>>> loader,
			List<Map<String, Object>> data) {
	}

	@Override
	public void onLoaderReset(Loader<List<Map<String, Object>>> loader) {
	}

}
