package com.example.chabaike;

import java.util.ArrayList;

import Utils.LoadDB;
import Utils.LoadNetUtils;
import Utils.LoadNetUtils.IOperateEntity;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.database.TeaProviderMetaData;
import com.example.database.TeaProviderMetaData.TableMaindataMetaData;
import com.example.entity.TouTiaoLVEntity;

public class ListItemActiviy extends Activity {
	private static String TAG = "ListItemActivity";

	private TextView title;
	private TextView source;
	private TextView createTime;
	private WebView wapThumb;
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_item);

		inite();
		loadDB();
		loadNet(url);

	}

	private void inite() {
		getActionBar().hide();
		url = getIntent().getStringExtra("url");
		title = (TextView) findViewById(R.id.title);
		source = (TextView) findViewById(R.id.source);
		createTime = (TextView) findViewById(R.id.create_time);
		wapThumb = (WebView) findViewById(R.id.wap_thumb);
	}

	protected void loadDB() {
		@SuppressWarnings("unchecked")
		ArrayList<TouTiaoLVEntity> datasLV = (ArrayList<TouTiaoLVEntity>) LoadDB
				.LoadingDBs(this, TeaProviderMetaData.TABLE_MAINDATA_NAME,
						TableMaindataMetaData.CATEGORY_LIST_ITEM);

		paddingData(datasLV);

	}

	private void loadNet(String url) {
		LoadNetUtils.downLoadEntity(this, url, LoadNetUtils.TYPE_TOU_LIST_ITEM,
				new IOperateEntity() {

					@Override
					public void operateViewPager(ArrayList<?> datas) {
						// 不做操作
					}

					@Override
					public void operateListView(ArrayList<?> datas) {
						// 列表中只有一个对象
						paddingData(datas);
					}

				});
	}

	private void paddingData(ArrayList<?> datas) {
		if (datas == null) {
			return;
		}
		TouTiaoLVEntity entity = (TouTiaoLVEntity) datas.get(0);
		String title2 = entity.getTitle();
		title.setText(title2);

		source.setText(entity.getSource());
		createTime.setText(entity.getCreateTime());

		WebSettings set = wapThumb.getSettings();
		set.setBuiltInZoomControls(true);
		wapThumb.loadDataWithBaseURL(null, entity.getWapThumb(), "text/html",
				"UTF-8", null);

		Log.d(TAG, "jobDown");
	}
}
