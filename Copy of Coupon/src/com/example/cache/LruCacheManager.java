package com.example.cache;

import android.graphics.Bitmap;

class LruCacheManager implements CacheInterfaceCallback {
	private static LruCacheManager lruCacheManager;
	private MyLruCache myLruCache;

	public static LruCacheManager getManager(int maxSize) {
		if (lruCacheManager == null) {
			lruCacheManager = new LruCacheManager(maxSize);
		}
		return lruCacheManager;
	}

	public LruCacheManager(int maxSize) {
		myLruCache = new MyLruCache(maxSize);
	}

	class MyLruCache extends android.support.v4.util.LruCache<String, Bitmap> {

		public MyLruCache(int maxSize) {
			super(maxSize);
		}

		@Override
		protected int sizeOf(String key, Bitmap value) {
			int size = value.getRowBytes() * value.getHeight();
			return size;

		}

		@Override
		protected void entryRemoved(boolean evicted, String key,
				Bitmap oldValue, Bitmap newValue) {
			if (evicted) {
				SoftReferenceManager softReferenceManager = SoftReferenceManager
						.getManager();
				softReferenceManager.add(key, oldValue);
				SDCardCacheManager manager = SDCardCacheManager
						.getManager(10 * 1024 * 1024);
				String arr[] = key.split("/");
				String name = arr[arr.length - 1];
				manager.add(name, oldValue);
			}
		}
	}

	@Override
	public boolean add(String fileName, Bitmap bitmap) {
		myLruCache.put(fileName, bitmap);
		return true;
	}

	@Override
	public Bitmap getCache(String fileName) {
		System.out.println("命中LRU");
		return myLruCache.get(fileName);
	}

	@Override
	public void clear() {
	}
}
