package sans.co.zw.sansexposure.view;

import android.content.Context;
import android.content.res.ColorStateList;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.helpers.Router;
import sans.co.zw.sansexposure.helpers.UserPreferences;
import sans.co.zw.sansexposure.model.StockItem;


/**
 * Created by Steve on 03/04/2015.
 */
public class GalleryFragment extends Fragment
    implements  SlidingUpPanelLayout.PanelSlideListener, View.OnClickListener {

    private UserPreferences userPrefs;
    Router router;
    private static String TAG = "GalleryFragment";
    ViewPager mViewPager;
    GalleryFragmentPagerAdapter mAdapter;
    private SlidingUpPanelLayout mLayout;
    TextView code, designer, sex, collection, price,itemName;
    Button placeOrder;
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
        userPrefs = new UserPreferences(getActivity());
        router = (Router)getActivity();

        mLayout = (SlidingUpPanelLayout)getView().findViewById(R.id.sliding_layout);
        mLayout.setPanelSlideListener(this);

        stockItem = (StockItem)getArguments().getSerializable(STOCK_ITEM);

        code = (TextView)getView().findViewById(R.id.code);
        designer = (TextView)getView().findViewById(R.id.designer);
        sex = (TextView)getView().findViewById(R.id.sex);
        collection = (TextView)getView().findViewById(R.id.collection);
        price = (TextView)getView().findViewById(R.id.price);
        itemName = (TextView)getView().findViewById(R.id.itemName);
        placeOrder = (Button)getView().findViewById(R.id.order);

        placeOrder.setOnClickListener(this);

        code.setText(stockItem.getCode());
        designer.setText(stockItem.getDesigner());
        collection.setText(stockItem.getCollection());
        switch(stockItem.getSex()){
            case "1":
                sex.setText("Male");
                break;
            case "0":
                sex.setText("Female");
                break;
            case "2":
                sex.setText("UniSex");
                break;
            default:
                sex.setText("");
                break;
        }
        price.setText(stockItem.getPrice());
        itemName.setText(stockItem.getItemName());

        mAdapter = new GalleryFragmentPagerAdapter(getActivity(),stockItem);
        mViewPager = (ViewPager) getView().findViewById(R.id.gallery_pager);
        mViewPager.setAdapter(mAdapter);
    }

    //panel
    @Override
    public void onPanelSlide(View view, float v) {
    }

    @Override
    public void onPanelCollapsed(View view) {

    }

    @Override
    public void onPanelExpanded(View view) {
    }

    @Override
    public void onPanelAnchored(View view) {

    }

    @Override
    public void onPanelHidden(View view) {

    }

    //button
    @Override
    public void onClick(View v) {
        router.switchFragmentsAgain(1,stockItem);
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



