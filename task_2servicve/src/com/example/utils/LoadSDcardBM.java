package com.example.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

/**
 * 查询sd卡有无图片，有则加载、缓存到lruCache，无则使用DownLoadTask类下载图片 并缓存到sd卡、lruCache
 * 
 * @author Administrator
 */
public class LoadSDcardBM {
	public static final File DIR;
	public static final File DOWNLOAD_DIR;
	public static final File PIC_DIR;

	private LoadSDcardBM() {
	}

	static {
		if (isAccessExtStor()) {
			DIR = Environment.getExternalStorageDirectory();
			DOWNLOAD_DIR = new File(DIR, "download");
			PIC_DIR = new File(DOWNLOAD_DIR, "picture");
			if (!PIC_DIR.exists()) {
				PIC_DIR.mkdirs();
			}
		} else {
			DIR = null;
			DOWNLOAD_DIR = null;
			PIC_DIR = null;
		}
	}

	private static final String TAG = "DownLoadNativeBM";

	public static boolean isAccessExtStor() {
		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			return true;
		}
		return false;
	}

	public static void setBitmapToView(String url, ImageView view) {

		if (PIC_DIR == null) {
			Log.d(TAG, "sd卡没有挂载");
			return;
		}
		String picName = getFileName(url);

		if (isPicSave(picName)) {
			Bitmap bitmap = BitmapFactory.decodeFile(new File(PIC_DIR, picName)
					.getAbsolutePath());
			view.setImageBitmap(bitmap);
		}
	}

	/**
	 * 根据指定url，截取器最后的"/"后的字符串
	 * 
	 * @param url
	 * @return 文件名
	 */
	public static String getFileName(String url) {
		String[] paths = url.split("/");
		String fileName = paths[paths.length - 1];
		Log.d(TAG, "File Name: " + fileName);
		return fileName;
	}

	public static void saveToSD(String url, Bitmap bitmap) {
		File picFile = getPicFile(url);
		try {
			bitmap.compress(CompressFormat.JPEG, 100, new FileOutputStream(
					picFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据指定url获取文件名，在PIC_DIR下创建文件，然后返回此文件输出流
	 * 
	 * @param url
	 * @return 根据指定url得到的文件，返回的OutputStream。
	 * @throws FileNotFoundException
	 */
	public static OutputStream getFileStream(String url)
			throws FileNotFoundException {
		String picName = getFileName(url);
		FileOutputStream outputStream = new FileOutputStream(new File(PIC_DIR,
				picName));
		return outputStream;
	}

	/**
	 * 根据指定url的后缀得到文件名，并在PIC_DIR下删除
	 * 
	 * @param url
	 * @return 删除失败、文件不存在返回false；删除成功返回true，
	 */
	public static boolean deleteFile(String url) {
		if (isPicSave(getFileName(url))) {
			return getPicFile(url).delete();
		}
		return false;
	}

	public static File getPicFile(String url) {
		String picName = getFileName(url);
		return new File(PIC_DIR, picName);
	}

	/**
	 * 判断PIC_DIR文件夹下，指定的文件名picName的文件时候存在
	 * 
	 * @param picName
	 *            文件名
	 * @return 存在true，不存在false
	 */
	public static boolean isPicSave(String picName) {
		File[] files = PIC_DIR.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().equals(picName)) {
				return true;
			}
		}
		return false;
	}
}
