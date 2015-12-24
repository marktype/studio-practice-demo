package fragment.tab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabThreeFragment extends Fragment {


    public static TabThreeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TabThreeFragment fragment = new TabThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tab_three_layout, container, false);
    }

}
