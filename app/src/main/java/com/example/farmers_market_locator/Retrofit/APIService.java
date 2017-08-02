package com.example.farmers_market_locator.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by maxrosado on 2/1/17.
 */

public interface APIService {
    @GET("resource/cdpt-29ur.json")
    Call<MainJSONObjects[]> pojoGetter(@Query("borough") String borough);
}
