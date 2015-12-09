package slidingmenu.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.warmtel.slidingmenu.lib.SlidingMenu;
import com.warmtel.slidingmenu.lib.app.SlidingActivity;

import costomview.MyOwnView;
import fragment.R;

public class slidingmenuActivity extends SlidingActivity implements View.OnClickListener{
    private Button mOneBtn,mTwoBtn,mThreeBtn;
    private MyOwnView mSlidingBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingmenu_layout);

        setBehindContentView(R.layout.slidingmenu_layout);
        SlidingMenu sm = getSlidingMenu();
        sm.setSlidingEnabled(true);
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offest);
        sm.setTouchModeBehind(SlidingMenu.TOUCHMODE_MARGIN);

        mOneBtn  = (Button) findViewById(R.id.slidingmenu_one_btn);
        mTwoBtn  = (Button) findViewById(R.id.slidingmenu_two_btn);
        mThreeBtn = (Button) findViewById(R.id.slidingmenu_three_btn);

        mSlidingBtn = (MyOwnView) findViewById(R.id.slidingmenu_my_view);


        mOneBtn.setOnClickListener(this);
        mTwoBtn.setOnClickListener(this);
        mThreeBtn.setOnClickListener(this);

        mSlidingBtn.setMyViewOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.own_first_txt:
                        toggle();
                        break;
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.slidingmenu_one_btn:
                Toast.makeText(this,"界面一",Toast.LENGTH_SHORT).show();
                break;
            case R.id.slidingmenu_two_btn:
                Toast.makeText(this,"界面二",Toast.LENGTH_SHORT).show();
                break;
            case R.id.slidingmenu_three_btn:
                Toast.makeText(this,"界面三",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
