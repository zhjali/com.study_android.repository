package com.example.tools;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;

import com.example.cache.CacheInterfaceCallback;

public class NetworkUtils {
	private Handler mainHandler;
	private static final int TEXT = 1;
	private static final int IMG = 2;
	private Bitmap bitmap;

	public NetworkUtils() {
		Looper looper = Looper.getMainLooper();
		mainHandler = new Handler(looper) {

			@Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg);
				if (msg.what == TEXT) {
					Bundle bundle = msg.getData();
					byte[] result = bundle.getByteArray("result");
					OnNetworkDownloadCompletedCallback callback = (OnNetworkDownloadCompletedCallback) msg.obj;
					callback.OnNetworkDownloadCompleted(result);
				} else if (msg.what == IMG) {
					//System.out.println("else if-------------");
					Bundle bundle = msg.getData();
					Bitmap bitmap = bundle.getParcelable("result");
					OnNetworkDownloadCompletedCallback callback = (OnNetworkDownloadCompletedCallback) msg.obj;
					callback.OnNetworkDownloadCompleted(bitmap);
				}
			}
		};
	}

	public void imageDownload(final String imgUrl,final ImageView imageView,
			final CacheInterfaceCallback c1,
			final OnNetworkDownloadCompletedCallback c2) {
		if (c1 != null) {
			if(c1.getCache(imgUrl)!=null){
				bitmap=c1.getCache(imgUrl);
				if(imageView!=null){
					imageView.setImageBitmap(bitmap);
				}
			}else{
				new Thread(new Runnable() {

					@Override
					public void run() {
						System.out.println("------------>run");
						HttpClient httpClient = new DefaultHttpClient();
						HttpGet httpGet = new HttpGet(imgUrl);
						HttpResponse resp = null;
						try {
							resp = httpClient.execute(httpGet);
							if (resp.getStatusLine().getStatusCode() == 200) {
								HttpEntity entity = resp.getEntity();
								InputStream ins = entity.getContent();
								bitmap= BitmapFactory
										.decodeStream(ins);
								if(bitmap!=null){
								c1.add(imgUrl, bitmap);
								System.out.println("加入缓存一次");
								Message msg = mainHandler.obtainMessage();
								Bundle bundle = new Bundle();
								bundle.putParcelable("result", bitmap);
								msg.setData(bundle);
								msg.obj = c2;
								msg.what = IMG;
								mainHandler.sendMessage(msg);
							}}
						} catch (ClientProtocolException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
				
			}
	
		} else {
				new Thread(new Runnable() {

					@Override
					public void run() {
						System.out.println("------------>run");
						HttpClient httpClient = new DefaultHttpClient();
						HttpGet httpGet = new HttpGet(imgUrl);
						HttpResponse resp = null;
						try {
							resp = httpClient.execute(httpGet);
							if (resp.getStatusLine().getStatusCode() == 200) {
								HttpEntity entity = resp.getEntity();
								InputStream ins = entity.getContent();
								bitmap = BitmapFactory
										.decodeStream(ins);
								//c1.add(imgUrl, bitmap);
								System.out.println("加入缓存一次");
								Message msg = mainHandler.obtainMessage();
								Bundle bundle = new Bundle();
								bundle.putParcelable("result", bitmap);
								msg.setData(bundle);
								msg.obj = c2;
								msg.what = IMG;
								mainHandler.sendMessage(msg);
							}
						} catch (ClientProtocolException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}).start();
			
		}
	}

	public void textDownload(final String textUrl,
			final OnNetworkDownloadCompletedCallback callback) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				HttpClient httpClient = new DefaultHttpClient();
				HttpGet httpGet = new HttpGet(textUrl);
				HttpResponse resp = null;
				InputStream in = null;
				try {
					resp = httpClient.execute(httpGet);
					int code = resp.getStatusLine().getStatusCode();
					if (code == 200) {
						HttpEntity entity = resp.getEntity();
						in = entity.getContent();
						ByteArrayOutputStream buf = new ByteArrayOutputStream();
						int len = 0;
						byte buffer[] = new byte[1024];
						while ((len = in.read(buffer)) != -1) {
							buf.write(buffer, 0, len);
						}
						Message msg = mainHandler.obtainMessage();
						Bundle bundle = new Bundle();
						bundle.putByteArray("result", buf.toByteArray());
						msg.setData(bundle);
						msg.obj = callback;
						msg.what = TEXT;
						mainHandler.sendMessage(msg);
					} else {
						System.out.println("CODE--" + code);
					}
				} catch (ClientProtocolException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}) {
		}.start();
	}

	public static void closeIO(InputStream ins) {
		if (ins != null) {
			try {
				ins.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
