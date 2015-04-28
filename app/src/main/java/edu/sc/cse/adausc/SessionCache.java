package edu.sc.cse.adausc;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

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
        m_oSectionDiagrams = SerializationHelper.DeserializeDiagramLinker(oContext);
        m_oIndex = SerializationHelper.DeserializeIndex(oContext);
    }

    public static boolean IsFavorite(String sSection){
        return m_oFavorites.contains(sSection);
    }

    public static void AddSessionSearch(String sSearch){
        m_oSessionSearches.add(sSearch);
    }

    //region fields
    public static Context m_oAppContext;
    public static ArrayList<String> m_oFavorites;       //cache favorites
    public static ArrayList<String> m_oSessionSearches; //cache anything the user searches (just an idea)
    public static ArrayList<ArrayList<String>> m_oParentChildList;
    public static String m_oCurrentStandard;
    public static String m_oPreviousStandard;
    public static String m_oFullDocHTM;
    public static HashMap<String, String> m_oSectionDiagrams;
    public static boolean m_bInitialized = false;
    public static boolean m_bFavsDirty = false;
    public static HashMap<String, String> m_oMetaData;
    public static HashMap<String, ArrayList<String>> m_oIndex;
    public static ArrayList<String> m_oWordList = new ArrayList<String>();
}
