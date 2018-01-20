package br.com.erudio.simplemenu2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String TAG = MainActivity.class.getSimpleName();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
	
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bookmark_menu:
                Toast.makeText(this, "You have selected Bookmark Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.save_menu:
                Toast.makeText(this, "You have selected Save Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.search_menu:
                Toast.makeText(this, "You have selected Search Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.share_menu:
                Toast.makeText(this, "You have selected Share Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete_menu:
                Toast.makeText(this, "You have selected Delete Menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.print_menu:
                Toast.makeText(this, "You have selected Print menu", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
