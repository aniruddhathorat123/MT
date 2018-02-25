package com.rishab.owner.mt;

import android.app.ActionBar;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class pandavleni_caves extends Activity {

    LocationManager lm;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pandavleni_caves);
        lm = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        ActionBar actionBar=getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    @Override
    public void onResume() {
        super.onResume();
//---PendingIntent to launch activity if the user is within
// some locations---
        pendingIntent = PendingIntent.getActivity(
                this, 0, new
                        Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("http://www.google.com")), 0);
        lm.addProximityAlert(20.997984,75.566711,2000, -1, pendingIntent);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        lm.removeProximityAlert(pendingIntent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pandavleni_caves, menu);
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
    public void pandavlenicavesmap(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Intent i = new Intent(this, tourist_place_map.class);
            i.putExtra("lat", 19.939792);
            i.putExtra("longi", 73.7459423);
            i.putExtra("place", "Pandavleni Caves");
            startActivity(i);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
    public void pandavlenicavesreach(View v) {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            Uri navigation = Uri.parse("google.navigation:q=Pandavleni+Caves,+Nasikh+India");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, navigation);
            // mapIntent.setPackage("com.google.android.apps.maps");
            // startActivity(mapIntent);
            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
            boolean isIntentSafe = activities.size() > 0;
            if (isIntentSafe) {
                startActivity(mapIntent);
            }
        } else {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
    public void pandavlenicavesreview(View v)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            Intent i = new Intent(this, Displaylistview.class);
            i.putExtra("place","pandavlenicavesreview");
            startActivity(i);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
}
