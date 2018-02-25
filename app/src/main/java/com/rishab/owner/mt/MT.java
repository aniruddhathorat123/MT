package com.rishab.owner.mt;

import android.app.Activity;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.Toast;

import org.apache.http.protocol.HTTP;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MT extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mt);
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info=connectivityManager.getActiveNetworkInfo();
        if(info!=null&&info.isConnected()) {
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Connect to Internet!!",Toast.LENGTH_LONG).show();
        }

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments                   //(RISHAB) this method is used to select which fragment to display on the click event
        Fragment objFragment=null;
        switch (position){
            case 0:
                objFragment=new menu_home();
                break;
            case 1:
                objFragment=new menu_selectcity();
                break;
            case 2:
                objFragment=new menu_feedback();
                break;
            case 3:
                objFragment=new menu_feedback();
                break;
        }
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container,objFragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle=getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
       // actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.mt, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.menu_selectcity, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MT) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }
    public void feedback(View v)
    {
        String deviceModel = android.os.Build.MODEL;                                                                          //(Rishab)android.os.model is used to get the model of device for eg-GT-18552
        int sdk= Build.VERSION.SDK_INT;                                                                         //(Rishab)android.os.Build.VERSION.SDK is ued to get version(Api level)of device eg-16
        Intent emailFeedback = new Intent(Intent.ACTION_SEND);
        emailFeedback.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");                                                                                                                        // (Rishab)The intent does not have a URI, so declare the "text/plain" MIME type
        emailFeedback.setType(HTTP.PLAIN_TEXT_TYPE);
        emailFeedback.putExtra(Intent.EXTRA_EMAIL, new String[]{"tourismmdeveloper@gmail.com"});                                  //  (Rishab)recipients to whch mail is to be sent
        emailFeedback.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
        emailFeedback.putExtra(Intent.EXTRA_TEXT, "Tourism Maharashtra is Nice App"+"\n"+ "Love it !!!!!"+"\n"+"\n"+"----------------------------------------------"+"\n"
                +"DEVICE INFORMATION"+"\n"+"Android Device Model- "+deviceModel+"\n"+"Android Build Version- "+sdk+"\n"+"----------------------------------------------");
      /*  PackageManager packageManager=getPackageManager();
        List activities = packageManager.queryIntentActivities(emailFeedback,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if(isIntentSafe) {
            startActivity(emailFeedback);
        }          */                                                                                                                     // WE can also attach multiple items by passing an ArrayList of Uris
        startActivity(emailFeedback);
    }

    public void reportInaccuracy(View v)
    {

        String deviceModel = android.os.Build.MODEL;
        int sdk= Build.VERSION.SDK_INT;
        Intent reportinaccuracy = new Intent(Intent.ACTION_VIEW);
        reportinaccuracy.setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail");                    //(Rishab) this is used to set Gmail Compose Activity
        reportinaccuracy.setType(HTTP.PLAIN_TEXT_TYPE);
        reportinaccuracy.putExtra(Intent.EXTRA_EMAIL, new String[]{"tourismmdeveloper@gmail.com"});
        reportinaccuracy.putExtra(Intent.EXTRA_SUBJECT,"Report InAccuracy");
        reportinaccuracy.putExtra(Intent.EXTRA_TEXT, "--------------------------------------"
                +"DEVICE INFORMATION"+"\n"+"\n"+"Device Model- "+deviceModel+"\n"+"Android Build Version- "+sdk+"\n"+"--------------------------------------");
      /*  PackageManager packageManager=getPackageManager();
        List activities = packageManager.queryIntentActivities(reportinaccuracy,
                PackageManager.MATCH_DEFAULT_ONLY);
        boolean isIntentSafe = activities.size() > 0;
        if(isIntentSafe) {
            startActivity(reportinaccuracy);
        }*/
        startActivity(reportinaccuracy);
    }

   public void jal(View v)
    {
       Intent i=new Intent(this,Jalgaon.class);
        startActivity(i);

    }
    public void mumbai(View v)
    {
        Intent i=new Intent(this,Mumbai.class);
        startActivity(i);
    }
    public void nashik(View v)
    {
        Intent i=new Intent(this,nashik.class);
        startActivity(i);
    }
    public void nagpur(View v)
    {
        Intent i=new Intent(this,Nagpur.class);
        startActivity(i);
    }
    public void kolhapur(View v)
    {
        Intent i=new Intent(this,Kolhapur.class);
        startActivity(i);
    }
    public void pune(View v)
    {
        startActivity(new Intent(this,pune.class));
    }
    public void tadobanationalpark(View v)
    {
       Intent i= new Intent(this,tadoba_national_park.class);
        startActivity(i);
    }
    public void sanjaygandhinationalpark(View view)
    {
        Intent intent=new Intent(this,sanjay_gandhi_national_park.class);
        startActivity(intent);
    }
    public void ajanta(View v)
    {
        Intent i=new Intent(this,ajanta.class);
        startActivity(i);
    }
    public void pandavleni(View v)
    {
        Intent i=new Intent(this,pandavleni_caves.class);
        startActivity(i);
    }
    public void elephanta(View v)
    {
        Intent i=new Intent(this,elephanta_caves.class);
        startActivity(i);
    }
    public void gandhiteerth(View v)
    {
        Intent i=new Intent(this,Gandhi_Tirth.class);
        startActivity(i);
    }
    public void shivnery(View v)
    {
        Intent i=new Intent(this,Shivnery.class);
        startActivity(i);
    }
    public void startexplore(View v)
    {
        Intent i=new Intent(this,Mumbai.class);
        startActivity(i);
    }
    public void tmnet(View v)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo info = connectivityManager.getActiveNetworkInfo();
        if(info != null && info.isConnected()) {
            Uri webpage = Uri.parse("http://www.tm-developer.site88.net");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
            PackageManager packageManager = getPackageManager();
            List activities = packageManager.queryIntentActivities(webIntent,
                    PackageManager.MATCH_DEFAULT_ONLY);
            boolean isIntentSafe = activities.size() > 0;
            if (isIntentSafe) {
                startActivity(webIntent);
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Please Connect to Internet",Toast.LENGTH_LONG).show();
        }
    }
}
