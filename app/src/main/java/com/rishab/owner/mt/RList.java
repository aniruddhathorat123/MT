package com.rishab.owner.mt;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RList extends Activity {

    JSONObject jsonObject;
    JSONArray jsonArray;
    RAdapter contactAdapter;
    ListView listView;
    ProgressDialog progressDialog;
    String station;
    String scode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        station=getIntent().getExtras().getString("place");
        scode=station;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rlist);
        contactAdapter = new RAdapter(this, R.layout.rlayout);
        btwork btworks=new btwork();
        btworks.execute();
        progressDialog =new ProgressDialog(this);
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...Please Wait");
        progressDialog.show();
    }
    public void disprail(String response) {
        listView = (ListView) findViewById(R.id.rlistview);
        listView.setAdapter(contactAdapter);
        try {
            jsonObject = new JSONObject(response);
            jsonArray = jsonObject.getJSONArray("train");

            int count = 0;
            String delaydeps, actarrs, numbers, schdeps, names, actdeps, delayarrs, scharrs;

            while (count < jsonArray.length()) {

                JSONObject j = jsonArray.getJSONObject(count);
               // delaydeps = j.getString("delaydep");
                actarrs = j.getString("actarr");
                numbers = j.getString("number");
                //schdeps=j.getString("schdep");
                names = j.getString("name");
                actdeps = j.getString("actdep");
                // delayarrs=j.getString("delayarr");
                //scharrs=j.getString("scharr");
                RContacts rcontacts = new RContacts(names, numbers, actarrs, actdeps);
                count++;
                contactAdapter.add(rcontacts);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rlist, menu);
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


    class btwork extends AsyncTask<String,Void,String>
    {
        String response;
        String urls;
        String urlssc;
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            urls="http://api.railwayapi.com/arrivals/station/"+scode+"/hours/2/apikey/rcair8296/";
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                URL url=new URL(urls);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line=bufferedReader.readLine())!=null)
                {
                    //stringBuilder=JSON_STRING+"\n";
                    response+=line.trim();                                                                                                                   // stringBuilder.append(JSON_STRING+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                //return stringBuilder.toString().trim();
                response=response.substring(4,response.length());
                response.trim();


            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            return response;
        }
        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            parseJSON(result);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
    public void parseJSON(String result)
    {
        JSONObject jsonObject;
        String rcode="";
        if(result==null)
        {
            Toast.makeText(getApplicationContext(), "Network Not Available", Toast.LENGTH_LONG).show();
        }
        else
        {
            try {
                jsonObject=new JSONObject(result);

                rcode=jsonObject.getString("response_code");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            if(rcode.equals("200")) {
                disprail(result);
            }
        }
    }
}
