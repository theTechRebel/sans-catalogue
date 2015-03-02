package sans.co.zw.sansexposure.model;

import java.util.ArrayList;

import sans.co.zw.sansexposure.R;

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

        for (int i = 0; i < pics.length - 1; i++) {
            GridViewData object = new GridViewData();
            object.setImageId(pics[i]);
            object.setItemName(text[i]);
            data.add(object);
        }

        return data;
    }
}