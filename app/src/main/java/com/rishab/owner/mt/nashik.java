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

public class nashik extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nashik);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nashik, menu);
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
    public void trimbakeshwar_des(View v)
    {
        Intent i=new Intent(this,trimbakeshwar.class);
        startActivity(i);
    }
    public void pandavlenicaves_des(View v)
    {
        Intent i=new Intent(this,pandavleni_caves.class);
        startActivity(i);

    }
    public void muktidham_des(View v)
    {
        Intent intent=new Intent(this,muktidham.class);
        startActivity(intent);
    }
    public void nashikhotels(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri gmmIntentUri = Uri.parse("geo:19.9911106,73.7334409?q=Hotels");
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
    public void nashikresturants(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri gmmIntentUri = Uri.parse("geo:19.9911106,73.7334409?q=resturants");
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
    public void nakrailway(View v)
    {
        Intent i = new Intent(this,RList.class);
        i.putExtra("place","nk");
        startActivity(i);
    }
}
