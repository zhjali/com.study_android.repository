package com.example.contants;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.text.TextUtils;

import com.example.contants.ground.ground_pinglun;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtils {
	private Demo_youhui youhui;
	private ground_pinglun gPinglun;

	public Demo_youhui changeJsonToObject(byte[] b) {
		String ss = new String(b);
		if (!TextUtils.isEmpty(ss)) {
			Gson gson = new Gson();
			TypeToken<Demo_youhui> token = new TypeToken<Demo_youhui>() {
			};
			Type type = token.getType();
			youhui = gson.fromJson(ss, type);
			return youhui;
		}
		return null;
	}

	public ground_pinglun changeJsonToObject_gpingjun(byte[] b) {
		String ss = new String(b);
		if (!TextUtils.isEmpty(ss)) {
			Gson gson = new Gson();
			TypeToken<ground_pinglun> token = new TypeToken<ground_pinglun>() {
			};
			Type type = token.getType();
			gPinglun = gson.fromJson(ss, type);
			return gPinglun;
		}
		return null;
	}
	

	public static List<Result> changeXmlToObj(byte[] b) {
		List<Result> list = null;
		List<shop1> shops = null;
		Result rs = null;
		shop1 sp = null;
		InputStream in = new ByteArrayInputStream(b);
		InputStreamReader ir = new InputStreamReader(in);
		try {
			XmlPullParserFactory xpFactory = XmlPullParserFactory.newInstance();
			XmlPullParser parser = xpFactory.newPullParser();
			parser.setInput(ir);
			int event = parser.getEventType();
			while (event != parser.END_DOCUMENT) {
				String nodeName = parser.getName();
				switch (event) {
				case XmlPullParser.START_DOCUMENT:
					list = new ArrayList<Result>();
					break;
				case XmlPullParser.START_TAG:
					if ("result".equals(nodeName)) {
						rs = new Result();
					}
					if ("id".equals(nodeName)) {
						String id = parser.nextText();
						rs.setId(id);
					} else if ("title".equals(nodeName)) {
						String title = parser.nextText();
						rs.setTitle(title);
					} else if ("endTime".equals(nodeName)) {
						String endTime = parser.nextText();
						rs.setEndTime(endTime);
					} else if ("category".equals(nodeName)) {
						String category = parser.nextText();
						rs.setCategory(category);
					} else if ("city".equals(nodeName)) {
						String city = parser.nextText();
						rs.setCity(city);
					} else if ("image".equals(nodeName)) {
						String image = parser.nextText();
						rs.setImage(image);
					} else if ("price".equals(nodeName)) {
						String price = parser.nextText();
						rs.setPrice(price);
					} else if ("value".equals(nodeName)) {
						String value = parser.nextText();
						rs.setValue(value);
					} else if ("rebate".equals(nodeName)) {
						String rebate = parser.nextText();
						rs.setRebate(rebate);
					} else if ("bought".equals(nodeName)) {
						String bought = parser.nextText();
						rs.setBought(bought);
					} else if ("website".equals(nodeName)) {
						String website = parser.nextText();
						rs.setWebsite(website);
					} else if ("delivery".equals(nodeName)) {
						String delivery = parser.nextText();
						rs.setDelivery(delivery);
					} else if ("freightFree".equals(nodeName)) {
						String freightFree = parser.nextText();
						rs.setFreightFree(freightFree);
					} else if ("freight".equals(nodeName)) {
						String freight = parser.nextText();
						rs.setFreight(freight);
					} else if ("maxPerOrder".equals(nodeName)) {
						String maxPerOrder = parser.nextText();
						rs.setMaxPerOrder(maxPerOrder);
					} else if ("minPerOrder".equals(nodeName)) {
						String minPerOrder = parser.nextText();
						rs.setMinPerOrder(minPerOrder);
					} else if ("dealUrl".equals(nodeName)) {
						String dealUrl = parser.nextText();
						rs.setDealUrl(dealUrl);
					} else if ("distance".equals(nodeName)) {
						String distance = parser.nextText();
						rs.setDistance(distance);
					}
					if ("shops".equals(nodeName)) {
						shops = new ArrayList<shop1>();
						rs.setShops(shops);
					}
					if ("shop".equals(nodeName)) {
						sp = new shop1();
						shops.add(sp);
					}
					// else if ("id".equals(nodeName)) {
					// String id = parser.nextText();
					// sp.setId(id);
					// }
					// if ("price".equals(nodeName)) {
					// String price = parser.nextText();
					// sp.setPrice(price);
					// }
					else if ("name".equals(nodeName)) {
						String name = parser.nextText();
						sp.setName(name);
					} else if ("address".equals(nodeName)) {
						String address = parser.nextText();
						sp.setAddress(address);
					} else if ("telno".equals(nodeName)) {
						String telno = parser.nextText();
						sp.setTelno(telno);
					} else if ("trade_name".equals(nodeName)) {
						String trade_name = parser.nextText();
						sp.setTrade_name(trade_name);
					} else if ("hasCoupon".equals(nodeName)) {
						String hasCoupon = parser.nextText();
						sp.setHasCoupon(hasCoupon);
					} else if ("hasGroup".equals(nodeName)) {
						String hasGroup = parser.nextText();
						sp.setHasGroup(hasGroup);
					} else if ("hasBank".equals(nodeName)) {
						String hasBank = parser.nextText();
						sp.setHasBank(hasBank);
					} else if ("hasBook".equals(nodeName)) {
						String hasBook = parser.nextText();
						sp.setHasBook(hasBook);
					} else if ("onlyShop".equals(nodeName)) {
						String onlyShop = parser.nextText();
						sp.setOnlyShop(onlyShop);
					} else if ("star".equals(nodeName)) {
						String star = parser.nextText();
						sp.setStar(star);
					}
					// else if ("price".equals(nodeName)) {
					// String price = parser.nextText();
					// sp.setPrice(price);
					// }
					else if ("shop_id".equals(nodeName)) {
						String shop_id = parser.nextText();
						sp.setShop_id(shop_id);
					}
					// else if ("distance".equals(nodeName)) {
					// String distance = parser.nextText();
					// sp.setDistance(distance);
					// }
					break;
				case XmlPullParser.TEXT:
					break;
				case XmlPullParser.END_TAG:

					// if ("shop".equals(nodeName)) {
					// rs.setShops(shops);
					// shops.add(sp);
					// }
					if ("result".equals(nodeName)) {
						list.add(rs);
						rs = null;
					}

					break;
				default:
					break;
				}
				event = parser.next();
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
