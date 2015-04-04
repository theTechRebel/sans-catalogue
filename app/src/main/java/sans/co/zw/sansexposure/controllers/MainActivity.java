package sans.co.zw.sansexposure.controllers;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import sans.co.zw.sansexposure.helpers.StatusBarNotification;
import sans.co.zw.sansexposure.helpers.Router;
import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.helpers.UserPreferences;
import sans.co.zw.sansexposure.model.CatalogueData;
import sans.co.zw.sansexposure.model.StockItem;
import sans.co.zw.sansexposure.view.GalleryFragment;
import sans.co.zw.sansexposure.view.MainFragment;

public class MainActivity extends ActionBarActivity implements Router {

    ActionBar actionBar;
    UserPreferences userPrefs;
    final static String APP_PATH_SD_CARD = "/catalogue/";
    File file = null;
    private static String TAG = "MainActivity";
    private ProgressBar spinner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userPrefs = new UserPreferences(getApplicationContext());
        spinner = (ProgressBar)findViewById(R.id.progressBar1);
        spinner.setVisibility(View.GONE);

        if (savedInstanceState == null) {
            if(userPrefs.getEmailAddress() == "empty" && userPrefs.getPassword() == "empty"){
                swapFragments(0);
            }else{
                launchTabsAcitivity();
            }
        }

