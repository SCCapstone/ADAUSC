package edu.sc.cse.adausc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.MultiAutoCompleteTextView;

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
    MultiAutoCompleteTextView searchView;
    ListView matchList;
    ArrayList<String> m_oMatches;
    ArrayAdapter<String> m_oMatchAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.browseList);
        searchView = (MultiAutoCompleteTextView) findViewById(R.id.searchView);
        matchList = (ListView) findViewById(R.id.matchView);
        m_oMatches = new ArrayList<String>();
        // preparing list data
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
        m_oMatches = new ArrayList<String>();
        m_oMatchAdapter = new ArrayAdapter<String>(this, R.layout.favorite_item, m_oMatches);
        matchList.setAdapter(m_oMatchAdapter);
        matchList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id)
            {
                String selectedFromList = matchList.getItemAtPosition(position).toString().substring(0, matchList.getItemAtPosition(position).toString().indexOf(' '));
                SessionCache.m_oPreviousStandard = SessionCache.m_oCurrentStandard;
                SessionCache.m_oCurrentStandard = selectedFromList;
                Intent oTransition = new Intent(BrowseScreen.this, SectionScreen.class);
                startActivity((oTransition));
            }});
        // setting list adapter
        expListView.setAdapter(listAdapter);
        expListView.setOnChildClickListener(this);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, SessionCache.m_oWordList);

        searchView.setAdapter(adapter);
        searchView.setTokenizer(new MultiAutoCompleteTextView.Tokenizer() {
            public int findTokenStart(CharSequence text, int cursor) {
                int i = cursor;

                while (i > 0 && text.charAt(i - 1) != ' ') {
                    i--;
                }
                while (i < cursor && text.charAt(i) == ' ') {
                    i++;
                }

                return i;
            }

            public int findTokenEnd(CharSequence text, int cursor) {
                int i = cursor;
                int len = text.length();

                while (i < len) {
                    if (text.charAt(i) == ' ') {
                        return i;
                    } else {
                        i++;
                    }
                }

                return len;
            }

            public CharSequence terminateToken(CharSequence text) {
                int i = text.length();

                while (i > 0 && text.charAt(i - 1) == ' ') {
                    i--;
                }

                if (i > 0 && text.charAt(i - 1) == ' ') {
                    return text;
                } else {
                    if (text instanceof Spanned) {
                        SpannableString sp = new SpannableString(text + "");
                        TextUtils.copySpansFrom((Spanned) text, 0, text.length(),
                                Object.class, sp, 0);
                        return sp;
                    } else {
                        return text + "";
                    }
                }
            }
        });
        searchView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String oInput = editable.toString().trim();
                if(oInput.equals("")){
                    expListView.setVisibility(View.VISIBLE);
                    matchList.setVisibility(View.GONE);
                } else{
                    if(SessionCache.m_oWordList.contains(oInput.toLowerCase())){
                        ArrayList<String> oMatches = SessionCache.m_oIndex.get(oInput.toLowerCase());
                        ArrayList<String> oResults = new ArrayList<String>();
                        for(int i=0; i<oMatches.size(); i++){
                            oResults.add(oMatches.get(i) + " " + SessionCache.m_oMetaData.get(oMatches.get(i)));
                        }
                        expListView.setVisibility(View.GONE);
                        matchList.setVisibility(View.VISIBLE);
                        m_oMatchAdapter.addAll(oResults);
                    }
                }
            }
        });
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
