package com.example.utils;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.content.Context;
import android.os.Handler;
import android.os.Message;

public class NetUtils {
	
	public interface NetWorkOK{
		public void ok();
	}
	
	public interface NetWorkError{
		public void error();
	}
	
	
	
	public static void getData(final Context context,final String uri,final NetWorkOK ok,final NetWorkError error){
		final Handler handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				
				switch (msg.what) {
				case 1:
					ok.ok();
					break;
				case 2:
					error.error();
					break;
				default:
					break;
				}
			}
		};
		
		
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				try {
					parsingJson(context, getJson(uri));
					handler.sendEmptyMessage(1);
				} catch (JSONException e) {
					handler.sendEmptyMessage(2);
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	
	
	private static String getJson(String uri) {
		System.out.println("is get Json...");
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(uri);
		try {
			return EntityUtils.toString(client.execute(get).getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void parsingJson(Context context,String json) throws JSONException{
			System.out.println("is parsing Json ...");
			JSONObject object = new JSONObject(json);
			JSONObject params = object.getJSONObject("paramz");
			JSONArray feeds = params.getJSONArray("feeds");
			for (int i = 0; i < feeds.length(); i++) {
				JSONObject object2 = feeds.getJSONObject(i);
				int id = object2.getInt("id");
				JSONObject data = object2.getJSONObject("data");
				String subject = data.getString("subject");
				String summary = data.getString("summary");
				String cover = data.getString("cover");
				DataHelper.getInstance(context).insert(id,subject,summary,cover);
			}
	}
}
