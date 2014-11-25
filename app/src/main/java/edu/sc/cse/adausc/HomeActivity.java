package edu.sc.cse.adausc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

public class HomeActivity extends Activity {

    private AlertDialog.Builder alert;
    private Button btBrowse;
    private Button btCalculator;
    private Button btFavorites;
    private Button btDocument;
    private TextView aboutLink;
    private TextView contactLink;

    //region methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getActionBar().hide();

        //go go super app!
        OnStartUp();
    }

    public void InputInitialization(){
        btBrowse = (Button) findViewById(R.id.buttonBrowse);
        btCalculator = (Button) findViewById(R.id.buttonCalculator);
        btFavorites = (Button) findViewById(R.id.buttonFavorites);
        btDocument = (Button) findViewById(R.id.buttonDocument);

        btBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when this button is clicked, show the alert
                //alert.show();
                Intent oTransition = new Intent(HomeActivity.this, BrowseScreen.class);
                startActivity((oTransition));
            }
        });

        btCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oTransition = new Intent(HomeActivity.this, CalculatorScreen.class);
                startActivity((oTransition));
            }
        });

        btFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oTransition = new Intent(HomeActivity.this, FavoriteScreen.class);
                startActivity((oTransition));
                //debug
                //String oFavs = "";
                //for(int i = 0; i < SessionCache.getFavorites().size(); i++){
                //    oFavs += SessionCache.getFavorites().get(i);
                //    oFavs += "\n";
                //}
                //AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);

                //builder.setMessage(oFavs)
                //        .setTitle("YO FAVZ LIST");

                //AlertDialog dialog = builder.create();
                //dialog.show();
            }
        });

        btDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when this button is clicked, show the alert
                //alert.show();
                //is this linking to chrome or are we displaying a local version?
            }
        });

        aboutLink = (TextView) findViewById(R.id.about);
        aboutLink.setMovementMethod(LinkMovementMethod.getInstance());
        aboutLink.setOnClickListener((view) -> {

            Intent oTransition = new Intent(HomeActivity.this, AboutScreen.class);
            startActivity(oTransition);

        });
        contactLink = (TextView) findViewById(R.id.contact);
        contactLink.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void OnStartUp(){
        InputInitialization(); //set up event listeners
        SessionCache.Initialize(); //store whatever we may need on the fly in session cache (may be unneeded?)
        SerializationHelper.DeserializeFavorites(this); //maybe a bad idea passing this?
    }
    
    //endregion methods

    //unused overrides
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
