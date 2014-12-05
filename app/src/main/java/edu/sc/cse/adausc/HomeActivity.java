package edu.sc.cse.adausc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends Activity {

    private Button btBrowse;
    private Button btCalculator;
    private Button btFavorites;
    private Button btDocument;
    private Button btAbout;
    private Button btContact;

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
        btAbout = (Button) findViewById(R.id.buttonAbout);
        btContact = (Button) findViewById(R.id.buttonContact);

        btBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
            }
        });

        btAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oTransition = new Intent (HomeActivity.this, AboutScreen.class);
                startActivity(oTransition);
            }
        });

        btContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oTransition = new Intent(HomeActivity.this, ContactScreen.class);
                startActivity(oTransition);
            }
        });

        btDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent oTransition = new Intent(HomeActivity.this, FullDocumentScreen.class);
                startActivity((oTransition));
            }
        });
        
    }

    public void OnStartUp(){
        InputInitialization(); //set up event listeners
        SessionCache.Initialize(this);
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
