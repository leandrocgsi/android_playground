package br.com.erudio.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public void convert(View view){
        EditText realField = (EditText) findViewById(R.id.realField);
        String realStr = realField.getText().toString();

        Double euroValue = 0.258906341D;
        Double realValue = 0D;
        if (realStr != null && !"".equals(realStr)) realValue = new Double(realStr);

        Log.i(TAG, realStr);

        double convertedValue = realValue * euroValue;

        Toast.makeText(getApplicationContext(), "YOUR VALUE IN EURO IS €" + roundToDecimals(convertedValue, 2), Toast.LENGTH_LONG).show();
    }

    public static double roundToDecimals(double d, int c) {
        int temp = (int)(d * Math.pow(10 , c));
        return ((double)temp)/Math.pow(10 , c);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
