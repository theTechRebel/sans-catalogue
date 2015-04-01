package sans.co.zw.sansexposure.helpers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Steve on 31/03/2015.
 */
    public class SquareImageView extends ImageView
    {
        public SquareImageView(Context context)
        {
            super(context);
        }

        public SquareImageView(Context context, AttributeSet attrs)
        {
            super(context, attrs);
        }

        public SquareImageView(Context context, AttributeSet attrs, int defStyle)
        {
            super(context, attrs, defStyle);
        }

        @Override
        protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
        {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth()); //Snap to width
        }
    }
