package br.com.erudio.eggtimer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    SeekBar timerSeekBar;
    TextView timerTextView;

    public void updateTimer(int secondsLeft) {
        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String secondString = Integer.toString(seconds);
        if(seconds == 0) {
            secondString = "00:00";
        } else if (seconds < 10) {
            secondString = "0" + Integer.toString(seconds);
        }

        //seconds == 0 ? "00" :  Integer.toString(seconds);

        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        timerTextView = (TextView) findViewById(R.id.timerTextView);

        timerSeekBar.setMax(600);
        timerSeekBar.setProgress(30);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void controlTimer (View view){

        Log.i(TAG + " Button pressed ! ", "Pressed");
        new CountDownTimer(timerSeekBar.getProgress() * 1000,1000) {

            public void onTick(long millisecondsUntilDone) {
                Log.i(TAG + " Seconds left ! ", String.valueOf(millisecondsUntilDone / 1000));

                updateTimer((int) millisecondsUntilDone / 1000);
            }

            public void onFinish() {
                Log.i(TAG + " Finished ! ", "Timer done");

                timerTextView.setText("00:00");
            }
        }.start();
    }
}
