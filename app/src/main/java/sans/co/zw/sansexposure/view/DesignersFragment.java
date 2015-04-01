package sans.co.zw.sansexposure.view;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.etsy.android.grid.StaggeredGridView;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.etsy.android.grid.util.DynamicHeightTextView;

import java.io.File;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.model.CatalogueData;
import sans.co.zw.sansexposure.model.CatalogueDataLoader;

/**
 * Created by Steve on 09/03/2015.
 */

//The Fragment to handle Designers data
public class DesignersFragment extends Fragment
    implements
        AbsListView.OnScrollListener,
        AbsListView.OnItemClickListener,
        LoaderManager.LoaderCallbacks<Cursor>{

    private static final String TAG = "DesignersFragment";

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
    private DesignersCursorAdapter mAdapter;
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

        getLoaderManager().initLoader(DESIGNERS_LOADER,null,this);

        mGridView = (StaggeredGridView)getView().findViewById(R.id.grid_view);

        if(savedInstanceState == null){
            final LayoutInflater layoutInflater = getActivity().getLayoutInflater();
            View header = layoutInflater.inflate(R.layout.grid_layout_header_footer, null);
            TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
            txtHeaderTitle.setText("SANS Exposure Designers");
            mGridView.addHeaderView(header);
        }

        if(mAdapter == null){
            mAdapter = new DesignersCursorAdapter(
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
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
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
                getLoaderManager().restartLoader(DESIGNERS_LOADER,null,this);
                mLoadMoreData = false;
            }
        }
    }
}

class DesignersCursorAdapter extends CursorAdapter{
    private LayoutInflater cursorInflater;
    private int textViewResourceId;

    static class ViewHolder{
        TextView designerLabel;
        ImageView designerImage;
    }

    public DesignersCursorAdapter(Context context, Cursor c, boolean autoRequery) {
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
                R.layout.grid_item_designers,
                parent,
                false
        );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder vh;
        vh = new ViewHolder();


        vh.designerLabel    = (TextView)view.findViewById(R.id.txt_designer_label);
        vh.designerImage    = (ImageView)view.findViewById(R.id.image_designer);

        vh.designerLabel.setText(cursor.getString(CatalogueData.Designers.CURSOR_COL_DESIGNER_LABEL));
        String imageUriAsString = cursor.getString(CatalogueData.Designers.CURSOR_COL_DESIGNER_PIC);
        Uri theUri = Uri.parse(imageUriAsString);
        vh.designerImage.setImageURI(theUri);
    }
}
