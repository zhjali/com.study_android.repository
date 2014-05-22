package com.example.task_29broadcastreceive;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String value = intent.getStringExtra("key");
		Toast.makeText(context, "The key "+value, Toast.LENGTH_LONG).show();
	}

}
