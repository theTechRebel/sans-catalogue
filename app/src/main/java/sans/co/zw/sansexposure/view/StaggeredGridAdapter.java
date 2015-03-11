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
        DynamicHeightTextView txtItemName;
        DynamicHeightTextView txtItemPrice;
        DynamicHeightTextView txtItemDesigner;
        DynamicHeightImageView imgItem;
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
            vh.txtItemName      = (DynamicHeightTextView) convertView.findViewById(R.id.txt_line1);
            vh.txtItemDesigner  = (DynamicHeightTextView) convertView.findViewById(R.id.txt_designer);
            vh.txtItemPrice     = (DynamicHeightTextView) convertView.findViewById(R.id.txt_price);
            vh.imgItem     = (DynamicHeightImageView) convertView.findViewById(R.id.image_1);

            convertView.setTag(vh);
        }else{
            vh = (ViewHolder) convertView.getTag();
        }

        GridViewData data = null;
        data = (GridViewData) getItem(position);

        vh.txtItemName.setText(data.getItemName());
        vh.txtItemDesigner.setText(data.getItemDesigner());
        vh.txtItemPrice.setText(data.getItemPrice());
        vh.imgItem.setImageResource(data.getImageId());
        return convertView;
    }
}
