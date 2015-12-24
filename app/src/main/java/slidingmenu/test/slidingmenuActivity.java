package slidingmenu.test;

import android.os.Bundle;
import android.view.View;

import com.warmtel.slidingmenu.lib.SlidingMenu;
import com.warmtel.slidingmenu.lib.app.SlidingActivity;

import costomview.MyOwnView;
import fragment.R;

public class slidingmenuActivity extends SlidingActivity implements SlidingmenuFragment.setOnSlidingmenuListener {

    private MyOwnView mSlidingBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slidingmenu_layout);

        setBehindContentView(R.layout.slidingmenu_layout);
        getSupportFragmentManager().beginTransaction().add(R.id.slidingmenu_main,SlidingmenuFragment.newInstance()).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.slidingmenu_fragment,FragmentOne.newInstance()).commit();
        SlidingMenu sm = getSlidingMenu();       //获取对象实例
        sm.setSlidingEnabled(true);        //设置使能够滑动
        sm.setBehindOffsetRes(R.dimen.slidingmenu_offest);         //设置偏移距离
        sm.setTouchModeBehind(SlidingMenu.TOUCHMODE_MARGIN);      //设置边界触发显示
        sm.setShadowWidthRes(R.dimen.slidingmenu_offest);
        sm.setFadeDegree(0.1f);    //设置渐出效果

        mSlidingBtn = (MyOwnView) findViewById(R.id.slidingmenu_my_view);
        mSlidingBtn.setMyViewOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.own_first_txt:
                        toggle();   //点击关闭滑屏界面
                        break;
                }

            }
        });
    }



    @Override
    public void setOneFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.slidingmenu_fragment,FragmentOne.newInstance()).commit();
        getSlidingMenu().showContent();  //显示内容关闭滑屏
    }

    @Override
    public void setTwoFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.slidingmenu_fragment,FragmentTwo.newInstance()).commit();
        getSlidingMenu().showContent();
    }

    @Override
    public void setThreeFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.slidingmenu_fragment,FragmentThree.newInstance()).commit();
        getSlidingMenu().showContent();
    }
}