        if(userPrefs.getDatabaseCreated() == false){
            new HandleDataBaseOperations(getApplicationContext()).execute(
                    CatalogueData.Designers.CONTENT_URI,
                    CatalogueData.Categories.CONTENT_URI,
                    CatalogueData.Stocks.CONTENT_URI,
                    CatalogueData.StockImages.CONTENT_URI
            );
            userPrefs.setDatabaseCreated(true);
        }
    }


        @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
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

        @Override
        public void swapFragments ( int n){
            Fragment f = new Fragment();

            switch (n) {
                case 0:
                    f = new MainFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
        }

    @Override
    public void launchTabsAcitivity() {
        Intent intent = new Intent(this, TabsActivity.class);
        startActivity(intent);
    }

    @Override
    public void launchGalleryActivity(StockItem stockItem) {
    }

    private void save(Uri contentUri){
        int pics[] = {};
        if(contentUri == CatalogueData.Designers.CONTENT_URI){
            pics = CatalogueData.Designers.PICS;
        }

        if(contentUri == CatalogueData.Categories.CONTENT_URI){
            pics = CatalogueData.Categories.PICS;
        }

        if(contentUri == CatalogueData.Stocks.CONTENT_URI){
            pics = CatalogueData.Stocks.PICS;
        }

        if(contentUri == CatalogueData.StockImages.CONTENT_URI){
            pics = CatalogueData.StockImages.PICS;
        }

        for(int i=0;i<pics.length;i++){
            Bitmap img = BitmapFactory.decodeResource(getResources(),pics[i]);
            Uri file = saveImageToInternalStorage(img, pics[i]+".png");
            populateDatabase(contentUri, file, i);
        }
    }

    private Uri saveImageToInternalStorage(Bitmap img, String name){
        try {
            file = getFilesDir();
            FileOutputStream fos = openFileOutput(name,MODE_PRIVATE);
            img.compress(Bitmap.CompressFormat.PNG, 50,fos);
            fos.close();
        } catch (IOException e) {
            Log.d("Error Saving File: ",""+e.getMessage());
        }
        //return file+"/"+name;
        File outFile = getFileStreamPath(name);
        return Uri.fromFile(outFile);
    }

    private void populateDatabase(Uri contentUri, Uri imageLocation, Integer i){
        ContentValues values = new ContentValues();
        if(contentUri == CatalogueData.Designers.CONTENT_URI){
            String[] data = CatalogueData.Designers.DB_DATA.get(i);
            values.put(CatalogueData.Designers.COL_DESIGNER, data[0]);
            values.put(CatalogueData.Designers.COL_LABEL, data[1]);
            values.put(CatalogueData.Designers.COL_FULLNAME, data[2]);
            values.put(CatalogueData.Designers.COL_PIC, imageLocation.toString());
        }

        if(contentUri == CatalogueData.Categories.CONTENT_URI){
            String[] data = CatalogueData.Categories.DB_DATA.get(i);
            values.put(CatalogueData.Categories.COL_KEY, data[0]);
            values.put(CatalogueData.Categories.COL_VALUE, data[1]);
            values.put(CatalogueData.Categories.COL_PIC, imageLocation.toString());
        }

        if(contentUri == CatalogueData.Stocks.CONTENT_URI){
            String[] data = CatalogueData.Stocks.DB_DATA.get(i);
            values.put(CatalogueData.Stocks.COL_CODE, data[0]);
            values.put(CatalogueData.Stocks.COL_PRICE, data[1]);
            values.put(CatalogueData.Stocks.COL_SIZE, data[2]);
            values.put(CatalogueData.Stocks.COL_QUANTITY, data[3]);
            values.put(CatalogueData.Stocks.COL_DESIGNER, data[4]);
            values.put(CatalogueData.Stocks.COL_SEX, data[5]);
            values.put(CatalogueData.Stocks.COL_ITEM_NAME, data[6]);
            values.put(CatalogueData.Stocks.COL_COLLECTION, data[7]);
            values.put(CatalogueData.Stocks.COL_DESCRIPTION, data[8]);
            values.put(CatalogueData.Stocks.COL_PIC, imageLocation.toString());
        }

        if(contentUri == CatalogueData.StockImages.CONTENT_URI){
            String[] data = CatalogueData.StockImages.DB_DATA.get(i);
            values.put(CatalogueData.StockImages.COL_DESIGNER, data[0]);
            values.put(CatalogueData.StockImages.COL_STOCK_ITEM, data[1]);
            values.put(CatalogueData.StockImages.COL_LOCATION, imageLocation.toString());
        }


        getContentResolver().insert(contentUri,values);
        //Uri returnUri = getContentResolver().insert(contentUri,values);
        //long id = ContentUris.parseId(returnUri);
        //Toast.makeText(this,"Created Image: "+imageLocation.toString(),Toast.LENGTH_LONG).show();
    }

    //not bieng used but might be needed a bit later
    private boolean saveImageToExternalStorage(Bitmap img, String name){
        try {
            String fullPath = Environment.getExternalStorageDirectory().getAbsolutePath()+APP_PATH_SD_CARD;
            File dir = new File(fullPath);
            if(!dir.exists()){
                dir.mkdirs();
            }

            OutputStream fOut = null;
            File file = new File(fullPath,name);
            file.createNewFile();
            fOut = new FileOutputStream(file);

            img.compress(Bitmap.CompressFormat.PNG, 50, fOut);
            fOut.flush();
            fOut.close();

            MediaStore.Images.Media.insertImage(getContentResolver(), file.getAbsolutePath(), file.getName(), file.getName());

            return true;
        } catch (IOException e) {
            Log.d("File",""+e.getMessage());
            return false;
        }
    }

    //AsyncTask to handle database population
    private class HandleDataBaseOperations extends AsyncTask<Uri, Integer, Boolean>{

        private StatusBarNotification mStatusBarNotification;
        private Context ctx;

        private HandleDataBaseOperations(Context ctx) {
            this.ctx = ctx;
            mStatusBarNotification = new StatusBarNotification(ctx);
        }

        @Override
        protected void onPreExecute() {

            mStatusBarNotification.createNotification();
            spinner.setVisibility(View.VISIBLE);
        }

        @Override
        protected Boolean doInBackground(Uri... params) {
            int i = 0;
            for(Uri uri : params){
                save(uri);
                i = i + 20;
                publishProgress(i);

                if(isCancelled()) return false;
            }
            return true;
        }

        protected void onProgressUpdate(Integer... progress) {
            mStatusBarNotification.progressUpdate(progress[0]);
        }

        protected void onPostExecute(Boolean result) {
            mStatusBarNotification.completed();
        spinner.setVisibility(View.GONE);
        }
    }

}


