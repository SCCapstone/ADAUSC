package edu.sc.cse.adausc;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
        oIsFav = (CheckBox) findViewById(R.id.isFavChkBox);
        //deserialize current section .ada file
        oSection = SerializationHelper.Deserialize(SessionCache.m_oCurrentStandard);
        oIsFav.setChecked(SessionCache.IsFavorite(oSection.getCode()));
        oIsFav.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    //favorited
                    SerializationHelper.AddFavSection(oSection.getCode());
                } else {
                    SerializationHelper.RemoveFavSection(oSection.getCode());
                }
            }
        });
        oTitle.setText(oSection.getTitle());
        oContent.loadData("<html><body><font size=" + "\"" + m_iFontSize + "\">" +oSection.getSection()+"</font></body></html>", "text/html", null);
        oCode.setText(oSection.getCode());

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //region fields
    StandardSection oSection;
    TextView oTitle;
    WebView oContent;
    TextView oCode;
    CheckBox oIsFav;
    int m_iFontSize = 5;
}
