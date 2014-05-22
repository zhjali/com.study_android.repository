package com.example.task_upload;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

public class UpLoadUtils {
	private static final int TIME_OUT = 10 * 1000000;
	public static final String CHARSET = "utf-8";
	public static final String CONTENT_TYPE = "";
	public static final String SUCCESS = "1";
	public static final String FALIURE = "0";

	public static String upLoad(File file, String RequestURL) {
		String BOUNDER = UUID.randomUUID().toString();
		String PREFIX = "--";
		String END = "/r/n";

		try {
			URL url = new URL(RequestURL);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setReadTimeout(TIME_OUT);
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setUseCaches(false);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Charset", CHARSET);
			connection.setRequestProperty("Connection", "Keep-Alive");
			connection.setRequestProperty("Cotent-Type", CONTENT_TYPE
					+ ";boundary=" + BOUNDER);

			if (file != null) {
				OutputStream outputStream = connection.getOutputStream();

				DataOutputStream dataOutputStream = new DataOutputStream(
						outputStream);
				StringBuffer sb = new StringBuffer();
				sb.append(PREFIX);
				sb.append(BOUNDER + END);
				dataOutputStream.write(sb.toString().getBytes());
				InputStream in = new FileInputStream(file);
				byte[] b = new byte[1024];
				int l = 0;
				while ((l = in.read()) != -1) {
					outputStream.write(b, 0, l);
				}
				in.close();
				dataOutputStream.write(END.getBytes());
				dataOutputStream.write((PREFIX + BOUNDER + PREFIX + END)
						.getBytes());
				dataOutputStream.flush();

				int i = connection.getResponseCode();
				if (i == 200) {
					return SUCCESS;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return FALIURE;

	}
}
