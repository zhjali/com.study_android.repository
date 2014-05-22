package com.example.fragment;

import java.util.ArrayList;

import Utils.LoadCache;
import Utils.LoadDB;
import Utils.LoadNetUtils;
import Utils.LoadNetUtils.IOperateEntity;
import Utils.UriPath;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.adapter.MyListViewAdapter;
import com.example.adapter.MyPagerAdapter;
import com.example.chabaike.R;
import com.example.database.TeaProviderMetaData;
import com.example.database.TeaProviderMetaData.TableMaindataMetaData;
import com.example.entity.TouTiaoLVEntity;
import com.example.entity.TouTiaoVPEntity;

public class ShowTouTiao extends Fragment implements IOperateEntity,
		OnItemClickListener {
	private final String TAG = "ShowTouTiao";
	private ViewPager mViewPager;
	private ListView mListView;
	private MyListViewAdapter mAdapter;
	private String vpUrl = UriPath.HOMEPATH;
	private String lsUrl = UriPath.TOU_TIAO;
	private ArrayList<ImageView> imageViews;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView");

		View headLineView = inflater.inflate(R.layout.show_tou_tiao, container,
				false);
		initListView(headLineView);

		initViewPager(inflater, headLineView);

		loadDB();

		loadNet();
		return headLineView;
	}

	private void initListView(View headLineView) {
		mAdapter = new MyListViewAdapter(getActivity());
		mListView = (ListView) headLineView.findViewById(R.id.tou_tiao_list);
		mListView.setAdapter(mAdapter);
		mListView.setOnItemClickListener(this);
	}

	private void initViewPager(LayoutInflater inflater, View headLineView) {
		ImageView iamgeView1 = (ImageView) inflater.inflate(
				R.layout.tou_tiao_vp1, null);
		ImageView iamgeView2 = (ImageView) inflater.inflate(
				R.layout.tou_tiao_vp2, null);
		ImageView iamgeView3 = (ImageView) inflater.inflate(
				R.layout.tou_tiao_vp3, null);

		// 用于更新头条的ViewPage图片
		imageViews = new ArrayList<ImageView>();
		imageViews.add(iamgeView1);
		imageViews.add(iamgeView2);
		imageViews.add(iamgeView3);
		MyPagerAdapter adapter = new MyPagerAdapter(imageViews);

		mViewPager = (ViewPager) headLineView
				.findViewById(R.id.tou_tiao_vPager);
		mViewPager.setAdapter(adapter);
	}

	/**
	 * 用于加载数据库，恢复ListView和ViewPager需要的数据
	 */
	public void loadDB() {
		try {
			// 加载ListView数据库缓存
			@SuppressWarnings("unchecked")
			ArrayList<TouTiaoLVEntity> datasLV = (ArrayList<TouTiaoLVEntity>) LoadDB
					.LoadingDBs(getActivity(),
							TeaProviderMetaData.TABLE_MAINDATA_NAME,
							TableMaindataMetaData.CATEGORY_TOU_TIAO);
			mAdapter.setDatas(datasLV);
			mAdapter.notifyDataSetChanged();

			// 加载ViewPager数据
			@SuppressWarnings("unchecked")
			ArrayList<TouTiaoVPEntity> datasVP = (ArrayList<TouTiaoVPEntity>) LoadDB
					.LoadingDB(getActivity(),
							TeaProviderMetaData.TABLE_VIEW_PAGER_NAME);
			for (int j = 0; j < datasVP.size(); j++) {
				LoadCache.setBitmapToView(datasVP.get(j).getImage(),
						imageViews.get(j));
			}
		} catch (NullPointerException exception) {
			exception.printStackTrace();
			return;
		}

	}

	/**
	 * 用于从网上加载数据，恢复ListView和ViewPager需要的数据
	 */
	public void loadNet() {
		if (LoadNetUtils.isNetConnected(getActivity())) {
			// 加载网络数据
			LoadNetUtils.downLoadEntity(getActivity(), vpUrl,
					LoadNetUtils.TYPE_TOU_TIAO_VP, this);
			LoadNetUtils.downLoadEntity(getActivity(), lsUrl,
					LoadNetUtils.TYPE_TOU_TIAO_LV, this);
		}
	}

	@Override
	public void operateViewPager(ArrayList<?> datas) {

		String url = null;
		for (int i = 0; i < datas.size(); i++) {
			url = ((TouTiaoVPEntity) datas.get(i)).getImage();
			LoadCache.setBitmapToView(url, imageViews.get(i));
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void operateListView(ArrayList<?> datas) {
		Log.d(TAG, "operateListView");

		mAdapter.setDatas((ArrayList<TouTiaoLVEntity>) datas);
		mAdapter.notifyDataSetChanged();
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		TouTiaoLVEntity entity = mAdapter.getDatas().get(position);
		String entityId = entity.getId();
		String baseURL = UriPath.NEWCONTENTPATH;
		String url = baseURL + "&id=" + entityId;
		Log.d(TAG, "url: " + url);

		Intent intent = new Intent("com.example.chabaike.ListItemActiviy");
		// intent.setClassName("com.example.chabaike",
		// "com.example.chabaike.ListItemActiviy");
		intent.addCategory(Intent.CATEGORY_DEFAULT);
		intent.putExtra("url", url);
		startActivity(intent);
	}

}
