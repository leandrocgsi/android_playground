package br.com.erudio.databinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

//import br.com.erudio.databinding.ActivityMainBinding;

import br.com.erudio.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView unbound = (TextView) findViewById(R.id.textViewUnBound); // Line 1
        MyDataBindingHelper myDataBindingHelper = MyDataBindingHelper.get("Unbound"); // Line 2
        unbound.setText(myDataBindingHelper.getMessage()); // Line 3


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main); // Line 4
        binding.setMydatabindinghelper(MyDataBindingHelper.get("Bound")); // Line 5

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    
    //SEE: https://www.developer.com/ws/android/programming/how-to-use-android-data-binding.html
}
