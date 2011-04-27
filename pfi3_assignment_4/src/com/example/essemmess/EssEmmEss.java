package com.example.essemmess;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.view.View.OnClickListener;
import se.k3.goransson.andreas.essemmesslib.*;
// import android.text.*;

public class EssEmmEss extends Activity implements EssemmessListener {
    
	Essemmess mServer = EssemmessHelper.getServer( this ); 
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    	// load up the layout
        setContentView(R.layout.main);
        
        mServer.addEssemmessEventListener(this);
        
        // get the button resource in the xml file and assign it to a local variable of type Button
        Button launch = (Button)findViewById(R.id.button1);
        
        // this is the action listener
        launch.setOnClickListener( new OnClickListener()
        {
        	
        	public void onClick(View viewParam)
        	{
        		// this gets the resources in the xml file and assigns it to a local variable of type EditText
                EditText usernameEditText = (EditText) findViewById(R.id.EditText01);
                EditText passwordEditText = (EditText) findViewById(R.id.EditText02);
                
                // the getText() gets the current value of the text box
                // the toString() converts the value to String data type
                // then assigns it to a variable of type String
                String sUserName = usernameEditText.getText().toString();
                String sPassword = passwordEditText.getText().toString();
             
                // this just catches the error if the program cant locate the GUI stuff
                if(usernameEditText == null || passwordEditText == null){
                   /* showAlert("Crap!", "Couldn't find the 'txt_username' or 'txt_password' "
                              + "EditView in main.xml", "Oh shit!", false);*/
                
                }else{
                	// display the username and the password in string format
                	//showAlert("Logging in", "Username: " + sUserName + "nPassword: " + sPassword , "Ok", true);
                	   mServer.login(sUserName, sPassword);
                }
        	}
        }
        
        ); // end of launch.setOnclickListener
    }

	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NewEssemmessLogin(EssemmessLoginEvent evt) {
		// TODO Auto-generated method stub
	
	if(evt.getLoggedin() != true){
     
     }else{
    	 Intent bytSkarm = new Intent(EssEmmEss.this,PostMessage.class);
    	 this.startActivity(bytSkarm);
    	 Toast.makeText(EssEmmEss.this, "Logged In!", 3000).show();
     
     }
	
	}

	@Override
	public void NewEssemmessPublish(EssemmessPublishEvent evt) {
		// TODO Auto-generated method stub
		
	}
}