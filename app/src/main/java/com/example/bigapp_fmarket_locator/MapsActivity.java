package com.example.bigapp_fmarket_locator;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    public static final String EXTRA_MARKET_NAME = "extra_market_name";


    private GoogleMap mMap;
    private GoogleApiClient mgoogleApiClient;
    private String marketName;
    private EditText et;
    private String address;

    public static void startActivity(Context context, String marketName) {
        Intent intent = new Intent(context, MapsActivity.class);
        context.startActivity(intent.putExtra(EXTRA_MARKET_NAME, marketName));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        marketName = getIntent().getStringExtra(EXTRA_MARKET_NAME);
        et = (EditText) findViewById(R.id.edit_text);

        if (marketName != null) {
            et.setText(marketName);
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button button = (Button) findViewById(R.id.find_location_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = et.getText().toString();
                Log.d("location", "geoLocate: "+location);
                try {
                    geoLocateByString(location);
                }catch(IllegalStateException e){
                    Log.d("location", "geoLocate: " +e);
                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        gotToLocationZoom(40.739194, -73.930890, 15);
    }

    public void gotToLocation(double lat, double lng) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLng(ll);
        mMap.moveCamera(update);

    }

    private void gotToLocationZoom(double lat, double lng, float zoom) {
        LatLng ll = new LatLng(lat, lng);
        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll, zoom);
        mMap.moveCamera(update);
    }

    void geoLocateByString(String location)  {

        Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);
        double LATITUDE = 40.730610;
        double LONGITUDE = -73.935242;

        String address = "";

        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE,LONGITUDE, 1);

            if(addresses != null && addresses.size() > 0) {
                Address returnedAddress = addresses.get(0);
                Log.d("LAT2", returnedAddress.getLatitude()+"");

                StringBuilder strReturnedAddress = new StringBuilder(location +" ");
                for(int i=0; i<returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }

                Log.d("RESULT", strReturnedAddress.toString());
                address = strReturnedAddress.toString();

                Log.d("locality", "geoLocateByString: " +returnedAddress.getLocality());

                Toast.makeText(this, address , Toast.LENGTH_LONG).show();

                double lat = returnedAddress.getLatitude();
                Log.d("LAT", returnedAddress.getLatitude()+"");
                double lng = returnedAddress.getLongitude();
                gotToLocationZoom(lat, lng, 15);


                MarkerOptions options = new MarkerOptions().title(address).position(new LatLng (lat, lng));
                mMap.addMarker((options));


            }
            else{
                Log.d("NO-RESULT","NO-RESULT");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            Log.d("NO-RESULT","NO-RESULT");
        }
    }

    LocationRequest mLocationRequest;

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mgoogleApiClient, mLocationRequest, this);

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        if (location == null) {
            Toast.makeText(this, "can't get current location", Toast.LENGTH_LONG).show();
        } else {
            LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());

        }

    }
}
