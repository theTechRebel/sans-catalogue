package sans.co.zw.sansexposure.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.helpers.UserPreferences;
import sans.co.zw.sansexposure.model.StockItem;


/**
 * Created by Steve on 03/04/2015.
 */
public class GalleryFragment extends Fragment{

    private UserPreferences userPrefs;
    private static String TAG = "GalleryFragment";
    private Context ctx;
    ViewPager mViewPager;
    GalleryFragmentPagerAdapter mAdapter;
    StockItem stockItem;
    public static String STOCK_ITEM = "stockItem";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery,container,false);

    }

    //add adapters and further UI elements in onActivityCreated()
    //because this gets a reference to the context of the Underlying Activity
    //meaning that the Activity has been created and u will not get
    //a NullPointerException
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        stockItem = (StockItem)getArguments().getSerializable(STOCK_ITEM);
        userPrefs = new UserPreferences(getActivity());

        mAdapter = new GalleryFragmentPagerAdapter(getActivity(),stockItem);
        mViewPager = (ViewPager) getView().findViewById(R.id.gallery_pager);
        mViewPager.setAdapter(mAdapter);
    }
}

class GalleryFragmentPagerAdapter extends PagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    StockItem stockItem;

    public GalleryFragmentPagerAdapter(Context context, StockItem stockItem) {
        mContext = context;
        this.stockItem = stockItem;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return stockItem.getImgLocations().length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item_gallery, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        String[] imgLocation = stockItem.getImgLocations();
        Uri theUri = Uri.parse(imgLocation[position]);
        imageView.setImageURI(theUri);

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}



