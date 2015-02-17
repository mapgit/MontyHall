package com.montyhall;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set the layout xml linked with this Activity
        setContentView(R.layout.activity_main);

        //Get the button from the view
        Button b1 = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);
        Button b3 = (Button) findViewById(R.id.button3);

        //Create an onClickListener
        View.OnClickListener l = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get the button text
                String button_text = ((Button)v).getText().toString();

                //Create an intent for starting ResultActivity
                Intent i = new Intent(v.getContext(), ResultActivity.class);

                //Put the button text as a String Extra with the intent
                i.putExtra(ResultActivity.EXTRA_WHICH_DOOR, button_text);

                //Start activity using the intent
                startActivity(i);
            }
        };

        //Assign the onClickListener to all buttons
        b1.setOnClickListener(l);
        b2.setOnClickListener(l);
        b3.setOnClickListener(l);
    }
}