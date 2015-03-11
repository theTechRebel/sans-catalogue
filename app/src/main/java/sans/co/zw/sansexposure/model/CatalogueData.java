package sans.co.zw.sansexposure.model;

import android.content.ContentUris;
import android.net.Uri;

import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import sans.co.zw.sansexposure.R;

/**
 * Created by Steve on 22/02/2015.
 */
public class CatalogueData{

    public static final String CONTENT_AUTHORITY = "sans.co.zw.sansexposure.model.CatalogueDataProvider";

    public static final String DATABASE_NAME = "sans_catalogue";
    public static final int DATABASE_VERSION = 44;

    public static final class Designers{
        public static final String TABLE_NAME = "designers";

        public static final Uri CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY+"/"+TABLE_NAME);
        public static final String CONTENT_ALL_TYPE = "vnd.android.cursor.dir/vnd."+CONTENT_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."+CONTENT_URI;

        public static Uri buildUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        private static final String[] ROW_0 = {"Lady_Cee_Kay", "Lady Cee Kay", "Cecelia", "N/A"};
        private static final String[] ROW_1 = {"Tariro_The_Jeweler", "Tariro The Jeweler", "Tariro The Jeweler", "N/A"};
        public static final int[] PICS      = {R.drawable.lady_cee_kay, R.drawable.tariro_the_jeweler};

        public static Map<Integer, String[]> DB_DATA = createDataMap();
        private static Map<Integer, String[]> createDataMap(){
            Map<Integer, String[]> result = new HashMap<Integer, String[]>();
            result.put(0,ROW_0);
            result.put(1,ROW_1);
            return java.util.Collections.unmodifiableMap(result);
        }

        public static final String COL_ID = "_id";
        public static final String COL_DESIGNER = "designer";
        public static final String COL_FULLNAME = "full_name";
        public static final String COL_LABEL = "label";
        public static final String COL_BIO = "bio";
        public static final String COL_PIC = "pic";

        public static final int CURSOR_COL_DESIGNER_ID = 0;
        public static final int CURSOR_COL_DESIGNER = 1;
        public static final int CURSOR_COL_DESIGNER_LABEL = 2;
        public static final int CURSOR_COL_DESIGNER_FULLNAME = 3;
        public static final int CURSOR_COL_DESIGNER_BIO = 4;
        public static final int CURSOR_COL_DESIGNER_PIC = 5;
    }

    public static final class Categories {
        public static final String TABLE_NAME = "categories";

        public static final Uri CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY+"/"+TABLE_NAME);
        public static final String CONTENT_ALL_TYPE = "vnd.android.cursor.dir/vnd."+CONTENT_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."+CONTENT_URI;

        public static Uri buildUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        public static final String[] ROW_0 = {"african_shirts","African Shirts"};
        public static final String[] ROW_1 = {"dangarees","Dangarees"};
        public static final String[] ROW_2 = {"dresses","Dresses"};
        public static final String[] ROW_3 = {"shorts","Shorts"};
        public static final String[] ROW_4 = {"skirts_and_tops","Skirts And Tops"};
        public static final String[] ROW_5 = {"jewelery","Jewelery"};
        public static final int[] PICS   = {R.drawable.african_shirt,R.drawable.dangaree,
                                            R.drawable.dresses,R.drawable.shorts,
                                            R.drawable.skirts_and_tops,R.drawable.jewelery};

        public static Map<Integer, String[]> DB_DATA = createDataMap();
        private static Map<Integer, String[]> createDataMap(){
            Map<Integer, String[]> result = new HashMap<Integer, String[]>();
            result.put(0, ROW_0);
            result.put(1, ROW_1);
            result.put(2, ROW_2);
            result.put(3, ROW_3);
            result.put(4, ROW_4);
            result.put(5, ROW_5);
            return java.util.Collections.unmodifiableMap(result);
        }

        public static final String COL_ID = "_id";
        public static final String COL_KEY = "key";
        public static final String COL_VALUE = "value";
        public static final String COL_PIC = "pic";

        public static final int CURSOR_COL_CATEGORY_ID = 0;
        public static final int CURSOR_COL_CATEGORY_KEY = 1;
        public static final int CURSOR_COL_CATEGORY_VALUE = 2;
        public static final int CURSOR_COL_CATEGORY_PIC = 3;
    }

    public static final class Stocks{
        public static final String TABLE_NAME = "stocks";
    }

    public static final class StockImages{
        public static final String TABLE_NAME = "stock_images";
    }

    //drop table statements
    public static final String DROP_TABLE_DESIGNERS = "DROP TABLE IF EXISTS `designers`";
    public static final String DROP_TABLE_CATEGORIES = "DROP TABLE IF EXISTS `categories`";
    public static final String DROP_TABLE_STOCKS = "DROP TABLE IF EXISTS `stocks`";
    public static final String DROP_TABLE_STOCK_IMAGES = "DROP TABLE IF EXISTS `stock_images`";


    //create table statements
    public static final String CREATE_DESIGNERS_TABLE = "CREATE TABLE IF NOT EXISTS `designers` (\n" +
            "  `_id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  `designer` VARCHAR(255),\n" +
            "  `label` VARCHAR(255),\n" +
            "  `full_name` VARCHAR(255),\n" +
            "  `bio` VARCHAR(255),\n" +
            "  `pic` VARCHAR(255) \n" +
            ");";
    public static final String CREATE_CATEGORIES_TABLE = "CREATE TABLE IF NOT EXISTS `categories` (\n" +
            "  `_id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  `key` VARCHAR(255),\n" +
            "  `value` VARCHAR(255),\n" +
            "  `pic` VARCHAR(255) \n" +
            ");";
    public static final String CREATE_STOCKS_TABLE = "CREATE TABLE IF NOT EXISTS `stocks` (\n" +
            "  `_id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
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
    public static final String CREATE_STOCK_IMAGES_TABLE = "CREATE TABLE IF NOT EXISTS `stock_images` (\n" +
            "  `_id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  `designer` VARCHAR(255),\n" +
            "  `location` VARCHAR(255),\n" +
            "  `stock_item` VARCHAR(255) \n" +
            ");";

}
