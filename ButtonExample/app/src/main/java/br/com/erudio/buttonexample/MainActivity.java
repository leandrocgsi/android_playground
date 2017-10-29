package br.com.erudio.buttonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public void buttonClicked(View view){

        EditText myTextField = (EditText) findViewById(R.id.textField);
        //Log.i("Info", "Hello Leandro");
        Log.i("Text Field Value", myTextField.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
