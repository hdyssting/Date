package com.date.app.model;

import java.util.ArrayList;
import java.util.List;

import com.date.app.db.DateOpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DateDB {

	public static final String DB_NAME = "date";
	
	public static final int VERSION = 1;
	
	private static DateDB dateDB;
	
	private SQLiteDatabase db;
	
	private DateDB(Context context) {
		DateOpenHelper dbHelper = new DateOpenHelper(context, DB_NAME, null, VERSION);
		db = dbHelper.getWritableDatabase();
		Log.d("MainActivity", "succeess con");
	}
	
	public synchronized static DateDB getInstance(Context context) {
		if (dateDB == null) {
			dateDB = new DateDB(context);
			Log.d("MainActivity", "succeess db");
		}
		return dateDB;
	}
	
	public void saveDate(RecordDate recordDate) {
		if (recordDate != null) {
			ContentValues values = new ContentValues();
			values.put("event_name", recordDate.getEventName());
			values.put("year", recordDate.getYear());
			values.put("month", recordDate.getMonth());
			values.put("day", recordDate.getDay());
			db.insert("Date", null, values);
		}
	}
	
	public List<RecordDate> loadDate() {
		List<RecordDate> list = new ArrayList<RecordDate>();
		Cursor cursor = db.query("Date", null, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				RecordDate recordDate = new RecordDate();
				recordDate.setEventName(cursor.getString(cursor.getColumnIndex("event_name")));
				recordDate.setYear(cursor.getInt(cursor.getColumnIndex("year")));
				recordDate.setMonth(cursor.getInt(cursor.getColumnIndex("month")));
				recordDate.setDay(cursor.getInt(cursor.getColumnIndex("day")));
				list.add(recordDate);
				
			} while (cursor.moveToNext());
		}
		if (cursor != null) {
			cursor.close();
		}
		return list;		
	}
	
}
