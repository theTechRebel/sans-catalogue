package sans.co.zw.sansexposure.src;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import sans.co.zw.sansexposure.R;

public class GridViewFragment extends Fragment {

    private ArrayAdapter<String> mArrayAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gridview, container, false);

        //raw array of data
        //String[] designersArray = {"Lady Cee Kay","Tariro The Jeweller","AfroKreative","Hause of Stone","Threads by Blaze"};
        //convert raw array of data to a data list
        //List<String> designersList = new ArrayList<String>(Arrays.asList(designersArray));
        //create data adapter to create a listview
        //mArrayAdapter = new ArrayAdapter<String>(
                //app context
                //getActivity(),
                //the layout ID of the individual list items textview used to create each listview item
                //R.layout._textview_listitem,
                //the ID of the individual list items textview used to create each listview item
                //R.id.list_item_textview,
                //the array list wit the data
                //designersList
        //);
        //find the listview by ID
        GridView gridView = (GridView)rootView.findViewById(R.id.gridview);
        //bind the data adapter to the listview by calling setAdapter()

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
        gridView.setAdapter(new myGridAdapter(getActivity(),text,pics));

        return rootView;
    }


    public class myGridAdapter extends BaseAdapter{
        private Context ctx;
        private final String[] text;
        private final int[] imageID;

        public myGridAdapter(Context ctx, String[] text, int [] imageID){
            this.ctx = ctx;
            this.imageID = imageID;
            this.text = text;
        }
        @Override
        public int getCount() {
            return text.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View grid;
            TextView textView;
            ImageView imageView;

            LayoutInflater inflater = (LayoutInflater)ctx.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {  // if it's not recycled, initialize some attributes
                grid = new View(ctx);
                grid = inflater.inflate(R.layout._gridview_listitem, null);
                textView = (TextView)grid.findViewById(R.id.grid_text);
                imageView = (ImageView)grid.findViewById(R.id.grid_image);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                textView.setText(text[position]);
                imageView.setImageResource(imageID[position]);

                grid.setLayoutParams(new GridView.LayoutParams(110, 110));
                grid.setPadding(1, 1, 1, 1);
            } else {
                grid = (View) convertView;
            }
            return grid;
        }
    }
}
