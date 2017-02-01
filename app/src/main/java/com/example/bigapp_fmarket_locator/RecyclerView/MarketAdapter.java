package com.example.bigapp_fmarket_locator.RecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.bigapp_fmarket_locator.Retrofit.MainJSONObjects;

import java.util.List;

/**
 * Created by maxrosado on 2/1/17.
 */

public class MarketAdapter extends RecyclerView.Adapter {
    public List<MainJSONObjects> markets;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

