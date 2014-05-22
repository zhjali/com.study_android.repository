package com.example.task_fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MyFragment extends Fragment {
	ArrayAdapter<String> adapter;
	/**
	 * 设置 Fragment显示的界面 inflater 布局资源解析器 container Fragment的父容器
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.my_fragment, null);
		adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1);
		adapter.add("A");
		adapter.add("B");
		adapter.add("C");
		adapter.add("D");
		adapter.add("E");
		adapter.add("F");
		ListView listView = (ListView) view.findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
			TextView textView = (TextView) getActivity().findViewById(R.id.textView1);
			if(textView != null){
				textView.setText(adapter.getItem(position));
			}else {
				Intent intent = new Intent();
				intent.putExtra("data", adapter.getItem(position));
				intent.setClass(getActivity(), BActivity.class);
				startActivity(intent);
			}
			}
		});
		return view;
	}

}
