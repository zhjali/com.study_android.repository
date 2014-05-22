package com.example.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;

import android.graphics.Bitmap;

class SoftReferenceManager implements CacheInterfaceCallback{
	private static SoftReferenceManager softReferenceManager;
	private HashMap<String, SoftReference<Bitmap>> hashMap;
	
	
	public static SoftReferenceManager getManager(){
		if(softReferenceManager==null){
			softReferenceManager=new SoftReferenceManager();
		}
		return softReferenceManager;
	}
	
	private SoftReferenceManager(){
		hashMap=new HashMap<String, SoftReference<Bitmap>>();
	}
	

	@Override
	public boolean add(String fileName, Bitmap bitmap) {
		SoftReference<Bitmap> sr=new SoftReference<Bitmap>(bitmap);
		hashMap.put(fileName, sr);
		return true;
	}

	@Override
	public Bitmap getCache(String fileName) {
		Bitmap bitmap=null;
		SoftReference<Bitmap> sr=hashMap.get(fileName);
		if(sr!=null){
			bitmap=sr.get();
		}
		return bitmap;
	}

	@Override
	public void clear() {
		
	} 
}
