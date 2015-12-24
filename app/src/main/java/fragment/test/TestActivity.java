package fragment.test;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import fragment.R;

public class TestActivity extends FragmentActivity implements MarchtFragment.OnFragmentItemListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment_layout);


    }

    @Override
    public void onFragmentInteraction() {

    }
}
