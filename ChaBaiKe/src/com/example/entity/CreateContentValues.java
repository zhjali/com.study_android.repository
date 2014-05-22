package com.example.entity;

import android.content.ContentValues;

import com.example.database.TeaProviderMetaData.TableMaindataMetaData;
import com.example.database.TeaProviderMetaData.TableViewPagerMetaData;

public class CreateContentValues {

	private CreateContentValues() {
	};

	public static ContentValues createLV(String id, String title,
			String source, String description, String wapThumb,
			String createTime, String nickName, String category) {
		ContentValues values = new ContentValues();
		values.put(TableMaindataMetaData.ID, id);
		values.put(TableMaindataMetaData.TITLE, title);
		values.put(TableMaindataMetaData.SOURCE, source);
		values.put(TableMaindataMetaData.DESCRIPTION, description);
		values.put(TableMaindataMetaData.WAP_THUMB, wapThumb);
		values.put(TableMaindataMetaData.CREATE_TIME, createTime);
		values.put(TableMaindataMetaData.NICK_NAME, nickName);
		values.put(TableMaindataMetaData.CATEGORY, category);

		return values;
	}

	public static ContentValues createVP(String id, String title, String name,
			String link, String content, String image, String images) {
		ContentValues values = new ContentValues();

		values.put(TableViewPagerMetaData.ID, id);
		values.put(TableViewPagerMetaData.TITLE, title);
		values.put(TableViewPagerMetaData.NAME, name);
		values.put(TableViewPagerMetaData.LINK, link);
		values.put(TableViewPagerMetaData.CONTENT, content);
		values.put(TableViewPagerMetaData.IMAGE, image);
		values.put(TableViewPagerMetaData.IMAGE_S, images);

		return values;
	}
}
