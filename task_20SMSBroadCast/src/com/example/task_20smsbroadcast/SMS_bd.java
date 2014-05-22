package com.example.task_20smsbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMS_bd extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle bundle = intent.getExtras();
		Object[] objects = (Object[]) bundle.get("pdus");
		SmsMessage[] smsSmsMessages = new SmsMessage[objects.length];
		for (int i = 0; i < smsSmsMessages.length; i++) {
			smsSmsMessages[i] = SmsMessage.createFromPdu((byte[]) objects[i]);
		}
		
		for(int i = 0; i<smsSmsMessages.length; i++){
			String body = smsSmsMessages[i].getDisplayMessageBody();
			String name = smsSmsMessages[i].getOriginatingAddress();
			System.out.println("body: "+body+" name: "+name);
			if (body.equals("ring")) {
				MediaPlayer player = MediaPlayer.create(context, R.raw.ring);
				player.start();
			}
		}
	}

}
