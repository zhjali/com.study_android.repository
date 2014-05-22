package com.example.task_2servicve;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.example.task_2servicve.MainActivity.MyReceiver;
import com.example.utils.LoadSDcardBM;

public class MyService extends Service {
	private static String TAG = "MyService";

	public static final int VALUE_FAILURE = 0;
	public static final int VALUE_SUCCESS = 1;
	public static final int VALUE_UPDATE = 2;
	public static final String KEY_RESULT = "result";
	public static final String KEY_UPDATE = "update";

	private String uri;
	private Intent broad_intent;
	private boolean flag = true;

	public boolean getFlag() {
		return flag;
	}

	/**
	 * �ͻ���ͨ���󶨷���˺�õ������ã���������������ر����ء�
	 * 
	 * @param flag
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		return super.onStartCommand(intent, flags, startId);
	}

	private Thread myThread = new Thread(new Runnable() {

		@Override
		public void run() {
			Log.d(TAG, "����˿��������߳�");

			try {
				broad_intent = new Intent(MyReceiver.ACTION);

				HttpClient client = new DefaultHttpClient();
				HttpGet get = new HttpGet(uri);

				HttpEntity entity = client.execute(get).getEntity();
				// �����ļ����ܳ���
				long length = entity.getContentLength();

				InputStream in = entity.getContent();

				if (in != null) {
					FileOutputStream out = (FileOutputStream) LoadSDcardBM
							.getFileStream(uri);
					byte[] buffer = new byte[1024];
					int len = 0;
					long addLen = 0;

					while ((len = in.read(buffer)) != -1 && flag == true) {
						out.write(buffer, 0, len);
						addLen += len;

						// �ж����ذٷֱ�
						int rate = (int) ((addLen * 100) / length);
						// ���͸���ProgressBar�Ĺ㲥
						broad_intent.putExtra(KEY_UPDATE, rate);
						sendBroadcast(broad_intent);
					}
				}
				if (flag == true) {
					// �����ļ��ɹ������ͳɹ��㲥
					broad_intent.putExtra(KEY_RESULT, VALUE_SUCCESS);
					sendBroadcast(broad_intent);
					return;
				}
			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			// �����ļ�ʧ�ܣ�����ʧ�ܹ㲥
			broad_intent.putExtra(KEY_RESULT, VALUE_FAILURE);
			sendBroadcast(broad_intent);
			// �����Լ��Ĺ����࣬ɾ��δ������ɵ��ļ�
			LoadSDcardBM.deleteFile(uri);
		}
	});

	@Override
	public IBinder onBind(Intent intent) {
		setFlag(true);
		return new MyBinder();
	}

	public class MyBinder extends Binder {
		public MyService getService() {
			return MyService.this;
		}
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	/**
	 * �ͻ��˵��ô˷�������ͼƬ��SD��
	 * 
	 * @param url
	 *            ͼƬ��ַ
	 */
	public void down(String url) {
		uri = url;
		myThread.start();
	}

}
