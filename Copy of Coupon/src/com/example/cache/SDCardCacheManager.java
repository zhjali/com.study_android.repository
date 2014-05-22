package com.example.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

class SDCardCacheManager implements CacheInterfaceCallback {

	private static final String CACHE_PATH = "cache";
	private static final long CAPACITY = 10 * 1024 * 1024;

	private List<CachedFile> cachedFiles;
	private long totalSpace;
	private long capacity;
	private String cachePath;
	private static SDCardCacheManager manager;

	public static SDCardCacheManager getManager(long capacity) {
		if (manager == null) {
			String actualPath = Environment.getExternalStorageDirectory()
					+ File.separator + CACHE_PATH + File.separator;
			manager = new SDCardCacheManager(actualPath, capacity);
		}
		return manager;
	}

	// ��ʼ��
	// 1.���ʹ�������Ŀ¼
	// 2.ɨ�軺��Ŀ¼���е��ļ����������С
	private SDCardCacheManager(String cachePath, long capacity) {
		File file = new File(cachePath);
		cachedFiles = new ArrayList<CachedFile>();
		totalSpace = 0;
		this.cachePath = cachePath;
		this.capacity = capacity;
		if (!file.exists()) {
			try {
				file.mkdir();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return;
		}

		File subFiles[] = file.listFiles();
		for (int i = 0; i < subFiles.length; i++) {
			File subFile = subFiles[i];
			if (!subFile.isDirectory()) {
				String fileName = subFiles[i].getName();
				long length = subFiles[i].length();
				long modified = subFiles[i].lastModified();
				CachedFile cachedFile = new CachedFile(fileName, length,
						modified);
				cachedFiles.add(cachedFile);
				totalSpace += length;
			}
		}
	}

	// ���?�����
	public void clear() {
		Collections.sort(cachedFiles);
		List<CachedFile> clearedFiles = cachedFiles.subList(
				cachedFiles.size() / 2, cachedFiles.size());
		for (CachedFile cachedFile : clearedFiles) {
			File file = new File(cachePath + cachedFile.getName());
			file.delete();
			totalSpace -= cachedFile.getLength();
			cachedFiles.remove(cachedFile);
		}
	}

	@Override
	public boolean add(String fileName, Bitmap bitmap) {
		String path = cachePath + fileName;
		System.out.println(path);
		File file = new File(path);
		if (file.exists()) {
			return true;
		} else {
			try {
				file.createNewFile();
				OutputStream os = new FileOutputStream(file);
				bitmap.compress(Bitmap.CompressFormat.PNG, 100, os);
				CachedFile cachedFile = new CachedFile(fileName, file.length(),
						file.lastModified());
				cachedFiles.add(cachedFile);
				totalSpace += file.length();

				if (totalSpace >= capacity) {
					clear();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public Bitmap getCache(String fileName) {
		Bitmap bitmap = null;
		System.out.println("SD-CARD");
		for (CachedFile cachedFile : cachedFiles) {
			if (cachedFile.getName().equals(fileName)) {
				File file = new File(cachePath + fileName);
				try {
					InputStream is = new FileInputStream(file);
					bitmap = BitmapFactory.decodeStream(is);
					return bitmap;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		}
		return bitmap;
	}
}
