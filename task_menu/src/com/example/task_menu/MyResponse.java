package com.example.task_menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;

public class MyResponse implements OnMenuItemClickListener {

	Context mContext;

	public MyResponse(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		String display = null;
		switch (item.getItemId()) {
		case 1:
			display = "click 1";
			break;
		case 2:
			display = "click 2";
			break;
		case 3:
			display = "click 3";
			break;
		case 4:
			display = "click 4";
			break;

		default:
			return true;
		}
		Toast.makeText(mContext, display, Toast.LENGTH_SHORT).show();
		return true;
	}

}
