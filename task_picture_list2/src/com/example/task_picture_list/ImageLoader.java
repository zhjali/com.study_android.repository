package com.example.task_picture_list;

import java.io.File;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class ImageLoader {
	static HashMap<String, Bitmap> cache = new HashMap<String, Bitmap>();
	static ImageView view;

	public static void loadImage(ImageView view, String url) {
		ImageLoader.view = view;
		Bitmap bitmap = cache.get(url);
		if (bitmap != null) {
			view.setImageBitmap(bitmap);
		} else {
			if (getSdkBitmap(url)) {
				return;
			}
			new ImageTask(view).execute(url);
		}
	}

	public static void put(String url, Bitmap bitmap) {
		cache.put(url, bitmap);
	}

	public static boolean getSdkBitmap(String url) {
		String filePath = Util.getSdkPath(url);
		File file = new File(filePath);
		if (file.exists()) {
			System.err.println("--------" + filePath);
			Bitmap bitmap = BitmapFactory.decodeFile(filePath);
			ImageLoader.view.setImageBitmap(bitmap);
			put(url, bitmap);
			return true;
		}
		return false;
	}
}
