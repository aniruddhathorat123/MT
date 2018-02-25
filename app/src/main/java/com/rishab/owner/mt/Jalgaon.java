package com.rishab.owner.mt;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class Jalgaon extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jalgaon);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jalgaon, menu);
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

    public void gandhi_tirth_des(View v)
    {
        Intent i=new Intent(this,Gandhi_Tirth.class);
        startActivity(i);
    }
    public void ajanta_des(View v)
    {
        Intent i=new Intent(this,ajanta.class);
        startActivity(i);
    }
    public void manudevi_des(View v)
    {
        Intent i=new Intent(this,manudevi.class);
        startActivity(i);
    }
    public void padmalaya_des(View v)
    {
        Intent i=new Intent(this,padmalya.class);
        startActivity(i);
    }
    public void jalgaonhotels(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri gmmIntentUri = Uri.parse("geo:20.9900844 , 75.5754232?q=Hotels");
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
    public void jalgaonresturants(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri gmmIntentUri = Uri.parse("geo:20.9900844 , 75.5754232?q=restaurants");
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
    public void jalrailway(View v)
    {
        Intent i = new Intent(this,RList.class);
        i.putExtra("place","jl");
        startActivity(i);
    }

}
