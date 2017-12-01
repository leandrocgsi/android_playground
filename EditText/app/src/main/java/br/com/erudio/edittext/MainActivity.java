package br.com.erudio.edittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    public void logIn(View view){
        EditText etUsername = (EditText) findViewById(R.id.username);
        EditText etPassword = (EditText) findViewById(R.id.password);

        Log.i(TAG + "_Username: ", etUsername.getText().toString());
        Log.i(TAG + "_Password: ", etPassword.getText().toString());

        String username = etUsername.getText().toString().toUpperCase();
        Toast.makeText(getApplicationContext(), "HI " + username, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

