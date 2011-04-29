package com.example.whackamole;

import android.graphics.Color;
import android.graphics.Paint;

public class Mole {

	int posX;
	int posY;
	boolean isShowing;
	int timer;
	private Paint paint;
	private int size = 26;
	
	public Mole() {
		
		
		// TODO Auto-generated constructor stub
		//this.setText("");
	
		
		paint = new Paint();		
		paint.setColor(Color.BLUE);
		
		
		
	}
	
	public Paint getPaint(){		
		return paint;
		}
	
	public int getPosX(){		
		return posX;
	}
	
	public int getPosY(){		
		return posY;		
	}
	
	public void setPosX(){		
		posX = size + (int) (Math.random()*(240 - size*2));
	}
	public void setPosY(){		
		posY = size + (int) (Math.random()*(320 - size*2));
		
	}

	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	

}
