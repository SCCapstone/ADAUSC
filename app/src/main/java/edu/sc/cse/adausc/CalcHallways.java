package edu.sc.cse.adausc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

/**
 * Created by David on 2/25/2015.
 */
public class CalcHallways extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_hallways);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtMain = (TextView) findViewById(R.id.infoText);
        txtMain.setVisibility(View.VISIBLE);
        txtMain.setText("*The width of walking surfaces must be 36 inches wide, minimum, and clear of obstructions.\n" +
                "\n" +
                "*At turns of 180 degrees around an element that is less than 48 inches wide, the clear width must be 42 inches minimum approaching the turn, 48 inches minimum at the turn and 42 inches minimum leaving the turn.\n" +
                "\n" +
                "*Accessible routes with clear width of less than 60 inches, passing spaces must be provided at intervals of 200 feet maximum. Passing spaces must either be a space 60 inches minimum by 60 inches minimum, or an intersection of two walking surfaces providing a T-shaped space where the arms extend 48 inches minimum beyond the intersection. \n");
    }
}