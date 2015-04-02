package sans.co.zw.sansexposure.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.helpers.Router;
import sans.co.zw.sansexposure.helpers.UserPreferences;

/**
 * Created by Steve on 20/02/2015.
 */
public class MainFragment extends Fragment implements View.OnClickListener{
    Button b;
    Router router;
    EditText email, password;
    UserPreferences userPreference;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        b = (Button)rootView.findViewById(R.id.btn_login);
        email = (EditText) rootView.findViewById(R.id.txt_login_email);
        password = (EditText) rootView.findViewById(R.id.txt_login_password);
        b.setOnClickListener(this);
        router = (Router)getActivity();
        userPreference = new UserPreferences(getActivity().getApplicationContext());
        return rootView;
    }


    @Override
    public void onClick(View v) {

        if(email.getText().toString().trim().matches("") || password.getText().toString().trim().matches("")){
            Toast.makeText(getActivity().getApplicationContext(),"Please fill in the fields in full",Toast.LENGTH_LONG).show();
        }else{
            userPreference.setEmailAddress(email.getText().toString());
            userPreference.setPassword(password.getText().toString());
            router.launchTabsAcitivity();
        }

    }

}
