package br.com.erudio.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public void convert(View view){
        EditText realField = (EditText) findViewById(R.id.realField);
        String realStr = realField.getText().toString();

        Double euroValue = 0.258906341D;
        Double realValue = new Double(realStr);

        Log.i(TAG, realStr);

        double convertedValue = realValue * euroValue;
        Toast.makeText(getApplicationContext(), "YOUR VALUE IN EURO IS " + convertedValue, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
