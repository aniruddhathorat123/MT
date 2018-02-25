package com.rishab.owner.mt;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class Gandhi_Tirth extends Activity {

   /* public static final String Extra_message_gandhi="com.rishab.owner.mt";*/

    double latitude;
    double lng;
    LocationManager locationManager;
    String addressString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gandhi__tirth);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gandhi__tirth, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void gandhiteerthmap(View view) {
           /* Uri location = Uri.parse("geo:20.94,75.55?q="+Uri.encode("Gandhi Research Foundation"));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
            boolean isIntentSafe = activities.size() > 0;
            if (isIntentSafe) {
                startActivity(mapIntent);
            }*/
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Intent i = new Intent(this, tourist_place_map.class);
            i.putExtra("lat", 20.9449714);
            i.putExtra("longi", 75.555130);
            i.putExtra("place", "Gandhi Teerth");
            startActivity(i);
        }
        else {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }

    public void gandhiteerthreach(View v) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            Uri navigation = Uri.parse("google.navigation:q=Gandhi+Teerth,+Jalgaon+India");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, navigation);
            // mapIntent.setPackage("com.google.android.apps.maps");
            // startActivity(mapIntent);
            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
            boolean isIntentSafe = activities.size() > 0;
            if (isIntentSafe) {
                startActivity(mapIntent);
            }
        }
        else
        {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
    public void gandhiteerthreview(View v)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            Intent i = new Intent(this, Displaylistview.class);
            i.putExtra("place", "gandhiteerthreview");
            startActivity(i);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }



        /*
        String location_context = Context.LOCATION_SERVICE;
        locationManager  = (LocationManager) getSystemService(location_context);
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();                                                    //(Rishab) used to get information about Active Network connecte dto mobile
        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) )                                           //(Rishab) this method is used to chech wether GPS is enabled or not
        {
            Toast.makeText(getBaseContext(), "GPS is Disabled Enable it", Toast.LENGTH_LONG).show();
        }
        else if(info==null)                                                                                          //(Rishab) if object info is null mobile is disconnected else connected
        {
            Toast.makeText(getBaseContext(),"Your Mobile is not Connected",Toast.LENGTH_LONG).show();
        }
        else{
        testProviders();
            Toast.makeText(getApplicationContext(),"Getting location Please Wait",Toast.LENGTH_LONG).show();
        }
    }

    public void testProviders() {
        List<String> providers = locationManager.getProviders(true);
        for (String provider : providers) {
            locationManager.requestLocationUpdates(provider, 1000, 0,
                    new LocationListener() {
                        public void onLocationChanged(Location location) {
                        }

                        public void onProviderDisabled(String provider) {
                        }

                        public void onProviderEnabled(String provider) {
                        }

                        public void onStatusChanged(String provider, int status,
                                                    Bundle extras) {
                        }
                    });


            Location location = locationManager.getLastKnownLocation(provider);
            if (location != null) {
                latitude = location.getLatitude();
                lng = location.getLongitude();
                Geocoder gc = new Geocoder(this, Locale.getDefault());
                try{
                List<Address> addresses = gc.getFromLocation(latitude, lng, 1);
                StringBuilder sb1 = new StringBuilder();
                if (addresses.size() > 0) {
                    Address address = addresses.get(0);
                    for (int i = 0; i < address.getMaxAddressLineIndex(); i++)
                        sb1.append(address.getAddressLine(i)).append(",");
                }
                addressString = sb1.toString();}
                catch (IOException e)
                {

                }

                    Intent  i = new Intent(this, tourist_place_map.class);
                i.putExtra("lat", latitude);
                i.putExtra("longi", lng);
                i.putExtra("place",addressString);
                if(addressString==null)
                {
                    Toast.makeText(getApplicationContext(),"Unable to find location",Toast.LENGTH_LONG).show();
                }
                else{
                startActivity(i);}
            } else {
            }
        }
    }*/
}
