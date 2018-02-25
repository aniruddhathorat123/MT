package com.rishab.owner.mt;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AddInfo extends Activity {

    EditText Name,Review;
    String name,review;
    String place_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info);
        Name = (EditText) findViewById(R.id.et_name);
        Review = (EditText) findViewById(R.id.et_review);
        Intent i=getIntent();
        place_name=i.getStringExtra("place");
    }

    public void saveInfo(View view)
    {
        name = Name.getText().toString();
        review = Review.getText().toString();
            Toast.makeText(getApplicationContext(), "Sending, please wait", Toast.LENGTH_LONG).show();
            BackgroundTask backgroundTask = new BackgroundTask();
            backgroundTask.execute(name, review, place_name);
            finish();
    }

    //Async task for performing database operations,because they take long time.....
    class BackgroundTask extends AsyncTask<String,Void,String>
    {

        //to add information into database..
        String add_info_url;

        @Override
        protected void onPreExecute() {
            add_info_url  ="http://tourism-maharashtra.site88.net/add_info.php";
        }

        @Override
        protected String doInBackground(String...args)
        {
            String name,review,place_info;
            name=args[0];
            review =args[1];
            place_info = args[2];
            //to start network operation
            try {
                URL url =new URL(add_info_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter  = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data_string= URLEncoder.encode("name", "UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"+
                        URLEncoder.encode("review","UTF-8")+"="+URLEncoder.encode(review,"UTF-8")+"&"+
                        URLEncoder.encode("place","UTF-8")+"="+URLEncoder.encode(place_info,"UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                return "Review Stored Successfully....";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
        }
    }
}
