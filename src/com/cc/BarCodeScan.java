package com.cc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class BarCodeScan extends Activity implements OnClickListener {
	
	Button barScan;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.barcodescan);
		barScan = (Button)findViewById(R.id.bBarScan);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bBarScan:
			Intent i = new Intent("com.google.zxing.client.android.SCAN");
			i.putExtra("SCAN_MODE", "QR_CODE_MODE");
			startActivityForResult(i, 0);
			System.out.println("sucessful");
			break;
		}
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent intent){
		if(requestCode == 0){
			if(resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				// handle successful scan, pass to result to tesco search
				Intent newIntent = new Intent(this, TescoSearch.class);
		    	newIntent.putExtra("barScan", contents + format);
		    	startActivity(newIntent);
			}else if(resultCode == RESULT_CANCELED){
				// handel cancel
				//System.out.println("failed");
			}
		}
	}


}
