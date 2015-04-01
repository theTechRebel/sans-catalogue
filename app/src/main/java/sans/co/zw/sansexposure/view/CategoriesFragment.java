package sans.co.zw.sansexposure.view;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.CursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.etsy.android.grid.util.DynamicHeightTextView;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.model.CatalogueData;
import sans.co.zw.sansexposure.model.CatalogueDataLoader;

/**
 * Created by Steve on 11/03/2015.
 */
public class CategoriesFragment extends Fragment
    implements
        AbsListView.OnScrollListener,
        AbsListView.OnItemClickListener,
        LoaderManager.LoaderCallbacks<Cursor>{

    private static final String TAG = "CategoriesFragment";

    private static final int CATEGORIES_LOADER = 1;

    private static final String[] CATEGORIES_COLUNMS = {
            CatalogueData.Categories.TABLE_NAME+"."+CatalogueData.Categories.COL_ID,
            CatalogueData.Categories.COL_KEY,
            CatalogueData.Categories.COL_VALUE,
            CatalogueData.Categories.COL_PIC
    };

    private StaggeredGridView mGridView;
    private CategoriesCursorAdapter mAdapter;
    private CatalogueDataLoader mLoader;
    private boolean mLoadMoreData;
    private Cursor c;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_staggeredgridview, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getLoaderManager().initLoader(CATEGORIES_LOADER, null, this);

        mGridView = (StaggeredGridView)getView().findViewById(R.id.grid_view);

        if(savedInstanceState == null){
            final LayoutInflater layoutInflater = getActivity().getLayoutInflater();
            View header = layoutInflater.inflate(R.layout.grid_layout_header_footer, null);
            TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
            txtHeaderTitle.setText("SANS Exposure Categories");
            mGridView.addHeaderView(header);
        }

        if(mAdapter == null){
            mAdapter = new CategoriesCursorAdapter(
                    getActivity(),
                    c,
                    false);
        }

        mGridView.setAdapter(mAdapter);
        mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(this);
    }

    //Cursor Loader Methods
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CatalogueDataLoader(
                getActivity(),
                CatalogueData.Categories.CONTENT_URI,
                CATEGORIES_COLUNMS,
                null,
                null,
                null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

        this.c = data;
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        //mAdapter.swapCursor(data);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item Clicked: " + position, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,
                         int totalItemCount) {
        //handling requests
        if(!mLoadMoreData){
            int lastInScreen = firstVisibleItem + visibleItemCount;
            if(lastInScreen >= totalItemCount){
                mLoadMoreData = true;
                getLoaderManager().restartLoader(CATEGORIES_LOADER,null,this);
                mLoadMoreData = false;
            }
        }
    }
}

class CategoriesCursorAdapter extends CursorAdapter {
    private LayoutInflater cursorInflater;
    private int textViewResourceId;

    static class ViewHolder{
        TextView categoryValue;
        ImageView categoryImage;
    }

    public CategoriesCursorAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
        cursorInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Cursor swapCursor(Cursor newCursor) {
        return super.swapCursor(newCursor);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return cursorInflater.inflate(
                R.layout.grid_item_categories,
                parent,
                false
        );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder vh;
        vh = new ViewHolder();


        vh.categoryValue    = (TextView)view.findViewById(R.id.txt_category_value);
        vh.categoryImage     = (ImageView)view.findViewById(R.id.image_category);

        vh.categoryValue.setText(cursor.getString(CatalogueData.Categories.CURSOR_COL_CATEGORY_VALUE));
        String imageUriAsString = cursor.getString(CatalogueData.Categories.CURSOR_COL_CATEGORY_PIC);
        Uri theUri = Uri.parse(imageUriAsString);
        vh.categoryImage.setImageURI(theUri);
    }
}
