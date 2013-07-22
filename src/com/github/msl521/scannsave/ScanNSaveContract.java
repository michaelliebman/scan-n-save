package com.github.msl521.scannsave;

import android.provider.BaseColumns;

public final class ScanNSaveContract {
	public static abstract class SavedScan implements BaseColumns {
		public static final String TABLE_NAME = "scans";
		public static final String COLUMN_NAME_SCAN_ID = "scanid";
		public static final String COLUMN_NAME_CONTENTS = "contents";
		public static final String COLUMN_NAME_ANNOTATION = "annotation";
		public static final String COLUMN_NAME_SAVEDATE = "savedate";
	}
}
