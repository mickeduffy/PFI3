package com.example.whackamole;

import android.os.Handler;

public class GameTimer extends Thread {

	private Handler _mainHandler;
	private boolean _running = true;
	private int WaitTime = 1000;
	
	public void stopCount(){		
		_running = false;		
	}
	
	public GameTimer(Handler mainHandler){
		_mainHandler = mainHandler;
	}
	
	@Override
	public void run(){
		super.run();
		while(_running){
			try{
				_mainHandler.sendEmptyMessage(NORM_PRIORITY);
				Thread.sleep(WaitTime);
			}	catch (InterruptedException e) {

			}	
		}
		
	}
	
	public void settimeMinus(){
		
		WaitTime = WaitTime - 10;
		
	}

	public void settimePlus() {
		// TODO Auto-generated method stub
		WaitTime = WaitTime + 10;
	}

	public void waittimeReset() {
		// TODO Auto-generated method stub
		WaitTime = 1000;
	}
}
