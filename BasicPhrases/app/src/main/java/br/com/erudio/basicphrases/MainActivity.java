package br.com.erudio.basicphrases;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public void buttonTapped(View view) {
        int id = view.getId();
        String ourId = view.getResources().getResourceEntryName(id);

        int resourceId =  getResources().getIdentifier(ourId, "raw", "br.com.erudio.basicphrases");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, resourceId);
        mediaPlayer.start();
        //Log.i(TAG + "Button tapped: ", Integer.toString(view.getId()));
        Log.i(TAG + "Button tapped: ", ourId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
