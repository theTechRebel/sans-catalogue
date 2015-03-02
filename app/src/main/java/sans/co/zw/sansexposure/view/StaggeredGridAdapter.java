package sans.co.zw.sansexposure.view;

import android.content.Context;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.etsy.android.grid.util.DynamicHeightTextView;

import java.util.ArrayList;
import java.util.Random;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.model.GridViewData;

/**
 * Created by Steve on 26/02/2015.
 */
public class StaggeredGridAdapter extends ArrayAdapter<Object>{

    private static final String TAG = "StaggeredGridViewAdapter";

    static class ViewHolder {
        DynamicHeightTextView txtLineOne;
        DynamicHeightImageView imageViewOne;
    }

    private final LayoutInflater mLayoutIflater;

    public StaggeredGridAdapter(final Context ctx, final int textViewResourceId){
        super(ctx, textViewResourceId);
        mLayoutIflater = LayoutInflater.from(ctx);
    }

    @Override
    public View getView(final int position, View convertView,final ViewGroup parent) {
        ViewHolder vh;
        if(convertView == null){
            convertView = mLayoutIflater.inflate(R.layout.grid_item_listitem, parent, false);
            vh = new ViewHolder();
            vh.txtLineOne = (DynamicHeightTextView) convertView.findViewById(R.id.txt_line1);
            vh.imageViewOne = (DynamicHeightImageView) convertView.findViewById(R.id.image_1);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }

        GridViewData data = null;
        data = (GridViewData) getItem(position);

        vh.txtLineOne.setText(data.getItemName());
        vh.imageViewOne.setImageResource(data.getImageId());
        return convertView;
    }
}
