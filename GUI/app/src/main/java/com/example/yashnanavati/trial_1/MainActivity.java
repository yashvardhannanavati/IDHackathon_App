package com.example.yashnanavati.trial_1;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.input_name) EditText _nameText;
    @Bind(R.id.input_address) EditText _addressText;
    @Bind(R.id.input_email) EditText _emailText;
    @Bind(R.id.input_mobile) EditText _mobileText;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.input_reEnterPassword) EditText _reEnterPasswordText;
    @Bind(R.id.btn_signup) Button _signupButton;
    @Bind(R.id.link_login) TextView _loginLink;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),NextActivity.class);
                startActivity(i);
                setContentView(R.layout.next_activity);

            }
        });
    }

    public static String send_server;
    public void signup() {
        String city = _nameText.getText().toString();
        String country = _addressText.getText().toString();
        String annual_city_precipitation = _emailText.getText().toString();
        String average_population_growth = _mobileText.getText().toString();
        String average_commuter_growth = _passwordText.getText().toString();
        String average_gdp_growth  = _reEnterPasswordText.getText().toString();
        send_server = "{\"city\":\"" + city + "\",\"country\":\"" + country + "\",\"baseline_year\":null,\"interim_year_1\":null,\"interim_year_2\":null,\"target_year\":null,\"annual_city_precipitation\":" + annual_city_precipitation + ",\"area_of_city\":0.0,\"climate\":null,\"population_baseline_year\":0,\"daily_commuters_baseline_year\":0,\"aa_pop_growth_baseline_year_1\":" + average_population_growth + ",\"aa_pop_growth_year_1_year_2\":0.0,\"aa_pop_growth_year_2_target_year\":0.0,\"aa_com_growth_baseline_year_1\":" + average_commuter_growth + ",\"aa_com_growth_year_1_year_2\":0.0,\"aa_com_growth_year_2_target_year\":0.0,\"aa_gdp_growth_baseline_year_1\":" + average_gdp_growth + ",\"aa_gdp_growth_year_1_year_2\":0.0,\"aa_gdp_growth_year_2_target_year\":0.0}";
        try {
            Log.i("Activity:", new MyAsyncTask().doInBackground().toString());
        } catch(Exception ex) {
            Log.i("Activity:", ex.toString());
        }
    }

    private String getCharityDetails(String url, String apiKey, String params) throws IOException {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url + apiKey + "&" + params);
        org.apache.http.HttpResponse response;
        try {
            response = httpclient.execute(httpget);
            Log.i("Something", response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                InputStream instream = entity.getContent();
                String result = convertStreamToString(instream);
                Log.i("Response: ", result);
                instream.close();
                return result;
            }
        } catch (Exception e) {
            Log.e("API Error", "Something Went Wrong");
        }
        return null;
    }

        private static String convertStreamToString(InputStream is) {
    /*
     * To convert the InputStream to String we use the BufferedReader.readLine()
     * method. We iterate until the BufferedReader return null which means
     * there's no more data to read. Each line will appended to a StringBuilder
     * and returned as String.
     */
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();

            String line = null;
            try {
                while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return sb.toString();
        }

    public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            DefaultHttpClient httpclient = new DefaultHttpClient();

            //url with the post data
            HttpPost httpost = new HttpPost("http://localhost:8080/WorldBankApp/saveData");
            try {
                //convert parameters into JSON object
                JSONObject holder = new JSONObject(send_server);
                Log.i("Parsing Successful! Result:", holder.toString());
                //passes the results to a string builder/entity
                StringEntity se = new StringEntity(holder.toString());

                //sets the post request as the resulting string
                httpost.setEntity(se);
                //sets a request header so the page receving the request
                //will know what to do with it
                //httpost.setHeader("Accept", "application/json");
                httpost.setHeader("Content-Type", "application/json");

                //Handles what is returned from the page
                ResponseHandler responseHandler = new BasicResponseHandler();
                String something = httpclient.execute(httpost, responseHandler).toString();
            } catch (Exception ex) {
                Log.e("Error:", ex.toString());
            }
            return null;
        }
    }
}
