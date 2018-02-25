package com.rishab.owner.mt;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class Nagpur extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nagpur);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nagpur, menu);
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
    public void deekshabhoomi_des(View v)
    {
        Intent i=new Intent(this,deekshabhoomi.class);
        startActivity(i);
    }
    public void tadobanationalpark_des(View v)
    {
        Intent i=new Intent(this,tadoba_national_park.class);
        startActivity(i);
    }
    public void dragonpalace_des(View v)
    {
        Intent i=new Intent(this,dragon_palace.class);
        startActivity(i);
    }
    public void maharajbaghzoo_des(View v)
    {
        Intent i=new Intent(this,maharaj_bagh_zoo.class);
        startActivity(i);
    }
    public void ramansciencecentre_des(View v)
    {
        Intent i=new Intent(this,raman_science_center.class);
        startActivity(i);
    }
    public void nagpurhotels(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri gmmIntentUri = Uri.parse("geo:21.1612315,79.0024702?q=Hotels");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            PackageManager packageManager = getPackageManager();
            List activities = packageManager.queryIntentActivities(mapIntent,
                    PackageManager.MATCH_DEFAULT_ONLY);
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
    public void nagpurresturants(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri gmmIntentUri = Uri.parse("geo:21.1612315,79.0024702?q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            PackageManager packageManager = getPackageManager();
            List activities = packageManager.queryIntentActivities(mapIntent,
                    PackageManager.MATCH_DEFAULT_ONLY);
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
    public void nagpurrailway(View v)
    {
        Intent i = new Intent(this,RList.class);
        i.putExtra("place","ngp");
        startActivity(i);
    }
}
