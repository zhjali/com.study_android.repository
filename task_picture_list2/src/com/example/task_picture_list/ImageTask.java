package com.example.task_picture_list;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageTask extends AsyncTask<Object, Object, String> {
	ImageView view;
	ArrayList<ItemData> mDatas = Util.DATAS;
	MyAdapter adapter;

	public ImageTask() {
		super();
	}

	public ImageTask(ImageView view) {
		super();
		this.view = view;
	}

	public ImageTask(MyAdapter adapter) {
		super();
		this.adapter = adapter;
	}

	/**
	 * if params[0] == "data",then download data;
	 * 
	 * if params.[0] is String instance,then update the ImageView list item;
	 */
	@Override
	protected String doInBackground(Object... params) {
		if (params[0].equals("data")) {
			final ArrayList<ItemData> datas = parseJson(Util.getJson(Util.URL));
			publishProgress(datas);
			return "get data";
		} else if (params[0] instanceof String) {
			String url = (String) params[0];
			Bitmap bitmap = null;
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			HttpResponse response = null;
			HttpEntity entity = null;
			InputStream in = null;
			try {
				response = client.execute(get);
				entity = response.getEntity();
				in = entity.getContent();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			bitmap = BitmapFactory.decodeStream(in);
			ImageLoader.put(url, bitmap);
			Util.saveSdkBitmap(url, bitmap);
			publishProgress(bitmap);
			return "update list item";
		}
		return "execute method wrong";
	}

	@Override
	protected void onProgressUpdate(Object... values) {
		if (values[0] instanceof ArrayList) {
			mDatas.addAll((ArrayList<ItemData>) values[0]);
			adapter.notifyDataSetChanged();
		} else {
			view.setImageBitmap((Bitmap) values[0]);
		}
	}

	@Override
	protected void onPostExecute(String result) {
		System.out.println(result);
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

}
