package sans.co.zw.sansexposure._;

import java.util.ArrayList;

/**
 * Created by Steve on 02/03/2015.
 */
public class GridViewData {
        private int imageId;
        private String itemName;
        public static final int SAMPLE_DATA_ITEM_COUNT = 30;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDesigner() {
        return itemDesigner;
    }

    public void setItemDesigner(String itemDesigner) {
        this.itemDesigner = itemDesigner;
    }

    private String itemPrice;
        private String itemDesigner;

    public static ArrayList<GridViewData> generateMoreData() {
        final ArrayList<GridViewData> data = new ArrayList<GridViewData>();

        int[] pics = {
                /*
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
                */
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
            data.add(object);
        }

        return data;
    }
}