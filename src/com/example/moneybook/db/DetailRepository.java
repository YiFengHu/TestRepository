package com.example.moneybook.db;

public class DetailRepository {
	
	protected static final String DATABASE_NAME = "moneybook.db";
	protected static final String DATABASE_TABLE = "Detail";

	protected static final String ID = "ID";
	protected static final String IO = "io";
	protected static final String CATEGORY = "category";
	protected static final String DATE = "date";
	protected static final String PRICE = "price";
	protected static final String REMARK = "remark";
	protected static final String TIME = "time";
	
	protected static String createDBSyntax(){
		String createDBSytax = 
			 "CREATE TABLE " + DATABASE_TABLE +"("
			 + ID + " INTEGER PRIMARY KEY, "
			 + IO + " TEXT NOT NULL, "
			 + CATEGORY + " TEXT NOT NULL, "
			 + DATE + " INT NOT NULL, "
			 + PRICE + " INT NOT NULL, "
			 + REMARK + " TEXT NOT NULL, "
			 + TIME + " TIMESTAMP, "
			 +");";
	
		return createDBSytax;
	}
	
	public static String getAllDetailDescSyntax(){
		String getAllDetail = "SELECT * FROM "+DATABASE_TABLE
				+" ODER BY "+DATE+" DESC;";
		return getAllDetail;
	}
	
	public static String getAllDetailAscSyntax(){
		String allDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" ODER BY "+DATE+" ASC;";
		return allDetailSyntax;
	}
	
	public static String getDetailFromGivenDuration(int from, int to){
		String allDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" WHERE "+DATE + " >= " + from
				+" AND " + DATE + " < " + (to+1);
		return allDetailSyntax;
	}
	
	public static String getDailyDetailSyntax(int date){
		String dailyDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" WHERE "+DATE + " >= " + date
				+" AND " + DATE + " < " + (date+1);
		return dailyDetailSyntax;
	}
	
	public static String getWeeklyDetailSyntax(int date){
		String weeklyDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" WHERE "+DATE + " BETWEEN " + date +" AND " + (date+100);
		return weeklyDetailSyntax;
	}
	
	public static String getMonthlydetail(int date){
		String monthlyDetailSyntax = "SELECT * FROM "+DATABASE_TABLE
				+" WHERE "+DATE + " BETWEEN " + date +" AND " + (date+100);
		return monthlyDetailSyntax;
	}
}
