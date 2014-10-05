package com.example.adausc;

import android.support.v7.app.ActionBarActivity;
import android.text.method.LinkMovementMethod;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	
	final Context context = this;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button) findViewById(R.id.buttonBrowse);

		
		//add button listener
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
				
				//set title
				alertDialogBuilder.setTitle("Test title");
				
				//set dialog message
				alertDialogBuilder
					.setMessage("Click \"Yes\" to exit")
					.setCancelable(false)
					.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							//if this button is clicked, close current activity
							MainActivity.this.finish();
						}
					})
					.setNegativeButton("No", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int id) {
							//if this button is clicked, just close the dialog box
							dialog.cancel();
						}
					});
					
					//create alert dialog
					AlertDialog alertDialog = alertDialogBuilder.create();
					
					//show it
					alertDialog.show();
			}
		});
	}
}