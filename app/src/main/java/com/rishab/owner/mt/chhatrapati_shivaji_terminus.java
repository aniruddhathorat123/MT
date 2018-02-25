package com.rishab.owner.mt;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class chhatrapati_shivaji_terminus extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chhatrapati_shivaji_terminus);
        ActionBar actionBar=getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chhatrapati_shivaji_terminus, menu);
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
    public void chhatrapatishivajiterminusmap(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Intent i = new Intent(this, tourist_place_map.class);
            i.putExtra("lat", 18.9398259);
            i.putExtra("longi", 72.8332789);
            i.putExtra("place", "Chhatrapati Shivaji Terminus");
            startActivity(i);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
    public void chhatrapatishivajiterminusreach(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri navigation = Uri.parse("google.navigation:q=Chhatrapati+Shivaji+Terminus,+Mumbai+India");
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
        else {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
    public void chhatrapatishivajiterminusreview(View v)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            Intent i = new Intent(this, Displaylistview.class);
            i.putExtra("place", "chhatrapatishivajiterminusreview");
            startActivity(i);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
}
