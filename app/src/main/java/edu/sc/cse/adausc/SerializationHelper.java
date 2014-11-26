package edu.sc.cse.adausc;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    //region fields
    private static final String FAVORITES_FILE_NAME = "favs.ada";

}
