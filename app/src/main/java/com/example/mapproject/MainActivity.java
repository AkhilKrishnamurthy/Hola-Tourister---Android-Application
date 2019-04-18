package com.example.mapproject;

import android.content.Context;
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
            String HotelAndRating = entry.getValue() + " - " + entry.getKey();
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
        searchLocation();
    }


    public List<Address> addressList = null;
    public void searchLocation() {
//        EditText locationSearch = (EditText) findViewById(R.id.editText);
        String location = "Americania Hotel";
        Log.d("America", location);
    }
}