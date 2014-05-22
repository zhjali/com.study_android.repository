package com.example.task_list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity {
	private static int times = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ListView listView = (ListView) findViewById(R.id.listview1);
		listView.setAdapter(new MyAdapter(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class MyAdapter extends BaseAdapter {
		private Context mContext;
		private LayoutInflater mInflater;

		class ViewHolder {
			ImageView imageView;
		}

		private int[] images = { R.drawable.emo_im_angel,
				R.drawable.emo_im_cool, R.drawable.emo_im_embarrassed,
				R.drawable.emo_im_foot_in_mouth, R.drawable.emo_im_happy,
				R.drawable.emo_im_kissing, R.drawable.emo_im_laughing };

		public MyAdapter(Context context) {
			super();
			this.mContext = context;
			mInflater = LayoutInflater.from(context);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 7;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ViewHolder holder;

			Log.v("ListTask", "in getView for position " + position
					+ ",convertView is "
					+ ((convertView == null) ? "null" : "being recycled"));

			if (convertView == null) {
				convertView = mInflater.inflate(R.layout.list_item, null);
				holder = new ViewHolder();
				holder.imageView = (ImageView) convertView
						.findViewById(R.id.imageView1);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.imageView.setImageDrawable(mContext.getResources()
					.getDrawable(images[position]));
			return convertView;
		}
	}
}
