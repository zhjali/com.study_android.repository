package com.example.task_sql;

import android.R.id;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.Contacts.Intents.Insert;

public class DataHelper {
	private Context context;
	private MySQLliteHelp help;
	public DataHelper(Context context) {
		this.context = context;
		this.help = new MySQLliteHelp(context);
	}
	
	public void insert(String name,int age,int score){
		String sql = "insert into students (name,age,score) values (?,?,?)";
		System.out.println(sql);
		
		SQLiteDatabase database = help.getWritableDatabase();
		database.execSQL(sql, new Object[] {name,age,score});
		
		database.close();
	}
	
	public void insert2(String name,int age,int score){
		ContentValues values = new ContentValues();
//		values.put("name", name);
		values.put("score", score);
		
		SQLiteDatabase database = help.getWritableDatabase();
		long result = database.insert("students", null, values);
		System.out.println("result :"+ result);
		database.close();
	}
	
	public void query(){
		SQLiteDatabase database = help.getWritableDatabase();
//		Cursor cursor = database.query("students", new String[]{"name","age"}, "id < ?", null, "5", null, null, "desc");
		Cursor cursor = database.query("students", new String[]{"id","name","age"}, "id < ?", new String[]{"100"}, null, null, "id");
		
		while (cursor.moveToNext()) {
			int id = cursor.getInt(cursor.getColumnIndex("id"));
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int age = cursor.getInt(cursor.getColumnIndex("age"));
//			int score = cursor.getInt(cursor.getColumnIndex("score"));
			
			System.out.println("_id: "+id+" Name: "+name+" age: "+age);
//			System.out.println("Name: "+name+" age: "+age);
		}
		
		cursor.close();
		database.close();
	}
	
	
	
	public void delet(String where,String[] params){
		SQLiteDatabase database = help.getWritableDatabase();
		database.delete("students", where, params);
		database.close();
	}
	
	public void update(ContentValues values,String where,String[] params){
		SQLiteDatabase database = help.getWritableDatabase();
		database.update("students", values, where, params);
	}
	
	public Cursor getCursor(){
		SQLiteDatabase database = help.getWritableDatabase();
		Cursor cursor = database.query("students",null, null,null, null, null, null);
		return cursor;
	}
	
	public void aletID(){
		SQLiteDatabase database = help.getWritableDatabase();
		database.execSQL("alter table students rename to tmp_students");
		database.execSQL("create table students(_id Integer primary key autoincrement,name varchar(20),age integer,score integer)");
		database.execSQL("insert into students (_id,name,age,score) select id,name,age,score from tmp_students");
		database.execSQL("drop table tmp_students");
	}
}
