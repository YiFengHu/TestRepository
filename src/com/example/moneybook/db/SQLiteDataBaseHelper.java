package com.example.moneybook.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper {
	
	private  String TAG = SQLiteDataBaseHelper.class.getSimpleName();
	private  SQLiteDatabase sqlDataBase;
	private static final String DATABASE_NAME = "detail.db";
	private static final int DATABASE_VERSION = 2;

	public SQLiteDataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase dataBase) {
		sqlDataBase = dataBase;
		createDetailTable();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + DetailRepository.DATABASE_TABLE);
		onCreate(db);
	}
	
	private void createDetailTable(){
		Log.d(TAG, "Create Table: "+DATABASE_NAME);
		sqlDataBase.execSQL(DetailRepository.createDBSyntax());
	}
	
	public SQLiteDatabase getWritebleDataBase(){
		sqlDataBase = getWritableDatabase();
		return sqlDataBase;
	}
	
	public void closeDataBase(){
		this.close();
	}
	
}
