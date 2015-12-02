package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragmentB extends Fragment {

    public static Fragment newIntance(){
        BlankFragmentB blankFragmentB = new BlankFragmentB();
        return blankFragmentB;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blank_fragment_b, container, false);
    }

}
