package edu.sc.cse.adausc;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

/**
 * Created by dohertsm on 12/4/2014.
 */
public class FullDocumentScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fulldoc);
        WebView oContent = (WebView) findViewById(R.id.fullDoc);
        oContent.loadDataWithBaseURL(null, SerializationHelper.LoadFullDoc(), "text/html", "UTF-8", null);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }


    ProgressBar oSpinner;
}
