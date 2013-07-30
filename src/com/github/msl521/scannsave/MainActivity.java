package com.github.msl521.scannsave;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	public final static String EXTRA_MESSAGE = "com.github.msl521.scannsave.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void scanBarcode(View view) {
		PackageManager pm = getPackageManager();
		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		List<ResolveInfo> infos = pm.queryIntentActivities(intent, 0);
		if (infos.size() > 0) {
			intent.setPackage("com.google.zxing.client.android");
			// intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
			startActivityForResult(intent, 0);
			
		} else {
			Toast.makeText(this, "No barcode scanner available.", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				// String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				Intent intentResult = new Intent(this,
						AnnotateScanActivity.class);
				intentResult.putExtra(EXTRA_MESSAGE, contents);
				startActivity(intentResult);
			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
			}
		}
	}

}
