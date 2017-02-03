package com.example.bigapp_fmarket_locator.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.bigapp_fmarket_locator.R;
import com.example.bigapp_fmarket_locator.Retrofit.MainJSONObjects;

import java.util.List;

/**
 * Created by maxrosado on 2/1/17.
 */

public class MarketAdapter extends RecyclerView.Adapter {
    public List<MainJSONObjects> markets;

    public MarketAdapter(List<MainJSONObjects> markets) {
        this.markets = markets;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MarketViewHolder(LayoutInflater
        .from(parent.getContext())
                .inflate(R.layout.rcv_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainJSONObjects market = markets.get(position);
        MarketViewHolder marketViewHolder = (MarketViewHolder) holder;
        marketViewHolder.bind(market);
    }

    @Override
    public int getItemCount() {
        if (markets == null) return 0;
        return markets.size();
    }
}

