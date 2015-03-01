package com.example.moneybook.db;

import android.database.Cursor;

public class DetailRepository {
	
	protected static final String DATABASE_NAME = "moneybook.db";
	protected static final String DATABASE_TABLE = "Detail";

	protected static final String KEY_ROWID = "_id";
	protected static final String KEY_SORT = "sort";
	protected static final String KEY_CATEGORY = "category";
	protected static final String KEY_DATE = "date";
	protected static final String KEY_PRICE = "price";
	protected static final String KEY_REMARK = "remark";
	protected static final String KEY_NOTE = "note";
	protected static final String KEY_TIME_CREATED = "created";
	protected static final String KEY_TIME_MODIFIED = "modified";
	
	protected static String createDBSyntax(){
		String createDBSytax = 
			 "CREATE TABLE " + DATABASE_TABLE +"("
			 + KEY_ROWID + " INTEGER PRIMARY KEY, "
			 + KEY_SORT + " TEXT NOT NULL, "
			 + KEY_CATEGORY + " TEXT NOT NULL, "
			 + KEY_DATE + " INT NOT NULL, "
			 + KEY_PRICE + " INT NOT NULL, "
			 + KEY_REMARK + " TEXT NOT NULL, "
			 + KEY_NOTE + " TEXT NOT NULL, "
			 + KEY_TIME_CREATED + " TIMESTAMP, "
			 + KEY_TIME_MODIFIED + " TIMESTAMP"
			 +");";
	
		return createDBSytax;
	}
	
	public static String getAllDetailDescSyntax(){
		String getAllDetail = "SELECT * FROM "+DATABASE_TABLE
				+" ODER BY "+KEY_DATE+" DESC;";
		return getAllDetail;
	}
	
	public static String getAllDetailAscSyntax(){
		String allDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" ODER BY "+KEY_DATE+" ASC;";
		return allDetailSyntax;
	}
	
	public static String getDetailFromGivenDuration(int from, int to){
		String allDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" WHERE "+KEY_DATE + " >= " + from
				+" AND " + KEY_DATE + " < " + (to+1);
		return allDetailSyntax;
	}
	
	public static String getDailyDetailSyntax(int date){
		String dailyDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" WHERE "+KEY_DATE + " >= " + date
				+" AND " + KEY_DATE + " < " + (date+1);
		return dailyDetailSyntax;
	}
	
	public static String getWeeklyDetailSyntax(int date){
		String weeklyDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" WHERE "+KEY_DATE + " BETWEEN " + date +" AND " + (date+100);
		return weeklyDetailSyntax;
	}
	
	public static String getMonthlydetail(int date){
		String monthlyDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" WHERE "+KEY_DATE + " BETWEEN " + date +" AND " + (date+100);
		return monthlyDetailSyntax;
	}
}
