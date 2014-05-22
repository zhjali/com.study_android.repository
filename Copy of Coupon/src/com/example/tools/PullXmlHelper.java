package com.example.tools;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class PullXmlHelper {

	public PullXmlHelper() {
	}

	public List<Map<String, Object>> getXmlList(byte[] b, String NodeName,
			List<String> params) {
		List<Map<String, Object>> list1 = null;
		Map<String, Object> map = null;
		// BufferedInputStream bis = null;
		InputStream in = new ByteArrayInputStream(b);
		InputStreamReader ir = new InputStreamReader(in);
		try {
			// 实例化一个XmlPullParser工厂
			XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
			// 实例化一个XmlPullParser 解析对象
			XmlPullParser xmlpullparse = factory.newPullParser();
			// 将Xml文件做为流传入到Inputstream
			// bis = new BufferedInputStream(new FileInputStream(XmlPath));
			// Xml解析对象接收输入流对象
			xmlpullparse.setInput(ir);
			// 得到一个事件
			int event = xmlpullparse.getEventType();
			while (event != XmlPullParser.END_DOCUMENT) {
				// 标签名
				System.out.println("event" + event);
				String str = xmlpullparse.getName();
				switch (event) {
				// 读到XML头文件的时候，就开始文档 event =0
				case XmlPullParser.START_DOCUMENT:
					list1 = new ArrayList<Map<String, Object>>();
					break;
				case XmlPullParser.START_TAG:
					if (NodeName.equals(str)) {
						map = new HashMap<String, Object>();
					}
					for (int i = 0; i < params.size(); i++) {
						if (str.equals(params.get(i))) {
							map.put(params.get(i).toString(),
									xmlpullparse.nextText());
						}
					}
					break;
				case XmlPullParser.TEXT:
					break;
				case XmlPullParser.END_TAG:
					if (NodeName.equals(str)) {
						list1.add(map);
						map = null;
					}
					break;
				default:
					break;
				}
				event = xmlpullparse.next();
			}
			return list1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
