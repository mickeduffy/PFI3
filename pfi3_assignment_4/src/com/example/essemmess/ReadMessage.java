package com.example.essemmess;

import java.util.ArrayList;

// import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
// import android.content.DialogInterface;
// import android.widget.AdapterView.OnItemClickListener;
// import android.view.*;
import se.k3.goransson.andreas.essemmesslib.*;
// import android.text.*;
import android.app.ListActivity;
// import android.app.AlertDialog;


public class ReadMessage extends ListActivity implements EssemmessListener {
	
	Essemmess mServer = EssemmessHelper.getServer( this );

	ArrayList<String> postCrap;
	ArrayAdapter<String> adapter;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	  super.onCreate(savedInstanceState);


	  postCrap = new ArrayList<String>();
	  
	  setListAdapter(adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, postCrap));
	  // String[] POSTS = new String[]{"", "", ""};
	  
	  /*ListView lv = getListView();
	  lv.setTextFilterEnabled(true);
	  lv.setOnItemClickListener(new OnItemClickListener(){

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3) {
			// TODO Auto-generated method stub
			Toast.makeText(ReadMessage.this, "Clicked " + arg1, Toast.LENGTH_SHORT).show();
		}});*/
	  
	  mServer.addEssemmessEventListener(this);
	  mServer.read("");
	}

	@Override
	public void NewEssemmessPosts(EssemmessReadEvent evt) {
		// TODO Auto-generated method stub
		ArrayList<Post> newposts = evt.getPosts();
		
		for( Post p : newposts){
			postCrap.add("User: " + p.tag + " ID: " + p.user + " Message: " + p.message);
		}
		
		/*posts = new String[evt.getPosts().size()];
		for(int i = 0; i < evt.getPosts().size(); i++){
		posts[i] = evt.getPosts().get(i).getMessage();
		}*/
		
		adapter.notifyDataSetChanged();
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
