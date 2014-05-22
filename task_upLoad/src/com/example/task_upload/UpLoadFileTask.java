package com.example.task_upload;

import java.io.File;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

public class UpLoadFileTask extends AsyncTask<String, Void, String> {
	private static final String TAG = "UpLoadFileTask";
	private ProgressDialog mDialog;
	private Context mContext;
	public static final String requestURL = "http://192.168.122.219:8080/AndroidUploadFileWeb/FileImageUploadServlet";

	public UpLoadFileTask(Context context) {
		mContext = context;
		mDialog = ProgressDialog
				.show(context, "Dowload", "System is requering");
	}

	@Override
	protected String doInBackground(String... params) {
		File file = new File("_______________");
		return UpLoadUtils.upLoad(file, requestURL);
	}

	@Override
	protected void onPostExecute(String result) {
		if (result.equals(UpLoadUtils.SUCCESS)) {
			Log.d(TAG, "UpLoad success");
		} else if (result.equals(UpLoadUtils.FALIURE)) {
			Log.d(TAG, "UpLoad faliure");
		}
		super.onPostExecute(result);
	}
}
