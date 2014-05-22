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
 * ��ѯsd������ͼƬ��������ء����浽lruCache������ʹ��DownLoadTask������ͼƬ �����浽sd����lruCache
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
			Log.d(TAG, "sd��û�й���");
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
	 * ����ָ��url����ȡ������"/"����ַ���
	 * 
	 * @param url
	 * @return �ļ���
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
	 * ����ָ��url��ȡ�ļ�������PIC_DIR�´����ļ���Ȼ�󷵻ش��ļ������
	 * 
	 * @param url
	 * @return ����ָ��url�õ����ļ������ص�OutputStream��
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
	 * ����ָ��url�ĺ�׺�õ��ļ���������PIC_DIR��ɾ��
	 * 
	 * @param url
	 * @return ɾ��ʧ�ܡ��ļ������ڷ���false��ɾ���ɹ�����true��
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
	 * �ж�PIC_DIR�ļ����£�ָ�����ļ���picName���ļ�ʱ�����
	 * 
	 * @param picName
	 *            �ļ���
	 * @return ����true��������false
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
