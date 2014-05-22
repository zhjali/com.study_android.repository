package com.example.boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "Receive broad cast", Toast.LENGTH_SHORT)
				.show();

		Intent intent2 = new Intent();
		intent2.setClassName("com.example.boot",
				"com.example.boot.MainActivity");
		context.startActivity(intent2);
	}

}
