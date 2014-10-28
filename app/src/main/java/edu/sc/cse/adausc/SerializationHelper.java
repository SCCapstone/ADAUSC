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

    public static void DeserializeFavorites(Context oContext){
        //possible functionality
        //store favorites in sessioncache
        //XmlDeserialize... I need to read up on the API & need to create test file

        //probably need to create a local file on a users first run of the app (not positive though)

        //this probably is not a good way to go about it, just using it for testing purposes
        ArrayList<String> oFavList = new ArrayList<String>();

        //http://www.avajava.com/tutorials/lessons/how-do-i-read-a-string-from-a-file-line-by-line.html
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

        SessionCache.PopulateFavorites(oFavList);
    }

    //region fields
    private static final String FAVORITES_FILE_NAME = "favorites.txt";

}
