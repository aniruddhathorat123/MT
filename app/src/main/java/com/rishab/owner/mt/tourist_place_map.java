package com.rishab.owner.mt;

import android.app.ActionBar;
import android.content.Intent;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class tourist_place_map extends FragmentActivity {


    private GoogleMap touristMap;                                                       //(Rishab) GoggleMap Might be null if Google Play services APK is not available.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i=getIntent();
        double lati=i.getDoubleExtra("lat", 0.0);
        double longi=i.getExtras().getDouble("longi", 0.0);
        final String title=i.getExtras().getString("place", "Error in Loading!!!!");
        final LatLng latlong=new LatLng(lati,longi);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourist_place_map);
        setUpMapIfNeeded();
        touristMap.setMyLocationEnabled(true);
       /* Location mylocn = touristMap.getMyLocation();
        mylocn.getLatitude();
        mylocn.getLongitude();*/
        touristMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        MarkerOptions marker = new MarkerOptions().position(latlong).title(title);
        touristMap.addMarker(marker);
        touristMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latlong, 15));
    }
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }


    /****
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #touristMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (touristMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            touristMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.*/
            if (touristMap != null) {
               /* LatLng lt =new LatLng(100,100);
                MarkerOptions mo=new MarkerOptions().position(lt).title("data");
                touristMap.addMarker(mo);*/

            }
        }
    }



    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #touristMap} is not null.
     */
    private void setUpMap() {
        touristMap.addMarker(new MarkerOptions().position(new LatLng(0, 0)).title("Marker"));
    }
}
