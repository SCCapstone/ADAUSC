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
public class CalcRamps extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_ramps);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtMain = (TextView) findViewById(R.id.infoText);
        txtMain.setVisibility(View.VISIBLE);
        txtMain.setText("Ramps:\n" +
                "\n" +
                "*The maximum steepness of a slope is 1:12\n" +
                "\n" +
                "*Ramps should have the least possible running slope and, when possible, accompany them with stairs\n" +
                "\n" +
                "*Cross slope of ramp runs shall not be steeper than 1:48\n" +
                "\n" +
                "*Clear width of a ramp run and, where handrails are provided, the clear width between handrails must be 36 inches minimum.\n" +
                "\n" +
                "*The rise for any ramp run shall only be 30 inches maximum.\n" +
                "\n" +
                "\n" +
                "Landings:\n" +
                "\n" +
                "*Ramps must have landings at the top and bottom of each ramp run.\n" +
                "\n" +
                "*Circular landing spaces must have a minimum turning space of 60 inches in diameter.\n" +
                "\n" +
                "*T-shaped turning spaces must exist within square of 60 in by 60 in minimum size. The arms and base of the T must be a minimum of 36 inches wide. Each arm must be clear of obstructions for a minimum distance of 12 inches in each direction and the base should be clear of obstructions for a minimum distance of 24 inches. \n");
    }
}
