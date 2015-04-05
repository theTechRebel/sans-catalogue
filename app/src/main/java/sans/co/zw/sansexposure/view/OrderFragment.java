package sans.co.zw.sansexposure.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.helpers.UserPreferences;
import sans.co.zw.sansexposure.model.StockItem;

/**
 * Created by Steve on 05/04/2015.
 */
public class OrderFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private UserPreferences userPrefs;
    private static String TAG = "OrderFragment";

    TextView code, designer, sex, collection, price,itemName;
    Button placeOrder;
    EditText message, fullNme, address, phone, email;
    Spinner spinner, payment;
    StockItem stockItem;
    public static String STOCK_ITEM = "stockItem";

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        userPrefs = new UserPreferences(getActivity());

        stockItem = (StockItem)getArguments().getSerializable(STOCK_ITEM);

        code = (TextView)getView().findViewById(R.id.code1);
        designer = (TextView)getView().findViewById(R.id.designer1);
        sex = (TextView)getView().findViewById(R.id.sex1);
        collection = (TextView)getView().findViewById(R.id.collection1);
        price = (TextView)getView().findViewById(R.id.price1);
        itemName = (TextView)getView().findViewById(R.id.itemName1);
        placeOrder = (Button)getView().findViewById(R.id.order1);
        message = (EditText)getView().findViewById(R.id.message);
        fullNme = (EditText)getView().findViewById(R.id.fullName);
        address = (EditText)getView().findViewById(R.id.address);
        phone = (EditText)getView().findViewById(R.id.phone);
        email = (EditText)getView().findViewById(R.id.email);

        code.setText(stockItem.getCode());
        designer.setText(stockItem.getDesigner());
        collection.setText(stockItem.getCollection());
        switch(stockItem.getSex()){
            case "1":
                sex.setText("Male");
                break;
            case "0":
                sex.setText("Female");
                break;
            case "2":
                sex.setText("UniSex");
                break;
            default:
                sex.setText("");
                break;
        }
        price.setText(stockItem.getPrice());
        itemName.setText(stockItem.getItemName());


        spinner = (Spinner)getView().findViewById(R.id.quantity);
        payment = (Spinner)getView().findViewById(R.id.payment);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.quantity_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity(),
                R.array.payment_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        payment.setAdapter(adapter2);
        spinner.setOnItemSelectedListener(this);
        payment.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = (String) parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
