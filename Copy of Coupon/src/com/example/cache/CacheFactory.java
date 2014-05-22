package com.example.cache;

public class CacheFactory {
	private static CacheInterfaceCallback cacheManager;

	public static CacheInterfaceCallback getCacheManager() {
		if (cacheManager == null) {
			cacheManager=new CacheManager(10*1024*1024, 10*1024*1024);
		}
		return cacheManager;
	}
	
}