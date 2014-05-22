package com.example.task_broadcast;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Utils.longThreadSignature(TAG);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		menu.add(Menu.CATEGORY_SYSTEM, Menu.CATEGORY_SYSTEM + 1, 1,
				"Send broadcast");
		menu.add(Menu.CATEGORY_SYSTEM, Menu.CATEGORY_SYSTEM + 2, 2,
				"Open contact");
		menu.add(Menu.CATEGORY_SYSTEM, Menu.CATEGORY_SYSTEM + 3, 4,
				"Open private Activiy");
		return true;
	}

	private void testSendBroadcast(Activity activity) {
		Log.i(TAG, "Send broadcast,action is " + TestReceiver.class.getName());

		Intent intent = new Intent(TestReceiver.class.getName());
		intent.putExtra("message", "Hello world");
		Log.d(TAG, "befor");
		activity.sendBroadcast(intent);
		Log.d(TAG, "befor");

	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i(TAG, item.getItemId() + " is be clicked");

		switch (item.getItemId()) {
		case Menu.CATEGORY_SYSTEM + 1:
			testSendBroadcast(this);
			break;
		case Menu.CATEGORY_SYSTEM + 2:
			Intent intent = new Intent(Intent.ACTION_CALL,
					Uri.parse("tel://123"));
			startActivity(intent);
			break;
		case Menu.CATEGORY_SYSTEM + 3:
			Intent intent2 = new Intent(this, PrivActivity.class);
			startActivity(intent2);
			break;
		}
		return true;
	}
}
