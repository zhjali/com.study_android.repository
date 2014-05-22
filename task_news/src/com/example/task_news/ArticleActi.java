package com.example.task_news;

import java.util.ArrayList;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.example.task_news.adapter.ArticleAdapter;
import com.example.task_news.bean.AbstractBean;
import com.example.task_news.bean.Contens;
import com.example.task_news_net.NetUtils;
import com.example.task_news_net.NetUtils.NetListener;

public class ArticleActi extends ListActivity implements NetListener {
	public int id;
	ArticleAdapter adapter;
	ListView listView;
	ProgressDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		adapter = new ArticleAdapter(this);
		listView = getListView();
		listView.setAdapter(adapter);

		id = getIntent().getIntExtra("id", 0);
		String path = "http://litchiapi.jstv.com/api/GetArticle?id=" + id
				+ "&val=CC065D82FE0D017649BC60040E7D577A";

		dialog = new ProgressDialog(this);
		dialog.setMessage("Loading...");
		dialog.show();

		NetUtils.getData(NetUtils.TYPE_ARTICLE, path, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.article, menu);
		return true;
	}

	@Override
	public void ok(ArrayList<? extends AbstractBean> data) {
		adapter.getArtDatas().addAll((ArrayList<Contens>) data);
		adapter.notifyDataSetChanged();
		dialog.dismiss();
	}

	@Override
	public void error(ArrayList<? extends AbstractBean> data) {
		Toast.makeText(this, "ÍøÂçÁ¬½Ó´íÎó", Toast.LENGTH_SHORT).show();
	}

}
