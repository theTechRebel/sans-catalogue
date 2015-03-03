package sans.co.zw.sansexposure.view;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;

import java.util.ArrayList;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.model.CatalogueData;
import sans.co.zw.sansexposure.model.GridViewData;

/**
 * Created by Steve on 26/02/2015.
 */
public class StaggeredGridFragment extends Fragment
    implements
        AbsListView.OnScrollListener,
        AbsListView.OnItemClickListener,
        LoaderManager.LoaderCallbacks<Cursor>{

    private static final String TAG = "StaggeredGridViewFragment";
    private String mDesigner;
    private static final int DESIGNERS_LOADER = 0;

    private static final String[] DESIGNERS_COLUNMS = {
            CatalogueData.Designers.TABLE_NAME+"."+CatalogueData.Designers.COL_ID,
            CatalogueData.Designers.COL_DESIGNER,
            CatalogueData.Designers.COL_LABEL,
            CatalogueData.Designers.COL_FULLNAME,
            CatalogueData.Designers.COL_BIO,
            CatalogueData.Designers.COL_PIC
    };

    public static final int COL_DESIGNER_ID = 0;
    public static final int COL_DESIGNER = 1;
    public static final int COL_DESIGNER_LABEL = 2;
    public static final int COL_DESIGNER_FULLNAME = 3;
    public static final int COL_DESIGNER_BIO = 4;
    public static final int COL_DESIGNER_PIC = 5;




    private StaggeredGridView mGridView;
    private StaggeredGridAdapter mAdapter;
    private ArrayList<GridViewData> objects = new ArrayList<GridViewData>();
    private boolean mHasRequestedMore;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_staggeredgridview, container, false);
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Loader Code!
        //getLoaderManager().initLoader(DESIGNERS_LOADER,null,this);

        mGridView = (StaggeredGridView)getView().findViewById(R.id.grid_view);

        if (savedInstanceState == null){
            final LayoutInflater layoutInflater = getActivity().getLayoutInflater();

            View header = layoutInflater.inflate(R.layout.grid_layout_header_footer, null);
            View footer = layoutInflater.inflate(R.layout.grid_layout_header_footer, null);
            TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
            TextView txtFooterTitle = (TextView) footer.findViewById(R.id.txt_title);

            txtHeaderTitle.setText("SANS Exposure Catalogue");
            txtFooterTitle.setText("SANS Exposure CAtalogue");

            mGridView.addHeaderView(header);
            mGridView.addFooterView(footer);
        }

        if(objects == null){
            setArrayListData();
        }

        if (mAdapter == null){
            mAdapter = new StaggeredGridAdapter(getActivity(), R.id.txt_line1);
        }

        for (GridViewData object : objects){
            mAdapter.add(object);
        }

        mGridView.setAdapter(mAdapter);
        mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
       Toast.makeText(getActivity(), "Item Clicked: "+ position, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        Log.d(TAG, "onScrollStateChanged: "+scrollState);
    }

    @Override
    public void onScroll(final AbsListView view,final int firstVisibleItem,final int visibleItemCount,final int totalItemCount) {
        Log.d(TAG,"onScroll firstVisibleItem: " + firstVisibleItem +
                  " visibleItmeCount: "+ visibleItemCount+
                  " totalItemCount: " + totalItemCount);

        //handling requests
        if(!mHasRequestedMore){
            int lastInScreen = firstVisibleItem +
                    visibleItemCount;
            if(lastInScreen >= totalItemCount){
                Log.d(TAG, "onScroll lastInScreen - so load more");
                mHasRequestedMore = true;
                onLoadMoreItems();
            }
        }

    }

    private void onLoadMoreItems(){
        final ArrayList<GridViewData> moreData = GridViewData.generateMoreData();

        for (GridViewData data : moreData){
            mAdapter.add(data);
        }
        objects.addAll(moreData);
        mAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;
    }


//take a look at Loaders before changing code starting here
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                getActivity(),
                CatalogueData.Designers.CONTENT_URI,
                DESIGNERS_COLUNMS,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        //mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        //mAdapter.swapCursor(null);
    }

//ending here

    private void setArrayListData(){
        //data can be pulled from data source

        // references to our images
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
            objects.add(object);
        }
    }
}
