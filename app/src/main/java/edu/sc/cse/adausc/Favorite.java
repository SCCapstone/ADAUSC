package edu.sc.cse.adausc;

/**
 * Created by dohertsm on 10/28/2014.
 */
public class Favorite {
    public Favorite(String oTitle, StandardSection oSection){
        m_sTitle = oTitle;
        m_oSection = oSection;
    }

    //region fields
    String m_sTitle;
    StandardSection m_oSection;
}
