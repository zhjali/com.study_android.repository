package com.example.android_wifimanager;

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
		if (!mobileInfo.isConnected() && !wifiInfo.isConnected()) {
			return false;
		}
		return true;
	}
}
