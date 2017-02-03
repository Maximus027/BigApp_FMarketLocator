package com.example.bigapp_fmarket_locator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;

import com.example.bigapp_fmarket_locator.Retrofit.APIService;
import com.example.bigapp_fmarket_locator.Retrofit.MainJSONObjects;
import com.example.bigapp_fmarket_locator.Retrofit.RetrofitBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button goButton;
    private Spinner boroughChooser;
    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiService = RetrofitBuilder.makeService();

        Call<MainJSONObjects[]> mainPOJOCall = apiService.pojoGetter("Bronx");
        mainPOJOCall.enqueue(new Callback<MainJSONObjects[]>() {
            @Override
            public void onResponse(Call<MainJSONObjects[]> call, Response<MainJSONObjects[]> response) {
//            MainJSONObjects mainPOJO = response.body();
//            List<MainJSONObjects> animals = mainPOJO.getMarketName();
//            recyclerView.setAdapter(new MainJSONObjects(animals));
            }

            @Override
            public void onFailure(Call<MainJSONObjects[]> call, Throwable t) {
//            Log.d(TAG, "Failed!" + t);
            }
        });
    }

//    public void onClickMarketFinder(View view) {
//        boroughChooser = (Spinner) view.findViewById(R.id.planets_spinner);
//        goButton = (Button) view.findViewById(R.id.next_bt);
//
//        Intent intent = new Intent(this, MarketListActivity.class);
////        String borough = boroughChooser
//    }

}

