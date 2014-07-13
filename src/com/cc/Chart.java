package com.cc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.androidplot.series.XYSeries;
import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;

public class Chart extends Activity{

	ArrayList<Integer> myPlan = new ArrayList<Integer>();
	ArrayList<Integer> myTake = new ArrayList<Integer>();
	private XYPlot myChart;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.chart);
		
		myChart = (XYPlot)findViewById(R.id.myChart);
		
		getMyPlan();
		Integer[] plan= myPlan.toArray(new Integer[myPlan.size()]);
		
		getMyIntake();
		Integer[] actual= myTake.toArray(new Integer[myTake.size()]);
		
		
		XYSeries series1 = new SimpleXYSeries(
				Arrays.asList(actual),
				SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
				"ActualTaken");
		
		XYSeries series2 = new SimpleXYSeries(
				Arrays.asList(plan),
				SimpleXYSeries.ArrayFormat.Y_VALS_ONLY,
				"IntakePlan");
		
		LineAndPointFormatter sf1 = new LineAndPointFormatter(
				Color.RED,
				Color.GREEN,
				Color.TRANSPARENT);
		
		myChart.addSeries(series1, sf1);
		
		LineAndPointFormatter sf2 = new LineAndPointFormatter(
				Color.CYAN,
				Color.BLUE,
				Color.TRANSPARENT);
		
		myChart.addSeries(series2, sf2);
		
		myChart.setTicksPerRangeLabel(3);
		
		myChart.disableAllMarkup();
		
	}

	public void getMyPlan(){
		HotOrNot db = new HotOrNot(this);
		ArrayList<String> list = new ArrayList<String>();
		try{
		db.open();
		list = db.getMyPlanIntake();
		db.close();
		for(int i=0; i<=list.size(); i++){
			Integer p = Integer.parseInt(list.get(i));
			myPlan.add(p);
			}
		}catch(Exception e){
			
		}
	}
	
	public void getMyIntake(){
		HotOrNot db = new HotOrNot(this);
		ArrayList<String> list = new ArrayList<String>();
		try{
		db.open();
		list = db.getMyActualIntake();
		db.close();
		for(int i=0; i<=list.size(); i++){
			Integer t = Integer.parseInt(list.get(i));
			myTake.add(t);
			}
		}catch(Exception e){
			
		}
	}
}
	

