package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class OperateDataBase {
	private static DataBaseHelper mOpenHelper;
	private static OperateDataBase mOperateDataBase;

	private OperateDataBase(Context mContext) {
		mOpenHelper = new DataBaseHelper(mContext);
	}

	public static synchronized OperateDataBase getInstance(Context mContext) {
		if (mOperateDataBase == null) {
			mOperateDataBase = new OperateDataBase(mContext);
		}
		return mOperateDataBase;
	}

	public Cursor query(String table, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		Cursor cursor = db.query(table, projection, selection, selectionArgs,
				null, null, sortOrder);
		return cursor;
	}

	public long insert(String table, ContentValues values) {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
		return db.insert(table, null, values);
	}

}
