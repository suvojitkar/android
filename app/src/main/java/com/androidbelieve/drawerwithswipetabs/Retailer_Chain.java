package com.androidbelieve.drawerwithswipetabs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Retailer_Chain extends AppCompatActivity {

    static  final LatLng one = new LatLng(12.8236,80.0442);
    static  final LatLng two = new LatLng(12.8100,80.1250);
    static  final LatLng three = new LatLng(12.8000,80.0442);


    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer__chain);

        map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

        Marker o = map.addMarker(new MarkerOptions().position(one).title("Chennai One").snippet("This is retailer one."));
        Marker t = map.addMarker(new MarkerOptions().position(two).title("Chennai Two").snippet("This is retailer two."));
        Marker th = map.addMarker(new MarkerOptions().position(three).title("Chennai Three").snippet("This is retailer three."));

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(one, 15));
        map.animateCamera(CameraUpdateFactory.zoomTo(10),2000,null);
    }
}
