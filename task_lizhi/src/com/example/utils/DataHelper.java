package com.example.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataHelper {
	private Context context;
	private SQLiteDatabase db;
	private static DataHelper helper;
	private static Object classLock = DataHelper.class;
	
	private DataHelper(Context context) {
		super();
		this.context = context;
		db = new MySQliteHelper(this.context).getWritableDatabase();
	}
	
	public static DataHelper getInstance(Context context){
		
		synchronized (classLock){
			if (helper == null) {
				helper = new DataHelper(context);
			}
			return helper;
		}
	}
	
	public void insert(int id ,String subject,String summary,String cover) {
		String sql = "insert into news (id,subject,summary,cover) values (?,?,?,?)";
		if(checke(id) == false)
			return;
		db.execSQL(sql, new Object[]{id,subject,summary,cover});
	}
	
	private boolean checke(int id) {
		Cursor cursor = db.query("news", null, null, null, null, null, null);
		if (cursor.getCount() == 0) {
			return true;
		}
		return false;
	}
	
	public Cursor query(String limit){
		return db.query("news", null, null, null, null, null, "_id desc", limit);
	}

	public void close(){
		helper = null;
		db.close();
	}
}
