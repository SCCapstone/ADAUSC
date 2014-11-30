package edu.sc.cse.adausc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

/**
 * Created by David on 11/29/2014.
 */

//Screen for the Parking Spot Calculator

public class CalcParking extends Activity{

    private Button btnCalculate;
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

            }
        });
    }

    public void editText() { //text when the int is valid
        TextView t = (TextView) findViewById(R.id.OutputText);
        t.setText("If you have " + i + " total parking spaces then you need " + j + " handicap accessible parking spaces.");
        t.setVisibility(View.VISIBLE);
        //add color Blue
    }

    public void editText2() { //text when the value entered isn't a positive integer
        TextView t = (TextView) findViewById(R.id.OutputText);
        t.setText("Error! Please enter a positive, non-zero number only.");
        t.setVisibility(View.VISIBLE);
        //add color Red
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
