package com.example.mapproject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class NearByCafes extends Activity {

    @SuppressLint("LongLogTag")
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.near_by_cafes);
//        List l1 = DataParser.placesList;
        List l1 = MapsActivity.placesList;
        Log.d("logging the places list222", Integer.toString(l1.size()));
        List<String> places = new ArrayList<String>();
        List<String> rating = new ArrayList<String>();
//        TreeMap<String, Integer> ratingMap = new TreeMap<>();
        TreeMap<String, String> ratingMap = new TreeMap<>();
        int rate = 0;
        for(int i=0;i<l1.size();i++) {
            rate = 0;
            JSONObject restaurant = (JSONObject) l1.get(i);
            Map<String, String> rest = (Map<String, String>) l1.get(i);
            places.add(rest.get("place_name"));
            rating.add(rest.get("rating"));
            ratingMap.put(rest.get("rating"), rest.get("place_name").toString());
        }

        for(Map.Entry<String,String> entry : ratingMap.entrySet()) {

            Log.d("place_name type list122", entry.getKey());
            Log.d("rating type list122", entry.getValue());
        }





    }
}
