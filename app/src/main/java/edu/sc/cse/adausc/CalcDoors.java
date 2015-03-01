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
public class CalcDoors extends Activity{

    private Button btnSwinging;
    private Button btnSlideFold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_doors);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //set up buttons
        btnSwinging = (Button) findViewById(R.id.btnSwinging);
        btnSlideFold = (Button) findViewById(R.id.btnSlidingFolding);

        btnSwinging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewSwing) {
                TextView txtSwing = (TextView) findViewById(R.id.infoText);
                txtSwing.setVisibility(View.VISIBLE);
                txtSwing.setText("Maneuvering clearances for swinging doors: \n" +
                        "\n" +
                        "*Approach from front, pull: Minimum 60 inches perpendicular to doorway and 18 inches parallel to doorway\n" +
                        "\n" +
                        "*Approach from front, push: Minimum 48 inches perpendicular to doorway and 0 inches parallel to doorway\n" +
                        "\n" +
                        "*Approach from hinge side, pull: Minimum 60 inches perpendicular to doorway and 36 inches parallel to doorway\n" +
                        "\n" +
                        "*Approach from hinge side, push: Minimum 42 inches perpendicular to doorway and 22 inches parallel to doorway\n" +
                        "\n" +
                        "*Approach from latch/knob side, pull: Minimum 48 inches perpendicular to doorway and 24 inches parallel to doorway\n" +
                        "\n" +
                        "*Approach from latch/knob side, push: Minimum 42 inches perpendicular to doorway and 24 inches parallel to doorway\n" +
                        "\n" +
                        "*See Section 404 for more detail and graphics.\n");
            }
        });

        btnSlideFold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewSlideFold) {
                TextView txtSlideFold = (TextView) findViewById(R.id.infoText);
                txtSlideFold.setVisibility(View.VISIBLE);
                txtSlideFold.setText("Maneuvering clearances for sliding/folding doors:\n" +
                        "\n" +
                        "*Approach from front:  Minimum 48 inches perpendicular to doorway and 0 inches parallel to doorway\n" +
                        "\n" +
                        "*Approach from side: Minimum 42 inches perpendicular to doorway and 0 inches parallel to doorway\n" +
                        "\n" +
                        "*Approach from hinge side: Minimum 42 inches perpendicular to doorway and 22 inches parallel to doorway\n" +
                        "\n" +
                        "*Approach from latch/knob side: Minimum 42 inches perpendicular to doorway and 24 inches parallel doorway\n" +
                        "\n" +
                        "*See Section 404 for more detail and graphics.\n");
            }
        });
    }
}
