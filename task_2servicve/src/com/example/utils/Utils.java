package com.example.utils;

public class Utils {
	private Utils() {
	};

	public static String getFileName(String url) {
		String[] fregemnt = url.split("/");
		return fregemnt[fregemnt.length - 1];
	}

}
