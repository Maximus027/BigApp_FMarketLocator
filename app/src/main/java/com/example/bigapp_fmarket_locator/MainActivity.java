package com.example.bigapp_fmarket_locator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    ImageView beeImage;
    // Animation
    Animation animMovein;



    public String borough = "";
    private Spinner boroughChooser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Animation
        beeImage = (ImageView)findViewById(R.id.bee_im) ;
        boroughChooser = (Spinner) findViewById(R.id.planets_spinner);

        // load the animation
        animMovein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if(hasFocus){
           //beeImage.startAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.slide_in_left|android.R.anim.fade_in));
           // start the animation
            beeImage.startAnimation(animMovein);

        }
    }

    public void startMarketActivity(View view) {
        borough = boroughChooser.getSelectedItem().toString();
        Intent intent = new Intent(this, MarketListActivity.class);
        intent.putExtra(getString(R.string.chosen_borough_key), borough);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_icon, menu);
        return super.onCreateOptionsMenu(menu);
    }
}

