package edu.sc.cse.adausc;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by dohertsm on 10/28/2014.
 */

//view model for Favorites
public class FavoriteScreen extends ListActivity {
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_favorites);
        m_oFavorites = SessionCache.getFavorites();
        //m_oFavoritesView = (ListView) findViewById(R.id.listFavorites);
        setListAdapter(new ArrayAdapter<String>(this, R.layout.favorite_item, m_oFavorites));
    }

    private ArrayList<String> m_oFavorites;
    //private ListView m_oFavoritesView;
}
