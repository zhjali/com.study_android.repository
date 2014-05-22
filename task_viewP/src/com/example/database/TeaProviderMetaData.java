package com.example.database;

import android.provider.BaseColumns;

/**
 * 
 * @author Administrator 描述数据库和其表的结构。用常量来表示。 便于用户访问。
 */
public class TeaProviderMetaData {
	// 数据库结构
	public static final String DATABASE_NAME = "ChaBaiKe.db";
	public static final int DATABASE_VERSION = 1;
	public static final String TABLE_MAINDATA_NAME = "maindata";
	public static final String TABLE_COLLECT_NAME = "collect";
	public static final String TABLE_VIEW_PAGER_NAME = "viewpagerinfo";

	private TeaProviderMetaData() {
	};

	public static final class TableMaindataMetaData implements BaseColumns {
		private TableMaindataMetaData() {
		};

		public static final String ID = "id";
		public static final String TITLE = "title";
		public static final String SOURCE = "source";
		public static final String DESCRIPTION = "description";
		public static final String WAP_THUMB = "wap_thumb";
		public static final String CREATE_TIME = "reate_time";
		public static final String NICK_NAME = "nick_name";
		public static final String CATEGORY = "category";
	}

	public static final class TableCollectMetaData implements BaseColumns {
		private TableCollectMetaData() {
		};

		public static final String ID_MAIN_DATA = "id_main_data";

	}

	public static final class TableViewPagerMetaData implements BaseColumns {
		private TableViewPagerMetaData() {
		};

		public static final String ID = "id";
		public static final String TITLE = "title";
		public static final String NAME = "name";
		public static final String LINK = "link";
		public static final String CONTENT = "content";
		public static final String IMAGE = "image";
		public static final String IMAGE_S = "iamge_s";
	}
}
