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
 * Created by David on 3/21/2015.
 */
public class QRdoors extends Activity{


    TextView content1;
    TextView content2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_doors);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        content1 = (TextView) findViewById(R.id.contentTextView1);
        content2 = (TextView) findViewById(R.id.contentTextView2);

        content1.setVisibility(View.GONE);
        content2.setVisibility(View.GONE);
    }

    public void toggle_contents(View view1){
        content1.setVisibility(content1.isShown()
                ? View.GONE
                : View.VISIBLE);

        content1.setText("Door openings must provide a clear minimum width of 32 inches. \n" +
                "\n" +
                "Hinged doors must open 90 degrees. \n" +
                "\n" +
                "Thresholds cannot be more than ½ inch high. \n" +
                "\n" +
                "Maneuvering clearances for swinging doors: \n" +
                "\n" +
                "Approach from front, pull: Minimum 60 inches perpendicular to doorway and 18 inches parallel to doorway\n" +
                "\n" +
                "Approach from front, push: Minimum 48 inches perpendicular to doorway and 0 inches parallel to doorway\n" +
                "\n" +
                "Approach from hinge side, pull: Minimum 60 inches perpendicular to doorway and 36 inches parallel to doorway\n" +
                "\n" +
                "Approach from hinge side, push: Minimum 42 inches perpendicular to doorway and 22 inches parallel to doorway\n" +
                "\n" +
                "Approach from latch/knob side, pull: Minimum 48 inches perpendicular to doorway and 24 inches parallel to doorway\n" +
                "\n" +
                "Approach from latch/knob side, push: Minimum 42 inches perpendicular to doorway and 24 inches parallel to doorway\n" +
                "\n" +
                "See Section 404 for more detail and graphics.\n");
    }

    public void toggle_contents2(View view2) {
        content2.setVisibility(content2.isShown()
                ? View.GONE
                : View.VISIBLE);

        content2.setText("Door openings must provide a clear minimum width of 32 inches. \n" +
                "\n" +
                "Hinged doors must open 90 degrees. \n" +
                "\n" +
                "Thresholds cannot be more than ½ inch high. \n" +
                "\n" +
                "Maneuvering clearances for sliding/folding doors:\n" +
                "\n" +
                "Approach from front:  Minimum 48 inches perpendicular to doorway and 0 inches parallel to doorway\n" +
                "\n" +
                "Approach from side: Minimum 42 inches perpendicular to doorway and 0 inches parallel to doorway\n" +
                "\n" +
                "Approach from hinge side: Minimum 42 inches perpendicular to doorway and 22 inches parallel to doorway\n" +
                "\n" +
                "Approach from latch/knob side: Minimum 42 inches perpendicular to doorway and 24 inches parallel doorway\n" +
                "\n" +
                "See Section 404 for more detail and graphics.\n");
    }
}
