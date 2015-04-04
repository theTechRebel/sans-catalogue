package sans.co.zw.sansexposure.helpers;

import sans.co.zw.sansexposure.model.StockItem;

/**
 * Created by Steve on 20/02/2015.
 */
public interface Router {
    void swapFragments(int number);
    void launchTabsAcitivity();
    void launchGalleryActivity(StockItem stockItem);
}
