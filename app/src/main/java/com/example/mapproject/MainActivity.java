package com.example.mapproject;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Context;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List l1 = MapsActivity.placesList;
//        TreeMap<String, Integer> ratingMap = new TreeMap<>();
        TreeMap<String, String> ratingMap = new TreeMap<>();
        for(int i=0;i<l1.size();i++) {
            Map<String, String> rest = (Map<String, String>) l1.get(i);
            if(ratingMap.containsValue(rest.get("rating"))) {
                ratingMap.put(rest.get("place_name").toString(), rest.get("rating").toString() + " ");
            }
            else ratingMap.put(rest.get("place_name"), rest.get("rating").toString());
        }

        for(Map.Entry<String,String> entry : ratingMap.entrySet()) {

            Log.d("Recycler View ", entry.getKey());
            Log.d("rating type list122", entry.getValue());
        }
        // data to populate the RecyclerView with
        ArrayList<String> animalNames = new ArrayList<>();
        for(Map.Entry<String,String> entry : ratingMap.entrySet()) {
            //String HotelAndRating = entry.getValue() + " - " + entry.getKey();
            String HotelAndRating = entry.getKey() + ": Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type";
            animalNames.add(HotelAndRating);
        }

        // set up the RecyclerView
        for(int i=0;i<l1.size();i++) {
            Log.d("the final list l1", l1.get(i).toString());
        }
        Log.d("the final list is ", Integer.toString(ratingMap.size()));
        RecyclerView recyclerView = findViewById(R.id.rvAnimals);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, animalNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
//        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        Intent navigate = new Intent(this,SecondMapPage.class);
        navigate.putExtra("location11111", adapter.getItem(position));
        startActivity(navigate);
//        m1.searchLocation1(adapter.getItem(position));
    }

    public List<Address> addressList = null;
//    public void searchLocation(String name) {
////        EditText locationSearch = (EditText) findViewById(R.id.editText);
//        String location = name;
//        Log.d("America", name);
//        addressList = null;
//        boolean connected = false, location1 = false;
//
//        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//            location1 = true;
//        }
//        else location1 = false;
//        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
//        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
//                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
//            //we are connected to a network
//            connected = true;
//        }
//        else connected = false;
//        Log.d("network state is", String.valueOf(connected));
//        if(location.length()<=0 || location==null || location.equals("") || connected==false || location1==false) {
////            Snackbar.make(view, "Invalid location or no internet connection", Snackbar.LENGTH_SHORT)
////                    .setAction("Action", null).show();
//        }
//
//        else if (location != null || !location.equals("")) {
//            Geocoder geocoder = new Geocoder(this);
//            try {
//                addressList = geocoder.getFromLocationName(location, 5);
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            mMap.clear();
//            Address address = addressList.get(0);
//            LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
//            mMap.addMarker(new MarkerOptions().position(latLng).title(location));
//            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
//            Toast.makeText(getApplicationContext(),address.getLatitude()+" "+address.getLongitude(),Toast.LENGTH_LONG).show();
//        }
//    }
}