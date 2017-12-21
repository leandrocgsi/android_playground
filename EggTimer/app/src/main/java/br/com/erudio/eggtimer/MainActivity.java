package br.com.erudio.eggtimer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.os.SystemClock.sleep;

public class MainActivity extends AppCompatActivity {

        private static final String TAG = MainActivity.class.getSimpleName();

    SeekBar timerSeekBar;
    TextView timerTextView;
    Boolean counterIsActive = false;
    Button goButton;
    CountDownTimer countDownTimer;

    public void resetTimer(){
        timerTextView.setText("0:30");
        timerSeekBar.setProgress(30);
        timerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        goButton.setText("Go!");
        counterIsActive = false;

        /* sleep(2000);

        ImageView image = (ImageView) findViewById(R.id.imageView);

        image.setImageResource(R.drawable.egg_smiling); */

    }

    public void updateTimer(int secondsLeft) {
        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;

        String secondString = (seconds < 10) ? "0" + Integer.toString(seconds): Integer.toString(seconds);

        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        goButton = (Button) findViewById(R.id.go);

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

        if (!counterIsActive) {
            counterIsActive = true;
            timerSeekBar.setEnabled(false);
            goButton.setText("Stop");

            Log.i(TAG + " Button pressed ! ", "Pressed");

            countDownTimer = new CountDownTimer(timerSeekBar.getProgress() * 1000 + 100, 1000) {

                public void onTick(long millisecondsUntilDone) {
                    Log.i(TAG + " Seconds left ! ", String.valueOf(millisecondsUntilDone / 1000));

                    updateTimer((int) millisecondsUntilDone / 1000);
                }

                public void onFinish() {
                    Log.i(TAG + " Finished ! ", "Timer done");

                    /* ImageView image = (ImageView) findViewById(R.id.imageView);

                    image.setImageResource(R.drawable.broken_egg); */

                    timerTextView.setText("00:00");
                    resetTimer();
                    MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.airhorn);
                    mediaPlayer.start();
                }
            }.start();
        } else {
            resetTimer();
        }
    }
}
