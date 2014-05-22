package com.example.task_2sdcardsqlite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		InputStream in = null;
//		try {
//			in = getAssets().open("lizhi.db");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		in = getResources().openRawResource(R.raw.lizhi);
		File rootFile = Environment.getExternalStorageDirectory();
		File dataBase = new File(rootFile, "lizhi2.db");
		System.out.println("Root file path: "+rootFile.getAbsolutePath());
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(dataBase);
			byte[] b = new byte[1024];
			int length = 0;
			while((length = in.read(b)) != -1){
				out.write(b, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dataBase, null);
		
		ContentValues values = new ContentValues();
		values.put("subject", "someSubject");
		values.put("summary", "someSummary");
		values.put("cover", "someCover");
		db.insert("news", null, values);
		
		Cursor cursor = db.query("news", null, null, null, null, null, null);
		while (cursor.moveToNext()) {
			String subject = cursor.getString(cursor.getColumnIndex("subject"));
			String summary = cursor.getString(cursor.getColumnIndex("summary"));
			String cover = cursor.getString(cursor.getColumnIndex("cover"));
			System.out.println("subject: "+subject+" summar: "+summary+" cover: "+cover);
		}
		
		cursor.close();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
