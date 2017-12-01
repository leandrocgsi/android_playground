package br.com.erudio.imagesexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public void sayHello(View view){

        ImageView image = (ImageView) findViewById(R.id.imageView);
        if(image.getTag() != null && image.getTag().toString().equals("waterfall1")) {
            image.setImageResource(R.drawable.waterfall2);
        } else {
            image.setImageResource(R.drawable.waterfall1);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}