package com.example.task_async;

import android.content.Context;
import android.os.AsyncTask;

public class MyAsy extends AsyncTask<String, Integer, String> {

	Context mContext;

	public MyAsy(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	protected String doInBackground(String... params) {

		return null;
	}

}
