 package br.com.erudio.timerdemo;

import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

 public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CountDownTimer(10000,1000) {

            public void onTick(long millisecondsUntilDone) {
                Log.i(TAG + " Seconds left ! ", String.valueOf(millisecondsUntilDone / 1000));
            }

            public void onFinish() {

            }
        }.start();

        /* final Handler handler = new Handler();
        Runnable run = new Runnable(){
            @Override
            public void run() {

                Log.i(TAG + " Runnable has run! ", "a second must have passed ...");

                handler.postDelayed(this, 1000);
            }
        };

        handler.post(run); */
    }
}
