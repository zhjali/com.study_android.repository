package com.example.task_sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLliteHelp	extends SQLiteOpenHelper {

	public MySQLliteHelp(Context context){
		super(context, "myDataBase.db", null, 1);
}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String  sql = "create table students (id integer primary key autoincrement," +
				"name varchar(20)," +
				"age integer," +
				"score integer)";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
}


