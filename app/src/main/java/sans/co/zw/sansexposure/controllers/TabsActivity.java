package sans.co.zw.sansexposure.controllers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.model.CatalogueData;
import sans.co.zw.sansexposure.view.GridViewFragment;
import sans.co.zw.sansexposure.view.StaggeredGridFragment;


public class TabsActivity extends ActionBarActivity implements
        ActionBar.TabListener,
        ViewPager.OnPageChangeListener{

    ViewPager mViewPager;
    ActionBar actionBar;
    Cursor c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabs);

        mViewPager = (ViewPager)findViewById(R.id.pager);
        mViewPager.setAdapter(new myFragmentStateAdapter(getSupportFragmentManager()));
        mViewPager.setOnPageChangeListener(this);

        actionBar = getSupportActionBar();
        actionBar.setTitle(R.string.app_name);
        actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.ic_launcher);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab tabDesigners = actionBar.newTab();
        tabDesigners.setText("Designers");
        tabDesigners.setTabListener(this);
        actionBar.addTab(tabDesigners);

        ActionBar.Tab tabCategories = actionBar.newTab();
        tabCategories.setText("Categories");
        tabCategories.setTabListener(this);
        actionBar.addTab(tabCategories);

        ActionBar.Tab tabCatalogue = actionBar.newTab();
        tabCatalogue.setText("Catalogue");
        tabCatalogue.setTabListener(this);
        actionBar.addTab(tabCatalogue);

        actionBar.selectTab(tabCategories);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabs, menu);
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

    //implement ActionBar.TabListener methods for when user selects a different tab
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        mViewPager.setCurrentItem(tab.getPosition());
        switch(tab.getPosition()){
            case 0:
                c =  getDataFromProvider(CatalogueData.Designers.CONTENT_URI);
                break;
            case 1:
                c = getDataFromProvider(CatalogueData.Collections.CONTENT_URI);
                break;
            case 2:

                break;
        }
        Toast.makeText(this, "" + c.getCount(), Toast.LENGTH_LONG).show();
        c.close();
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    //implement ViewPager.OnPageChangeListener methods for when user swipes accross tabs
    @Override
    public void onPageSelected(int position) {
        actionBar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    //method to use ContentProvider to retrive a generic query
    private Cursor getDataFromProvider(Uri uri){
        c = getContentResolver().query(
                uri,
                null,
                null,
                null,
                null
        );
        return c;
    }
}


class myFragmentStateAdapter extends FragmentStatePagerAdapter{
    //implements FragmentStatePagerAdapter to change fragments as and when the user swipes accross tabs or selects a different tab
    public myFragmentStateAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = null;
        switch(position){
            case 0:
                f = new GridViewFragment();
                break;
            case 1:
                f = new GridViewFragment();
                break;
            case 2:
                f = new StaggeredGridFragment();
                break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return 3;
    }
}