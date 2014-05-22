package com.example.task_expandlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyExAdapter extends BaseExpandableListAdapter{
	String[] group = {"1","2","3","4"};
	String[][] childe= {{"shabi","erbi","sanbi"},{"niaho","hello","ri"},{"just"},{"zheshiyige"}};
	
	private Context context;
	private LayoutInflater inflater;
	
	
	public MyExAdapter(Context context) {
		super();
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getGroupCount() {
		return group.length;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return childe[groupPosition].length;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return group[groupPosition];
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return group[groupPosition];
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		View groupView = inflater.inflate(R.layout.group_view, null);
		((TextView)groupView.findViewById(R.id.textView1)).setText(group[groupPosition]);
		return groupView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		View childView = inflater.inflate(R.layout.childe_view, null);
		((TextView) childView.findViewById(R.id.textView1)).setText(childe[groupPosition][childPosition]);
		((ImageView) childView.findViewById(R.id.imageView1)).setImageResource(R.drawable.ic_launcher);
		return childView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

}
