package com.example.task_broadcast;

import android.os.Bundle;
import android.util.Log;

public class Utils {

	public static long getThreadId() {
		Thread t = Thread.currentThread();
		return t.getId();
	}

	public static String getThreadSignature() {
		Thread t = Thread.currentThread();
		long l = t.getId();
		String name = t.getName();
		long p = t.getPriority();
		String gname = t.getThreadGroup().getName();
		return (name + ":(id)" + l + ":(priority)" + p + ":(group)" + gname);
	}

	public static void longThreadSignature(String TAG) {
		Log.i(TAG, getThreadSignature());
	}

	public static void sleepForInSecs(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Bundle getStringAsABundle(String message) {
		Bundle bundle = new Bundle();
		bundle.putString("message", message);
		return bundle;
	}

	public static String getStringFromABundle(Bundle bundle) {
		return bundle.getString("message");
	}
}
