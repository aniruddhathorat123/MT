package com.rishab.owner.mt;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;




    public class Displaylistview extends Activity {
        String place_name;
        JSONObject jsonObject;
        JSONArray jsonArray;
        ContactAdapter contactAdapter;
        ListView listView;
        private ProgressDialog progressDialog;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            place_name = getIntent().getExtras().getString("place");
            BackgroundTask b1 = new BackgroundTask();
            b1.execute(place_name);

            progressDialog = new ProgressDialog(this);
            progressDialog.setIndeterminate(true);//because circle will rotate which shows that do not know how mch time is take process
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Loading...,Please Wait");
            progressDialog.show();
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_displaylistview);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_displaylistview, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.refresh) {
                BackgroundTask b2 = new BackgroundTask();
                b2.execute(place_name);
                Toast.makeText(getApplicationContext(), "Refreshing Review, Please Wait", Toast.LENGTH_LONG).show();
            }
            return super.onOptionsItemSelected(item);
        }

        public void displist(String response) {
            listView = (ListView) findViewById(R.id.listview);
            contactAdapter = new ContactAdapter(this, R.layout.activity_row_layout);
            listView.setAdapter(contactAdapter);

            try {
                jsonObject = new JSONObject(response);
                jsonArray = jsonObject.getJSONArray("server_response");//Returns the value mapped by name if it exists and is a JSONArray, or throws otherwise.
                int count = 0;
                String name, review;

                while (count < jsonArray.length()) {
                    JSONObject JO = jsonArray.getJSONObject(count);//Returns the value mapped by name if it exists and is a JSONObject, or throws otherwise.
                    name = JO.getString("name");
                    review = JO.getString("review");
                    Contacts contacts = new Contacts(name, review);
                    contactAdapter.add(contacts);
                    count++;
                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        class BackgroundTask extends AsyncTask<String, Void, String> {//String pass to the parameter as argument, Void no need of progress access , String for getting final result of doInBackground and sends to onPostExecute..
            String json_url;
            String response = "";

            @Override
            protected void onPreExecute() {
                json_url = "http://tourism-maharashtra.site88.net/json_get_data.php";
            }

            @Override
            protected String doInBackground(String... params) {
                try{
                    URL url = new URL(json_url);//A Uniform Resource Locator that identifies the location of an Internet resource.

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                    httpURLConnection.setRequestMethod("POST");//Sets the request command which will be sent to the remote HTTP server. This method can only be called before the connection is made.
                    httpURLConnection.setDoOutput(true);//Sets the flag indicating whether this URLConnection allows output. It cannot be set after the connection is established.
                    httpURLConnection.setDoInput(true);//Sets the flag indicating whether this URLConnection allows input.
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data_string = URLEncoder.encode("whclause", "UTF-8") + "=" + URLEncoder.encode(params[0], "UTF-8");
                    bufferedWriter.write(data_string);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    String line = "";
                    while ((line = bufferedReader.readLine()) != null) {
                        response += line;
                        // stringBuilder.append(JSON_STRING+"\n");
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return response;


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
                response = result;
                parseJSON(response);
                progressDialog.dismiss();
            }
        }

        public void parseJSON(String response) {

            if (response == null) {
                Toast.makeText(getApplicationContext(), "No Data Found", Toast.LENGTH_LONG).show();
            } else {
                displist(response);
            }
        }

        public void addcontact(View view) {
            Intent i = new Intent(this, AddInfo.class);
            i.putExtra("place", place_name);
            startActivity(i);
        }
    }
