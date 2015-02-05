package edu.sc.cse.adausc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by dohertsm on 10/28/2014.
 */
public class BrowseScreen extends Activity implements ExpandableListView.OnChildClickListener{
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.browseList);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(this);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("1 Administration");
        listDataHeader.add("2 Scoping Requirements");
        listDataHeader.add("3 Building Blocks");
        listDataHeader.add("4 Accessible Routes");
        listDataHeader.add("5 Site and Building Elements");
        listDataHeader.add("6 Plumbing Facilities");
        listDataHeader.add("7 Communication");
        listDataHeader.add("8 Special Elements");
        listDataHeader.add("9 Built-In Elements");

        // Adding child data
        List<String> section1 = new ArrayList<String>();
        for(int i = 0; i < SessionCache.m_oParentChildList.get(0).size(); i++){
            section1.add(SessionCache.m_oParentChildList.get(0).get(i));
        }
        List<String> section2 = new ArrayList<String>();
        for(int i = 0; i < SessionCache.m_oParentChildList.get(1).size(); i++){
            section2.add(SessionCache.m_oParentChildList.get(1).get(i));
        }
        List<String> section3 = new ArrayList<String>();
        for(int i = 0; i < SessionCache.m_oParentChildList.get(2).size(); i++){
            section3.add(SessionCache.m_oParentChildList.get(2).get(i));
        }
        List<String> section4 = new ArrayList<String>();
        for(int i = 0; i < SessionCache.m_oParentChildList.get(3).size(); i++){
            section4.add(SessionCache.m_oParentChildList.get(3).get(i));
        }
        List<String> section5 = new ArrayList<String>();
        for(int i = 0; i < SessionCache.m_oParentChildList.get(4).size(); i++){
            section5.add(SessionCache.m_oParentChildList.get(4).get(i));
        }
        List<String> section6 = new ArrayList<String>();
        for(int i = 0; i < SessionCache.m_oParentChildList.get(5).size(); i++){
            section6.add(SessionCache.m_oParentChildList.get(5).get(i));
        }
        List<String> section7 = new ArrayList<String>();
        for(int i = 0; i < SessionCache.m_oParentChildList.get(6).size(); i++){
            section7.add(SessionCache.m_oParentChildList.get(6).get(i));
        }
        List<String> section8 = new ArrayList<String>();
        for(int i = 0; i < SessionCache.m_oParentChildList.get(7).size(); i++){
            section8.add(SessionCache.m_oParentChildList.get(7).get(i));
        }
        List<String> section9 = new ArrayList<String>();
        for(int i = 0; i < SessionCache.m_oParentChildList.get(8).size(); i++){
            section9.add(SessionCache.m_oParentChildList.get(8).get(i));
        }
        listDataChild.put(listDataHeader.get(0), section1);
        listDataChild.put(listDataHeader.get(1), section2);
        listDataChild.put(listDataHeader.get(2), section3);
        listDataChild.put(listDataHeader.get(3), section4);
        listDataChild.put(listDataHeader.get(4), section5);
        listDataChild.put(listDataHeader.get(5), section6);
        listDataChild.put(listDataHeader.get(6), section7);
        listDataChild.put(listDataHeader.get(7), section8);
        listDataChild.put(listDataHeader.get(8), section9);

    }

    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long l) {
        SessionCache.m_oPreviousStandard = SessionCache.m_oCurrentStandard;
        SessionCache.m_oCurrentStandard = SessionCache.m_oParentChildList.get(i).get(i2).substring(0, SessionCache.m_oParentChildList.get(i).get(i2).indexOf(' ')).trim();
        Intent oTransition = new Intent(BrowseScreen.this, SectionScreen.class);
        startActivity((oTransition));
        return false;
    }
}
