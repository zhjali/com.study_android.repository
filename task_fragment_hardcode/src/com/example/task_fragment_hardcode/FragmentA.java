package com.example.task_fragment_hardcode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentA extends Fragment implements OnItemClickListener {
	ArrayAdapter<String> adapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		//View view = inflater.inflate(R.layout.fragment_a, null);
		View view =inflater.inflate(R.layout.fragment_a, container, false);
		
		ListView list = (ListView) view.findViewById(R.id.listView1);
		adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1);
		adapter.add("Item1");
		adapter.add("Item2");
		adapter.add("Item3");
		adapter.add("Item4");
		adapter.add("Item5");
		adapter.add("Item6");

		list.setAdapter(adapter);
		list.setOnItemClickListener(this);

		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

	}
}
