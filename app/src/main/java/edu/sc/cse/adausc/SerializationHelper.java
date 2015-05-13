package edu.sc.cse.adausc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by dohertsm on 10/28/2014.
 */
public class SerializationHelper {

    //singleton pattern

    public static ArrayList<String> DeserializeFavorites(Context oContext){
        //deserialize and store favorites in sessioncache

        ArrayList<String> oFavList = new ArrayList<String>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(oContext.getFilesDir() + File.separator + FAVORITES_FILE_NAME));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                oFavList.add(line);
            }

        } catch (IOException e) {
            //create this file if it doesnt
            try {
                File oFavs = new File(oContext.getFilesDir(), FAVORITES_FILE_NAME);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        Collections.sort(oFavList);

        return oFavList;
    }

    public static HashMap<String, String> DeserializeDiagramLinker(Context oContext){
        //deserialize and store diagram/section associations

        HashMap<String, String> oLinker = new HashMap<String, String>();
        try {
            InputStream oLinkerStream = oContext.getAssets().open(DIAG_SEC_LINKER_FILE_NAME);
            InputStreamReader oReader = new InputStreamReader(oLinkerStream);
            BufferedReader bufferedReader = new BufferedReader(oReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //format: pic# section#
                int spaceIndex = line.indexOf(' ');
                String picNum = line.substring(0, spaceIndex);
                String sectionNum = line.substring(spaceIndex+1, line.indexOf('.'));//line.length());
                oLinker.put(sectionNum, picNum);
            }
            oLinkerStream.close();
            oReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oLinker;
    }

    public static HashMap<String, ArrayList<String>> DeserializeIndex(Context oContext){
        HashMap<String, ArrayList<String>> oIndex = new HashMap<String, ArrayList<String>>();
        try{
            InputStream oStream = oContext.getAssets().open(INDEX_FILE_NAME);
            InputStreamReader oReader = new InputStreamReader(oStream);
            BufferedReader bufferedReader = new BufferedReader(oReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //format: XXX.X title words //space delimited
                String[] sWords = line.split(" ");
                String sSection = sWords[0];
                for(int i=1; i<sWords.length; i++){
                    if(sWords[i].indexOf('.') != -1){
                        sWords[i] = sWords[i].substring(0,sWords[i].length()-1);
                    }
                    if(SessionCache.m_oWordList.contains(sWords[i].toLowerCase())==false){
                        SessionCache.m_oWordList.add(sWords[i].toLowerCase());
                        oIndex.put(sWords[i].toLowerCase(), new ArrayList<String>());
                        oIndex.get(sWords[i].toLowerCase()).add(sSection);
                    } else{
                        if(oIndex.get(sWords[i].toLowerCase()).contains(sSection) == false) {
                            oIndex.get(sWords[i].toLowerCase()).add(sSection);
                        }
                    }
                }
            }
            oStream.close();
            oReader.close();
            bufferedReader.close();
        } catch (Exception oEx){

        }
        return oIndex;
    }

    public static StandardSection Deserialize(String sSection){
        StandardSection oSection = new StandardSection();
        try {
            InputStream oFileIn = SessionCache.m_oAppContext.getAssets().open("s" + sSection + ".ada");
            ObjectInputStream oObjectReader = new ObjectInputStream(oFileIn);
            oSection = (edu.sc.cse.adausc.StandardSection)oObjectReader.readObject();
        } catch (Exception oEx){
            //do nothing
            oEx.printStackTrace();
        }
        return  oSection;
    }

    public static Bitmap GetDiagramBitmap(String diagramNumber){
        //our decoded gif object to set in sectionstandards view
        Bitmap bits = null;

        try {
            //well structured string literal
            InputStream bitmap= SessionCache.m_oAppContext.getAssets().open("ADAGIFs/diagram"+diagramNumber+".gif");
            bits = BitmapFactory.decodeStream(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return bits;
    }

    public static ArrayList<ArrayList<String>> DeserializeMetadata(Context oContext) {
        ArrayList<ArrayList<String>> oParentChildList = new ArrayList<ArrayList<String>>();
        HashMap<String, String> oFullList = new HashMap<String, String>();
        for(int i = 0; i < 10; i++){
            oParentChildList.add(new ArrayList<String>());
        }
        try {
            InputStream oMetafile = oContext.getAssets().open(METADATA_FILE_NAME);
            InputStreamReader oReader = new InputStreamReader(oMetafile);
            BufferedReader bufferedReader = new BufferedReader(oReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int oSection = -1;
                if (line.indexOf('.') == 3) {
                    oSection = Integer.parseInt(line.substring(0, 1));
                    Log.d("oSection:", Integer.toString(oSection));
                }
                else if (line.indexOf('.') == 4) {
                    oSection = Integer.parseInt(line.substring(0, 2));
                    Log.d("oSection:", Integer.toString(oSection));
                }

                if (oSection != -1) {
                    oParentChildList.get(oSection - 1).add(line);
                    oFullList.put(line.substring(0, line.indexOf(' ')), line.substring(line.indexOf(' ')+1, line.length()));
                }
            }
            oReader.close();
            bufferedReader.close();
            SessionCache.m_oMetaData = oFullList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oParentChildList;
    }

    public static boolean AddFavSection(String sSection){
        try{
            //SessionCache.m_oAppContext.openFileOutput(FAVORITES_FILE_NAME, Context.MODE_APPEND);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(SessionCache.m_oAppContext.getFilesDir()+File.separator+FAVORITES_FILE_NAME, true));
            bufferedWriter.write(sSection+"\n");
            bufferedWriter.close();
            if(!SessionCache.m_oFavorites.contains(sSection)) {
                SessionCache.m_oFavorites.add(sSection);
            }
            //re-sort
            Collections.sort(SessionCache.m_oFavorites);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static String LoadFullDoc(){
        //this is wicked slow.... not sure why
        StringBuilder sDoc = new StringBuilder();
        try {
            InputStream oInput = SessionCache.m_oAppContext.getAssets().open(FULL_DOC_FILE_NAME);
            InputStreamReader oReader = new InputStreamReader(oInput);
            BufferedReader bufferedReader = new BufferedReader(oReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                sDoc.append(line);
            }
        } catch (Exception oEx){
            //fail..so crash?? idk
        }
        return sDoc.toString();
    }

    public static boolean RemoveFavSection(String sSection){
        try{
            //recreate the fav.txt file empty and rewrite all favorites
            SessionCache.m_oFavorites.remove(sSection);
            File oFavs = new File(SessionCache.m_oAppContext.getFilesDir(), FAVORITES_FILE_NAME);
            BufferedWriter oWriter = new BufferedWriter(new FileWriter(oFavs));
            for(int i=0; i<SessionCache.m_oFavorites.size(); i++){
                oWriter.write(SessionCache.m_oFavorites.get(i)+"\n");
            }
            oWriter.close();
        } catch (IOException ex){

        }
        return true;
    }

    //region fields
    private static final String FAVORITES_FILE_NAME = "fav.txt";
    private static final String METADATA_FILE_NAME = "Metadata.ada"; //code title, space delimited
    private static final String FULL_DOC_FILE_NAME = "2010ADAStandards.htm";
    private static final String DIAG_SEC_LINKER_FILE_NAME = "diagramlinker.txt";
    private static final String INDEX_FILE_NAME = "ADAIndex.txt";
}
