package com.example.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQliteHelper extends SQLiteOpenHelper {
	
	public MySQliteHelper(Context context) {
		super(context,"lizhi.db",null,1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println("dataBase is creating");
		String sql = "create table news (" +
				"_id integer primary key autoincrement," +
				"id integer," +
				"subject text," +
				"summary text," +
				"cover text)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
