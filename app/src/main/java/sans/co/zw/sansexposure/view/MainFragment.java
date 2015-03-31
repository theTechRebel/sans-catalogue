package sans.co.zw.sansexposure.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import sans.co.zw.sansexposure.R;
import sans.co.zw.sansexposure.helpers.Router;

/**
 * Created by Steve on 20/02/2015.
 */
public class MainFragment extends Fragment implements View.OnClickListener{

    Button b;
    Router router;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        b = (Button)rootView.findViewById(R.id.btn_login);
        b.setOnClickListener(this);
        router = (Router)getActivity();
        return rootView;
    }


    @Override
    public void onClick(View v) {
        router.launchTabsAcitivity();
    }
}
