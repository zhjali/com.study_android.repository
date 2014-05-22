package com.example.stockquoteclient;

import com.example.task_17payserver.IStockQuoteService;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private static final String TAG = "StockQuoteClient";
	private IStockQuoteService stockService = null;
	private ToggleButton binBtn;
	private Button callBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		binBtn = (ToggleButton) findViewById(R.id.toggleButton1);
		callBtn = (Button) findViewById(R.id.button1);
	}
	
	private ServiceConnection serConn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.v(TAG,"onServiceDisconnected() called");
			binBtn.setChecked(false);
			callBtn.setEnabled(false);
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			Log.v(TAG, "onServiceConnected() called");
			stockService = IStockQuoteService.Stub.asInterface(service);
			binBtn.setChecked(true);
			callBtn.setEnabled(true);
		}
	};

	protected void onDestroy() {
		Log.v(TAG, "onDestroy() called");
		if(callBtn.isEnabled())
			unbindService(serConn);
		super.onDestroy();
	}
	
	public void doClick(View view){
		System.out.println("is click");
		switch (view.getId()) {
		case R.id.toggleButton1:
			System.out.println("toggle clicked");
			System.out.println("Name: "+IStockQuoteService.class.getName());
			if(((ToggleButton) view).isChecked()){
				bindService(new Intent(
						IStockQuoteService.class.getName()),
						serConn, Context.BIND_AUTO_CREATE);
				System.out.println("bind service");
			}else {
				unbindService(serConn);
				callBtn.setEnabled(false);
			}
			break;
		case R.id.button1:
			callService();
			break;

		}
	}

	private void callService() {
		double val;
		try {
			val = stockService.getQuote("ANDRODI");
			Toast.makeText(MainActivity.this, "Vaule from service is" + val, Toast.LENGTH_SHORT).show();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
