package com.cc;



import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class FoodDataBase extends Activity implements OnClickListener{

	TabHost th;
	EditText etSearch;
	Button bSearch;
	TextView tvFdN, tvCalo;
	
	EditText etAF, etAC;
	Button bAdd;
	
	EditText etFD;
	Button bDele;
	
	EditText etFNU, etFCU, etFID;
	Button bUpdate;
	
	TextView SQLfn, SQLfid, SQLcalo; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fooddatabase);
		
		
		th = (TabHost)findViewById(R.id.tabhost);
		
		//search tab components
		etSearch = (EditText)findViewById(R.id.etSearch);
		bSearch = (Button)findViewById(R.id.bSearch);
		tvFdN = (TextView)findViewById(R.id.tvFdN);
		tvCalo = (TextView)findViewById(R.id.tvCalo);
		
		//add tab components
		etAF = (EditText)findViewById(R.id.etAddFood);
		etAC = (EditText)findViewById(R.id.etAddCalo);
		bAdd = (Button)findViewById(R.id.bAdd);
		
		//dele tab components
		etFD = (EditText)findViewById(R.id.etFoodDele);
		bDele = (Button)findViewById(R.id.bDele);
		
		//update tab components
		etFNU = (EditText)findViewById(R.id.etFoodNameUpdate);
		etFCU = (EditText)findViewById(R.id.etFoodCaloUpdate);
		etFID = (EditText)findViewById(R.id.etFoodIdUpdate);
		bUpdate = (Button)findViewById(R.id.bUpdate);
		
		
		
		bSearch.setOnClickListener(this);
		bAdd.setOnClickListener(this);
		bDele.setOnClickListener(this);
		bUpdate.setOnClickListener(this);
		
		th.setup();
		
		TabSpec specs = th.newTabSpec("tab1");
		specs.setContent(R.id.tabSearch);
		specs.setIndicator("SearchFood");
		th.addTab(specs);
		
		specs = th.newTabSpec("tab2");
		specs.setContent(R.id.tabAdd);
		specs.setIndicator("AddFood");
		th.addTab(specs);
		
		specs = th.newTabSpec("tab3");
		specs.setContent(R.id.tabDele);
		specs.setIndicator("DeleteFood");
		th.addTab(specs);
		
		specs = th.newTabSpec("tab4");
		specs.setContent(R.id.tabUpdate);
		specs.setIndicator("UpdateFood");
		th.addTab(specs);
		
		specs = th.newTabSpec("tab5");
		specs.setContent(R.id.tabList);
		specs.setIndicator("FoodList");
		th.addTab(specs);
		
		refreshFoodList();
	}
	
	public void refreshFoodList() {
		try{
		SQLfn = (TextView)findViewById(R.id.SQLfn);
		SQLcalo = (TextView)findViewById(R.id.SQLcalo);
		SQLfid = (TextView)findViewById(R.id.SQLfid);
		HotOrNot info = new HotOrNot (this);
		info.open();
		String dataId = info.getDataID();
		String dataFn = info.getDataName();
		String dataCalo = info.getDataCalo();
		info.close();
		SQLfid.setText(dataId);
		SQLfn.setText(dataFn);
		SQLcalo.setText(dataCalo);
		}catch(Exception e){
			Dialog di = new Dialog(this);
			di.setTitle("You do not have any data yet!");
		}
	}
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSearch:
			try{
				String t = etSearch.getText().toString().toUpperCase();
				HotOrNot entrys = new HotOrNot(this);
				entrys.open();
				String fn = entrys.getNameByFoodname(t);
				String ca = entrys.getCaloByFoodname(t);
				entrys.close();
				tvFdN.setText(fn);
				tvCalo.setText(ca);
			}catch(Exception e){
				errorHandle(e);
			}
			etSearch.setText("");
			break;
			
			
		case R.id.bAdd:
			boolean addmsg =true;
			try{
				String fn = etAF.getText().toString().toUpperCase();
				String calo = etAC.getText().toString();
				HotOrNot entrya = new HotOrNot(FoodDataBase.this);
				entrya.open();
				entrya.createEntry(fn, calo);
				entrya.close();
				refreshFoodList();
			}catch(Exception e){
				addmsg = false;
				errorHandle(e);
			}finally{
				if(addmsg){
					Dialog di = new Dialog(this);
					di.setTitle("Operation Successful");
					TextView tv = new TextView(this);
					tv.setText("Data added, Mission Completed :-)!!!");
					di.setContentView(tv);
					di.show();
				}
			}
			etAF.setText("");
			etAC.setText("");
			break;
			
			
		case R.id.bDele:
			
			boolean delemsg = true;
			try{
				String dele = etFD.getText().toString().toUpperCase();				
				HotOrNot entryd = new HotOrNot(this);
				entryd.open();
				entryd.deleteEntry(dele);
				entryd.close();
				refreshFoodList();
			}catch(Exception e){
				delemsg = false;
				errorHandle(e);
			}finally{
				if(delemsg){
					Dialog di = new Dialog(this);
					di.setTitle("Operation Successful");
					TextView tv = new TextView(this);
					tv.setText("Data deleted, Mission Completed :-)!!!");
					di.setContentView(tv);
					di.show();
				}
			}
			etFD.setText("");
			break;
			
			
		case R.id.bUpdate:
			boolean UDmsg = true;
			try{
				String updatefood = etFNU.getText().toString().toUpperCase();
				String updatecalo = etFCU.getText().toString();
				long c = Long.parseLong(updatecalo);
				String updateid = etFID.getText().toString();
				long l = Long.parseLong(updateid);
				HotOrNot entryu = new HotOrNot(this);
				entryu.open();
				entryu.updateEntry(l, updatefood, c);
				entryu.close();
				refreshFoodList();
			}catch(Exception e){
				UDmsg = false;
				errorHandle(e);
			}finally{
				if(UDmsg){
					Dialog di = new Dialog(this);
					di.setTitle("Operation Successful");
					TextView tv = new TextView(this);
					tv.setText("Data updated, Mission Completed :-)!!!");
					di.setContentView(tv);
					di.show();
				}
			}
			etFNU.setText("");
			etFCU.setText("");
			etFID.setText("");
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
