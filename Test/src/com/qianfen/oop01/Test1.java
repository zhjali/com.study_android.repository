package com.qianfen.oop01;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test1 {
	public static void main(String[] args) {
		try {
			ServerSocket st = new ServerSocket(8090);
			Socket ss = st.accept();
			InputStream sc = ss.getInputStream();
			byte b[] = new byte[1024];
			int len = 0;
			while ((len = sc.read(b)) != -1) {
				for (byte ss1 : b) {
					System.out.println(ss1);
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
