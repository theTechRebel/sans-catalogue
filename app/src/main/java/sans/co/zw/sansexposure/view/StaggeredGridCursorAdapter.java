package sans.co.zw.sansexposure.view;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.etsy.android.grid.util.DynamicHeightImageView;
import com.etsy.android.grid.util.DynamicHeightTextView;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.model.CatalogueData;
import sans.co.zw.sansexposure.model.GridViewData;

/**
 * Created by Steve on 09/03/2015.
 */
public class StaggeredGridCursorAdapter extends CursorAdapter {
    private LayoutInflater cursorInflater;
    private int textViewResourceId;

    static class ViewHolder {
        DynamicHeightTextView txtItemName;
        DynamicHeightTextView txtItemPrice;
        DynamicHeightTextView txtItemDesigner;
        DynamicHeightImageView imgItem;
    }

    public StaggeredGridCursorAdapter(Context context, Cursor c, boolean autoRequery, int textViewResourceId) {
        super(context, c, autoRequery);
        cursorInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.textViewResourceId = textViewResourceId;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }

    @Override
    public Cursor swapCursor(Cursor newCursor) {
        return super.swapCursor(newCursor);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        Log.d("db",""+textViewResourceId);
        return cursorInflater.inflate(R.layout.grid_item_listitem, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder vh;
        vh = new ViewHolder();

        vh.txtItemName      = (DynamicHeightTextView) view.findViewById(R.id.txt_line1);
        vh.txtItemDesigner  = (DynamicHeightTextView) view.findViewById(R.id.txt_designer);
        vh.txtItemPrice     = (DynamicHeightTextView) view.findViewById(R.id.txt_price);
        vh.imgItem          = (DynamicHeightImageView) view.findViewById(R.id.image_1);

        vh.txtItemName.setText(cursor.getString(cursor.getColumnIndex(CatalogueData.Designers.COL_DESIGNER)));
        vh.txtItemDesigner.setText(cursor.getString(cursor.getColumnIndex(CatalogueData.Designers.COL_FULLNAME)));
        vh.txtItemPrice.setText(cursor.getString(cursor.getColumnIndex(CatalogueData.Designers.COL_LABEL)));
        //vh.imgItem.setImageResource(cursor.getInt(cursor.getColumnIndex(CatalogueData.Designers.COL_PIC)));
        vh.imgItem.setImageResource(R.drawable.sample_3);
    }
}
