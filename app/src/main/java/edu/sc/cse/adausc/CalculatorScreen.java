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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        //the buttons
        btnParking = (Button) findViewById(R.id.parking_button);

        //what the buttons do
        btnParking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculatorScreen.this, CalcParking.class);
                startActivity((intent));
            }
        });
    }
}
