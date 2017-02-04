package com.example.bigapp_fmarket_locator.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bigapp_fmarket_locator.MapsActivity;
import com.example.bigapp_fmarket_locator.R;
import com.example.bigapp_fmarket_locator.Retrofit.MainJSONObjects;

/**
 * Created by maxrosado on 2/1/17.
 */

public class MarketViewHolder extends RecyclerView.ViewHolder {
    private TextView tv1;
    private TextView tv2;
    private MainJSONObjects vhMarket;
    private Button goButton;
    private Spinner boroughChooser;

    public MarketViewHolder(View itemView) {
        super(itemView);
        tv1 = (TextView) itemView.findViewById(R.id.market_name_tv);
        tv2 = (TextView) itemView.findViewById(R.id.borough_name_tv);

    }

    public void bind(final MainJSONObjects market) {
        //// TODO: set click listener to view. on click send to new activity send object using parcelable
        //// TODO: 2/3/17 (parceler) parcel library for android

        this.vhMarket = market;
        String marketName = market.getMarketName();
        String boroughName = market.getBorough();
        if (marketName != null) {
            tv1.setText(marketName);
        }
        if (marketName != null) {
            tv2.setText(boroughName);
        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapsActivity.startActivity(v.getContext(), vhMarket.getStreetAddress());
            }
        });
    }
}
