package com.example.task_2broad_cast;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtils {
	private static ConnectivityManager manager;

	public static boolean isNetWorkConnectivity(Context context) {
		manager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo mobileInfo = manager
				.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		NetworkInfo wifiInfo = manager
				.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (mobileInfo != null && mobileInfo.isConnected()) {
			return true;
		}
		if (wifiInfo != null && wifiInfo.isConnected()) {
			return true;
		}
		return false;
	}
}
