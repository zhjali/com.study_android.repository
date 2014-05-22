package com.example.task_sdk;

import java.io.File;

import android.os.Environment;

public class SDCardHelper {
	
	public static boolean isSDCardMounted(){
		return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
	}
	
	public static File getSDCardRootFile(){
		return Environment.getExternalStorageDirectory();
	}
}
