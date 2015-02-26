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
    private Button btnDoors;
    private Button btnHallways;
    private Button btnRamps;

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
        btnDoors = (Button) findViewById(R.id.door_button);
        btnHallways = (Button) findViewById(R.id.hallway_button);
        btnRamps = (Button) findViewById(R.id.ramp_button);

        //what the buttons do
        btnParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewPark) {
                Intent parking = new Intent(CalculatorScreen.this, CalcParking.class);
                startActivity((parking));
            }
        });

        btnBathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewBathroom) {
                Intent bathroom = new Intent (CalculatorScreen.this, CalcBathroom.class);
                startActivity((bathroom));
            }
        });

        btnDoors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewDoors) {
                Intent doors = new Intent (CalculatorScreen.this, CalcDoors.class);
                startActivity((doors));
            }
        });

        btnHallways.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewHallways) {
                Intent hallways = new Intent (CalculatorScreen.this, CalcHallways.class);
                startActivity((hallways));
            }
        });

        btnRamps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View viewRamps) {
                Intent ramps = new Intent (CalculatorScreen.this, CalcRamps.class);
                startActivity((ramps));
            }
        });
    }
}
