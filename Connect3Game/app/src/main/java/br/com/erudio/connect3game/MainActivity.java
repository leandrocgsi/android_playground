package br.com.erudio.connect3game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Boolean flag = true;

    public void dropIn(View view){

        ImageView counter = (ImageView) view;

        counter.setTranslationY(-1000f);
        if (flag) {
            counter.setImageResource(R.drawable.yellow);
            flag = false;
        } else {
            counter.setImageResource(R.drawable.red);
            flag = true;
        }
        counter.animate().translationYBy(1000f).rotation(3600).setDuration(300);


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
