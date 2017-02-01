package com.example.bigapp_fmarket_locator.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by maxrosado on 2/1/17.
 */

public interface APIService {
    @GET("resource/cdpt-29ur.json")
    Call<MainJSONObjects> pojoGetter();
}
