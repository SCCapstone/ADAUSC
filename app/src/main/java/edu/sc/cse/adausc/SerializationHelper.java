package edu.sc.cse.adausc;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Created by dohertsm on 10/28/2014.
 */
public class SerializationHelper {

    //singleton pattern

    public static ArrayList<String> DeserializeFavorites(Context oContext){
        //deserialize and store favorites in sessioncache

        //all this is for testing, we will move to xml soon.

        //this is not a good way to go about it, just using it for testing purposes
        ArrayList<String> oFavList = new ArrayList<String>();

        try {
            InputStream oFavorites = oContext.getAssets().open(FAVORITES_FILE_NAME);
            InputStreamReader oReader = new InputStreamReader(oFavorites);
            BufferedReader bufferedReader = new BufferedReader(oReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                oFavList.add(line);
            }
            oFavorites.close();
            oReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //SessionCache.PopulateFavorites(oFavList);
        return oFavList;
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

    public static ArrayList<ArrayList<String>> DeserializeMetadata(Context oContext) {
        ArrayList<ArrayList<String>> oParentChildList = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < 9; i++){
            oParentChildList.add(new ArrayList<String>());
        }
        try {
            InputStream oMetafile = oContext.getAssets().open(METADATA_FILE_NAME);
            InputStreamReader oReader = new InputStreamReader(oMetafile);
            BufferedReader bufferedReader = new BufferedReader(oReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int oSection = Integer.parseInt(line.substring(0, 1));//(int)line.charAt(0);
                oParentChildList.get(oSection - 1).add(line);
            }
            oReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oParentChildList;
    }



    public static boolean SerializeSection(String sSection){
        //serialize sSection to favs.ada
        return true;
    }

    public static boolean RemoveSection(String sSection){
        //remove sSection from favs.ada
        return true;
    }



    //region fields
    private static final String FAVORITES_FILE_NAME = "favs.ada";
    private static final String METADATA_FILE_NAME = "Metadata.ada";
}
