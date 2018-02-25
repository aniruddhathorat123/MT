package com.rishab.owner.mt;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;


public class pune extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pune);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pune, menu);
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
    public void agakhanpalace(View v)
    {
        Intent i=new Intent(this,agakhanpalace.class);
        startActivity(i);
    }
    public void alandi_des(View v)
    {
        Intent i=new Intent(this,Alandi.class);
        startActivity(i);
    }
    public void dehu_des(View v)
    {
        Intent i=new Intent(this,Dehu.class);
        startActivity(i);
    }
    public void katrajzoo_des(View v)
    {
        Intent i=new Intent(this,Katrajzoo.class);
        startActivity(i);
    }
    public void kelkarmuseum_des(View v)
    {
        Intent i=new Intent(this,Kelkarmuseum.class);
        startActivity(i);
    }
    public void ranjangaon_des(View v)
    {
        Intent i=new Intent(this,Ranjangaon.class);
        startActivity(i);
    }
    public void shaniwarwada_des(View v)
    {
        Intent i=new Intent(this,Shaniwarwada.class);
        startActivity(i);
    }
    public void shivnery(View v)
    {
        Intent i=new Intent(this,Shivnery.class);
        startActivity(i);
    }
    public void lonavla_des(View v)
    {
        Intent i=new Intent(this,lonalva.class);
        startActivity(i);
    }
    public void punehotels(View v)
    {
        Uri gmmIntentUri = Uri.parse("geo:18.5247663,73.7929274?q=Hotels");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(mapIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if(isIntentSafe)
        {
            startActivity(mapIntent);
        }
    }
    public void puneresturants(View v)
    {
        Uri gmmIntentUri = Uri.parse("geo:18.5247663,73.7929274?q=restaurants");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        PackageManager packageManager = getPackageManager();
        List activities = packageManager.queryIntentActivities(mapIntent,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if(isIntentSafe)
        {
            startActivity(mapIntent);
        }
    }
    public void punerailway(View v)
    {
        Intent i = new Intent(this,RList.class);
        i.putExtra("place","PUNE");
        startActivity(i);
    }
}
