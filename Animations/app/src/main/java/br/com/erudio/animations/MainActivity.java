package br.com.erudio.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade (View view){
        ImageView southPark = (ImageView) findViewById(R.id.iVPulpFictionSouthPark);

        southPark.animate().scaleX(0.5f).scaleY(0.5f).setDuration(2000);

        //southPark.animate().rotation(180f).setDuration(2000);

        //southPark.animate().translationXBy(-1000f).setDuration(2000);

        //southPark.animate().translationYBy(1000f).setDuration(2000);

        /*ImageView simpson = (ImageView) findViewById(R.id.iVPulpFictionSimpsons);

        southPark.animate().alpha(0f).setDuration(2000);
        simpson.animate().alpha(1f).setDuration(2000);*/
    }

    public void fadeBack (View view){
        ImageView southPark = (ImageView) findViewById(R.id.iVPulpFictionSouthPark);
        ImageView simpson = (ImageView) findViewById(R.id.iVPulpFictionSimpsons);

        simpson.animate().alpha(0f).setDuration(2000);
        southPark.animate().alpha(1f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
