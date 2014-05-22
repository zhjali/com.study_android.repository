package com.example.cache;

import android.graphics.Bitmap;

 public interface CacheInterfaceCallback {
	
	public boolean add(String fileName,Bitmap t);
	
	public Bitmap getCache(String fileName);
	
	public void clear();
}
