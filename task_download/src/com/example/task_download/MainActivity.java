package com.example.task_download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView textView;
	ProgressBar bar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textView = (TextView) findViewById(R.id.textView1);
		bar = (ProgressBar) findViewById(R.id.progressBar1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public Handler myHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			bar.setMax(msg.arg2);
			bar.setProgress(msg.arg1);
			textView.setText(100.0 * msg.arg1 / msg.arg2 + "%");
			System.out.println("----------------");
		}
	};

	public class MyThread extends Thread {

		@Override
		public void run() {
			super.run();
			String path = "http://192.168.56.1/gsonapi2.21.chm";
			InputStream ins = null;
			FileOutputStream out = null;

			try {
				URL url = new URL(path);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setConnectTimeout(3000);
				connection.connect();
				int length = connection.getContentLength();

				// »ñµÃSD¿¨Â·¾¶"/mnt/sdcard"
				File root = Environment.getExternalStorageDirectory();

				String filePathString = root.getPath() + "/" + "JavaSE1.chm";
				File file = new File(filePathString);
				out = new FileOutputStream(file);
				ins = connection.getInputStream();
				byte[] b = new byte[1024];
				int len = 0;
				int pro = 0;
				while ((len = ins.read(b)) != -1) {
					System.out.println("len:" + len);
					out.write(b, 0, len);
					pro += len;
					Message message = myHandler.obtainMessage();
					message.arg1 = pro;
					message.arg2 = length;
					myHandler.sendMessage(message);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (ins != null) {
					try {
						ins.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

	public void click(View view) {
		new MyThread().start();
	}
}
