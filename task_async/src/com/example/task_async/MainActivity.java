package com.example.task_async;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView;
	ProgressBar progressBar;
	String pathString;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView1);
		progressBar = (ProgressBar) findViewById(R.id.progressBar1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {
		pathString = "http://192.168.56.1/gsonapi2.21.chm";
		new Task().execute(pathString, "hello");
	}

	class Task extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... params) {
			InputStream in = null;
			FileOutputStream out = null;
			try {
				String urlPath = params[0];
				System.out.println("--+++" + params[1]);
				URL url = new URL(urlPath);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				// 当父类强转为子类时，可以调用子类特有、或覆盖父类的方法吗？
				in = connection.getInputStream();
				String path = Environment.getExternalStorageDirectory()
						.getAbsolutePath();
				String[] unit = urlPath.split("/");
				String fileName = unit[unit.length - 1];
				path += "/" + fileName;
				File file = new File(path);
				System.out.println(file.getAbsolutePath());
				out = new FileOutputStream(file);
				int length = 0;
				byte[] b = new byte[1024];
				int filesize = connection.getContentLength();
				int size = 0;
				System.out.println("------" + in);
				while ((length = in.read(b)) != -1) {
					out.write(b, 0, length);
					size += length;
					publishProgress(size, filesize);
				}
				return "Success";
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			return "Error";
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			progressBar.setMax(values[1]);
			progressBar.setProgress(values[0]);
			textView.setText(100.0 * values[0] / values[1] + "%");
		}

		@Override
		protected void onPostExecute(String result) {
			textView.setText(result);
		}

	}
}
