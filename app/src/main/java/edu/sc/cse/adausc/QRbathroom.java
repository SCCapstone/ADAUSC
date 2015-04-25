package edu.sc.cse.adausc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


/**
 * Created by David on 3/20/2015.
 */
public class QRbathroom extends Activity {

    TextView content1;
    TextView content2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_bathroom);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        content1 = (TextView) findViewById(R.id.contentTextView1);
        content2 = (TextView) findViewById(R.id.contentTextView2);

        content1.setVisibility(View.GONE);
        content2.setVisibility(View.GONE);
    }

    //Toggle Top Content Section
    public void toggle_contents(View view1){
        content1.setVisibility(content1.isShown()
        ? View.GONE
        : View.VISIBLE);
        //Information
        content1.setText(R.string.bathroom_info_1);
    }

    //Toggle Bottom Content Section
    public void toggle_contents2(View view2) {
        content2.setVisibility(content2.isShown()
        ? View.GONE
        : View.VISIBLE);
        //Information
        content2.setText(R.string.bathroom_info_2);
    }
}
