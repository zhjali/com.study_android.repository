package com.example.task_picture_list;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listView;
	MyAdapter adapter;
	ArrayList<ItemData> mDatas = new ArrayList<ItemData>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.listView1);
		adapter = new MyAdapter(this, mDatas);
		listView.setAdapter(adapter);
		new MyThread().start();
	}

	public Handler myHandler = new Handler();

	public class MyThread extends Thread {
		@Override
		public void run() {
			final ArrayList<ItemData> datas = parseJson(getJson());
			myHandler.post(new Runnable() {

				@Override
				public void run() {
					mDatas.addAll(datas);
					adapter.notifyDataSetChanged();
				}
			});
		}
	}

	public String getJson() {
		String json = null;
		String uri = "http://192.168.122.227/mydata.json";
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(uri);
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

	public ArrayList<ItemData> parseJson(String json) {
		ArrayList<ItemData> datas = new ArrayList<ItemData>();
		try {
			JSONArray array = new JSONArray(json);
			for (int i = 0; i < array.length(); i++) {
				JSONObject object = (JSONObject) array.get(i);
				String name = object.getString("name");
				String imageUrl = object.getString("image");
				datas.add(new ItemData(name, imageUrl));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return datas;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
