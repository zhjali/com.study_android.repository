package com.example.task_picture_list;

import android.os.Environment;

public class Util {

	/**
	 * return the appropriate SDK file path of the specify url
	 * 
	 * @param url
	 * @return sdkPath
	 */
	public static String getSdkPath(String url) {
		String[] strings = url.split("/");
		String fileName = strings[strings.length - 1];
		String rootPath = Environment.getExternalStorageDirectory()
				.getAbsolutePath();
		String filePath = rootPath + "/" + fileName;
		return filePath;
	}
}
