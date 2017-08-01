package com.example.farmers_market_locator.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maxrosado on 2/1/17.
 */

public class RetrofitBuilder {
    private static final String baseURL = "http://data.cityofnewyork.us";
    private static Retrofit retrofit;
    private static Retrofit.Builder builder;

    public static APIService makeService() {
        if (retrofit == null) {
            builder = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create());
        }
        retrofit = builder.build();
        return retrofit.create(APIService.class);
    }
}
