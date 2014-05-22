package com.example.task_6a_asyntaskloader;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.AsyncTaskLoader;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity implements LoaderCallbacks<Cursor>{
	public static SimpleCursorAdapter adapter;
	public static ContentResolver contentResolver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		getLoaderManager().initLoader(0, null, this);
		adapter = new SimpleCursorAdapter(this, 
						R.layout.list_item,
						null, 
						new String[]{"name","age"},
						new int[]{R.id.textView1,R.id.textView2},
						SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		ListView listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		
		contentResolver = getContentResolver();
		
	}



	
	public static class MyLoader extends AsyncTaskLoader<Cursor>{

		public MyLoader(Context context) {
			super(context);
		}

		@Override
		protected void onStartLoading() {
			super.onStartLoading();
			forceLoad();
		}
		
		@Override
		public Cursor loadInBackground() {
			Uri uri = Uri.parse("content://com.example.MyProvider/student");
			Cursor cursor = contentResolver.query(uri, null, null, null, null);

			return cursor;
		}
		
		@Override
		public void deliverResult(Cursor data) {
			super.deliverResult(data);
			adapter.swapCursor(data);
		}
		
	}






	@Override
	public android.content.Loader<Cursor> onCreateLoader(int id, Bundle args) {
		return new MyLoader(this);

	}


	@Override
	public void onLoadFinished(android.content.Loader<Cursor> loader,
			Cursor data) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void onLoaderReset(android.content.Loader<Cursor> loader) {
		// TODO Auto-generated method stub
		
	}

}
