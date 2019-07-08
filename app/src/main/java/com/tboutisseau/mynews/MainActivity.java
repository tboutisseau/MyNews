package com.tboutisseau.mynews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Widgets
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);

        //Set the toolbar
        setSupportActionBar(mToolbar);
    }

    // Inflate the toolbar menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    // Manage the clicks on the toolbar menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search_btn :
                // TODO: 2019-07-08 open search activity
                Toast.makeText(this, "open search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.notification_btn :
                // TODO: 2019-07-08 open notifications activity
                return true;
            case R.id.help_btn :
                // TODO: 2019-07-08 open help page
                return true;
            case R.id.about_btn :
                // TODO: 2019-07-08  open about page
                return true;
            default :
                return super.onOptionsItemSelected(item);
        }
    }
}
