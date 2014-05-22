package com.example.task_async_picture;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView;
	private ImageView imageView;
	private String path;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView1);
		imageView = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {
		path = "http://192.168.56.1/ic_launcher.png";
		new Task1().execute(path);
	}

	public class Task1 extends AsyncTask<String, Integer, Bitmap> {

		@Override
		protected Bitmap doInBackground(String... params) {
			String path = params[0];
			URL url;
			HttpURLConnection connection;
			InputStream in;
			FileOutputStream out;
			try {
				url = new URL(path);
				connection = (HttpURLConnection) url.openConnection();
				in = connection.getInputStream();

				return BitmapFactory.decodeStream(in);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			// mText.setText(result);

			imageView.setImageBitmap(result);
			AlphaAnimation anim = new AlphaAnimation(0, 1);
			anim.setDuration(500);
			imageView.startAnimation(anim);
		}

	}
}
