package com.example.moneybook.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDataBaseHelper extends SQLiteOpenHelper {
	
	private static SQLiteDataBaseHelper instance;
	private static SQLiteDatabase sqlDataBase;
	private static final String DATABASE_NAME = "detail.db";
	private static final int DATABASE_VERSION = 2;

	public SQLiteDataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	public SQLiteDataBaseHelper getInstance(Context context){
		if(instance == null){
			instance = new SQLiteDataBaseHelper(context);
		}
		return instance;
	}

	@Override
	public void onCreate(SQLiteDatabase dataBase) {
		sqlDataBase = dataBase;
		dataBase.execSQL(DetailRepository.createDBSyntax());
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + DetailRepository.DATABASE_TABLE);
		onCreate(db);
	}
	
	public SQLiteDatabase getWritebleDataBase(){
		sqlDataBase = getWritableDatabase();
		return sqlDataBase;
	}
	
	public void closeDataBase(){
		this.close();
	}
	
}
