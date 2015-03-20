package edu.sc.cse.adausc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

/**
 * Created by David on 3/20/2015.
 */
public class QRbathroom extends Activity {

    TextView content1;
    TextView content2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_bathroom);

        //enable return to home from action bar
        getActionBar().setDisplayHomeAsUpEnabled(true);

        content1 = (TextView) findViewById(R.id.contentTextView1);
        content2 = (TextView) findViewById(R.id.contentTextView2);

        content1.setVisibility(View.GONE);
        content2.setVisibility(View.GONE);
    }

    public void toggle_contents(View view1){
        content1.setVisibility(content1.isShown()
        ? View.GONE
        : View.VISIBLE);

        content1.setText("Toilets must be positioned with a wall to the rear and to one side. \n" +
                "\n" +
                "The center of the toilet must be 16 to 18 inches from the side wall or partition. \n" +
                "\n" +
                "Clearance must be 60 inches minimum perpendicular from the side wall and 56 inches minimum perpendicular from the rear wall for wall hung toilets or 59 inches minimum for floor mounted toilets. For children, the stall should be 60 inches wide and 59 inches deep minimum. \n" +
                "\n" +
                "Seat height must be 17 inches minimum and 19 inches maximum from the floor for adults.\n" +
                "\n" +
                "The side wall grab bar must be 42 inches long minimum and be placed a maximum of 12 inches from the rear wall.\n" +
                "\n" +
                "The rear wall grab bar must be 36 inches long minimum and extend from the center of the toilet 12 inches minimum on one side and 24 inches on the other. \n" +
                "\n" +
                "Doors can only be in the front or side partition of the stall. They must open outward, be 32 or 36 inches wide, be self-closing and a maximum of 4 inches from the side wall or partition farthest from the toilet. \n");
    }

    public void toggle_contents2(View view2) {
        content2.setVisibility(content2.isShown()
        ? View.GONE
        : View.VISIBLE);

        content2.setText("Ambulatory stalls are for people who walk with the assistance of canes or crutches.\n" +
                "\n" +
                "Center of the toilet must be 17 to 19 inches from the side wall or partition. \n" +
                "\n" +
                "Seat height must be 11 inches minimum and 17 inches maximum from the floor.\n" +
                "\n" +
                "Toilets must be positioned with a wall to the rear and on each side.\n" +
                "\n" +
                "Stall must have a depth of 60 inches minimum (from the back wall to the partition/door) and width of 35 inches minimum and 37 inches maximum. \n" +
                "\n" +
                "Grab bars on each side of the stall. Each bar should measure 42 inches long minimum and be located a maximum of 12 inches from the rear wall.\n" +
                "\n" +
                "Doors must swing outward, be self-closing, and have a 32 inch door. \n");
    }
}
