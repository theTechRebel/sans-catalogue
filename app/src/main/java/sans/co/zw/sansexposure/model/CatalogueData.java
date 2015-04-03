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
    public static final int DATABASE_VERSION = 6;

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

        public static final Uri CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY+"/"+TABLE_NAME);
        public static final String CONTENT_ALL_TYPE = "vnd.android.cursor.dir/vnd."+CONTENT_URI;
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd."+CONTENT_URI;

        public static Uri buildUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        private static final String[] ROW_0 = {"Alternative_Tapfuma_Munenge","batikhaze1"};
        private static final String[] ROW_1 = {"Alternative_Tapfuma_Munenge","batikhaze1"};
        private static final String[] ROW_2 = {"Alternative_Tapfuma_Munenge","batikhaze1"};
        private static final String[] ROW_3 = {"Alternative_Tapfuma_Munenge","batikhaze1"};

        private static final String[] ROW_7 = {"Alternative_Tapfuma_Munenge","butterflyeffect1"};
        private static final String[] ROW_8 = {"Alternative_Tapfuma_Munenge","butterflyeffect1"};
        private static final String[] ROW_9 = {"Alternative_Tapfuma_Munenge","butterflyeffect1"};
        private static final String[] ROW_10 = {"Alternative_Tapfuma_Munenge","butterflyeffect1"};

        private static final String[] ROW_11 = {"Alternative_Tapfuma_Munenge","darkfantasy1"};
        private static final String[] ROW_12 = {"Alternative_Tapfuma_Munenge","darkfantasy1"};
        private static final String[] ROW_13 = {"Alternative_Tapfuma_Munenge","darkfantasy1"};
        private static final String[] ROW_14= {"Alternative_Tapfuma_Munenge","darkfantasy1"};

        private static final String[] ROW_15 = {"Alternative_Tapfuma_Munenge","dreamland1"};
        private static final String[] ROW_16 = {"Alternative_Tapfuma_Munenge","dreamland1"};
        private static final String[] ROW_17 = {"Alternative_Tapfuma_Munenge","dreamland1"};
        private static final String[] ROW_18= {"Alternative_Tapfuma_Munenge","dreamland1"};

        private static final String[] ROW_19 = {"Alternative_Tapfuma_Munenge","savagegarden1"};
        private static final String[] ROW_20 = {"Alternative_Tapfuma_Munenge","savagegarden1"};
        private static final String[] ROW_21 = {"Alternative_Tapfuma_Munenge","savagegarden1"};
        private static final String[] ROW_22 = {"Alternative_Tapfuma_Munenge","savagegarden1"};

        private static final String[] ROW_23 = {"Alternative_Tapfuma_Munenge","thebestseller"};
        private static final String[] ROW_24 = {"Alternative_Tapfuma_Munenge","thebestseller"};
        private static final String[] ROW_25 = {"Alternative_Tapfuma_Munenge","thebestseller"};
        private static final String[] ROW_26 = {"Alternative_Tapfuma_Munenge","thebestseller"};

        private static final String[] ROW_27 = {"Lady_Cee_Kay","cee001"};
        private static final String[] ROW_28 = {"Lady_Cee_Kay","cee001"};
        private static final String[] ROW_29 = {"Lady_Cee_Kay","cee001"};

        private static final String[] ROW_30 = {"Lady_Cee_Kay","cee002"};
        private static final String[] ROW_31 = {"Lady_Cee_Kay","cee002"};
        private static final String[] ROW_32 = {"Lady_Cee_Kay","cee002"};

        private static final String[] ROW_33 = {"Lady_Cee_Kay","cee003"};
        private static final String[] ROW_34 = {"Lady_Cee_Kay","cee003"};
        private static final String[] ROW_35 = {"Lady_Cee_Kay","cee003"};

        private static final String[] ROW_36 = {"Lady_Cee_Kay","cee004"};
        private static final String[] ROW_37 = {"Lady_Cee_Kay","cee004"};
        private static final String[] ROW_38 = {"Lady_Cee_Kay","cee004"};
        private static final String[] ROW_39 = {"Lady_Cee_Kay","cee004"};

        private static final String[] ROW_40 = {"Lady_Cee_Kay","cee005"};
        private static final String[] ROW_41 = {"Lady_Cee_Kay","cee005"};
        private static final String[] ROW_42 = {"Lady_Cee_Kay","cee005"};
        private static final String[] ROW_43 = {"Lady_Cee_Kay","cee005"};

        private static final String[] ROW_44 = {"Lady_Cee_Kay","cee006"};
        private static final String[] ROW_45 = {"Lady_Cee_Kay","cee006"};
        private static final String[] ROW_46 = {"Lady_Cee_Kay","cee006"};

        private static final String[] ROW_47 = {"Lady_Cee_Kay","cee007"};
        private static final String[] ROW_48 = {"Lady_Cee_Kay","cee007"};
        private static final String[] ROW_49 = {"Lady_Cee_Kay","cee007"};

        private static final String[] ROW_50 = {"Lady_Cee_Kay","cee008"};
        private static final String[] ROW_51 = {"Lady_Cee_Kay","cee008"};
        private static final String[] ROW_52 = {"Lady_Cee_Kay","cee008"};

        private static final String[] ROW_53 = {"Lady_Cee_Kay","cee009"};
        private static final String[] ROW_54 = {"Lady_Cee_Kay","cee009"};
        private static final String[] ROW_55 = {"Lady_Cee_Kay","cee009"};
        private static final String[] ROW_56 = {"Lady_Cee_Kay","cee009"};

        private static final String[] ROW_57 = {"Lady_Cee_Kay","cee010"};
        private static final String[] ROW_58 = {"Lady_Cee_Kay","cee010"};
        private static final String[] ROW_59 = {"Lady_Cee_Kay","cee010"};

        private static final String[] ROW_60 = {"Lady_Cee_Kay","cee011"};
        private static final String[] ROW_61 = {"Lady_Cee_Kay","cee011"};
        private static final String[] ROW_62 = {"Lady_Cee_Kay","cee011"};

        private static final String[] ROW_63 = {"Lady_Cee_Kay","cee012"};
        private static final String[] ROW_64 = {"Lady_Cee_Kay","cee012"};
        private static final String[] ROW_65 = {"Lady_Cee_Kay","cee012"};
        private static final String[] ROW_66 = {"Lady_Cee_Kay","cee012"};

        private static final String[] ROW_68 = {"Lady_Cee_Kay","cee013"};
        private static final String[] ROW_69 = {"Lady_Cee_Kay","cee013"};
        private static final String[] ROW_70 = {"Lady_Cee_Kay","cee013"};
        private static final String[] ROW_71 = {"Lady_Cee_Kay","cee013"};

        private static final String[] ROW_72 = {"Lady_Cee_Kay","cee014"};
        private static final String[] ROW_73 = {"Lady_Cee_Kay","cee014"};
        private static final String[] ROW_74 = {"Lady_Cee_Kay","cee014"};
        private static final String[] ROW_75 = {"Lady_Cee_Kay","cee014"};

        private static final String[] ROW_79 = {"Lady_Cee_Kay","cee015"};
        private static final String[] ROW_80 = {"Lady_Cee_Kay","cee015"};
        private static final String[] ROW_81 = {"Lady_Cee_Kay","cee015"};
        private static final String[] ROW_82 = {"Lady_Cee_Kay","cee015"};

        private static final String[] ROW_84 = {"Lady_Cee_Kay","cee016"};
        private static final String[] ROW_85 = {"Lady_Cee_Kay","cee016"};
        private static final String[] ROW_86 = {"Lady_Cee_Kay","cee016"};

        private static final String[] ROW_87 = {"Lady_Cee_Kay","cee017"};
        private static final String[] ROW_88 = {"Lady_Cee_Kay","cee017"};
        private static final String[] ROW_89 = {"Lady_Cee_Kay","cee017"};
        private static final String[] ROW_90 = {"Lady_Cee_Kay","cee017"};

        private static final String[] ROW_91 = {"Lady_Cee_Kay","cee018"};
        private static final String[] ROW_92 = {"Lady_Cee_Kay","cee018"};
        private static final String[] ROW_93 = {"Lady_Cee_Kay","cee018"};
        private static final String[] ROW_94 = {"Lady_Cee_Kay","cee018"};

        private static final String[] ROW_95 = {"Lady_Cee_Kay","cee019"};
        private static final String[] ROW_96 = {"Lady_Cee_Kay","cee019"};
        private static final String[] ROW_97 = {"Lady_Cee_Kay","cee019"};
        private static final String[] ROW_98 = {"Lady_Cee_Kay","cee019"};

        private static final String[] ROW_99 = {"Lady_Cee_Kay","cee020"};
        private static final String[] ROW_100 = {"Lady_Cee_Kay","cee020"};
        private static final String[] ROW_101 = {"Lady_Cee_Kay","cee020"};
        private static final String[] ROW_102 = {"Lady_Cee_Kay","cee020"};

        private static final String[] ROW_105 = {"Lady_Cee_Kay","cee21"};
        private static final String[] ROW_106 = {"Lady_Cee_Kay","cee21"};
        private static final String[] ROW_107 = {"Lady_Cee_Kay","cee21"};
        private static final String[] ROW_108 = {"Lady_Cee_Kay","cee21"};

        private static final String[] ROW_109 = {"Lady_Cee_Kay","cee22"};
        private static final String[] ROW_110 = {"Lady_Cee_Kay","cee22"};
        private static final String[] ROW_111 = {"Lady_Cee_Kay","cee22"};

        private static final String[] ROW_112 = {"Lady_Cee_Kay","cee23"};
        private static final String[] ROW_113 = {"Lady_Cee_Kay","cee23"};
        private static final String[] ROW_114 = {"Lady_Cee_Kay","cee23"};
        private static final String[] ROW_115 = {"Lady_Cee_Kay","cee23"};


        public static final int[] PICS      =
                {
                        R.drawable.batikhaze1_1,R.drawable.batikhaze1_2,R.drawable.batikhaze1_3,R.drawable.batikhaze1_4,
                        R.drawable.butterflyeffect1_1,R.drawable.butterflyeffect1_2,R.drawable.butterflyeffect1_3,R.drawable.butterflyeffect1_4,
                        R.drawable.darkfantasy1_1,R.drawable.darkfantasy1_2,R.drawable.darkfantasy1_3,R.drawable.darkfantasy1_4,
                        R.drawable.dreamland1_1,R.drawable.dreamland1_2,R.drawable.dreamland1_3,R.drawable.dreamland1_4,
                        R.drawable.savagegarden1_1,R.drawable.savagegarden1_2,R.drawable.savagegarden1_3,R.drawable.savagegarden1_4,
                        R.drawable.thebestseller_1,R.drawable.thebestseller_2,R.drawable.thebestseller_3,R.drawable.thebestseller_4,
                        R.drawable.cee001_1,R.drawable.cee001_2,R.drawable.cee001_3,
                        R.drawable.cee002_1,R.drawable.cee002_2,R.drawable.cee002_3,
                        R.drawable.cee003_1,R.drawable.cee003_2,R.drawable.cee003_3,
                        R.drawable.cee004_1,R.drawable.cee004_2,R.drawable.cee004_3,R.drawable.cee004_4,
                        R.drawable.cee005_1,R.drawable.cee005_2,R.drawable.cee005_3,R.drawable.cee005_4,
                        R.drawable.cee006_1,R.drawable.cee006_2,R.drawable.cee006_3,
                        R.drawable.cee007_1,R.drawable.cee007_2,R.drawable.cee007_3,
                        R.drawable.cee008_1,R.drawable.cee008_2,R.drawable.cee008_3,
                        R.drawable.cee009_1,R.drawable.cee009_2,R.drawable.cee009_3,R.drawable.cee009_4,
                        R.drawable.cee010_1,R.drawable.cee010_2,R.drawable.cee010_3,
                        R.drawable.cee011_1,R.drawable.cee011_2,R.drawable.cee011_3,
                        R.drawable.cee012_1,R.drawable.cee012_2,R.drawable.cee012_3,R.drawable.cee012_4,
                        R.drawable.cee013_1,R.drawable.cee013_2,R.drawable.cee013_3,R.drawable.cee013_4,
                        R.drawable.cee014_1,R.drawable.cee014_2,R.drawable.cee014_3,R.drawable.cee014_4,
                        R.drawable.cee015_1,R.drawable.cee015_2,R.drawable.cee015_3,R.drawable.cee015_4,
                        R.drawable.cee016_1,R.drawable.cee016_2,R.drawable.cee016_3,
                        R.drawable.cee017_1,R.drawable.cee017_2,R.drawable.cee017_3,R.drawable.cee017_4,
                        R.drawable.cee018_1,R.drawable.cee018_2,R.drawable.cee018_3,R.drawable.cee018_4,
                        R.drawable.cee019_1,R.drawable.cee019_2,R.drawable.cee019_3,R.drawable.cee019_4,
                        R.drawable.cee20_1,R.drawable.cee20_2,R.drawable.cee20_3,R.drawable.cee20_4,
                        R.drawable.cee21_1,R.drawable.cee21_2,R.drawable.cee21_3,R.drawable.cee21_4,
                        R.drawable.cee22_1,R.drawable.cee22_2,R.drawable.cee22_3,
                        R.drawable.cee23_1,R.drawable.cee23_2,R.drawable.cee23_3,R.drawable.cee23_4
                };

        public static Map<Integer, String[]> DB_DATA = createDataMap();
        private static Map<Integer, String[]> createDataMap(){
            Map<Integer, String[]> result = new HashMap<Integer, String[]>();
            result.put(0,ROW_0 );
            result.put(1,ROW_1 );
            result.put(2,ROW_2 );
            result.put(3,ROW_3 );

            result.put(4,ROW_7 );
            result.put(5,ROW_8 );
            result.put(6,ROW_9 );
            result.put(7,ROW_10);

            result.put(8,ROW_11);
            result.put(9,ROW_12);
            result.put(10,ROW_13);
            result.put(11,ROW_14);

            result.put(12,ROW_15);
            result.put(13,ROW_16);
            result.put(14,ROW_17);
            result.put(15,ROW_18);

            result.put(16,ROW_19);
            result.put(17,ROW_20);
            result.put(18,ROW_21);
            result.put(19,ROW_22);

            result.put(20,ROW_23);
            result.put(21,ROW_24);
            result.put(22,ROW_25);
            result.put(23,ROW_26);

            result.put(24,ROW_27);
            result.put(25,ROW_28);
            result.put(26,ROW_29);

            result.put(27,ROW_30);
            result.put(28,ROW_31);
            result.put(29,ROW_32);

            result.put(30,ROW_33);
            result.put(31,ROW_34);
            result.put(32,ROW_35);

            result.put(33,ROW_36);
            result.put(34,ROW_37);
            result.put(35,ROW_38);
            result.put(36,ROW_39);

            result.put(37,ROW_40);
            result.put(38,ROW_41);
            result.put(39,ROW_42);
            result.put(40,ROW_43);

            result.put(41,ROW_44);
            result.put(42,ROW_45);
            result.put(43,ROW_46);

            result.put(44,ROW_47);
            result.put(45,ROW_48);
            result.put(46,ROW_49);

            result.put(47,ROW_50);
            result.put(48,ROW_51);
            result.put(49,ROW_52);

            result.put(50,ROW_53);
            result.put(51,ROW_54);
            result.put(52,ROW_55);
            result.put(53,ROW_56);

            result.put(54,ROW_57);
            result.put(55,ROW_58);
            result.put(56,ROW_59);

            result.put(57,ROW_60);
            result.put(58,ROW_61);
            result.put(59,ROW_62);

            result.put(60,ROW_63);
            result.put(61,ROW_64);
            result.put(62,ROW_65);
            result.put(63,ROW_66);

            result.put(64,ROW_68);
            result.put(65,ROW_69);
            result.put(66,ROW_70);
            result.put(67,ROW_71);

            result.put(68,ROW_72);
            result.put(69,ROW_73);
            result.put(70,ROW_74);
            result.put(71,ROW_75);

            result.put(72,ROW_79);
            result.put(73,ROW_80);
            result.put(74,ROW_81);
            result.put(75,ROW_82);

            result.put(76,ROW_84);
            result.put(77,ROW_85);
            result.put(78,ROW_86);

            result.put(79,ROW_87);
            result.put(80,ROW_88);
            result.put(81,ROW_89);
            result.put(82,ROW_90);

            result.put(83,ROW_91);
            result.put(84,ROW_92);
            result.put(85,ROW_93);
            result.put(86,ROW_94);

            result.put(87,ROW_95);
            result.put(88,ROW_96);
            result.put(89,ROW_97);
            result.put(90,ROW_98);

            result.put(91,ROW_99);
            result.put(92,ROW_100);
            result.put(93,ROW_101);
            result.put(94,ROW_102);

            result.put(95,ROW_105);
            result.put(96,ROW_106);
            result.put(97,ROW_107);
            result.put(98,ROW_108);

            result.put(99,ROW_109);
            result.put(100,ROW_110);
            result.put(101,ROW_111);

            result.put(102,ROW_112);
            result.put(103,ROW_113);
            result.put(104,ROW_114);
            result.put(105,ROW_115);
            return java.util.Collections.unmodifiableMap(result);
        }

        public static final String COL_ID = "_id";
        public static final String COL_DESIGNER = "designer";
        public static final String COL_LOCATION = "location";
        public static final String COL_STOCK_ITEM = "stock_item";

        public static final int CURSOR_COL_STOCK_IMAGES_ID = 0;
        public static final int CURSOR_COL_STOCK_IMAGES_DESIGNER = 1;
        public static final int CURSOR_COL_STOCK_IMAGES_LOCATION = 2;
        public static final int CURSOR_COL_STOCK_IMAGES_STOCK_ITEM = 3;
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
