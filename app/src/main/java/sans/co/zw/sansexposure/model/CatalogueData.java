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
    public static final int DATABASE_VERSION = 1;

    public static final class Designers{
        public static final String TABLE_NAME = "designers";

        public static final Uri CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY+"/"+TABLE_NAME);
        public static final String CONTENT_ALL_TYPE = "vnd.android.cursor.dir/vnd."+CONTENT_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."+CONTENT_URI;

        public static Uri buildUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        private static final String[] ROW_0 = {"Lady_Cee_Kay", "Lady Cee Kay", "Cecelia", "N/A"};
        private static final String[] ROW_1 = {"Alternative_Tapfuma_Munenge", "Alternative Tapfuma Munenge", "Tapfuma", "N/A"};
        public static final int[] PICS      = {R.drawable.lady_cee_kay, R.drawable.alternative_tapfuma};

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
        public static final String[] ROW_5 = {"shirts","Shirts"};
        public static final int[] PICS   = {R.drawable.african_shirt,R.drawable.dangaree,
                                            R.drawable.dresses,R.drawable.shorts,
                                            R.drawable.skirts_and_tops,R.drawable.shirts};

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

        public static final Uri CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY+"/"+TABLE_NAME);
        public static final String CONTENT_ALL_TYPE = "vnd.android.cursor.dir/vnd."+CONTENT_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."+CONTENT_URI;

        public static Uri buildUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        public static final String[] ROW_0 = {"batikhaze1","30","0","0","Alternative_Tapfuma_Munenge","1","Batik Haze","Shirts","N/A"};
        public static final String[] ROW_1 = {"butterflyeffect1","30","0","0","Alternative_Tapfuma_Munenge","1","Butterfly Effect","Shirts","N/A"};
        public static final String[] ROW_2 = {"cee001","35","0","0","Lady_Cee_Kay","1","African Shirt","african_shirts","N/A"};
        public static final String[] ROW_3 = {"cee002","30","0","0","Lady_Cee_Kay","1","African Shirt","african_shirts","N/A"};
        public static final String[] ROW_4 = {"cee003","30","0","0","Lady_Cee_Kay","1","African Shirt","african_shirts","N/A"};
        public static final String[] ROW_5 = {"cee004","25","0","0","Lady_Cee_Kay","1","African Shirt","african_shirts","N/A"};
        public static final String[] ROW_6 = {"cee005","30","0","0","Lady_Cee_Kay","0","Dangaree","dangarees","N/A"};
        public static final String[] ROW_7 = {"cee006","45","0","0","Lady_Cee_Kay","0","African Dress","dresses","N/A"};
        public static final String[] ROW_8 = {"cee007","45","0","0","Lady_Cee_Kay","0","African Dress","dresses","N/A"};
        public static final String[] ROW_9 = {"cee008","45","0","0","Lady_Cee_Kay","0","African Outfit","dresses","N/A"};
        public static final String[] ROW_10 = {"cee009","30","0","0","Lady_Cee_Kay","0","Cocktail Dress","dresses","N/A"};
        public static final String[] ROW_11 = {"cee010","45","0","0","Lady_Cee_Kay","0","Dashik Dress","dresses","N/A"};
        public static final String[] ROW_12 = {"cee011","45","0","0","Lady_Cee_Kay","0","Dashiki Dress","dresses","N/A"};
        public static final String[] ROW_13 = {"cee012","25","0","0","Lady_Cee_Kay","0","Maxxi Dress","dresses","N/A"};
        public static final String[] ROW_14 = {"cee013","25","0","0","Lady_Cee_Kay","0","African Shorts","shorts","N/A"};
        public static final String[] ROW_15 = {"cee014","25","0","0","Lady_Cee_Kay","0","Stretchy Dress","dresses","N/A"};
        public static final String[] ROW_16 = {"cee015","20","0","0","Lady_Cee_Kay","0","Chiffon Top","skirts_and_tops","N/A"};
        public static final String[] ROW_17 = {"cee016","25","0","0","Lady_Cee_Kay","0","Peplum Top","skirts_and_tops","N/A"};
        public static final String[] ROW_18 = {"cee017","25","0","0","Lady_Cee_Kay","0","Peplum Top","skirts_and_tops","N/A"};
        public static final String[] ROW_19 = {"cee018","45","0","0","Lady_Cee_Kay","0","Peplum top and pencil skirt","skirts_and_tops","N/A"};
        public static final String[] ROW_20 = {"cee019","40","0","0","Lady_Cee_Kay","0","Shatter skirt and Croptop","skirts_and_tops","N/A"};
        public static final String[] ROW_21 = {"cee020","25","0","0","Lady_Cee_Kay","0","Skatter Skirt","skirts_and_tops","N/A"};
        public static final String[] ROW_22 = {"cee21","25","0","0","Lady_Cee_Kay","0","Skatter Skirt","skirts_and_tops","N/A"};
        public static final String[] ROW_23 = {"cee22","35","0","0","Lady_Cee_Kay","0","Skatter Skirt and Crop Top","skirts_and_tops","N/A"};
        public static final String[] ROW_24 = {"cee23","25","0","0","Lady_Cee_Kay","0","African Shorts","shorts","N/A"};
        public static final String[] ROW_25 = {"darkfantasy1","30","0","0","Alternative_Tapfuma_Munenge","1","Dark Fantasy","Shirts","N/A"};
        public static final String[] ROW_26 = {"dreamland1","40","0","0","Alternative_Tapfuma_Munenge","1","Dreamland","Shirts","N/A"};
        public static final String[] ROW_27 = {"savagegarden1","30","0","0","Alternative_Tapfuma_Munenge","1","Savage Garden","Shirts","N/A"};
        public static final String[] ROW_28 = {"thebestseller","30","0","0","Alternative_Tapfuma_Munenge","1","The Best Seller","Shirts","N/A"};

        public static final int[] PICS   = {R.drawable.batikhaze,R.drawable.butterflyeffect,R.drawable.african_shirt,R.drawable.cee002,
                                            R.drawable.cee003,R.drawable.cee004,R.drawable.dangaree,R.drawable.cee006,R.drawable.cee007,R.drawable.cee008,
                                            R.drawable.dresses,R.drawable.cee010,R.drawable.cee011,R.drawable.cee012,R.drawable.cee013,
                                            R.drawable.cee014,R.drawable.cee015,R.drawable.cee016,R.drawable.cee017,R.drawable.cee018,R.drawable.cee019,
                                            R.drawable.cee020,R.drawable.skirts_and_tops,R.drawable.cee22,R.drawable.shorts,R.drawable.darkfantasy,R.drawable.dreamland,
                                            R.drawable.savagegarden,R.drawable.shirts};

        public static Map<Integer, String[]> DB_DATA = createDataMap();
        private static Map<Integer, String[]> createDataMap(){
            Map<Integer, String[]> result = new HashMap<Integer, String[]>();
            result.put(0, ROW_0);
            result.put(1, ROW_1);
            result.put(2, ROW_2);
            result.put(3, ROW_3);
            result.put(4, ROW_4);
            result.put(5, ROW_5);
            result.put(6, ROW_6);
            result.put(7, ROW_7);
            result.put(8, ROW_8);
            result.put(9, ROW_9);
            result.put(10, ROW_10);
            result.put(11, ROW_11);
            result.put(12, ROW_12);
            result.put(13, ROW_13);
            result.put(14, ROW_14);
            result.put(15, ROW_15);
            result.put(16, ROW_16);
            result.put(17, ROW_17);
            result.put(18, ROW_18);
            result.put(19, ROW_19);
            result.put(20, ROW_20);
            result.put(21, ROW_21);
            result.put(22, ROW_22);
            result.put(23, ROW_23);
            result.put(24, ROW_24);
            result.put(25, ROW_25);
            result.put(26, ROW_26);
            result.put(27, ROW_27);
            result.put(28, ROW_28);
            return java.util.Collections.unmodifiableMap(result);
        }

        public static final String COL_ID = "_id";
        public static final String COL_CODE = "code";
        public static final String COL_PRICE = "price";
        public static final String COL_SIZE = "size";
        public static final String COL_QUANTITY = "quantity";
        public static final String COL_DESIGNER = "designer";
        public static final String COL_SEX = "sex";
        public static final String COL_ITEM_NAME = "item_name";
        public static final String COL_COLLECTION = "collection";
        public static final String COL_DESCRIPTION = "description";
        public static final String COL_PIC = "pic";


        public static final int CURSOR_COL_STOCKS_ID = 0;
        public static final int CURSOR_COL_STOCKS_CODE = 1;
        public static final int CURSOR_COL_STOCKS_PRICE = 2;
        public static final int CURSOR_COL_STOCKS_DESIGNER = 5;
        public static final int CURSOR_COL_STOCKS_SEX = 6;
        public static final int CURSOR_COL_STOCKS_ITEM_NAME = 7;
        public static final int CURSOR_COL_STOCKS_COLLECTION = 8;
        public static final int CURSOR_COL_STOCKS_PIC = 10;
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
            "  `price` VARCHAR(255),\n" +
            "  `size` VARCHAR(255),\n" +
            "  `quantity` VARCHAR(255),\n" +
            "  `designer` VARCHAR(255),\n" +
            "  `sex` VARCHAR(255),\n" +
            "  `item_name` VARCHAR(255),\n" +
            "  `collection` VARCHAR(255),\n" +
            "  `description` VARCHAR(255), \n" +
            "  `pic` VARCHAR(255)\n" +
            ");";
    public static final String CREATE_STOCK_IMAGES_TABLE = "CREATE TABLE IF NOT EXISTS `stock_images` (\n" +
            "  `_id` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  `designer` VARCHAR(255),\n" +
            "  `location` VARCHAR(255),\n" +
            "  `stock_item` VARCHAR(255) \n" +
            ");";

}
