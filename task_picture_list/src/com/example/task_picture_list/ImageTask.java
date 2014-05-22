package com.example.task_picture_list;

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

public class ImageTask extends AsyncTask<String, Integer, Bitmap> {
	ImageView view;

	public ImageTask(ImageView view) {
		super();
		this.view = view;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		Bitmap bitmap = null;
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(params[0]);
		HttpResponse response = null;
		HttpEntity entity = null;
		InputStream in = null;
		try {
			response = client.execute(get);
			entity = response.getEntity();
			in = entity.getContent();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		bitmap = BitmapFactory.decodeStream(in);
		ImageLoader.put(params[0], bitmap);
		saveSdkBitmap(params[0], bitmap);
		return bitmap;
	}

	public void saveSdkBitmap(String url, Bitmap bitmap) {
		File file = new File(Util.getSdkPath(url));
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		view.setImageBitmap(result);
	}
}
