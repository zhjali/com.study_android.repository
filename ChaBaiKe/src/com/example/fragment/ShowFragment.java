package com.example.fragment;

import java.util.ArrayList;

import Utils.LoadDB;
import Utils.LoadNetUtils;
import Utils.LoadNetUtils.IOperateEntity;
import Utils.UriPath;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.example.adapter.MyListViewAdapter;
import com.example.chabaike.R;
import com.example.database.TeaProviderMetaData;
import com.example.entity.TouTiaoLVEntity;

public class ShowFragment extends Fragment implements IOperateEntity,
		OnItemClickListener {
	protected static final String TAG = "ShowFragment";
	protected static final String LSURL = "lsUrl";
	protected static final String CATEGORY = "tableCategory";
	protected ListView mListView;
	protected MyListViewAdapter mAdapter;
	protected String lsUrl;
	protected String tableCategory;

	public static ShowFragment newInstance(String url, String tableCategory) {
		ShowFragment fragment = new ShowFragment();

		Bundle bundle = new Bundle();
		bundle.putString(LSURL, url);
		bundle.putString(CATEGORY, tableCategory);
		Log.d(TAG, "1_lsUrl: " + url);
		Log.d(TAG, "1_category: " + tableCategory);

		fragment.setArguments(bundle);
		return fragment;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (savedInstanceState != null) {
			lsUrl = savedInstanceState.getString(LSURL);
			tableCategory = savedInstanceState.getString(CATEGORY);
		}
		lsUrl = getArguments().getString(LSURL);
		tableCategory = getArguments().getString(CATEGORY);

		View headLineView = laodContentView(inflater, container);
		initListView(headLineView);

		loadDB(tableCategory);
		loadNet();
		return headLineView;
	}

	public View laodContentView(LayoutInflater inflater, ViewGroup container) {
		return inflater.inflate(R.layout.show_entity, container, false);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString(LSURL, lsUrl);
		outState.putString(CATEGORY, tableCategory);
	}

	protected void initListView(View headLineView) {
		mAdapter = new MyListViewAdapter(getActivity());
		mListView = (ListView) headLineView.findViewById(R.id.tou_tiao_list);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(this);
	}

	protected void loadDB(String tableCategory) {
		@SuppressWarnings("unchecked")
		ArrayList<TouTiaoLVEntity> datasLV = (ArrayList<TouTiaoLVEntity>) LoadDB
				.LoadingDBs(getActivity(),
						TeaProviderMetaData.TABLE_MAINDATA_NAME, tableCategory);
		if (datasLV != null) {
			mAdapter.setDatas(datasLV);
			mAdapter.notifyDataSetChanged();
		}

	}

	/**
	 * 用于从网上加载数据，恢复ListView和ViewPager需要的数据
	 */
	public void loadNet() {
		if (LoadNetUtils.isNetConnected(getActivity())) {
			// 加载网络数据
			LoadNetUtils.downLoadEntity(getActivity(), lsUrl,
					LoadNetUtils.TYPE_TOU_TIAO_LV, this);
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		TouTiaoLVEntity entity = mAdapter.getDatas().get(position);
		String entityId = entity.getId();
		String baseURL = UriPath.NEWCONTENTPATH;
		String url = baseURL + "&id=" + entityId;

		Intent intent = new Intent("com.example.chabaike.ListItemActiviy");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.putExtra("url", url);
		startActivity(intent);
	}

	@Override
	public void operateViewPager(ArrayList<?> datas) {
		// 不使用
	}

	@SuppressWarnings("unchecked")
	@Override
	public void operateListView(ArrayList<?> datas) {
		mAdapter.setDatas((ArrayList<TouTiaoLVEntity>) datas);
		mAdapter.notifyDataSetChanged();
	}

}
