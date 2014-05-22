package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

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
	public static final File chabaike_DIR;
	public static final File PIC_DIR;

	private LoadSDcardBM() {
	}

	static {
		if (isAccessExtStor()) {
			DIR = Environment.getExternalStorageDirectory();
			chabaike_DIR = new File(DIR, "chabaike");
			PIC_DIR = new File(chabaike_DIR, "picture");
			if (!PIC_DIR.exists()) {
				PIC_DIR.mkdirs();
			}
		} else {
			DIR = null;
			chabaike_DIR = null;
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
		File pic_file = null;

		if (PIC_DIR == null) {
			Log.d(TAG, "sd卡没有挂载");
			return;
		}
		String picName = getPicName(url);
		pic_file = new File(PIC_DIR, picName);

		if (isPicSave(picName)) {
			Bitmap bitmap = BitmapFactory.decodeFile(new File(PIC_DIR, picName)
					.getAbsolutePath());
			view.setImageBitmap(bitmap);
			LoadCache.getCache().put(url, bitmap);
		} else {
			new DownLoadTask(view).execute(url);
		}

	}

	public static String getPicName(String url) {
		String[] paths = url.split("/");
		String picName = paths[paths.length - 1];
		Log.d(TAG, "Picture Name: " + picName);
		return picName;
	}

	public static boolean isPicSave(String picName) {
		File[] files = PIC_DIR.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (files[i].getName().equals(picName)) {
				return true;
			}
		}
		return false;
	}

	public static void saveToSD(String url, Bitmap bitmap) {

		String picName = getPicName(url);
		Log.d(TAG, "save to sd card " + picName);
		File picFile = new File(PIC_DIR, picName);
		try {
			bitmap.compress(CompressFormat.JPEG, 100, new FileOutputStream(
					picFile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
