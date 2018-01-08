package br.com.erudio.wathstheweather;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    EditText cityName;
    TextView weatherTextView;

    public class DownloadTask extends AsyncTask<String, Void, String> {

        //https://openweathermap.org
        @Override
        protected String doInBackground(String... urls) {

            String result = "";

            URL url;
            HttpURLConnection urlConnection = null;

            //Log.i(TAG + " Website URL:  ", urls[0]);

            try {
                url = new URL(urls[0]);

                urlConnection = (HttpURLConnection) url.openConnection();

                InputStream inputStream = urlConnection.getInputStream();

                InputStreamReader reader = new InputStreamReader(inputStream);

                int data = reader.read();

                while (data != -1) {
                    char current = (char) data;

                    result += current;

                    data = reader.read();
                }

                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            String weather = "";
            String message = "";

            try {
                JSONObject jsonObject = new JSONObject(result);

                weather = jsonObject.getString("weather");

                JSONArray arr = new JSONArray(weather);

                for (int i = 0; i < arr.length(); i++) {
                    JSONObject jsonPart = arr.getJSONObject(i);

                    String main = jsonPart.getString("main");
                    String description = jsonPart.getString("description");

                    /*Log.i(TAG + " Main: ", jsonPart.getString("main"));
                    Log.i(TAG + " Description: ", jsonPart.getString("description"));*/

                    if (main != null && !"".equals(main) && description != null && !"".equals(description)) {
                        message += main + " : " + description + "\r\n";
                    }
                }

                if (!"".equals(message)) {
                    weatherTextView.setText(message);
                } else {
                    displayMessage();
                }

            } catch (JSONException e) {
                displayMessage();
                e.printStackTrace();
            }
        }
    }
    
    public void findWeather(View view) {
        Log.i("City Name: ", cityName.getText().toString());

        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(cityName.getWindowToken(), 0);

        try {
            String encodedCityName = URLEncoder.encode(cityName.getText().toString(), "UTF-8");
            DownloadTask task = new DownloadTask();
            String result = null;
            String urlAddress = "http://samples.openweathermap.org/data/2.5/weather?q=" + encodedCityName + "&appid=b6907d289e10d714a6e88b30761fae22";
            result = task.execute(urlAddress).get();
        } catch (UnsupportedEncodingException e) {
            displayMessage();
            e.printStackTrace();
        } catch (InterruptedException e) {
            displayMessage();
            e.printStackTrace();
        } catch (ExecutionException e) {
            displayMessage();
            e.printStackTrace();
        } catch (Exception e) {
            displayMessage();
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityName = (EditText) findViewById(R.id.cityName);
        weatherTextView = (TextView) findViewById(R.id.weatherResult);

    }

    public void displayMessage(){
        Toast.makeText(getApplicationContext(), "Could not find weather", Toast.LENGTH_LONG);
    }
}
