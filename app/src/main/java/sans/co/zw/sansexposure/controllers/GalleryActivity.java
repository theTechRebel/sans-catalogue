package sans.co.zw.sansexposure.controllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.io.File;
import java.io.Serializable;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.helpers.Router;
import sans.co.zw.sansexposure.helpers.UserPreferences;
import sans.co.zw.sansexposure.model.StockItem;
import sans.co.zw.sansexposure.view.GalleryFragment;
import sans.co.zw.sansexposure.view.MainFragment;
import sans.co.zw.sansexposure.view.OrderFragment;

/**
 * Created by Steve on 03/04/2015.
 */
public class GalleryActivity extends ActionBarActivity
    implements Router{

    UserPreferences userPrefs;
    private static String TAG = "GalleryActivity";
    StockItem stockItem;
    public static String STOCK_ITEM = "stockItem";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        stockItem = (StockItem)getIntent().getSerializableExtra(STOCK_ITEM);
        switchFragmentsAgain(0,null);
    }

     @Override
    public void switchFragmentsAgain(int n, StockItem stockItem){
        Fragment f = new Fragment();
        Bundle args = new Bundle();

        switch (n) {
            case 0:
                f = new GalleryFragment();
                args.putSerializable(GalleryFragment.STOCK_ITEM, this.stockItem);
                f.setArguments(args);
                break;

            case 1:
                f = new OrderFragment();
                args.putSerializable(OrderFragment.STOCK_ITEM, stockItem);
                f.setArguments(args);
                break;
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
    }

    @Override
    public void swapFragments(int number) {

    }

    @Override
    public void launchTabsAcitivity() {

    }

    @Override
    public void launchGalleryActivity(StockItem stockItem) {

    }
}
