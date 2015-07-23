package work.sindri.tapit1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import work.sindri.tapit1.R;
import work.sindri.tapit1.activity.Global;
import work.sindri.tapit1.activity.LoginActivity;


/**
 * Created by Sindri on 11/05/15.
 */
public class LogOutFragment extends Fragment{

    Global global = Global.getInstance();
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.activity_simple_pay, container, false);

        Intent intent = new Intent(getActivity() ,LoginActivity.class);

        global.setFundraiser(null);
        startActivity(intent);

        return rootView;
    }
}
