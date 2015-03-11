package sans.co.zw.sansexposure.controllers;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.model.CatalogueDBAdapter;
import sans.co.zw.sansexposure.model.CatalogueData;
import sans.co.zw.sansexposure.model.CatalogueDataProvider;
import sans.co.zw.sansexposure.view.MainFragment;

import com.etsy.android.grid.StaggeredGridView;

public class MainActivity extends ActionBarActivity implements Router {

    ActionBar actionBar;
    final static String APP_PATH_SD_CARD = "/catalogue/";
    File file = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            swapFragments(0);
        }

        save(CatalogueData.Designers.CONTENT_URI);
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

    private void save(Uri contentUri){
        int pics[] = {};
        if(contentUri == CatalogueData.Designers.CONTENT_URI){
            pics = CatalogueData.Designers.PICS;
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

        Uri returnUri = getContentResolver().insert(contentUri,values);
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


}
