package com.example.essemmess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import se.k3.goransson.andreas.essemmesslib.*;
// import android.text.*;


public class PostMessage extends Activity implements EssemmessListener {
    /** Called when the activity is first created. */
    // @Override
	
	Essemmess mServer = EssemmessHelper.getServer( this );
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);
        
 //       final EditText edittext1 = (EditText) findViewById(R.id.editText1);
 //       final EditText edittext2 = (EditText) findViewById(R.id.editText2);
        
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            
            public void onClick(View v) {
            	
            	EditText tagField = (EditText) findViewById(R.id.editText1);           		
        		EditText textField = (EditText) findViewById(R.id.editText2);
            	
        		//Toast.makeText(EssEmmEss.this, edittext1.getText().toString()+edittext2.getText().toString(), 300).show();
        		// Toast.makeText(EssEmmEss.this, edittext1.getText().toString(), 300).show();
            	// Toast.makeText(EssEmmEss.this, edittext2.getText().toString(), 300).show();
            	
        		mServer.post( textField.getText().toString(), tagField.getText().toString());
        		
            	tagField.setText ("");
            	textField.setText ("");
            	
            	Intent bytSkarm = new Intent(PostMessage.this,ReadMessage.class);
   	    	 	startActivity(bytSkarm);
				
			}
        
    });
}

	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub

	    
		
	}

	@Override
	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		// TODO Auto-generated method stub
		
	     
	     
	}

	@Override
	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub
		
	}
}
