package com.example.captureBundle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class Post {
	
	private static final Integer TIMEOUT = 2000;

	public static String requestByPost(String urlpath,String requesData) throws IOException{
		String str;
		URL  url = new URL(urlpath);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoInput(true);
		conn.setConnectTimeout(TIMEOUT);
		conn.setReadTimeout(TIMEOUT);
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Accept-Ecoding", "gzip");
		
		conn.connect();
		
		String urlEncodedRequestStr = URLEncoder.encode(requesData,"utf-8");
		String requestStr = "jsonStr="+urlEncodedRequestStr;
		
		conn.getOutputStream().write(requestStr.getBytes("utf-8"));
		conn.getOutputStream().flush();
		conn.getOutputStream().close();
		
		Map<String,List<String>> map = conn.getHeaderFields();
		if(null != map){
			for(String key: map.keySet()){
				System.out.println(key +"---->"+map.get(key));
			}
		}
		String content_encode = conn.getContentEncoding();
		System.out.println("contetn_encode: "+content_encode);
		
		int responseCode = conn.getResponseCode();
		System.out.println("response code: "+responseCode);
		
		if(responseCode != 200){
			String message = conn.getResponseMessage();
			throw new IOException("ResponseCode: "+responseCode+",message: "+message);
		}
		if (null != content_encode && !"".equals(content_encode) &&content_encode.equals("gzip")) {
			GZIPInputStream	in = new GZIPInputStream(conn.getInputStream());
			if(in == null){
				System.out.println("gzip is null");
				return "";
			}
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			int len;
			byte[] buffer = new byte[1024];
			while((len = in.read(buffer)) != -1){
				arrayOutputStream.write(buffer, 0, len);
			}
			in.close();
			arrayOutputStream.close();
			conn.disconnect();
			str = new String(arrayOutputStream.toByteArray(),"utf-8");
		}else {
			InputStream in = conn.getInputStream();
			if(in == null){
				return "";
			}
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			int len;
			byte[] buffer = new byte[1024];
			while((len = in.read(buffer)) != -1){
				arrayOutputStream.write(buffer, 0, len);
			}
			in.close();
			arrayOutputStream.close();
			conn.disconnect();
			str = new String(arrayOutputStream.toByteArray(),"utf-8");
		}
		return str;
	}
	
	public static void deCode(String str){
		try {
			System.out.println("================");
			System.out.println(URLDecoder.decode(str, "utf-8"));
			System.out.println("================");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
//		Post.requestByPost("http://www.baidu.com/", "hello=nishi");
		Post.deCode("Buding-PI: CwABAAAAEGNuLmJ1ZGluZy5jb3Vwb24LAAIAAAAEMzcxMAgAAwAAAAILAAQAAAAFYmFpZHULAAUAAAAZfjIwMTQwNDMwMTcxOTAxNTgwNjY1NDY3MwsABwAAABEwODowMDoyNzo2MDphNzo0NwQACAAAAAAAAAAABAAJAAAAAAAAAAALAAwAAAAkR2FsYXh5IFMyIC0gNC4xLjEgLSBBUEkgMTYgLSA0ODB4ODAwCwANAAAAATALAA8AAAArSlJPMDNTO2VuZy5idWlsZGJvdC4yMDEzMTIxNi4xMDU3Mzc7VW5rbm93bggAEAAAAAEA/r/nBuding-SID: buding_common_service-89ac1456-18ad-4665-a391-36604b81d575");
	}
}
