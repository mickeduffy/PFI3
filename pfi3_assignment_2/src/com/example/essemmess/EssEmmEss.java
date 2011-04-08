package com.example.essemmess;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
// import android.text.*;


public class EssEmmEss extends Activity {
    /** Called when the activity is first created. */
    // @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText edittext1 = (EditText) findViewById(R.id.editText1);
        final EditText edittext2 = (EditText) findViewById(R.id.editText2);
        
        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
            	
            	EditText tagField = (EditText) findViewById(R.id.editText1);           		
        		EditText textField = (EditText) findViewById(R.id.editText2);
            	
        		Toast.makeText(EssEmmEss.this, edittext1.getText().toString()+edittext2.getText().toString(), 300).show();
        		// Toast.makeText(EssEmmEss.this, edittext1.getText().toString(), 300).show();
            	// Toast.makeText(EssEmmEss.this, edittext2.getText().toString(), 300).show();
            	
            	tagField.setText ("");
            	textField.setText ("");
            }
        
    });
}
}
