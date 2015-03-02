package sans.co.zw.sansexposure.model;

/**
 * Created by Steve on 02/03/2015.
 */
public class GridViewData {
        private int imageId;
        private String itemName;

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
}
