package Utils;

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

import android.content.ContentValues;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.example.database.OperateDataBase;
import com.example.database.TeaProviderMetaData;
import com.example.database.TeaProviderMetaData.TableMaindataMetaData;
import com.example.entity.CreateContentValues;
import com.example.entity.Entity;
import com.example.entity.TouTiaoLVEntity;
import com.example.entity.TouTiaoVPEntity;

public class LoadNetUtils {
	private static final String TAG = "DowLoadUtils";
	public static final int TYPE_TOU_TIAO_VP = 0;
	public static final int TYPE_TOU_TIAO_LV = 1;
	public static final int TYPE_TOU_LIST_ITEM = 2;

	public interface IOperateEntity {
		public void operateViewPager(ArrayList<?> datas);

		public void operateListView(ArrayList<?> datas);

	}

	/**
	 * 
	 * @param mContext
	 *            用于OperateDataBase.getInstance(Context mContext)
	 * @param url
	 *            下载地址URL
	 * @param type
	 *            下载的种类如TYPE_TOU_TIAO_VP，或TYPE_TOU_TIAO_LV
	 * @param operateEntity
	 *            接口实例，用于下载完成后的回调方法
	 */
	public static void downLoadEntity(final Context mContext, final String url,
			final int type, final IOperateEntity operateEntity) {

		/**
		 * msg.arg1为对应的解析实体种类，如:TYPE_TOU_TIAO_VP
		 */
		final Handler handler = new Handler() {

			@Override
			public void handleMessage(Message msg) {
				ArrayList<?> datas = null;
				if (msg.obj == null) {
					Toast.makeText(mContext, "网络连接异常", Toast.LENGTH_LONG)
							.show();
					return;
				}

				switch (msg.what) {
				case TYPE_TOU_TIAO_VP:
					datas = (ArrayList<?>) msg.obj;
					operateEntity.operateViewPager(datas);
					break;
				case TYPE_TOU_TIAO_LV:
				case TYPE_TOU_LIST_ITEM:
					datas = (ArrayList<?>) msg.obj;
					operateEntity.operateListView(datas);
					break;
				}
				super.handleMessage(msg);
			}

		};

		new Thread() {

			@Override
			public void run() {
				Message msg = handler.obtainMessage();
				msg.what = type;
				String category;
				switch (type) {
				case TYPE_TOU_TIAO_VP:
					msg.obj = parseTouTiaoVP(mContext, getJson(url));
					break;
				case TYPE_TOU_TIAO_LV:
					category = getCategory(url);
					msg.obj = parseTouTiaoLV(mContext, getJson(url), category);
					break;
				case TYPE_TOU_LIST_ITEM:
					category = getCategory(url);
					msg.obj = parseListItem(mContext, getJson(url), category);
				default:
					break;
				}
				msg.sendToTarget();
			}
		}.start();

	}

