package br.com.erudio.downloadingwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public class DownloadTask extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {

            String result = "";

            URL url;
            HttpURLConnection urlConnection = null;

            Log.i(TAG + " Website URL:  ", params[0]);

            try {
                url = new URL(params[0]);

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
            } catch (Exception e) {
                e.printStackTrace();
                return "Failed!";
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();
        String result = null;
        try {
            result = task.execute("https://www.ecowebhosting.co.uk/", "https://stackoverflow.com").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Log.i(TAG + " Result! ", result);
    }
}
