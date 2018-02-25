package com.rishab.owner.mt;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class Kolhapur extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kolhapur);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kolhapur, menu);
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
    public void jyotiba_des(View v)
    {
        Intent i=new Intent(this,jyotiba_temple.class);
        startActivity(i);
    }
    public void mahalaxmi_des(View v)
    {
        Intent i=new Intent(this,Mahalaxmi.class);
        startActivity(i);
    }
    public void panhalafort_des(View v)
    {
        Intent i=new Intent(this,Panhala_fort.class);
        startActivity(i);
    }
    public void rankalalake_des(View v)
    {
        Intent i=new Intent(this,Rankala_lake.class);
        startActivity(i);
    }
    public void kolhapurhotels(View v)
    {
        Uri location = Uri.parse("geo:16.7085478,74.2038484?q=Hotels");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size()>0;
        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }
    public void kolhapurresturants(View v)
    {
        Uri location = Uri.parse("geo:16.7085478,74.2038484?q=resturants");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        PackageManager packageManager = getPackageManager();
        List<ResolveInfo> activities = packageManager.queryIntentActivities(mapIntent, 0);
        boolean isIntentSafe = activities.size()>0;
        if (isIntentSafe) {
            startActivity(mapIntent);
        }
    }
    public void kolhapurrailway(View v)
    {
        Intent i = new Intent(this,RList.class);
        i.putExtra("place","KOP");
        startActivity(i);
    }
}
