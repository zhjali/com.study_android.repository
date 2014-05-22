package com.example.task_qq;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdater extends BaseAdapter {
	// map.String == "content"||"person"||"date"
	// map.Object == String || Integer || String
	// Integer->self is 0,other is 1

	public static final String content = "content";
	public static final String person = "person";
	public static final String date = "date";
	private ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
	private Context mContext;
	private LayoutInflater mInflater;

	public ArrayList<HashMap<String, Object>> getData() {
		return data;
	}

	public void setData(ArrayList<HashMap<String, Object>> data) {
		this.data = data;
	}

	public MyAdater(Context mContext) {
		super();
		this.mContext = mContext;
		mInflater = LayoutInflater.from(mContext);
		// for (int i = 0; i < 10; i++) {
		// HashMap<String, Object> columns = new HashMap<String, Object>();
		// if (i % 2 == 0) {
		// columns.put("person", 0);
		// columns.put("content", "nihao");
		// } else {
		// columns.put("person", 1);
		// columns.put("content", "hello");
		// }
		// data.add(columns);
		// }
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		HashMap<String, Object> columns = data.get(position);
		// ViewHolder viewHolder;
		// if(convertView == null){
		// convertView = mInflater.inflate(R.layout.list_item0, null);
		// viewHolder = new ViewHolder();
		// viewHolder.imageView = convertView.findViewById(R.id.)
		// }
		switch ((Integer) columns.get(MyAdater.person)) {
		case 0:
			view = mInflater.inflate(R.layout.list_item0, null);
			((TextView) view.findViewById(R.id.time0)).setText((String) columns
					.get(MyAdater.date));
			((Button) view.findViewById(R.id.content0))
					.setText((String) columns.get(MyAdater.content));
			break;
		case 1:
			view = mInflater.inflate(R.layout.list_item1, null);
			((TextView) view.findViewById(R.id.time1)).setText((String) columns
					.get(MyAdater.date));
			((Button) view.findViewById(R.id.content1))
					.setText((String) columns.get("content"));

			break;
		default:
			break;
		}

		return view;
	}

	public class ViewHolder {
		Button button;
		ImageView imageView;
	}
}
