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
 * Created by David on 11/29/2014.
 */

//Screen for the Parking Spot Calculator

public class CalcParking extends Activity{

    private Button btnCalculate;
    private Button btnInstruct;
    int i, j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_parking);
        pullInteger();


    }

    public void pullInteger() {
        final EditText myInt = (EditText) findViewById(R.id.numberInput);
        btnCalculate = (Button) findViewById(R.id.button_calculate);
        btnInstruct = (Button) findViewById(R.id.button_instruct);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = myInt.getText().toString();
                if (s.matches("")){
                    editText2();
                }
                else {
                    i = Integer.parseInt(myInt.getText().toString());
                    calculateSpots();
                }

                //clear edittext box after button click?

                //if you hit Calculate and the keyboard is hidden, it will appear.
            }
        });

        btnInstruct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView x = (TextView) findViewById(R.id.instructText);
                    //show/hide text
                if (x.getVisibility() == View.VISIBLE){
                    x.setVisibility(View.INVISIBLE);
                }
                else if (x.getVisibility() == View.INVISIBLE){
                    x.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    public void editText() { //text when the int is valid
        TextView t = (TextView) findViewById(R.id.OutputText);
        t.setText("Total spaces: " + i + "\nAccessible spaces required: " + j);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //Hide keyboard on button click
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        //if you hit Calculate and the keyboard is hidden, will appear

        t.setVisibility(View.VISIBLE);
        //add color Blue?
    }

    public void editText2() { //text when the value entered isn't a positive integer
        TextView t = (TextView) findViewById(R.id.OutputText);
        t.setText("Error! Please enter a positive, non-zero number only.");
        t.setVisibility(View.VISIBLE);
        //add color Red?
    }

    public void calculateSpots(){
        if (i > 0)
        {
            if (i <= 25){
                j = 1;
            }
            else if (i <= 50){
                j = 2;
            }
            else if (i <= 75) {
                j = 3;
            }
            else if (i <= 100) {
                j = 4;
            }
            else if (i <= 150) {
                j = 5;
            }
            else if (i <= 200) {
                j = 6;
            }
            else if (i <= 300) {
                j = 7;
            }
            else if (i <= 400) {
                j = 8;
            }
            else if (i <= 500) {
                j = 9;
            }
            else if (i <= 1000) {
                double d = (double) j;
                d = i * .02;
                j = (int) d;
            }
            else{
                //actually, j = 20 + 1 for every 100 spots over 1000
                int k = i - 1000;
                int f = k / 100;
                j = f + 20;
                //so, k = i - 1000. k / 100 = f. j = f + 20
            }
            editText();
        }
        else
        {
            editText2();
        }
    }
}
