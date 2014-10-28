package edu.sc.cse.adausc;

/**
 * Created by dohertsm on 10/28/2014.
 */
public class Favorite {
    public Favorite(String oTitle, StandardsSection oSection){
        m_sTitle = oTitle;
        m_oSection = oSection;
    }

    //region fields
    String m_sTitle;
    StandardsSection m_oSection;
}
