package com.github.msl521.scannsave;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.github.msl521.scannsave.ScanNSaveContract.SavedScan;

public class ScanNSaveDbHelper extends SQLiteOpenHelper {
	// If you change the database schema, you must increment the database
	// version.
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "ScanNSave.db";

	private static final String TEXT_TYPE = " TEXT";
	private static final String DATE_TYPE = " DATETIME";
	private static final String COMMA_SEP = ",";
	private static final String SQL_CREATE_SCANS = "CREATE TABLE "
			+ SavedScan.TABLE_NAME + " (" + SavedScan._ID
			+ " INTEGER PRIMARY KEY," + SavedScan.COLUMN_NAME_SCAN_ID
			+ TEXT_TYPE + COMMA_SEP + SavedScan.COLUMN_NAME_CONTENTS
			+ TEXT_TYPE + COMMA_SEP + SavedScan.COLUMN_NAME_ANNOTATION
			+ TEXT_TYPE + COMMA_SEP + SavedScan.COLUMN_NAME_SAVEDATE
			+ DATE_TYPE + " )";

	private static final String SQL_DELETE_SCANS = "DROP TABLE IF EXISTS "
			+ SavedScan.TABLE_NAME;

	public ScanNSaveDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE_SCANS);
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// This database is only a cache for online data, so its upgrade policy
		// is
		// to simply to discard the data and start over
		db.execSQL(SQL_DELETE_SCANS);
		onCreate(db);
	}

	public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		onUpgrade(db, oldVersion, newVersion);
	}

}
