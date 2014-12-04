package edu.sc.cse.adausc;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by dohertsm on 10/28/2014.
 */
public class SectionScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        oTitle = (TextView) findViewById(R.id.sectionTitle);
        oContent = (WebView) findViewById(R.id.sectionContent);
        oCode = (TextView) findViewById(R.id.sectionCode);
        //deserialize current section .ada file
        oSection = SerializationHelper.Deserialize(SessionCache.m_oCurrentStandard);
        oTitle.setText(oSection.getTitle());
        oContent.loadData("<html><body><font size=" + "\"" + m_iFontSize + "\">" +oSection.getSection()+"</font></body></html>", "text/html", null);
        oCode.setText(oSection.getCode());
    }

    //region fields
    StandardSection oSection;
    TextView oTitle;
    WebView oContent;
    TextView oCode;
    int m_iFontSize = 5;
}
