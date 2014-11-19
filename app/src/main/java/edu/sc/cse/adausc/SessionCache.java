package edu.sc.cse.adausc;

import java.util.ArrayList;

/**
 * Created by dohertsm on 10/28/2014.
 */
public class SessionCache {
    //region Methods
    public static void Initialize(){
        m_oFavorites = new ArrayList<String>();
        m_oSessionSearches = new ArrayList<String>();
    }

    public static void PopulateFavorites(ArrayList<String> oFavorites){
        if(oFavorites.size() > 0){
            //populate with favorites
            m_oFavorites = oFavorites;
        }
    }

    public static void AddSessionSearch(String sSearch){
        m_oSessionSearches.add(sSearch);
    }

    //region Properties
    public static ArrayList<String> getFavorites(){
            return m_oFavorites;
    }


    //region fields
    private static ArrayList<String> m_oFavorites;       //cache favorites
    private static ArrayList<String> m_oSessionSearches; //cache anything the user searches (just an idea)
}