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

public class Mumbai extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mumbai);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mumbai, menu);
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

    public void gatewayofindiades(View v)
    {
        Intent i=new Intent(this,gate_way_of_india.class);
        startActivity(i);
    }
    public void elephantacavesdes(View v)
    {
        Intent i=new Intent(this,elephanta_caves.class);
        startActivity(i);
    }
    public void chhatrapatishivajimuseumdes(View v)
    {
        Intent i=new Intent(this,chhatrapati_shivaji_museum.class);
        startActivity(i);
    }
    public void juhubeachdes(View v)
    {
        Intent i=new Intent(this,juhu_beach.class);
        startActivity(i);
    }
    public void sanjaygandhinationalparkdes(View v)
    {
        Intent i=new Intent(this,sanjay_gandhi_national_park.class);
        startActivity(i);
    }
    public void tajhoteldes(View v)
    {
        Intent i=new Intent(this,taj_hotel.class);
        startActivity(i);
    }
    public void chhatrapatishivajiterminusdes(View v)
    {
        Intent intent=new Intent(this,chhatrapati_shivaji_terminus.class);
        startActivity(intent);
    }
    public void mumbaihotels(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri gmmIntentUri = Uri.parse("geo:19.0821978,72.741118?q=Hotels");
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
    public void mumbairesturants(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri gmmIntentUri = Uri.parse("geo:19.0821978,72.741118?q=restaurants");
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
            Toast.makeText(getBaseContext(), "Please Connect to Internet",Toast.LENGTH_SHORT).show();
        }
    }
    public void mumbairailway(View v)
    {
        Intent i = new Intent(this,RList.class);
        i.putExtra("place","ltt");
        startActivity(i);
    }
}
