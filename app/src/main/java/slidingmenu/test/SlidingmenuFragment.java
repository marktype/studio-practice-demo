package slidingmenu.test;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import fragment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SlidingmenuFragment extends Fragment implements View.OnClickListener{
    private Button mOneBtn,mTwoBtn,mThreeBtn;
    private setOnSlidingmenuListener mListener;
    public interface setOnSlidingmenuListener{
         void setOneFragment();
         void setTwoFragment();
         void setThreeFragment();
    }

    public static SlidingmenuFragment newInstance() {
        
        Bundle args = new Bundle();
        SlidingmenuFragment fragment = new SlidingmenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof setOnSlidingmenuListener){
            mListener = (setOnSlidingmenuListener) context;
        }else{
            throw new RuntimeException("没有实现setOnSlidingmenuListener接口");
        }

    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slidingmenu_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mOneBtn  = (Button) getView().findViewById(R.id.slidingmenu_one_btn);
        mTwoBtn  = (Button) getView().findViewById(R.id.slidingmenu_two_btn);
        mThreeBtn = (Button) getView().findViewById(R.id.slidingmenu_three_btn);

        mOneBtn.setOnClickListener(this);
        mTwoBtn.setOnClickListener(this);
        mThreeBtn.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.slidingmenu_one_btn:
                mListener.setOneFragment();
                break;
            case R.id.slidingmenu_two_btn:
                mListener.setTwoFragment();
                break;
            case R.id.slidingmenu_three_btn:
                mListener.setThreeFragment();
                break;
        }
    }
}
