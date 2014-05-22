package Utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class DownLoadTask extends AsyncTask<String, Bitmap, String> {
	private final String TAG = "DownLoadTask";

	private ImageView mView;

	public DownLoadTask(ImageView mView) {
		this.mView = mView;
	}

	@Override
	protected String doInBackground(String... params) {
		Log.d(TAG, "DownLoad bitmap in background");

		URL url = null;
		try {
			url = new URL(params[0]);
			Bitmap bitmap = BitmapFactory.decodeStream(url.openStream());
			publishProgress(bitmap);

			LoadSDcardBM.saveToSD(params[0], bitmap);
			LoadCache.getCache().put(params[0], bitmap);

			return "suceess";
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "failure";
	}

	@Override
	protected void onPostExecute(String result) {
		Log.d(TAG, "Result: " + result);

		super.onPostExecute(result);
	}

	@Override
	protected void onProgressUpdate(Bitmap... values) {
		mView.setImageBitmap(values[0]);

		super.onProgressUpdate(values);
	}
}
