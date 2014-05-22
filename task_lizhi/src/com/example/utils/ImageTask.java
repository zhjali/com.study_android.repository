package com.example.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageTask extends AsyncTask<String, Bitmap, Bitmap>{
	
	ImageView imageView;
	
	public ImageTask(ImageView imageView) {
		super();
		this.imageView = imageView;
	}


	@Override
	protected Bitmap doInBackground(String... params) {
		try {
			InputStream inputStream = new URL(params[0]).openStream();
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
			ImageLoader.cache.put(params[0],bitmap);
			return bitmap;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		imageView.setImageBitmap(result);
	}
}
