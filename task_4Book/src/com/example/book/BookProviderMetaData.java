package com.example.book;

import android.net.Uri;
import android.provider.BaseColumns;
import android.widget.CursorAdapter;

public class BookProviderMetaData {
	public static final String AUTHORITY = "com.androidbook.provider.BookProvider";
	
	public static final String DATABASE_NAME = "book.db";
	public static final int DATABASE_VERSION = 1;
	public static final String BOOKS_TABLE_NAME = "books";
	
	private BookProviderMetaData(){};
	
	public static final class BookTableMetaData implements BaseColumns{
		public static final String TABLE_NAME = "books";
		public static final Uri CONTENT_URI = 
				Uri.parse("content://" + AUTHORITY + "/books");
		public static final String CONTENT_TYPE = 
				"vnd.android.cursor.dir/vnd.androidbook.book";
		public static final String CONTENT_ITEM_TYPE = 
				"vnd.android.cursor.item/vnd.androidbook.book";
		public static final String DEFAULT_SORT_ORDER = "modified DESC";
		
		//String type
		public static final String BOOK_NAME = "name";
		//String type
		public static final String BOOK_ISBN = "isbn";
		//String type
		public static final String BOOK_AUTHOR = "author";
		
		//Integer from System.currentTimeMillis()
		public static final String CREATED_DATE = "created";
		//Integer from System.currentTimeMillis()
		public static final String MODIFIED_DATE = "modified";
		
		private BookTableMetaData(){};
		
	}
}
