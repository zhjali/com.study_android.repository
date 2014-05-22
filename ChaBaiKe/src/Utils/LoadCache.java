package Utils;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

public class LoadCache {
	private static LruCache<String, Bitmap> cache;

	static {
		int maxMemory = (int) Runtime.getRuntime().maxMemory();
		int maxSize = maxMemory / 8;
		cache = new LruCache<String, Bitmap>(maxSize) {
			@Override
			protected int sizeOf(String key, Bitmap value) {
				// TODO Auto-generated method stub
				return value.getByteCount();
			};
		};
	}

	public static void setBitmapToView(String url, ImageView view) {
		Bitmap bitmap = cache.get(url);

		if (cache.get(url) != null) {
			view.setImageBitmap(bitmap);
			return;
		}
		LoadSDcardBM.setBitmapToView(url, view);
	}

	public static LruCache<String, Bitmap> getCache() {
		return cache;
	}

	public static void setCache(LruCache<String, Bitmap> cache) {
		LoadCache.cache = cache;
	}

}
