package sans.co.zw.sansexposure.model;

import java.io.Serializable;

/**
 * Created by Steve on 04/04/2015.
 */
public class StockItem implements Serializable{

    String[] imgLocations;
    String designer;
    String price;
    String code;
    String itemName;
    String collection;
    String mainPic;
    String sex;

    public StockItem(String[] imgLocations, String designer, String price, String code, String itemName, String collection, String mainPic, String sex) {
        this.imgLocations = imgLocations;
        this.designer = designer;
        this.price = price;
        this.code = code;
        this.itemName = itemName;
        this.collection = collection;
        this.mainPic = mainPic;
        this.sex = sex;
    }

    public String[] getImgLocations() {
        return imgLocations;
    }

    public void setImgLocations(String[] imgLocations) {
        this.imgLocations = imgLocations;
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getMainPic() {
        return mainPic;
    }

    public void setMainPic(String mainPic) {
        this.mainPic = mainPic;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
