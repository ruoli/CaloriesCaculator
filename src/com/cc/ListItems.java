package com.cc;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ListItems extends Activity{

	String loginURL = "https://secure.techfortesco.com/groceryapi/RESTService.aspx?COMMAND=LOGIN&EMAIL=&PASSWORD=&DEVELOPERKEY=<TKXnUqAKd7gPHgEa9uo8>&APPLICATIONKEY=<C6C40066C1CBB83ACDDB>";
	String startURL = "http://www.techfortesco.com/groceryapi/RESTService.aspx?COMMAND=PRODUCTSEARCH&SESSIONKEY=";
		
	
	String result = "";
	String deviceId = "";
	final String tag = "logcat tag: ";
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.listitems);
		
		String key="";
		try {
			key = login();
		} catch (JSONException e1) {
			
			e1.printStackTrace();
		}
		Bundle barScanResult = this.getIntent().getExtras();
		String queryData = "";
		if (barScanResult!=null){
			queryData = barScanResult.getString("food");
		}
		 EditText foundThis = (EditText) findViewById(R.id.etListItem);
		 Button backButton = (Button) findViewById(R.id.bListItem);
		 HttpClient httpclient = new DefaultHttpClient();
		 
		 String URL = startURL+key+ "&SEARCHTEXT=" +queryData +"&EXTENDEDINFO=N&QUICKSEARCH=Y";
	    	HttpGet request = new HttpGet(URL);
	    
	    	request.addHeader("deviceId", deviceId);
	    	ResponseHandler<String> handler = new BasicResponseHandler();
	    	try {
	    		result = httpclient.execute(request, handler);
	    		foundThis.setText(result);
	    		
	    	}catch (ClientProtocolException e) {
	    		e.printStackTrace();
	    	}catch(IOException e) {
	    		e.printStackTrace();
	    	}
	    	httpclient.getConnectionManager().shutdown();
	    	Log.i(tag, result);
	    	
		 backButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				handleBackButton();
			}
		});
		
	}

	private void handleBackButton(){
		finish();
	}
	
	private String login() throws JSONException{
		 HttpClient httpclient = new DefaultHttpClient();
		   // 	HttpGet request = new HttpGet(URL+q);
		    	HttpGet request = new HttpGet(loginURL);
		    	request.addHeader("CaloCounter", deviceId);
		    	ResponseHandler<String> handler = new BasicResponseHandler();
		    	try {
		    		result = httpclient.execute(request, handler);
		    		JSONObject object = (JSONObject) new JSONTokener(result).nextValue();
			    	result = object.getString("SessionKey");
		    		
		    	}catch (ClientProtocolException e) {
		    		e.printStackTrace();
		    	}catch(IOException e) {
		    		e.printStackTrace();
		    	}
		    	httpclient.getConnectionManager().shutdown();
		    	Log.i(tag, result);
		    	
		    	return result;
	}
}

