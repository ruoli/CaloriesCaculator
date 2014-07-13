package com.cc;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Statistic extends Activity implements OnClickListener{

	
	Button bCaculate, bOV; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.statistic);
		

		bCaculate = (Button)findViewById(R.id.bCaculate);
		bOV = (Button)findViewById(R.id.bOV);
		
		
		bCaculate.setOnClickListener(this);
		bOV.setOnClickListener(this);
	}
	
	
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bCaculate:
			Intent d;
			d = new Intent(this, DailyIntake.class);
			startActivity(d);
			break;
		case R.id.bOV:
			Intent ov;
			ov = new Intent(this, OverView.class);
			startActivity(ov);
			break;
		}
	}

}
