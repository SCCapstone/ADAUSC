package edu.sc.cse.adausc;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by dohertsm on 10/28/2014.
 */
public class SessionCache {
    //singleton

    //region Methods
    public static void Initialize(Context oContext){
        m_oParentChildList = SerializationHelper.DeserializeMetadata(oContext);
        m_oFavorites = SerializationHelper.DeserializeFavorites(oContext);
        m_oSessionSearches = new ArrayList<String>();
        m_oAppContext = oContext;
        //should we go ahead and save full doc in start up?
        //m_oFullDocHTM = SerializationHelper.LoadFullDoc();
    }

    public static void PopulateFavorites(ArrayList<String> oFavorites){
        if(oFavorites.size() > 0){
            //populate with favorites
            m_oFavorites = oFavorites;
        }
    }

    public static boolean IsFavorite(String sSection){
        return m_oFavorites.contains(sSection);
    }

    public static void AddSessionSearch(String sSearch){
        m_oSessionSearches.add(sSearch);
    }

    //region Properties
    public static ArrayList<String> getFavorites(){
            return m_oFavorites;
    }


    //region fields
    public static Context m_oAppContext;
    private static ArrayList<String> m_oFavorites;       //cache favorites
    private static ArrayList<String> m_oSessionSearches; //cache anything the user searches (just an idea)
    public static ArrayList<ArrayList<String>> m_oParentChildList;
    public static String m_oCurrentStandard;
    public static String m_oPreviousStandard;
    public static String m_oFullDocHTM;
}
