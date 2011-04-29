package com.example.whackamole;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;

// import android.widget.Button;

public class Whackamole extends Activity implements OnClickListener, Callback {
    
	private GameTimer t;
	private GameArea gameView;
	private Handler handler;

	
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        
        gameView = new GameArea(this);

        setContentView(gameView);
        
        handler = new Handler(this);
        
        t = new GameTimer(handler);
        t.start();
        gameView.setScoreBoardZero();
        
    }

	@Override
	public boolean handleMessage(Message arg0) {
		// TODO Auto-generated method stub
		gameView.updateView();
		
		return false;
	}

	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		
	}

	public void clickOnMole() {
		// TODO Auto-generated method stub
		gameView.updateView();
		t.settimeMinus();
	}

	public void clickOutsideMole() {
		// TODO Auto-generated method stub
		t.settimePlus();
		
	}

	public void waittimeReset() {
		// TODO Auto-generated method stub
		t.waittimeReset();
	}

	
}