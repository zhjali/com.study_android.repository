package com.example.utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class ImageLoader {
	static LruCache<String, Bitmap> cache;
	
	static{
		int maxSize = (int) Runtime.getRuntime().maxMemory();
		cache = new LruCache<String, Bitmap>(maxSize){
			protected int sizeOf(String key, Bitmap value) {
				 return  value.getRowBytes()*value.getHeight();
			};
		};
	}
	
	static public void loadImage(String url,ImageView imageView){
		Bitmap bitmap = cache.get(url);
		if (bitmap != null) {
			imageView.setImageBitmap(bitmap);
		}
		new ImageTask(imageView).execute(url);
	}
}
