package com.example.task_19registerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, 
				"Nomarl receiver: "+intent.getStringExtra("key")+" send broadcast",
				Toast.LENGTH_LONG).show();
	}
}
