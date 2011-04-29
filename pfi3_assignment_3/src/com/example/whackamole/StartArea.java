package com.example.whackamole;

// import com.example.Whackamole;
// import com.example.R;
// import com.example.StartArea;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
// import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
// import android.widget.EditText;

public class StartArea extends Activity {
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, 
                                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        
        
        // startArea = new StartArea(this);

        setContentView(R.layout.main);
        
        

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
            	
            	Intent bytSkarm = new Intent(StartArea.this,Whackamole.class);
   	    	 	startActivity(bytSkarm);
				
			}
            
        }
        
        ); // end of launch.setOnclickListener
        }
	
	
    }
