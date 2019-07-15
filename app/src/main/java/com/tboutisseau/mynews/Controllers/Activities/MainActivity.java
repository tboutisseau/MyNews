package com.tboutisseau.mynews.Controllers.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.tboutisseau.mynews.R;
import com.tboutisseau.mynews.Views.TabsAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //Widgets
    @BindView(R.id.toolbar) Toolbar mToolbar;
    @BindView(R.id.main_tablayout) TabLayout mTabLayout;
    @BindView(R.id.main_viewpager) ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //Set the toolbar
        setSupportActionBar(mToolbar);

        configureViewPagerAndTabs();
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

    // Set up the ViewPager with TabLayout
    private void configureViewPagerAndTabs(){

        // Set Adapter with ViewPager
        mViewPager.setAdapter(new TabsAdapter(getSupportFragmentManager()));

        // Glue TabLayout and ViewPager together
        mTabLayout.setupWithViewPager(mViewPager);

        // Set TabMode to scrollable if there is more than 3 categories
        Log.d(TAG, "number of tabs : " + mTabLayout.getTabCount());

        if (mTabLayout.getTabCount() <= 3) {
            mTabLayout.setTabMode(TabLayout.MODE_FIXED);
        }
        else {
            mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        }

        // Set text color for selected and unselected tabs
        mTabLayout.setTabTextColors(getResources().getColor(R.color.TabNotSelected), getResources().getColor(R.color.tabSelected));

    }
}
