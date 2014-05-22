package com.example.task_17payserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class StockQuoteService extends Service {
	private static final String TAG = "StockQuoteService";

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy() called");
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		Log.v(TAG,"onBind() called");
		return new StockQuoteServiceImpl();
	}

	public class StockQuoteServiceImpl extends IStockQuoteService.Stub
	{
		@Override
		public double getQuote(String ticker) throws RemoteException {
			Log.v(TAG, "getQuote() called for" + ticker);
			return 2.0;
		}
	}
	
	
}
