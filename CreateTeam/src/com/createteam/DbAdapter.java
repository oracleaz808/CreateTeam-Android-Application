package com.createteam;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DbAdapter
{
    private static String DbAdapterTag = "DbAdapter";

	public static final String DB_NAME = "createteamdb.db";
	public static final int DB_VERSION = 1;
	
	Context context;
	
	public DbAdapter(Context context){
		this.context = context;
		Log.d(DbAdapterTag, DbAdapterTag + " - varibles declared.");
	}
	
	public class DBHelper extends SQLiteOpenHelper
	{
		private static final String DBHelper_TAG = "DBHelper";

		public DBHelper(){
			super(context, DB_NAME, null, DB_VERSION);
		}

		public void onCreate(SQLiteDatabase db)
		{
		}

		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
		}		
	}
}
