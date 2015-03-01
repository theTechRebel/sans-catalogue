package sans.co.zw.sansexposure.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import sans.co.zw.sansexposure.src.SampleData;

/**
 * Created by Steve on 26/02/2015.
 */
public class StaggeredGridFragment extends Fragment
    implements
        AbsListView.OnScrollListener,
        AbsListView.OnItemClickListener{

    private static final String TAG = "StaggeredGridViewFragment";

    private StaggeredGridView mGridView;
    private GridViewAdapter mAdapter;
    private ArrayList<String> mData;
    private boolean mHasRequestedMore;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_staggeredgridview, container, false);
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mGridView = (StaggeredGridView)getView().findViewById(R.id.grid_view);

        if (savedInstanceState == null){
            final LayoutInflater layoutInflater = getActivity().getLayoutInflater();

            View header = layoutInflater.inflate(R.layout.grid_item_header_footer, null);
            View footer = layoutInflater.inflate(R.layout.grid_item_header_footer, null);
            TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
            TextView txtFooterTitle = (TextView) footer.findViewById(R.id.txt_title);

            txtHeaderTitle.setText("SANS Exposure Catalogue");
            txtFooterTitle.setText("SANS Exposure CAtalogue");

            mGridView.addHeaderView(header);
            mGridView.addFooterView(footer);
        }

        if (mAdapter == null){
            mAdapter = new GridViewAdapter(getActivity(), R.id.txt_line1);
        }

        if (mData == null){
            mData = SampleData.generateSampleData();
        }

        for (String data : mData){
            mAdapter.add(data);
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
        final ArrayList<String> sampleData = SampleData.generateSampleData();
        for(String data : sampleData){
            mAdapter.add(data);
        }
        // stash all the data in our backing store
        mData.addAll(sampleData);
        //notify the adapter that we can update now
        mAdapter.notifyDataSetChanged();
        mHasRequestedMore = false;

    }
}
