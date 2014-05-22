package com.example.task_19registerreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class RegisterReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, 
				"Register receiver: "+intent.getStringExtra("key")+" send broadcast",
				Toast.LENGTH_LONG).show();
	}

}
