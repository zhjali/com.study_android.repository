package com.example.task_actionprovider;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ShareActionProvider;

public class MyProvider extends ShareActionProvider {
	Context context;
	
	public MyProvider(Context context) {
		super(context);
		this.context = context;
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateActionView() {
		final Button button = new Button(context);
		button.setText("+");
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PopupWindow window = new PopupWindow();
				window.setWindowLayoutMode(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
				
				ListView view = new ListView(context);
				
				ArrayAdapter<String> myadAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
				myadAdapter.add("hello");
				myadAdapter.add("nihao");
				myadAdapter.add("he");
				myadAdapter.add("A");
				myadAdapter.add("B");
				view.setAdapter(myadAdapter);
				view.setBackgroundColor(Color.BLACK);
				
				window.setContentView(view);
				window.setFocusable(true);
				window.showAsDropDown(button);
			}
		});
		return button;
	}

}
