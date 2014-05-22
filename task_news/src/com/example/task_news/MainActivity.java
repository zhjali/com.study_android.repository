package com.example.task_news;

import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.task_news.adapter.MyAdapter;
import com.example.task_news.bean.AbstractBean;
import com.example.task_news.bean.News;
import com.example.task_news_net.NetUtils;
import com.example.task_news_net.NetUtils.NetListener;

public class MainActivity extends Activity implements NetListener,
		OnClickListener, OnScrollListener {
	ListView listView;
	MyAdapter myAdapter;
	ProgressDialog dialog;
	Button button;
	boolean first = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listView = (ListView) findViewById(R.id.listView1);
		myAdapter = new MyAdapter(this);

		button = new Button(this);
		button.setText("加载更多....");
		button.setOnClickListener(this);

		listView.addFooterView(button);
		listView.setAdapter(myAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = new Intent();
				int i = myAdapter.getData().get(position).getOid();
				intent.putExtra("id", i);
				intent.setClass(MainActivity.this, ArticleActi.class);
				startActivity(intent);
			}

		});

		dialog = new ProgressDialog(this);
		dialog.setMessage("Loading...");
		dialog.show();

		String path = "http://litchiapi.jstv.com/api/GetFeeds?column=0&PageSize=20&pageIndex=1&val=100511D3BE5301280E0992C73A9DEC41";
		NetUtils.getData(NetUtils.TYPE_NEW, path, this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void ok(ArrayList<? extends AbstractBean> data) {
		myAdapter.getData().addAll((ArrayList<News>) data);
		myAdapter.notifyDataSetChanged();
		if (first) {
			dialog.dismiss();
			first = false;
		}
		button.setText("加载更多...");
	}

	@Override
	public void error(ArrayList<? extends AbstractBean> data) {
		Toast.makeText(this, "网络连接错误", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		button.setText("正在加载....");

		NetUtils.getData(NetUtils.TYPE_ARTICLE,
				"http://litchiapi.jstv.com/api/GetFeeds?column=0&PageSize=20&pageIndex="
						+ myAdapter.getData().size()
						+ "&val=100511D3BE5301280E0992C73A9DEC41",
				MainActivity.this);

	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {
		switch (scrollState) {
		case OnScrollListener.SCROLL_STATE_FLING:

			break;
		case OnScrollListener.SCROLL_STATE_IDLE:
			break;
		case OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
			break;

		default:
			break;
		}

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		// TODO Auto-generated method stub

	}

}