	private static String getJson(String url) {
		Log.d(TAG, "Get json,url: " + url);

		// 设别请求时那个模块的，并给category赋值

		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			return EntityUtils.toString(response.getEntity());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ArrayList<Entity> parseTouTiaoVP(Context mContext,
			String json) {
		Log.d(TAG, "Start pase TouTiaoVp");

		ArrayList<Entity> datas = new ArrayList<Entity>();
		try {
			JSONObject object = new JSONObject(json);
			JSONArray array = object.getJSONArray("data");
			for (int i = 0; i < array.length(); i++) {
				JSONObject object2 = array.getJSONObject(i);
				String id = object2.getString("id");
				String title = object2.getString("title");
				String name = object2.getString("name");
				String link = object2.getString("link");
				String content = object2.getString("content");
				String image = object2.getString("image");
				String images = object2.getString("image_s");
				Log.d(TAG, "url: " + image);

				if (!LoadDB.inDataBase(mContext,
						TeaProviderMetaData.TABLE_VIEW_PAGER_NAME, id)) {
					ContentValues values = CreateContentValues.createVP(id,
							title, name, link, content, image, images);
					OperateDataBase.getInstance(mContext).insert(
							TeaProviderMetaData.TABLE_VIEW_PAGER_NAME, values);
				}

				datas.add(new TouTiaoVPEntity(image));
			}
			return datas;
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ArrayList<Entity> parseTouTiaoLV(Context mContext,
			String json, String category) {
		Log.d(TAG, "Start pase TouTiaoLV");

		ArrayList<Entity> datas = new ArrayList<Entity>();
		try {
			JSONObject object = new JSONObject(json);
			JSONArray array = object.getJSONArray("data");
			for (int i = 0; i < array.length(); i++) {
				JSONObject object2 = array.getJSONObject(i);
				String id = object2.getString("id");
				String title = object2.getString("title");
				String source = object2.getString("source");
				String wapThumb = object2.getString("wap_thumb");
				String createTime = object2.getString("create_time");
				String nickName = object2.getString("nickname");
				String description = object2.getString("description");
				if (!LoadDB.inDataBase(mContext,
						TeaProviderMetaData.TABLE_MAINDATA_NAME, id)) {
					ContentValues values = CreateContentValues.createLV(id,
							title, source, description, wapThumb, createTime,
							nickName, category);
					OperateDataBase.getInstance(mContext).insert(
							TeaProviderMetaData.TABLE_MAINDATA_NAME, values);
				}

				datas.add(new TouTiaoLVEntity(id, title, source, description,
						wapThumb, createTime, nickName));
			}
			return datas;
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static ArrayList<Entity> parseListItem(Context mContext,
			String json, String category) {
		Log.d(TAG, "Json: " + json);

		JSONObject object;
		try {
			object = new JSONObject(json);
			JSONObject entity = object.getJSONObject("data");

			String id = entity.getString("id");
			String title = entity.getString("title");
			String source = entity.getString("source");
			String wapThumb = entity.getString("wap_content");
			String createTime = entity.getString("create_time");
			String nickName = entity.getString("author");

			Log.d(TAG, "ListItem id" + id);
			if (!LoadDB.inLIDataBase(mContext,
					TeaProviderMetaData.TABLE_MAINDATA_NAME, id, true)) {
				Log.d(TAG, "ListItem is insert");

				ContentValues values = CreateContentValues.createLV(id, title,
						source, "", wapThumb, createTime, nickName, category);
				OperateDataBase.getInstance(mContext).insert(
						TeaProviderMetaData.TABLE_MAINDATA_NAME, values);
			}
			ArrayList<Entity> datas = new ArrayList<Entity>();
			datas.add(new TouTiaoLVEntity(id, title, source, "", wapThumb,
					createTime, nickName));

			// Log.d(TAG, "paseListitem: " + datas.toString());

			return datas;
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean isNetConnected(Context mContext) {
		ConnectivityManager cManager = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cManager.getActiveNetworkInfo();
		if (info != null && info.isConnected()) {
			Log.d(TAG, "网络连接正常，将开始下载JSON");

			return true;
		}

		Toast.makeText(mContext, "网络连接异常", Toast.LENGTH_SHORT).show();
		return false;
	}

	/**
	 * 
	 * @param url
	 *            解析最后的type=？，来区分是头条等5个模块
	 */
	public static String getCategory(String url) {
		if (url.contains("news.getNewsContent")) {
			return TableMaindataMetaData.CATEGORY_LIST_ITEM;
		} else if (url.contains("type=52")) {
			return TableMaindataMetaData.CATEGORY_ZI_XUN;
		} else if (url.contains("type=16")) {
			return TableMaindataMetaData.CATEGORY_BAI_KE;
		} else if (url.contains("type=54")) {
			return TableMaindataMetaData.CATEGORY_SHU_JU;
		} else if (url.contains("type=53")) {
			return TableMaindataMetaData.CATEGORY_JING_YING;
		} else if (url.contains("getHeadlines")) {
			return TableMaindataMetaData.CATEGORY_TOU_TIAO;
		}
		return null;
	}

}
