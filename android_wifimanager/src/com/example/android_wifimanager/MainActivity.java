package com.example.android_wifimanager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ListView;
import android.widget.Switch;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";

	public static final int CONNECTING = 1;

	private ListView listView;
	private WifiManager wifiManager;
	private List<ScanResult> list;
	private List<String> wifiList;
	private Switch switch1;
	private Button refresh;
	private AlertDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		inite();
	}

	private void inite() {
		listView = (ListView) findViewById(R.id.listView1);
		refresh = (Button) findViewById(R.id.refresh);
		refresh.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				if (!isWifiConn()
						&& wifiManager.getWifiState() != WifiManager.WIFI_STATE_ENABLING) {
					getWifiState();
					popUpWifi();
					return;
				}
				showListView();

			}
		});
		wifiManager = (WifiManager) getSystemService(WIFI_SERVICE);
		wifiList = new ArrayList<String>();
	}

	public boolean isWifiConn() {
		if (wifiManager.getWifiState() == WifiManager.WIFI_STATE_ENABLED) {
			Log.d(TAG, "is wificonn 连接");
			// wifiManager.startScan();
			list = wifiManager.getScanResults();
			return true;
		}

		Log.d(TAG, "is wificonn 没有连接");

		return false;
	}

	public void showListView() {

		if (list == null) {
			Callback callback = new Callback() {

				@Override
				public boolean handleMessage(Message msg) {
					switch (msg.what) {
					case CONNECTING:
						showListView();
						break;

					default:
						break;
					}
					return false;
				}
			};
			Handler handler = new Handler(callback);
			handler.sendEmptyMessageDelayed(CONNECTING, 3000);
			return;
		}
		wifiList.clear();
		for (ScanResult result : list) {
			wifiList.add(result.SSID);
			Log.d(TAG, "--BSSID-->" + result.BSSID);
			Log.d(TAG, "--capabitlites--->" + result.capabilities);
			Log.d(TAG, "--frequency" + result.frequency);
			Log.d(TAG, "");

		}

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, wifiList);
		listView.setAdapter(adapter);
	}

	public void popUpWifi() {
		System.out.println("popUp wifi");
		View view = LayoutInflater.from(this).inflate(R.layout.pop_up_wifi,
				null);
		switch1 = (Switch) view.findViewById(R.id.switch1);
		switch1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				wifiManager.setWifiEnabled(isChecked);
				dialog.dismiss();
				showListView();
			}
		});
		dialog = new AlertDialog.Builder(this).setView(view)
				.setTitle("Connect wifi").show();
	}

	public void getWifiState() {
		switch (wifiManager.getWifiState()) {
		case WifiManager.WIFI_STATE_DISABLED:
			System.out.println("=========disabled");
			break;
		case WifiManager.WIFI_STATE_DISABLING:
			System.out.println("=========disabling");
		case WifiManager.WIFI_STATE_ENABLED:
			System.out.println("=========enabled");
		case WifiManager.WIFI_STATE_ENABLING:
			System.out.println("=========enabling");

		default:
			break;
		}
	}
}
