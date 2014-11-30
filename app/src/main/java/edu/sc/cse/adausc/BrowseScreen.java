package edu.sc.cse.adausc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;


/**
 * Created by dohertsm on 10/28/2014.
 */
public class BrowseScreen extends Activity {
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
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Section 1");
        listDataHeader.add("Section 2");
        listDataHeader.add("Section 3");

        // Adding child data
        List<String> section1 = new ArrayList<String>();
        section1.add("Section 1.a");
        section1.add("Section 1.b");
        section1.add("Section 1.c");

        List<String> section2 = new ArrayList<String>();
        section2.add("Section 2.a");
        section2.add("Section 2.b");
        section2.add("Section 2.c");
        section2.add("Section 2.d");

        List<String> section3 = new ArrayList<String>();
        section3.add("Section 3.a");
        section3.add("Section 3.b");

        listDataChild.put(listDataHeader.get(0), section1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), section2);
        listDataChild.put(listDataHeader.get(2), section3);
    }
}
