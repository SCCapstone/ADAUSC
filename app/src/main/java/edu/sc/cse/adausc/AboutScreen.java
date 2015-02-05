package edu.sc.cse.adausc;

import android.os.Bundle;
import android.app.Activity;

/**
 * Created by Mateusz on 11/20/2014.
 */
public class AboutScreen extends Activity {

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }
}