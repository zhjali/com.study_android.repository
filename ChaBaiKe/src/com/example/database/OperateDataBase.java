package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class OperateDataBase {
	private static final String TAG = "OperateDataBase";

	private static DataBaseHelper mOpenHelper;
	private static OperateDataBase mOperateDataBase;

	private OperateDataBase(Context mContext) {
		// Log.d(TAG, "Éú³É DataBaseHelper object");

		mOpenHelper = new DataBaseHelper(mContext);
	}

	public static synchronized OperateDataBase getInstance(Context mContext) {
		// Log.d(TAG, "getInstance");

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
		long id = db.insert(table, null, values);
		Log.d(TAG, "the insert count: " + id);

		return id;
	}

}
