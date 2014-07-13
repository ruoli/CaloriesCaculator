package com.cc;



import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DailyIntake extends Activity implements OnClickListener{

	EditText etEnterFood, etDayIntakePlan, etWeekNo, etWeekDay;
	Button bEnterFood, bSTB;
	TextView tvTodayTotal, tvfnEntered, tvShowContains, tvfcEntered;
	
	ArrayList<String> foodName = new ArrayList<String>();
	ArrayList<String> foodCalo = new ArrayList<String>();
	
	int totalCalo = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dailyintake);
		
		etEnterFood = (EditText)findViewById(R.id.etEnterFood);
		etDayIntakePlan = (EditText)findViewById(R.id.etDayIntakePlan);
		etWeekNo = (EditText)findViewById(R.id.etWeekNo);
		etWeekDay = (EditText)findViewById(R.id.etWeekDay);
		
		bEnterFood = (Button)findViewById(R.id.bEnterFood);
		bSTB = (Button)findViewById(R.id.bSTB);
		
		tvTodayTotal = (TextView)findViewById(R.id.tvTodayTotal);
		tvfnEntered = (TextView)findViewById(R.id.tvFNentered);
		tvShowContains = (TextView)findViewById(R.id.tvShowContains);
		tvfcEntered = (TextView)findViewById(R.id.tvFCentered);
		
		bEnterFood.setOnClickListener(this);
		bSTB.setOnClickListener(this);
	}
	
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bEnterFood:
			try{
			String s = etEnterFood.getText().toString().toUpperCase();
			HotOrNot db = new HotOrNot(this);
			db.open();
			String fn = db.getNameByFN(s);
			String fc = db.getCaloByFN(s);
			db.close();
			foodName.add(fn);  
			foodCalo.add(fc);
			
			tvfnEntered.setText(fn);
			tvShowContains.setText("CONTAINS");
			tvfcEntered.setText(fc+" CAL");	
			
			
			for(String c : foodCalo){
				int calo = Integer.parseInt(c);
				totalCalo += calo;
			}
			tvTodayTotal.setText("I have taken "+totalCalo+" calories today!");
			
			}catch(Exception e){
				errorHandle(e);
			}
			etEnterFood.setText("");
			break;
			
			
		case R.id.bSTB:
			boolean m = true;
			try{
				String weekno = etWeekNo.getText().toString();
				String weekday = etWeekDay.getText().toString().toUpperCase();
				String plan = etDayIntakePlan.getText().toString();
				String intaken = ""+totalCalo;
				HotOrNot db = new HotOrNot(DailyIntake.this);
				db.open();
				db.createRecord(weekno, weekday, plan, intaken);
				db.close();
			}catch(Exception e){
				m = false;
				errorHandle(e);
			}finally{
				if(m){
					Dialog di = new Dialog(this);
					di.setTitle("Operation Successful");
					TextView tv = new TextView(this);
					tv.setText("Data updated, Mission Completed :-)!!!");
					di.setContentView(tv);
					di.show();
				}
			}
//			etDayIntakePlan.setText("");
//			etWeekDay.setText("");
//			etWeekNo.setText("");
			break;
		}
	}
	
	public void errorHandle(Exception e){		
		String error = e.toString();
		Dialog di = new Dialog(this);
		di.setTitle("Opps, Error! :-(!!");
		TextView tv = new TextView(this);
		tv.setText(error);
		di.setContentView(tv);
		di.show();
	}
}
	
	