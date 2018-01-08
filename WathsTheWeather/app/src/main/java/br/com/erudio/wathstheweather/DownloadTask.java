package br.com.erudio.wathstheweather;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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