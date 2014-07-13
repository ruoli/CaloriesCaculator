package com.cc;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class OverView extends Activity implements OnClickListener{

	TextView week, day, plan, take;
	Button reset, viewGraph;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.overview);
		
		week = (TextView)findViewById(R.id.tvOvWeek);
		day = (TextView)findViewById(R.id.tvOvDay);
		plan = (TextView)findViewById(R.id.tvOvPlan);
		take = (TextView)findViewById(R.id.tvOvTake);
		
		reset = (Button)findViewById(R.id.bReset);
		viewGraph = (Button)findViewById(R.id.bVG);
		
		reset.setOnClickListener(this);
		viewGraph.setOnClickListener(this);
		
		try{
		HotOrNot info = new HotOrNot(this);
		info.open();
		String w = info.getWeekInfo();
		String d = info.getDayInfo();
		String p = info.getMyPlanInfo();
		String t = info.getActualyIntakeInfo();
		info.close();
		week.setText(w);
		day.setText(d);
		plan.setText(p);
		take.setText(t);
		}catch(Exception e){
			String error = e.toString();
			Dialog di = new Dialog(this);
			di.setTitle("Opps, Error! :-(!!");
			TextView tv = new TextView(this);
			tv.setText(error);
			di.setContentView(tv);
			di.show();
		}
	}
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.bReset:
			HotOrNot db = new HotOrNot(this);
			db.open();
			db.cleanTable();
			db.close();
			Intent i = new Intent(this, Statistic.class);
			startActivity(i);
			break;
		
		case R.id.bVG:
			Intent c = new Intent(this, Chart.class);
			startActivity(c);
			break;
		}
	}

}
