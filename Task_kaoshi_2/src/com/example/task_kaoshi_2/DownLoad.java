package com.example.task_kaoshi_2;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpConnection;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class DownLoad extends AsyncTask<String, Object, String> {
	public static final String URL = "urlString";
	public static final String DATA = "data";
	ArrayList<Data> datas;
	private ImageView imageView;
	private MyAdapter adapter;
	
	public DownLoad() {
		super();
	}

	public DownLoad(MyAdapter adapter) {
		super();
		this.adapter = adapter;
		this.datas = new ArrayList<Data>();
	}

	public DownLoad(ImageView imageView) {
		super();
		this.imageView = imageView;
	}

	@Override
	protected String doInBackground(String... params) {
		if (params[0].equals(DATA)) {
			HttpClient client = new DefaultHttpClient();
			HttpGet get = new HttpGet(params[1]);
			try {
				HttpResponse response = client.execute(get);
				HttpEntity entity = response.getEntity();
				String json = EntityUtils.toString(entity);
				parseJson(json);
				publishProgress("success");
				return "success";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (params[0].equals(DownLoad.URL)) {
			try {
				java.net.URL url = new java.net.URL(params[1]);
				publishProgress(BitmapFactory.decodeStream(url.openStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "success";
		} 
		return null;
	}

	@Override
	protected void onPostExecute(String result) {
		System.out.println(result);
	}

	//String BitMap
	@Override
	protected void onProgressUpdate(Object... values) {
		if (values[0] instanceof String) {
			adapter.setDatas(datas);
			adapter.notifyDataSetChanged();
		}else if(values[0] instanceof Bitmap){
			imageView.setImageBitmap((Bitmap) values[0]);
		}
	}
	
	public void parseJson(String json){
		try {
			JSONArray jsonArray = new JSONArray(json);
			for(int i = 0; i<jsonArray.length() ; i++){
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				String name = jsonObject.getString("name");
				String urlString = jsonObject.getString("image");
				Data data = new Data(name, urlString);
				datas.add(data);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
}
