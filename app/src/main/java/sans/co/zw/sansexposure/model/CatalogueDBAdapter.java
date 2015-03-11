package sans.co.zw.sansexposure.model;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import sans.co.zw.sansexposure.src.Message;

/**
 * Created by Steve on 22/02/2015.
 */
public class CatalogueDBAdapter {
    CatalogueDBHelper dbHelper;
    SQLiteDatabase db;

    public CatalogueDBAdapter(Context ctx) {
        dbHelper = new CatalogueDBHelper(ctx);
        db = dbHelper.getWritableDatabase();
    }

    public SQLiteDatabase getDBObject(){
        return this.db;
    }

    static class CatalogueDBHelper extends SQLiteOpenHelper {

        private Context ctx;

        public CatalogueDBHelper(Context ctx) {
            super(ctx, CatalogueData.DATABASE_NAME, null, CatalogueData.DATABASE_VERSION);
            this.ctx = ctx;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CatalogueData.CREATE_DESIGNERS_TABLE);
                db.execSQL(CatalogueData.CREATE_STOCK_IMAGES_TABLE);
                db.execSQL(CatalogueData.CREATE_STOCKS_TABLE);
                db.execSQL(CatalogueData.CREATE_COLLECTIONS);
            } catch (SQLException e) {
                Log.e("DB", "create error: \n" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(CatalogueData.DROP_TABLE_COLLECTIONS);
                db.execSQL(CatalogueData.DROP_TABLE_DESIGNERS);
                db.execSQL(CatalogueData.DROP_TABLE_STOCK_IMAGES);
                db.execSQL(CatalogueData.DROP_TABLE_STOCKS);
                onCreate(db);
            } catch (SQLException e) {
                Log.e("DB", "upgrade error: \n" + e);
            }
        }
    }
}