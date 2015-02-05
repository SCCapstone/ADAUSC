package edu.sc.cse.adausc;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

/**
 * Created by dohertsm on 10/28/2014.
 */

//Main Calculator Screen

public class CalculatorScreen extends Activity {

    private Button btnParking;
    private Button btnBathroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        addListenerOnButton();

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void addListenerOnButton() {

        //the buttons
        btnParking = (Button) findViewById(R.id.parking_button);
        btnBathroom = (Button) findViewById(R.id.stall_button);

        //what the buttons do
        btnParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent parking = new Intent(CalculatorScreen.this, CalcParking.class);
                startActivity((parking));
            }
        });

        btnBathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Intent bathroom = new Intent (CalculatorScreen.this, CalcBathroom.class);
                startActivity((bathroom));
            }
        });
    }
}
