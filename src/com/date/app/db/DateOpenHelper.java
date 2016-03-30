package com.date.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DateOpenHelper extends SQLiteOpenHelper {

	public static final String CREATE_DATE = "create table Date ("
			+ "id integer primary key autoincrement, "
			+ "event_name text, "
			+ "year integer, "
			+ "month integer, "
			+ "day integer)";
	
	
	public DateOpenHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_DATE);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
