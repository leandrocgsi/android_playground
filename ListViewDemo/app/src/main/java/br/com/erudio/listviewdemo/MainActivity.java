package br.com.erudio.listviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView myListView = (ListView)findViewById(R.id.myListView);

        final ArrayList<String> family = new ArrayList<String>(asList("Dan McCafferty", "Manny Charlton", "Pete Agnew", "Darrel Sweet"));
        /*
        final ArrayList<String> family = new ArrayList<String>();
        family.add("Hommer Simpson");
        family.add("Bart Simpson");
        family.add("Lisa Simpson");
        family.add("Mr. Burns");
        */

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, family);

        myListView.setAdapter(arrayAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPerson = family.get(position);
                Log.i(TAG + " Selected person is: ", selectedPerson);
                Toast.makeText(getApplicationContext(), "HELLO " + selectedPerson.toUpperCase(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
