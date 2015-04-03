package sans.co.zw.sansexposure.model;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Steve on 24/02/2015.
 */
public class CatalogueDataProvider extends ContentProvider {
    SQLiteDatabase db;
    CatalogueDBAdapter dbAdapter;

    public final static int DESIGNERS_ALL_RECORDS = 100;
    public final static int DESIGNERS_ONE_RECORD = 101;

    public final static int COLLECTIONS_ALL_RECORDS = 200;
    public final static int COLLECTIONS_ONE_RECORD = 201;

    public final static int STOCKS_ALL_RECORDS = 300;
    public final static int STOCKS_ONE_RECORD = 301;

    public final static int STOCK_IMAGES_ALL_RECORDS = 400;
    public final static int STOCK_IMAGES_ONE_RECORDS = 401;

    private static final UriMatcher uriMatcher = buildUriMatcher();

    private final static UriMatcher buildUriMatcher(){
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);

        matcher.addURI(CatalogueData.CONTENT_AUTHORITY, CatalogueData.Designers.TABLE_NAME, DESIGNERS_ALL_RECORDS);
        matcher.addURI(CatalogueData.CONTENT_AUTHORITY, CatalogueData.Designers.TABLE_NAME+"/#", DESIGNERS_ONE_RECORD);

        matcher.addURI(CatalogueData.CONTENT_AUTHORITY, CatalogueData.Categories.TABLE_NAME, COLLECTIONS_ALL_RECORDS);
        matcher.addURI(CatalogueData.CONTENT_AUTHORITY, CatalogueData.Categories.TABLE_NAME+"/#",COLLECTIONS_ONE_RECORD);

        matcher.addURI(CatalogueData.CONTENT_AUTHORITY, CatalogueData.Stocks.TABLE_NAME, STOCKS_ALL_RECORDS);
        matcher.addURI(CatalogueData.CONTENT_AUTHORITY, CatalogueData.Stocks.TABLE_NAME+"/#", STOCKS_ONE_RECORD);

        matcher.addURI(CatalogueData.CONTENT_AUTHORITY, CatalogueData.StockImages.TABLE_NAME, STOCK_IMAGES_ALL_RECORDS);
        matcher.addURI(CatalogueData.CONTENT_AUTHORITY, CatalogueData.StockImages.TABLE_NAME+"/#", STOCK_IMAGES_ONE_RECORDS);

        return matcher;
    }

    @Override
    public boolean onCreate() {
        dbAdapter = new CatalogueDBAdapter(getContext());
        this.db = dbAdapter.getDBObject();
        return true;
    }

    @Override
    public String getType(Uri uri) {
        final int match = uriMatcher.match(uri);
        switch(match){
            case DESIGNERS_ALL_RECORDS:
                return CatalogueData.Designers.CONTENT_ALL_TYPE;

            case DESIGNERS_ONE_RECORD:
                return CatalogueData.Designers.CONTENT_ITEM_TYPE;

            case COLLECTIONS_ALL_RECORDS:
                return CatalogueData.Categories.CONTENT_ALL_TYPE;

            case COLLECTIONS_ONE_RECORD:
                return CatalogueData.Categories.CONTENT_ITEM_TYPE;

            case STOCKS_ALL_RECORDS:
                return CatalogueData.Stocks.CONTENT_ALL_TYPE;

            case STOCKS_ONE_RECORD:
                return CatalogueData.Stocks.CONTENT_ITEM_TYPE;

            case STOCK_IMAGES_ALL_RECORDS:
                return CatalogueData.StockImages.CONTENT_ALL_TYPE;

            case STOCK_IMAGES_ONE_RECORDS:
                return CatalogueData.StockImages.CONTENT_ITEM_TYPE;

            default:
                throw new UnsupportedOperationException("404 URI Not Found: "+ uri);
        }
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        Cursor c;
        switch (uriMatcher.match(uri)){

            case DESIGNERS_ALL_RECORDS:
                c = db.query(
                        CatalogueData.Designers.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
            break;

            case DESIGNERS_ONE_RECORD:
                c = db.query(
                        CatalogueData.Designers.TABLE_NAME,
                        projection,
                        CatalogueData.Designers.COL_ID +"="+ ContentUris.parseId(uri),
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            case COLLECTIONS_ALL_RECORDS:
                c = db.query(
                        CatalogueData.Categories.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            case COLLECTIONS_ONE_RECORD:
                c = db.query(
                        CatalogueData.Categories.TABLE_NAME,
                        projection,
                        CatalogueData.Categories.COL_ID +"="+ ContentUris.parseId(uri),
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            case STOCKS_ALL_RECORDS:
                c = db.query(
                        CatalogueData.Stocks.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            case STOCKS_ONE_RECORD:
                c = db.query(
                        CatalogueData.Stocks.TABLE_NAME,
                        projection,
                        CatalogueData.Stocks.COL_ID +"="+ ContentUris.parseId(uri),
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            case STOCK_IMAGES_ALL_RECORDS:
                c = db.query(
                        CatalogueData.StockImages.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            case STOCK_IMAGES_ONE_RECORDS:
                c = db.query(
                        CatalogueData.StockImages.TABLE_NAME,
                        projection,
                        CatalogueData.StockImages.COL_ID +"="+ ContentUris.parseId(uri),
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;

            default:
                throw new UnsupportedOperationException("404 URI Not Found: "+ uri);
        }

        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values){
        Uri returnUri;
        long _id;
        switch (uriMatcher.match(uri)){

            case DESIGNERS_ALL_RECORDS:
                 _id = db.insert(CatalogueData.Designers.TABLE_NAME,
                        null,
                        values);
                if(_id > 0){
                    returnUri = CatalogueData.Designers.buildUri(_id);
                }else{
                    throw new SQLException("Failed to insert row into: "+ uri);
                }
                break;

            case COLLECTIONS_ALL_RECORDS:
                _id = db.insert(CatalogueData.Categories.TABLE_NAME,
                        null,
                        values);
                if(_id > 0){
                    returnUri = CatalogueData.Categories.buildUri(_id);
                }else{
                    throw new SQLException("Failed to insert row into: "+ uri);
                }
                break;

            case STOCKS_ALL_RECORDS:
                _id = db.insert(CatalogueData.Stocks.TABLE_NAME,
                        null,
                        values);
                if(_id > 0){
                    returnUri = CatalogueData.Stocks.buildUri(_id);
                }else{
                    throw new SQLException("Failed to insert row into: "+ uri);
                }
                break;

            case STOCK_IMAGES_ALL_RECORDS:
                _id = db.insert(CatalogueData.StockImages.TABLE_NAME,
                        null,
                        values);
                if(_id > 0){
                    returnUri = CatalogueData.StockImages.buildUri(_id);
                }else{
                    throw new SQLException("Failed to insert row into: "+ uri);
                }
                break;

            default:
                throw new UnsupportedOperationException("404 URI Not Found: "+ uri);
        }

        getContext().getContentResolver().notifyChange(uri, null);
        return returnUri;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
