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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.etsy.android.grid.util.DynamicHeightTextView;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.model.CatalogueData;
import sans.co.zw.sansexposure.model.CatalogueDataLoader;

/**
 * Created by Steve on 29/03/2015.
 */
public class StocksFragment  extends Fragment
        implements
        AbsListView.OnScrollListener,
        AbsListView.OnItemClickListener,
        LoaderManager.LoaderCallbacks<Cursor>{

    private static final String TAG = "StocksFragment";

    private static final int STOCKS_LOADER = 1;

    private static final String[] STOCKS_COLUNMS = {
            CatalogueData.Stocks.TABLE_NAME+"."+CatalogueData.Stocks.COL_ID,
            CatalogueData.Stocks.COL_PRICE,
            CatalogueData.Stocks.COL_DESIGNER,
            CatalogueData.Stocks.COL_ITEM_NAME,
            CatalogueData.Stocks.COL_PIC
    };

    private StaggeredGridView mGridView;
    private StocksCursorAdapter mAdapter;
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

        getLoaderManager().initLoader(STOCKS_LOADER, null, this);

        mGridView = (StaggeredGridView)getView().findViewById(R.id.grid_view);

        if(savedInstanceState == null){
            final LayoutInflater layoutInflater = getActivity().getLayoutInflater();
            View header = layoutInflater.inflate(R.layout.grid_layout_header_footer, null);
            TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
            txtHeaderTitle.setText("SANS Exposure Catalogue");
            mGridView.addHeaderView(header);
        }

        if(mAdapter == null){
            mAdapter = new StocksCursorAdapter(
                    getActivity(),
                    c,
                    false);
        }
        mGridView.setAdapter(mAdapter);
        mGridView.setOnScrollListener(this);
        mGridView.setOnItemClickListener(this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CatalogueDataLoader(
                getActivity(),
                CatalogueData.Stocks.CONTENT_URI,
                STOCKS_COLUNMS,
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
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //handling requests
        if(!mLoadMoreData){
            int lastInScreen = firstVisibleItem + visibleItemCount;
            if(lastInScreen >= totalItemCount){
                mLoadMoreData = true;
                getLoaderManager().restartLoader(STOCKS_LOADER,null,this);
                mLoadMoreData = false;
            }
        }
    }
}

class StocksCursorAdapter extends CursorAdapter{

    private LayoutInflater cursorInflater;

    static class ViewHolder{
        DynamicHeightImageView stockItemImage;
        DynamicHeightTextView stockItemPrice, stockItemName, stockItemdesigner;
    }

    StocksCursorAdapter(Context context, Cursor c, boolean autoRequery) {
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
                R.layout.grid_item_stocks,
                parent,
                false
        );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder vh;
        vh = new ViewHolder();

        vh.stockItemImage = (DynamicHeightImageView)view.findViewById(R.id.image_stock);
        vh.stockItemdesigner = (DynamicHeightTextView)view.findViewById(R.id.txt_designer_label);
        vh.stockItemPrice = (DynamicHeightTextView)view.findViewById(R.id.txt_item_price);
        vh.stockItemName = (DynamicHeightTextView)view.findViewById(R.id.txt_item_name);

        vh.stockItemdesigner.setText(cursor.getString(CatalogueData.Stocks.CURSOR_COL_STOCKS_DESEIGNER));
        vh.stockItemPrice.setText(cursor.getString(CatalogueData.Stocks.CURSOR_COL_STOCKS_PRICE));
        vh.stockItemName.setText(cursor.getString(CatalogueData.Stocks.CURSOR_COL_STOCKS_ITEM_NAME));
        String imageUriAsString = cursor.getString(CatalogueData.Stocks.CURSOR_COL_STOCKS_PIC);
        Uri theUri = Uri.parse(imageUriAsString);
        vh.stockItemImage.setImageURI(theUri);
    }
}
