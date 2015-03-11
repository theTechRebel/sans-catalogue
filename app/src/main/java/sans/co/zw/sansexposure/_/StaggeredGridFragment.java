package sans.co.zw.sansexposure._;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
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
import sans.co.zw.sansexposure.model.CatalogueDataLoader;

/**
 * Created by Steve on 26/02/2015.
 */

/*
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




    private StaggeredGridView mGridView;
    private StaggeredGridCursorAdapter mAdapter;
    private CatalogueDataLoader mLoader;
    private ArrayList<GridViewData> objects = new ArrayList<GridViewData>();
    private boolean mHasRequestedMore;
    private Cursor c;


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

        //start the loader here
        getLoaderManager().initLoader(DESIGNERS_LOADER,null,this);

        mGridView = (StaggeredGridView)getView().findViewById(R.id.grid_view);

        if (savedInstanceState == null){
            final LayoutInflater layoutInflater = getActivity().getLayoutInflater();

            View header = layoutInflater.inflate(R.layout.grid_layout_header_footer, null);
            View footer = layoutInflater.inflate(R.layout.grid_layout_header_footer, null);
            TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
            TextView txtFooterTitle = (TextView) footer.findViewById(R.id.txt_title);

            txtHeaderTitle.setText("SANS Exposure Catalogue");
            txtFooterTitle.setText("SANS Exposure Catalogue");

            mGridView.addHeaderView(header);
            mGridView.addFooterView(footer);
        }

        if (mAdapter == null){
            //mAdapter = new StaggeredGridAdapter(getActivity(), R.id.txt_line1);
            mAdapter = new StaggeredGridCursorAdapter(getActivity(),c,false,R.id.txt_line1);
        }

        //for(GridViewData object : objects){
        //   mAdapter.add(object);
        //}

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
    }

    @Override
    public void onScroll(final AbsListView view,final int firstVisibleItem,final int visibleItemCount,final int totalItemCount) {
        //handling requests
        if(!mHasRequestedMore){
            int lastInScreen = firstVisibleItem + visibleItemCount;
            if(lastInScreen >= totalItemCount){
                mHasRequestedMore = true;
                getLoaderManager().restartLoader(DESIGNERS_LOADER,null,this);
                mHasRequestedMore = false;
            }
        }
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CatalogueDataLoader(
                getActivity(),
                CatalogueData.Designers.CONTENT_URI,
                DESIGNERS_COLUNMS,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        this.c = data;
        mAdapter.swapCursor(data);
        //Toast.makeText(getActivity(),""+data.getCount(),Toast.LENGTH_LONG).show();
        //mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        //mAdapter.swapCursor(data);
    }
}
*/