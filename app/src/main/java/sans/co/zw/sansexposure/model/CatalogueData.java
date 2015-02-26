package sans.co.zw.sansexposure.model;

import android.content.ContentUris;
import android.net.Uri;

/**
 * Created by Steve on 22/02/2015.
 */
public class CatalogueData{

    public static final String CONTENT_AUTHORITY = "sans.co.zw.sansexposure.model.CatalogueDataProvider";

    public static final String DATABASE_NAME = "sans_catalogue";
    public static final int DATABASE_VERSION = 29;

    public static final class Designers{
        public static final String TABLE_NAME = "designers";

        public static final Uri CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY+"/"+TABLE_NAME);
        public static final String CONTENT_ALL_TYPE = "vnd.android.cursor.dir/vnd."+CONTENT_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."+CONTENT_URI;

        public static Uri buildUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        public static final String STATEMENT_INSERT = "INSERT INTO `designers` (`_ID`, `surname`, `label`, `full_name`, `bio`, `pic`) VALUES ";
        public static final String ROW_1 = "(1, 'Lady_Cee_Kay', 'Lady Cee Kay', 'Cecelia', 'N/A', 'image_location_here'); ";
        public static final String ROW_2 = "(2, 'Tariro_The_Jeweler', 'Tariro The Jeweler', 'Tariro The Jeweler', 'N/A', 'image_location_here'); ";

        public static final String COL_ID = "_ID";
        public static final String COL_LABEL = "label";
        public static final String COL_BIO = "bio";
        public static final String COL_PIC = "pic";
    }

    public static final class Collections{
        public static final String TABLE_NAME = "collections";

        public static final Uri CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY+"/"+TABLE_NAME);
        public static final String CONTENT_ALL_TYPE = "vnd.android.cursor.dir/vnd."+CONTENT_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."+CONTENT_URI;

        public static Uri buildUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        public static final String STATEMENT_INSERT = "INSERT INTO `collections` (`_ID`, `collection_name`) VALUES ";
        public static final String ROW_1 = "(1, 'african_shirts');";
        public static final String ROW_2 = "(2, 'dangarees');";
        public static final String ROW_3 = "(3, 'dresses');";
        public static final String ROW_4 = "(4, 'shorts');";
        public static final String ROW_5 = "(5, 'skirts_and_tops');";
        public static final String ROW_6 = "(6, 'Jewelery');";

        public static final String COL_ID = "_ID";
        public static final String COL_NAME = "collection_name";
    }

    public static final class Stocks{
        public static final String TABLE_NAME = "stocks";
    }

    public static final class StockImages{
        public static final String TABLE_NAME = "stock_images";
    }

    //drop table statements
    public static final String DROP_TABLE_STOCK_IMAGES = "DROP TABLE IF EXISTS `stock_images`";
    public static final String DROP_TABLE_DESIGNERS = "DROP TABLE IF EXISTS `stocks`";
    public static final String DROP_TABLE_STOCKS = "DROP TABLE IF EXISTS `designers`";
    public static final String DROP_TABLE_COLLECTIONS = "DROP TABLE IF EXISTS `collections`";

    //create table statements
    public static final String CREATE_DESIGNERS_TABLE = "CREATE TABLE IF NOT EXISTS `designers` (\n" +
            "  `_ID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  `surname` VARCHAR(255),\n" +
            "  `label` VARCHAR(256),\n" +
            "  `full_name` VARCHAR(255),\n" +
            "  `bio` VARCHAR(255),\n" +
            "  `pic` VARCHAR(255) \n" +
            ");";
    public static final String CREATE_STOCKS_TABLE = "CREATE TABLE IF NOT EXISTS `stocks` (\n" +
            "  `_ID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
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
            "  `_ID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  `designer` VARCHAR(255),\n" +
            "  `location` VARCHAR(255),\n" +
            "  `stock_item` VARCHAR(255) \n" +
            ");";
    public static final String CREATE_COLLECTIONS = "CREATE TABLE IF NOT EXISTS `collections` (\n" +
            "  `_ID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "  `collection_name` VARCHAR(255)\n" +
            ");";
}
