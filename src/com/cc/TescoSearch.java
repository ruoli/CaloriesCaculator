package com.cc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TescoSearch extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tescosearch);
        final Bundle getBarCode = this.getIntent().getExtras();
        
        final EditText txtSearch = (EditText)findViewById(R.id.etLIsearch);
        txtSearch.setOnClickListener(new EditText.OnClickListener() {
        	public void onClick(View v){txtSearch.setText("");}
        });
        	final Button btnSearch = (Button)findViewById(R.id.bLIbutton);
        	btnSearch.setOnClickListener(new Button.OnClickListener() {
        		public void onClick(View v) {
        			//get information from bar scanner
        			String scanResult = "";
        			if (getBarCode!=null){
        			scanResult = getBarCode.getString("barScan");
        			}
        			txtSearch.setText(scanResult);
        			callWebService(scanResult);
        		}
        	});
    }
    private void callWebService(String q) {
    	Intent newIntent = new Intent(this, ListItems.class);
    	newIntent.putExtra("food", q);
    	startActivity(newIntent);
    	
    	
    	
    }
}
