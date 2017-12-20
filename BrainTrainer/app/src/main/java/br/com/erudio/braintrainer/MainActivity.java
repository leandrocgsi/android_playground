package br.com.erudio.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    Button startButton;
    ArrayList<Integer> answers = new ArrayList<>();
    TextView resultTextView;
    TextView pointsTextView;
    int locationOfCorrectanswer;
    int score = 0;
    int numberOfQuestions = 0;

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgain;

    TextView sumTextView;
    TextView timerTextView;

    public void generateQuestion() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectanswer = rand.nextInt(4);

        answers.clear();

        int incorrectAnswer;

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectanswer) {
                answers.add(a + b);
            } else {
                incorrectAnswer = rand.nextInt(41);
                while (incorrectAnswer == a + b) {
                    incorrectAnswer = rand.nextInt(41);
                }
                answers.add(incorrectAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
    }

    public void chooseAnswer(View view){
        Log.i(TAG + " Button pressed ! ", (String) view.getTag());
        if (view.getTag().toString().equals(Integer.toString(locationOfCorrectanswer))) {
            Log.i(TAG + " Correct ! ", "Correct");
            score++;
            resultTextView.setText("Correct");
        } else {
            resultTextView.setText("Wrong");
        }
        numberOfQuestions++;
        pointsTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        generateQuestion();
    }

    public void playAgain(View view){
        score = 0;
        numberOfQuestions = 0;

        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");
        playAgain.setVisibility(View.INVISIBLE);

        new CountDownTimer(30100, 1000){

            @Override
            public void onTick(long millisecondsUntilFinished) {
                timerTextView.setText(String.valueOf(millisecondsUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                playAgain.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your score: " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestions)) ;
            }

        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);
        sumTextView = (TextView)findViewById(R.id.sumTextView);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        playAgain = (Button) findViewById(R.id.playAgainButton);

        resultTextView = (TextView) findViewById(R.id.resultTextView);
        pointsTextView = (TextView) findViewById(R.id.pointsTextView);
        timerTextView = (TextView) findViewById(R.id.timerTextView);

        generateQuestion();

        playAgain(findViewById(R.id.playAgainButton));

    }
}
