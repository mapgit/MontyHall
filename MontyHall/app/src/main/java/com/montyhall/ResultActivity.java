package com.montyhall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class ResultActivity extends Activity {

    public static final String EXTRA_WHICH_DOOR = "which_door", BUTTON_PRESSED = "button_pressed";
    private static String whichDoor;
    private static boolean buttonPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the layout xml linked with this Activity
        setContentView(R.layout.activity_result);

        //Get the intent which was responsible for starting this activity
        Intent intent = getIntent();

        //Get the String Extra which was attached along with the intent
        whichDoor = getIntent().getStringExtra(ResultActivity.EXTRA_WHICH_DOOR);

        //Get the button from view
        Button b4 = (Button) findViewById(R.id.button4);

        /*
         * If any data is present in savedInstanceState then check if the button is pressed
         * If it is pressed, then get saved string which represents EXTRA_WHICH_DOOR and set that as
         * text for button4
         */
        if(savedInstanceState!=null)
        {
            buttonPressed = savedInstanceState.getBoolean(ResultActivity.BUTTON_PRESSED);
            if(buttonPressed) {
                whichDoor = savedInstanceState.getString(ResultActivity.EXTRA_WHICH_DOOR);
                b4.setText(whichDoor);
            }
        }

        //Set setOnClickListener for button4
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed = true;
                ((Button)v).setText(whichDoor);
            }
        });
    }

    /*
     * This method is called automatically when the activity is about to be destroyed (not always)
     * and the state of the activity needs to be saved
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ResultActivity.BUTTON_PRESSED, buttonPressed);
        outState.putString(ResultActivity.EXTRA_WHICH_DOOR, whichDoor);
    }
}
