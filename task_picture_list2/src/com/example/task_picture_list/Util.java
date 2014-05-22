package com.example.task_picture_list;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


import android.graphics.Bitmap;
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

	public static final String URL = "http://192.168.122.227/mydata.json";
	public static ArrayList<ItemData> DATAS = new ArrayList<ItemData>();

	public static String getJson(String url) {
		String json = null;
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		HttpResponse response;
		try {
			response = client.execute(get);
			json = EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return json;
	}

	public static void saveSdkBitmap(String url, Bitmap bitmap) {
		File file = new File(Util.getSdkPath(url));
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
	}
}
