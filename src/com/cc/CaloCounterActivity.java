package com.cc;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class CaloCounterActivity extends Activity {
    /** Called when the activity is first created. */
	
	MediaPlayer song;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
        setContentView(R.layout.main);
        
        song = MediaPlayer.create(CaloCounterActivity.this, R.raw.bomb);
        song.start();
        
        Thread timer = new Thread() {
        	public void run() {
        		try{
        			sleep(2000);
        			
        		}catch (InterruptedException e){
					e.printStackTrace();
				}finally {
					Intent i = new Intent("com.cc.MENU");
					startActivity(i);
				}
        	}
        };
        timer.start();
    }
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		song.release();
		finish();
	}
    
}