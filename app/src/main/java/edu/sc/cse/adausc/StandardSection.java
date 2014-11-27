package edu.sc.cse.adausc;

import java.io.Serializable;

/**
 * Created by dohertsm on 10/28/2014.
 */
public class StandardSection implements Serializable{

    public StandardSection(String oSectionCode, String oTitle, String oContent) {
         this.m_sCode = oSectionCode;
         this.m_sTitle = oTitle;
         this.m_sContent = oContent;
    }

    public StandardSection(){
        m_sCode = "Dummy";
        m_sContent = "Dummy";
        m_sTitle = "Dummy";
    }

    public String getSection(){
        return m_sContent;
    }

    public String getTitle(){
        return m_sTitle;
    }

    public String getCode(){
        return m_sCode;
    }

    private String m_sTitle;
    private String m_sCode;
    private String m_sContent;
    private static final long serialVersionUID = 1L;




}
