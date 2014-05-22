package com.example.task_news_net;

import java.io.File;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.Environment;
import android.os.Handler;
import android.os.Message;

import com.example.task_news.bean.AbstractBean;
import com.example.task_news.bean.Contens;
import com.example.task_news.bean.News;
import com.example.task_news.bean.NewsData;

public class NetUtils {
	public static final int NETWORK_OK = 1;
	public static final int NETWORK_ERROR = 2;
	public static final int TYPE_ARTICLE = 2;
	public static final int TYPE_NEW = 1;

	public static ArrayList<News> data = new ArrayList<News>();

	public interface NetListener {
		public void ok(ArrayList<? extends AbstractBean> data);

		public void error(ArrayList<? extends AbstractBean> data);
	}

	public static void getData(final int type, final String path,
			final NetListener listener) {
		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case NETWORK_OK:
					System.out.println("ok");
					switch (type) {
					case TYPE_NEW:
						listener.ok((ArrayList<News>) msg.obj);
						break;
					case TYPE_ARTICLE:
						listener.ok((ArrayList<Contens>) msg.obj);
						break;
					}
					break;
				case NETWORK_ERROR:
					System.out.println("hello");
					switch (type) {
					case TYPE_NEW:
						listener.error((ArrayList<Contens>) msg.obj);
						break;
					case TYPE_ARTICLE:
						listener.ok((ArrayList<Contens>) msg.obj);
					default:
						break;
					}
					break;
				}
			};

		};
		new Thread() {
			@Override
			public void run() {
				HttpClient client = new DefaultHttpClient();
				HttpGet get = new HttpGet(path);
				try {
					HttpResponse response = client.execute(get);
					if (response.getStatusLine().getStatusCode() == 200) {
						String jsonDate = EntityUtils.toString(response
								.getEntity());
						Message message = null;
						switch (type) {
						case TYPE_NEW:
							message = handler.obtainMessage(NETWORK_OK,
									parserNews(jsonDate));
							break;
						case TYPE_ARTICLE:
							message = handler.obtainMessage(NETWORK_OK,
									parserContents(jsonDate));
							break;
						}
						handler.sendMessage(message);
						return;
					} else {
						int what = NETWORK_ERROR;
						Message message = handler.obtainMessage(what,
								new Object());
						handler.sendMessage(message);
					}
				} catch (Exception e) {
					e.printStackTrace();
					int what = NETWORK_ERROR;
					Message message = handler.obtainMessage(what, new Object());
					handler.sendMessage(message);
				}
			}

		}.start();
	}

	private static ArrayList<Contens> parserContents(String jsonDate) {
		ArrayList<Contens> data = new ArrayList<Contens>();
		// ÓÃBuilderÄ£Ê½
		try {
			JSONObject json1 = new JSONObject(jsonDate);
			JSONObject json2 = json1.getJSONObject("paramz");
			JSONObject json3 = json2.getJSONObject("article");
			JSONArray jsonArray = json3.getJSONArray("contents");
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject json4 = jsonArray.getJSONObject(i);
				String category = json4.getString("category");
				if (category.equals("txt")) {
					String text = json4.getString("text");
					Contens contens = new Contens(category, text);
					data.add(contens);
				}
				if (category.equals("image")) {
					String link = json4.getString("link");
					String summary = json4.getString("summary");
					int width = json4.getInt("width");
					int height = json4.getInt("height");
					System.out.println("category------" + category);
					Contens contens = new Contens(category, link, summary,
							width, height);
					data.add(contens);
				}
			}
			return data;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ArrayList<News> parserNews(String jsonDate) {
		ArrayList<News> data = new ArrayList<News>();

		try {
			JSONObject json1 = new JSONObject(jsonDate);
			JSONObject json2 = json1.getJSONObject("paramz");
			JSONArray jsonArray = json2.getJSONArray("feeds");
			System.out.println("jsonArray: " + jsonArray);
			System.out.println("jsonArrayLength: " + jsonArray.length());
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				int id = jsonObject.getInt("id");
				int oid = jsonObject.getInt("oid");
				String category = jsonObject.getString("category");
				JSONObject jsonObject2 = jsonObject.getJSONObject("data");
				String subject = jsonObject2.getString("subject");
				String summary = jsonObject2.getString("summary");
				String cover = jsonObject2.getString("cover");
				String format = jsonObject2.getString("format");
				String changed = jsonObject2.getString("changed");
				NewsData nd = new NewsData(subject, summary, cover, format,
						changed);
				News ns = new News(id, oid, category, nd);
				data.add(ns);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return data;
	};

	/**
	 * return: sdk/lizhi/*.*
	 */
	public static String getSdkPath(String url) {
		String rootPath = Environment.getExternalStorageDirectory()
				.getAbsolutePath();
		File rootFile = new File(rootPath, "lizhi");
		if (!rootFile.exists()) {
			rootFile.mkdir();
		}
		String fileName = getBMName(url);
		return rootFile + "/" + fileName;
	}

	public static String getBMName(String url) {
		String[] segment = url.split("/");
		return segment[segment.length - 1];
	}
}
