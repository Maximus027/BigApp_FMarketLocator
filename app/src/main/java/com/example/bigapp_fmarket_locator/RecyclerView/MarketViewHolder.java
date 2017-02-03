package com.example.bigapp_fmarket_locator.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

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
    }

    public void bind (final MainJSONObjects market) {
        this.vhMarket = market;
        String marketName = market.getMarketName();
        if (marketName != null) {
            tv1.setText(marketName);
        }
    }


}
