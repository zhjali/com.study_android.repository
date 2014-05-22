package com.example.cache;

import android.graphics.Bitmap;

class CacheManager implements CacheInterfaceCallback {
	private LruCacheManager lruCacheManager;
	private SoftReferenceManager softReferenceManager;
	private SDCardCacheManager sdCardCacheManager;

	public CacheManager(int maxSize, long sdcardCapacity) {
		lruCacheManager = LruCacheManager.getManager(maxSize);
		softReferenceManager = SoftReferenceManager.getManager();
		sdCardCacheManager = SDCardCacheManager.getManager(sdcardCapacity);
	}

	@Override
	public boolean add(String fileName, Bitmap bitmap) {
		lruCacheManager.add(fileName, bitmap);
		return true;
	}

	@Override
	public Bitmap getCache(String fileName) {
		Bitmap bitmap = lruCacheManager.getCache(fileName);
		if (bitmap == null) {
			bitmap = softReferenceManager.getCache(fileName);
			if (bitmap == null) {
				String name = fileName.substring(fileName.lastIndexOf("/"),
						fileName.length());
				System.out.println("命中name:" + name);
				bitmap = sdCardCacheManager.getCache(name);
				System.out.println("命中缓存--");
				return bitmap;
			}
		}
		return bitmap;
	}

	@Override
	public void clear() {

	}

}
