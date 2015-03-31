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
public class QRramps extends Activity{

    TextView content1;
    TextView content2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_ramps);

        content1 = (TextView) findViewById(R.id.contentTextView1);
        content2= (TextView) findViewById(R.id.contentTextView2);

        content1.setVisibility(View.GONE);
        content2.setVisibility(View.GONE);
    }

    public void toggle_contents(View view1){
        content1.setVisibility(content1.isShown()
                ? View.GONE
                : View.VISIBLE);

        content1.setText(R.string.ramp_info_1);
    }

    public void toggle_contents2(View view2) {
        content2.setVisibility(content2.isShown()
                ? View.GONE
                : View.VISIBLE);

        content2.setText(R.string.ramp_info_2);
    }
}
