package com.example.bigapp_fmarket_locator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {
    public String borough = "";
    private Spinner boroughChooser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boroughChooser = (Spinner) findViewById(R.id.planets_spinner);
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

