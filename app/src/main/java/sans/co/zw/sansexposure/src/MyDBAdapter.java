package sans.co.zw.sansexposure.src;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Steve on 21/02/2015.
 */

public class MyDBAdapter {

    MySQLiteOpenHelper sqliteOpenHelper;

    public MyDBAdapter(Context ctx){
        sqliteOpenHelper = new MySQLiteOpenHelper(ctx);
    }

    public long insertCollection(String collection){
        SQLiteDatabase db = sqliteOpenHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(MySQLiteOpenHelper.COLLECTIONS, collection);
        long id = db.insert(MySQLiteOpenHelper.TABLE_COLLECTIONS, null,contentValues );
        return id;
    }

    public String getCollection(){
        SQLiteDatabase db = sqliteOpenHelper.getWritableDatabase();
        String[] colunms = {MySQLiteOpenHelper.DATABASE_ID, MySQLiteOpenHelper.COLLECTIONS};
        Cursor cursor = db.query(MySQLiteOpenHelper.TABLE_COLLECTIONS, colunms, null, null, null, null, null);

        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()){
            int index1 = cursor.getColumnIndex(MySQLiteOpenHelper.DATABASE_ID);
            int collection_ID = cursor.getInt(index1);

            int index2 = cursor.getColumnIndex(MySQLiteOpenHelper.COLLECTIONS);
            String collection_NAME = cursor.getString(index2);

            buffer.append(index1+": "+collection_ID+" "+index2+": "+collection_NAME+" \n");
        }
        return buffer.toString();
    }

    static class MySQLiteOpenHelper extends SQLiteOpenHelper {
        private Context ctx;
        private static final String DATABASE_NAME = "sans_catalogue";
        private static final int DATABASE_VERSION = 8;
        private static final String TABLE_COLLECTIONS = "collections";
        private static final String TABLE_DESIGNERS = "designers";
        private static final String TABLE_STOCKS = "stocks";
        private static final String TABLE_STOCK_IMAGES = "stock_images";
        private static final String DATABASE_ID = "id";
        private static final String DESIGNER_LABEL = "label";
        private static final String DESIGNER_BIO = "bio";
        private static final String IMAGE_LOCATION = "pic";
        private static final String IMAGE_LOCATION_IMAGES = "location";
        private static final String ITEM_CODE = "code";
        private static final String ITEM_PRICE = "price";
        private static final String ITEM_SEX = "sex";
        private static final String ITEM_DESIGNER = "designer";
        private static final String ITEM_NAME = "item_name";
        private static final String ITEM_COLLECTION = "collection";
        private static final String ITEM_DESCRIPTION = "description";
        private static final String ITEM_COLLECTION_IMAGES = "stock_item";
        private static final String COLLECTIONS = "collection_name";
        private static final String CREATE_DESIGNERS_TABLE = "CREATE TABLE IF NOT EXISTS `designers` (\n" +
                "  `id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  `surname` VARCHAR(255),\n" +
                "  `label` VARCHAR(256),\n" +
                "  `full_name` VARCHAR(255),\n" +
                "  `bio` VARCHAR(255),\n" +
                "  `pic` VARCHAR(255) \n" +
                ");";
        private static final String CREATE_STOCKS_TABLE = "CREATE TABLE IF NOT EXISTS `stocks` (\n" +
                "  `id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  `code` VARCHAR(255),\n" +
                "  `pic` VARCHAR(255),\n" +
                "  `price` VARCHAR(255),\n" +
                "  `size` VARCHAR(255),\n" +
                "  `quantity` VARCHAR(255),\n" +
                "  `designer` VARCHAR(255),\n" +
                "  `sex` INTEGER,\n" +
                "  `item_name` VARCHAR(255),\n" +
                "  `collection` VARCHAR(255),\n" +
                "  `description` VARCHAR(255) \n" +
                ");";
        private static final String CREATE_STOCK_IMAGES_TABLE = "CREATE TABLE IF NOT EXISTS `stock_images` (\n" +
                "  `id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  `designer` VARCHAR(255),\n" +
                "  `location` VARCHAR(255),\n" +
                "  `stock_item` VARCHAR(255) \n" +
                ");";
        private static final String CREATE_COLLECTIONS = "CREATE TABLE IF NOT EXISTS `collections` (\n" +
                "  `id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  `collection_name` VARCHAR(255)\n" +
                ");";
        private static final String DROP_TABLE_STOCK_IMAGES = "DROP TABLE IF EXISTS `stock_images`";
        private static final String DROP_TABLE_DESIGNERS = "DROP TABLE IF EXISTS `stocks`";
        private static final String DROP_TABLE_STOCKS = "DROP TABLE IF EXISTS `designers`";
        private static final String DROP_TABLE_COLLECTIONS = "DROP TABLE IF EXISTS `collections`";

        public MySQLiteOpenHelper(Context ctx) {
            super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
            this.ctx = ctx;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_DESIGNERS_TABLE);
                db.execSQL(CREATE_STOCK_IMAGES_TABLE);
                db.execSQL(CREATE_STOCKS_TABLE);
                db.execSQL(CREATE_COLLECTIONS);
            } catch (SQLException e) {
                Message.message(ctx, "" + e);
                Log.e("DB","create error: "+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE_COLLECTIONS);
                db.execSQL(DROP_TABLE_DESIGNERS);
                db.execSQL(DROP_TABLE_STOCK_IMAGES);
                db.execSQL(DROP_TABLE_STOCKS);
                onCreate(db);
            } catch (SQLException e) {
                Message.message(ctx, "" + e);
                Log.e("DB","upgrade error: "+e);
            }
        }
    }
}
