package com.example.book;

import java.util.HashMap;

import com.example.book.BookProviderMetaData.BookTableMetaData;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

public class BookProvider extends ContentProvider {
	private static final String TAG = "BookProvider";
	
	//Setup projection Map
	private static HashMap<String, String> sBooksProjectionMap;
	
	static{
		sBooksProjectionMap = new HashMap<String, String>();
		sBooksProjectionMap.put(BookTableMetaData._ID,
				BookTableMetaData._ID);
		
		sBooksProjectionMap.put(BookTableMetaData.BOOK_NAME,
				BookTableMetaData.BOOK_NAME);
		sBooksProjectionMap.put(BookTableMetaData.BOOK_ISBN,
				BookTableMetaData.BOOK_ISBN);
		sBooksProjectionMap.put(BookTableMetaData.BOOK_AUTHOR,
				BookTableMetaData.BOOK_AUTHOR);
		
		sBooksProjectionMap.put(BookTableMetaData.CREATED_DATE,
				BookTableMetaData.CREATED_DATE);
		sBooksProjectionMap.put(BookTableMetaData.MODIFIED_DATE,
				BookTableMetaData.MODIFIED_DATE);
		
	}
	
	//Setup URIs
	private static final UriMatcher sUriMatcher;
	private static final int INCOMING_BOOK_COLLECTION_URI_INDICATOR = 1;
	private static final int INCOMING_SINGLE_BOOK_URI_INDICATOR = 2;
	
	static{
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(BookProviderMetaData.AUTHORITY, "books", 
							INCOMING_BOOK_COLLECTION_URI_INDICATOR);
		sUriMatcher.addURI(BookProviderMetaData.AUTHORITY, "books/#",
							INCOMING_SINGLE_BOOK_URI_INDICATOR);
	}
	
	//Set/Create Database
	private static class DatabaseHelper extends SQLiteOpenHelper{
		DatabaseHelper(Context context) {
			super(context,
					BookProviderMetaData.DATABASE_NAME,
					null,
					BookProviderMetaData.DATABASE_VERSION
					);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			Log.d(TAG, "inner oncreate called");
			db.execSQL("CREATE TABLE" + BookTableMetaData.TABLE_NAME +
					"("+BookTableMetaData._ID + "INTEGER PRIMARY KEY,"+
					BookTableMetaData.BOOK_NAME + "TEXT," +
					BookTableMetaData.BOOK_ISBN + "TEXT,"+
					BookTableMetaData.BOOK_AUTHOR +"TEXT"+
					BookTableMetaData.CREATED_DATE + "INTEGER,"+
					BookTableMetaData.MODIFIED_DATE +"INTEGER"+
					");"
					);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.d(TAG, "inner onupgrade called");
			db.execSQL("DROP TABLE IF EXISTS"+
					BookTableMetaData.TABLE_NAME);
			onCreate(db);
		}
	}
	
	private DatabaseHelper mOpenHelper;
	
	@Override
	public boolean onCreate() {
		Log.d(TAG, "main onCreated called");
		mOpenHelper = new DatabaseHelper(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
		
		switch (sUriMatcher.match(uri)) {
		case INCOMING_BOOK_COLLECTION_URI_INDICATOR:
			qb.setTables(BookTableMetaData.TABLE_NAME);
			qb.setProjectionMap(sBooksProjectionMap);
			break;
		case INCOMING_SINGLE_BOOK_URI_INDICATOR:
			qb.setTables(BookTableMetaData.TABLE_NAME);
			qb.setProjectionMap(sBooksProjectionMap);
			break;
		default:
			throw new IllegalArgumentException("Unknow URI "+uri);
				}
		String orderBy;
		if(TextUtils.isEmpty(sortOrder)){
			orderBy = BookTableMetaData.DEFAULT_SORT_ORDER;
		}else {
			orderBy = sortOrder;
		}
		
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, orderBy);
		
//		int i = c.getCount();
		
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	@Override
	public String getType(Uri uri) {
		switch (sUriMatcher.match(uri)) {
		case INCOMING_BOOK_COLLECTION_URI_INDICATOR:
			return BookTableMetaData.CONTENT_TYPE;
			
		case INCOMING_SINGLE_BOOK_URI_INDICATOR:
			return BookTableMetaData.CONTENT_ITEM_TYPE;
			
		default:
			throw new IllegalArgumentException("Unknown URI "+uri);
		}
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		if (sUriMatcher.match(uri) 
				!= INCOMING_BOOK_COLLECTION_URI_INDICATOR) {
				throw new IllegalArgumentException("Unknown URI "+uri);
		}
		
		ContentValues localValues;
		if (values != null) {
			localValues = new ContentValues(values);
		}else {
			localValues= new ContentValues();
		}
		
		Long now = Long.valueOf(System.currentTimeMillis());
		
		if(localValues.containsKey(BookTableMetaData.CREATED_DATE) == false)
		{
			localValues.put(BookTableMetaData.CREATED_DATE, now);
		}
		if(localValues.containsKey(BookTableMetaData.MODIFIED_DATE) == false)
		{
			localValues.put(BookTableMetaData.MODIFIED_DATE, now);
		}
		if(localValues.containsKey(BookTableMetaData.BOOK_NAME) == false)
		{
			throw new SQLException(
					"Failed to insert row because Book Name is needed"+uri);
		}
		if(localValues.containsKey(BookTableMetaData.BOOK_ISBN) == false)
		{
			localValues.put(BookTableMetaData.BOOK_ISBN, "Unknown ISBN");
		}
		if(localValues.containsKey(BookTableMetaData.BOOK_AUTHOR) == false)
		{
			localValues.put(BookTableMetaData.BOOK_AUTHOR, "Unkonwn Author");
		}
		
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
		long rowId = db.insert(BookTableMetaData.TABLE_NAME, BookTableMetaData.BOOK_NAME, localValues);
		
		if (rowId > 0) {
			Uri insertedBookUri = 
					ContentUris.withAppendedId(BookTableMetaData.CONTENT_URI, rowId);
			getContext()
				.getContentResolver()
					.notifyChange(insertedBookUri, null);
			return insertedBookUri;
		}
		throw new SQLException("Failed to insert row into "+ uri);
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
