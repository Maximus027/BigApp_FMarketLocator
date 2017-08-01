package com.example.farmers_market_locator.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmers_market_locator.R;
import com.example.farmers_market_locator.Retrofit.MainJSONObjects;

/**
 * Created by maxrosado on 2/1/17.
 */

public class MarketAdapter extends RecyclerView.Adapter {
    public MainJSONObjects[] markets;

    public MarketAdapter(MainJSONObjects[] markets) {
        this.markets = markets;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.rcv_item_layout, parent, false);
        return new MarketViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainJSONObjects market = markets[position];
        MarketViewHolder marketViewHolder = (MarketViewHolder) holder;
        marketViewHolder.bind(market);
    }

    @Override
    public int getItemCount() {
        if (markets == null) return 0;
        return markets.length;
    }
}

