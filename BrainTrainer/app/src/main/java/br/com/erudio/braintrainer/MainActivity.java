package br.com.erudio.braintrainer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton;

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    public void chooseAnswer(View view){
    }

    public void playAgain(View view){
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
    }
}
