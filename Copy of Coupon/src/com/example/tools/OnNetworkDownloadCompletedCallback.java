package com.example.tools;

import android.graphics.Bitmap;

public interface OnNetworkDownloadCompletedCallback {
	public void OnNetworkDownloadCompleted(byte[] result);

	public void OnNetworkDownloadCompleted(Bitmap result);
}
