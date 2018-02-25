package com.rishab.owner.mt;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class Rankala_lake extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankala_lake);
        ActionBar actionBar=getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rankala_lake, menu);
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
    public void rankalalakemap(View v)
    {

        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
        Intent i=new Intent(this,tourist_place_map.class);
        i.putExtra("lat",16.6887229);
        i.putExtra("longi",74.2108065);
        i.putExtra("place","Rankala Lake");
        startActivity(i);
        }
        else {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
    public void rankalalakereach(View v)
    {
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
            Uri navigation = Uri.parse("google.navigation:q=Rankala+Lake+Kolhapur+India");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, navigation);
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
    public void  rankalalakereview(View v)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            Intent i = new Intent(this, Displaylistview.class);
            i.putExtra("place", "rankalalakereview");
            startActivity(i);
        }
        else
        {
            Toast.makeText(getBaseContext(), "Please Connect to Internet", Toast.LENGTH_SHORT).show();
        }
    }
}
