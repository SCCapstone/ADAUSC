package edu.sc.cse.adausc;

import android.app.Activity;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getActionBar().hide();

        alert = new AlertDialog.Builder(HomeActivity.this);
        alert.setTitle("About");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(HomeActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(HomeActivity.this, "Fail", Toast.LENGTH_SHORT) .show();
            }
        });
        btBrowse = (Button) findViewById(R.id.buttonBrowse);
        btCalculator = (Button) findViewById(R.id.buttonCalculator);
        btFavorites = (Button) findViewById(R.id.buttonFavorites);
        btDocument = (Button) findViewById(R.id.buttonDocument);

        btBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when this button is clicked, show the alert
                alert.show();
            }
        });

        btCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when this button is clicked, show the alert
                alert.show();
            }
        });

        btFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when this button is clicked, show the alert

                //debug
                String oFavs = "";
                for(int i = 0; i < SessionCache.getFavorites().size(); i++){
                    oFavs += SessionCache.getFavorites().get(i);
                    oFavs += "\n";
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);

                builder.setMessage(oFavs)
                        .setTitle("YO FAVZ LIST");

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btDocument.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //when this button is clicked, show the alert
                alert.show();
            }
        });

        aboutLink = (TextView) findViewById(R.id.about);
        aboutLink.setMovementMethod(LinkMovementMethod.getInstance());
        contactLink = (TextView) findViewById(R.id.contact);
        contactLink.setMovementMethod(LinkMovementMethod.getInstance());

        //after button initialization fire our start up method
        OnStartUp();

    }

    public void OnStartUp(){
        //store whatever we may need on the fly in session cache. (probably wont be much
        //and may show to be unneeded eventually)
        SessionCache.Initialize();
        SerializationHelper.DeserializeFavorites(this); //maybe a bad idea passing this?
    }


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
