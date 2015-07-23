package work.sindri.tapit1.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import work.sindri.tapit1.R;
import work.sindri.tapit1.activity.CreateInventoryActivity;

/**
 * Created by Sindri on 13/05/15.
 */
public class CreateInventoryFragment extends Fragment {


    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_cart, container, false);

        Intent intent = new Intent(getActivity(), CreateInventoryActivity.class);
        startActivity(intent);

        return rootView;
    }
}
