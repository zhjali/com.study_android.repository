package com.example.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.database.TeaProviderMetaData.TableCollectMetaData;
import com.example.database.TeaProviderMetaData.TableMaindataMetaData;
import com.example.database.TeaProviderMetaData.TableViewPagerMetaData;

public class DataBaseHelper extends SQLiteOpenHelper {
	private static final String TAG = "DataBaseHelper";

	public DataBaseHelper(Context context) {
		super(context, TeaProviderMetaData.DATABASE_NAME, null,
				TeaProviderMetaData.DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql1 = "CREATE TABLE " + TeaProviderMetaData.TABLE_MAINDATA_NAME
				+ " (" + TableMaindataMetaData._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ TableMaindataMetaData.ID + " INTEGER,"
				+ TableMaindataMetaData.TITLE + " TEXT,"
				+ TableMaindataMetaData.SOURCE + " TEXT,"
				+ TableMaindataMetaData.DESCRIPTION + " TEXT,"
				+ TableMaindataMetaData.WAP_THUMB + " TEXT,"
				+ TableMaindataMetaData.CREATE_TIME + " TEXT,"
				+ TableMaindataMetaData.NICK_NAME + " TEXT,"
				+ TableMaindataMetaData.CATEGORY + " TEXT" + ");";
		Log.d(TAG, sql1);

		String sql2 = "CREATE TABLE " + TeaProviderMetaData.TABLE_COLLECT_NAME
				+ " (" + TableCollectMetaData._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ TableCollectMetaData.ID_MAIN_DATA + " INTEGER REFERENCES "
				+ TeaProviderMetaData.TABLE_MAINDATA_NAME + "(_id)" + ");";
		Log.d(TAG, sql2);

		String sql3 = "CREATE TABLE "
				+ TeaProviderMetaData.TABLE_VIEW_PAGER_NAME + " ("
				+ TableViewPagerMetaData._ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ TableViewPagerMetaData.ID + " INTEGER,"
				+ TableViewPagerMetaData.TITLE + " TEXT,"
				+ TableViewPagerMetaData.NAME + " TEXT,"
				+ TableViewPagerMetaData.LINK + " TEXT,"
				+ TableViewPagerMetaData.CONTENT + " TEXT,"
				+ TableViewPagerMetaData.IMAGE + " TEXT,"
				+ TableViewPagerMetaData.IMAGE_S + " TEXT" + ");";
		Log.d(TAG, sql3);

		// ������maindata
		db.execSQL(sql1);

		// ������collect
		db.execSQL(sql2);

		// ������viewpager
		db.execSQL(sql3);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
	}

}
