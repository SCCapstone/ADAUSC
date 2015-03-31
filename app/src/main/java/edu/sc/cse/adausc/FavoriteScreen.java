package edu.sc.cse.adausc;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by dohertsm on 10/28/2014.
 */

//view model for Favorites
public class FavoriteScreen extends ListActivity {
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        m_oFavorites = new ArrayList<String>();
        for(int i=0;i<SessionCache.m_oFavorites.size(); i++){
            String sSection = SessionCache.m_oFavorites.get(i);
            String sTitle = SessionCache.m_oMetaData.get(sSection);
            m_oFavorites.add(sSection + " " + sTitle);
        }

        setListAdapter(new ArrayAdapter<String>(this, R.layout.favorite_item, m_oFavorites));

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onResume() {
        super.onResume();
        m_oFavorites = new ArrayList<String>();
        for(int i=0;i<SessionCache.m_oFavorites.size(); i++){
            String sSection = SessionCache.m_oFavorites.get(i);
            String sTitle = SessionCache.m_oMetaData.get(sSection);
            m_oFavorites.add(sSection + " " + sTitle);
        }
        setListAdapter(new ArrayAdapter<String>(this, R.layout.favorite_item, m_oFavorites));
    }


    private ArrayList<String> m_oFavorites;

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        //go to selected section. pass just string of section code: xxx.x / xxx.x.x
        SessionCache.m_oPreviousStandard = SessionCache.m_oCurrentStandard;
        SessionCache.m_oCurrentStandard = m_oFavorites.get(position).substring(0, m_oFavorites.get(position).indexOf(' '));
        Intent oTransition = new Intent(FavoriteScreen.this, SectionScreen.class);
        startActivity((oTransition));
    }
    //private ListView m_oFavoritesView;
}
