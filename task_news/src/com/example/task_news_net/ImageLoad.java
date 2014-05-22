package com.example.task_news_net;

import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class ImageLoad {
	private static HashMap<String, SoftReference<Bitmap>> cache = new HashMap<String, SoftReference<Bitmap>>();
	private static boolean down = true;
	private static String ROOTSTRING = Environment
			.getExternalStorageDirectory().getAbsolutePath() + "/" + "lizhi";

	private static LruCache<String, Bitmap> lruCache = new LruCache<String, Bitmap>(
			(int) (Runtime.getRuntime().maxMemory() / 8)) {
		protected int sizeOf(String key, Bitmap value) {
			return value.getByteCount();
		};

		protected void entryRemoved(boolean evicted, String key,
				Bitmap oldValue, Bitmap newValue) {
			if (evicted) {
				putToCahce(key, oldValue);
			}
		}
	};

	public void loadBitmap(String url, ImageView view) {
		Bitmap bitmap = null;
		if (cache.containsKey(url)) {
			// 从内存获取图片
			bitmap = get(url);
			if (bitmap != null) {
				view.setImageBitmap(bitmap);
				return;
			}
		}
		if ((bitmap = getSdkBitmap(url)) != null) {
			// 从sdk获取图片
			System.out.println("-----------");
			putToCahce(url, bitmap);
			view.setImageBitmap(bitmap);
			return;
		}

		// 从网络下载图片
		if (down)
			new ImageTask(view).execute(url);
		return;
	}

	private Bitmap getSdkBitmap(String url) {
		String filePath = NetUtils.getSdkPath(url);
		File[] files = new File(ImageLoad.ROOTSTRING).listFiles();
		if (files != null) {
			for (File item : files) {
				System.out.println(item.getAbsolutePath());
				if (item.getAbsolutePath().equals(filePath)) {
					return BitmapFactory.decodeFile(filePath);
				}
			}
		}
		return null;
	}

	public static void putToCahce(String url, Bitmap bitmap) {
		cache.put(url, new SoftReference<Bitmap>(bitmap));
	}

	public static Bitmap get(String url) {
		SoftReference<Bitmap> reference = cache.get(url);
		if (reference != null) {
			Bitmap bitmap = reference.get();
			if (bitmap != null) {
				return bitmap;
			}
		}
		return null;
	}

	public static void setDown(boolean down) {
		ImageLoad.down = down;
	}
}
