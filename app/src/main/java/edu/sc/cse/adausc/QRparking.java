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
 * Created by David on 3/30/2015.
 */
public class QRparking extends Activity {

    private Button btnCalculate;
    int i, j;
    TextView content1;
    TextView content2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_parking);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        pullInteger();

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        content1 = (TextView) findViewById(R.id.contentTextView1);
        content2= (TextView) findViewById(R.id.contentTextView2);

        content1.setVisibility(View.GONE);
        content2.setVisibility(View.GONE);
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
        t.setText("Total spaces: " + i + "\nAccessible spaces required: " + j);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        //Hide keyboard on button click
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        //if you hit Calculate and the keyboard is hidden, will appear

        t.setVisibility(View.VISIBLE);
    }

    public void editText2() { //text when the value entered isn't a positive integer
        TextView t = (TextView) findViewById(R.id.OutputText);
        t.setText("Error! Please enter a positive, non-zero number only.");
        t.setVisibility(View.VISIBLE);
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
                //double d = (double) j;
                double d = i * .02;
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

    public void toggle_contents(View view1){
        content1.setVisibility(content1.isShown()
                ? View.GONE
                : View.VISIBLE);

        content1.setText(R.string.calc_park_inst);
    }

    public void toggle_contents2(View view2) {
        content2.setVisibility(content2.isShown()
                ? View.GONE
                : View.VISIBLE);

        content2.setText(R.string.parking_info_1);
    }
}
