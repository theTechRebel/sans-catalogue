package sans.co.zw.sansexposure.model;


import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.CursorLoader;
import android.util.Log;

import java.util.ArrayList;

import sans.co.zw.sansexposure.R;

/**
 * Created by Steve on 08/03/2015.
 */
public class CatalogueDataLoader extends CursorLoader {

    private Cursor c;

    public CatalogueDataLoader(Context context, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        super(context, uri, projection, selection, selectionArgs, sortOrder);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        super.onStartLoading();
    }

    @Override
    public Cursor loadInBackground() {
        this.c = getContext().getContentResolver().query(
                getUri(),
                getProjection(),
                getSelection(),
                getSelectionArgs(),
                getSortOrder()
        );
      return c;
    }

    @Override
    public void deliverResult(Cursor cursor) {
        super.deliverResult(cursor);
    }

    /*
    ArrayList<GridViewData> objects = new ArrayList<GridViewData>();


    public CatalogueDataLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
        super.onStartLoading();
    }

    @Override
    public ArrayList<GridViewData> loadInBackground() {
        // references to our images
        int[] pics = {
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7,
                R.drawable.sample_0, R.drawable.sample_1,
                R.drawable.sample_2, R.drawable.sample_3,
                R.drawable.sample_4, R.drawable.sample_5,
                R.drawable.sample_6, R.drawable.sample_7
        };

        // references to images text
        String[] text = {
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress",
                "Skatter Skirt", "Crop top and Dress"
        };

        // references to images designer
        String[] designer = {
                "Lady Cee Kay", "Tariro the Jeweler",
                "AfroKreative", "K-7",
                "Haus Of Stone", "DeMoyo",
                "House of Targeran", "Amara",
                "Lady Cee Kay", "Tariro the Jeweler",
                "AfroKreative", "K-7",
                "Haus Of Stone", "DeMoyo",
                "House of Targeran", "Amara",
                "Lady Cee Kay", "Tariro the Jeweler",
                "AfroKreative", "K-7",
                "Haus Of Stone", "DeMoyo"
        };

        // references to images price
        String[] price = {
                "$35.00", "$50.00",
                "$40.00", "$150.00",
                "$80.00", "$25.00",
                "$15.00", "$60.00",
                "$35.00", "$50.00",
                "$40.00", "$150.00",
                "$80.00", "$25.00",
                "$15.00", "$60.00",
                "$35.00", "$50.00",
                "$40.00", "$150.00",
                "$80.00", "$25.00"
        };
        for (int i = 0; i < pics.length - 1; i++) {
            GridViewData object = new GridViewData();
            object.setImageId(pics[i]);
            object.setItemName(text[i]);
            object.setItemDesigner(designer[i]);
            object.setItemPrice(price[i]);
            objects.add(object);
        }
        return objects;
    }

    @Override
    public void deliverResult(ArrayList<GridViewData> data) {
        super.deliverResult(data);
    }
    */
}
