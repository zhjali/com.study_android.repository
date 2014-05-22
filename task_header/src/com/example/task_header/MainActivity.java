package com.example.task_header;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listView;
	static int times = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.listView1);
		ArrayList<String> data = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			data.add("Item: " + i);
		}
		final MyAdapter adapter = new MyAdapter(this, data);
		Button button = new Button(this);
		button.setText("Load more ...");
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				for (int i = 0; i < 20; i++) {
					adapter.getData().add("Item: " + (20 * times + i));
				}
				adapter.notifyDataSetChanged();
			}
		});
		listView.addFooterView(button);
		listView.setAdapter(adapter);
		Button button2 = (Button) findViewById(R.id.button1);
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ArrayList<Boolean> isCheck = MyAdapter.getIsChecks();
				for (int i = 0; i < isCheck.size(); i++) {
					if (isCheck.get(i)) {
						System.out.println("-------->" + i);
						adapter.getData().remove(i);
						isCheck.remove(i);
						i--;
					}
				}
				adapter.notifyDataSetChanged();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
