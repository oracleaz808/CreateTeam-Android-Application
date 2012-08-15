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
	
	public static final String tblTeams = "tblTeams";

	public static final String Team_ID = "_id";
	public static final String Team_TeamName = "team_name";

	public static final String TBLTEAMS_TABLE_CREATE = "create table " + tblTeams + " (" +
	Team_ID + " integer primary key autoincrement, " +
	Team_TeamName + " text not null);";
	
	Context context;
	DbHelper dbHelper;
	SQLiteDatabase db;
	
	public DbAdapter(Context context){
		this.context = context;
		dbHelper = new DbHelper();
		Log.d(DbAdapterTag, DbAdapterTag + " - varibles declared and constructor called.");
	}
	
	public void createTeam (String TeamName) {
		try{
			db = dbHelper.getWritableDatabase();

			ContentValues cvTeamName = new ContentValues();
			cvTeamName.put(Team_TeamName, TeamName);

			db.insert(tblTeams, null, cvTeamName);
			db.close();

			Log.d(DbAdapterTag, "Tryed to create a team in the database.");
		} catch (Exception e) {
			Log.e(DbAdapterTag, "Error creating the team into the database.", e);
		} finally {
			Log.d(DbAdapterTag, "Successfully created " + TeamName + " in the table");
		}
	}
	
	public class DbHelper extends SQLiteOpenHelper
	{
		private static final String DbHelperTag = "DbHelper";

		public DbHelper(){
			super(context, DB_NAME, null, DB_VERSION);
			Log.d(DbHelperTag, DbHelperTag + " - constructor called.");
		}

		public void onCreate(SQLiteDatabase db)
		{
			try {
				db.execSQL(TBLTEAMS_TABLE_CREATE);
			} catch (SQLException e) {
				Log.e(DbHelperTag, DbHelperTag + " has an Error! Error: " + e, e);

				e.printStackTrace();
			} finally {
				Log.d(DbHelperTag, DbHelperTag + " onCreate sql: " + TBLTEAMS_TABLE_CREATE);
				Log.d(DbHelperTag, DbHelperTag + " created the database and tables.");
			}
			Log.d(DbHelperTag, DbHelperTag + " - database created.");
		}

		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
		{
			try {
				db.execSQL("drop table if exists " + tblTeams);

				this.onCreate(db);
				Log.d(DbHelperTag, DbHelperTag + " attempted to drop table " + tblTeams);
			} catch (SQLException e) {
				Log.e(DbHelperTag, DbHelperTag + " Error! Error: " + e, e);

				e.printStackTrace();
			} finally {
				Log.d(DbHelperTag, DbHelperTag + " database was dropped" + tblTeams);
			}
			Log.d(DbHelperTag, DbHelperTag + " - database upgraded.");
		}		
	}
}
