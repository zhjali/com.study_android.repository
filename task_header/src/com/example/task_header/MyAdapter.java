package com.example.task_header;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private static ArrayList<Boolean> isChecks = new ArrayList<Boolean>();
	ArrayList<String> data;

	public static ArrayList<Boolean> getIsChecks() {
		return isChecks;
	}

	public static void setIsChecks(ArrayList<Boolean> isChecks) {
		MyAdapter.isChecks = isChecks;
	}

	public ArrayList<String> getData() {
		return data;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}

	public MyAdapter(Context mContext, ArrayList<String> data) {
		super();
		this.mContext = mContext;
		this.mInflater = LayoutInflater.from(mContext);
		this.data = data;
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {

		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder = new ViewHolder();

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder.textView = (TextView) convertView
					.findViewById(R.id.textView1);
			holder.checkBox = (CheckBox) convertView
					.findViewById(R.id.checkBox1);
			convertView.setTag(holder);
			isChecks.add(false);
		} else {
			holder = (ViewHolder) convertView.getTag();
			isChecks.add(false);
		}

		holder.textView.setText(data.get(position));
		CheckBox checkBox = holder.checkBox;
		if (isChecks.get(position)) {
			System.out.println(position + " true");
			checkBox.setChecked(true);
		} else {
			checkBox.setChecked(false);
		}
		checkBox.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				isChecks.set(position, !isChecks.get(position));
			}
		});
		return convertView;
	}

	public class ViewHolder {
		TextView textView;
		CheckBox checkBox;
	}
}
