package com.example.task_18blanklist;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.TelephonyManager;

public class MonitorPhone extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		monitorThread.start();
		return null;
	}
	
	
	Thread monitorThread = new Thread(){
		boolean flag = true;
		
		public void run() {
			String num = null;
			while(flag){
				TelephonyManager phoneManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
				if(phoneManager.getCallState() == TelephonyManager.CALL_STATE_RINGING){
					num = phoneManager.getLine1Number();
				}
				if(num.equals(123456)){
					
				}
			}
		};
	};

}
