package com.example.task_2sdcardsqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQliteHelper extends SQLiteOpenHelper {
	Context context;
	
	
	public MySQliteHelper(Context context) {
		super(context, "person.db", null, 1);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "create table student (" +
				"_id integer primary key autoincrement," +
				"name text," +
				"age integer)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		

	}

}
