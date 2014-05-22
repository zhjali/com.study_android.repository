package com.example.task_news_net;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageTask extends AsyncTask<String, Bitmap, String> {
	ImageView imageView;

	public ImageTask(ImageView imageView) {
		super();
		this.imageView = imageView;
	}

	@Override
	protected String doInBackground(String... params) {
		System.out.println(params[0]);
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(params[0]);
		Bitmap bitmap = null;
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			InputStream inputStream = entity.getContent();
			bitmap = BitmapFactory.decodeStream(inputStream);
			ImageLoad.putToCahce(params[0], bitmap);
			saveToSdk(params[0], bitmap);
			publishProgress(bitmap);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	protected void onProgressUpdate(Bitmap... values) {
		if (values[0] != null) {
			imageView.setImageBitmap(values[0]);
		}
	}

	public void saveToSdk(String url, Bitmap bitmap) {
		File file = new File(NetUtils.getSdkPath(url));

		try {
			bitmap.compress(Bitmap.CompressFormat.JPEG, 100,
					new FileOutputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
