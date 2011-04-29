package com.example.whackamole;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
// import android.view.View.OnTouchListener;

public class GameArea extends View{
	
	public boolean showing;
	private Mole mole;
	private int scoreBoard;
	private int scoreGoal = 10;
	private Whackamole parent;
	private Paint textPaint;
	// private int color;
	private boolean playing;
	
	
	
	
	public GameArea(Context context) {
		super(context);
		mole = new Mole();
		parent = (Whackamole) context;
		textPaint = new Paint();
		textPaint.setColor(Color.BLACK);
		playing = true;
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		canvas.drawColor(Color.WHITE);
		
		if(scoreBoard < scoreGoal){
			playing = true;
			canvas.drawText(Integer.toString(scoreBoard) + " of " + Integer.toString(scoreGoal), 100, 380, textPaint);
				if(!showing){
				canvas.drawCircle(mole.getPosX(), mole.getPosY(), mole.getSize(), mole.getPaint());
		
				} 
		}else{
			
			canvas.drawText(Integer.toString(scoreBoard) + " / " + Integer.toString(scoreGoal), 100, 380, textPaint);
			canvas.drawText("You annihilated "+ Integer.toString(scoreGoal)+ " pieces of SHIT?", 30, 100, textPaint);
			canvas.drawText("TAP teh screen to restart, fool...", 40, 280, textPaint);
			canvas.drawText("USELESS...", 100, 120, textPaint);
			playing = false;
			
		}
	}

	public void updateView() {
		// TODO Auto-generated method stub
		switchShowing();
		mole.setPosX();
		mole.setPosY();
		this.invalidate();
		
		
	}
	
	private void switchShowing(){
		//Switches the boolean
		showing = !showing;
	}
	
	

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		
		if(playing){
			
			/*
			 * (event.getX() < (mole.getPosX()+mole.getSize())) && 
				(event.getX() > (mole.getPosX()- mole.getSize()) )
				&& event.getY() < (mole.getPosY()+mole.getSize())
				&& event.getY() > (mole.getPosY()-mole.getSize())
			 */
			
			float dx = mole.getPosX() - event.getX();
			float dy = mole.getPosY() - event.getY();
			
		if( Math.sqrt( dx*dx + dy*dy) < mole.getSize() ){
			
			scoreBoard += 1;
			parent.clickOnMole();
			
			
			
		}else{
			scoreBoard -= 1;
			parent.clickOutsideMole();
		}
	
		}else if(!playing){
			
			setScoreBoardZero();
			parent.waittimeReset();
			playing = true;
			
		}
		
		return super.onTouchEvent(event);
	}

	public void setScoreBoardZero() {
		// TODO Auto-generated method stub
		scoreBoard = 0;
	}

	public int getScoreBoard() {
		// TODO Auto-generated method stub
		return scoreBoard;
	}
	
}
