package edu.sc.cse.adausc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by David on 3/30/2015.
 */
public class QRhallways extends Activity {

    TextView content1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_hallways);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        //No toggle, lack of a second content section
        content1 = (TextView) findViewById(R.id.contentTextView1);
        //Information
        content1.setText(R.string.hallway_info_1);
    }

}
