package fragment.tab;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import fragment.Logs;
import fragment.R;

public class MyTabActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener{
    private RadioGroup mRadioGroup;
    private RadioButton mOneBtn,mTwoBtn,mThreeBtn;
    private TabTwoFragment tabTwoFragment;
    private TabOneFragment tabOneFragment;
    private TabThreeFragment tabThreeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tab_layout);

        mRadioGroup = (RadioGroup) findViewById(R.id.raidoGroupTab);
        mRadioGroup.setOnCheckedChangeListener(this);
        tabOneFragment = TabOneFragment.newInstance();



        //进入时默认选中
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_tab_content,tabOneFragment).commit();
//        ((RadioButton) mRadioGroup.getChildAt(0)).toggle(); // 默认选中第一项,此时此方法无效

    }

//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        switch (checkedId){
//            case R.id.raidoTab1:
//                ft.replace(R.id.fragment_tab_content,TabOneFragment.newInstance());
//                break;
//            case R.id.raidoTab2:
//                ft.replace(R.id.fragment_tab_content,TabTwoFragment.newInstance());
//                break;
//            case R.id.raidoTab3:
//                ft.replace(R.id.fragment_tab_content,TabOneFragment.newInstance());
//                break;
//        }
//        ft.commit();
//    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                hideFragments(ft);  //隐藏fragment
        switch (checkedId){
            case R.id.raidoTab1:
                if (tabOneFragment == null){
                    Logs.e("1111111111111");
                    tabOneFragment = TabOneFragment.newInstance();
                    ft.add(R.id.fragment_tab_content,tabOneFragment);
                }else {
                    Logs.e("else 11111111111111");
                    ft.show(tabOneFragment);
                }
                break;
            case R.id.raidoTab2:
                if (tabTwoFragment == null){
                    Logs.e("2222222222222222");
                    tabTwoFragment = TabTwoFragment.newInstance();
                    ft.add(R.id.fragment_tab_content,tabTwoFragment);
                }else {
                    Logs.e("else22222222222");
                    ft.show(tabTwoFragment);
                }
                break;
            case R.id.raidoTab3:
                if (tabThreeFragment == null){
                    Logs.e("33333333333333333");
                    tabThreeFragment = TabThreeFragment.newInstance();
                    ft.add(R.id.fragment_tab_content,tabThreeFragment);
                }else {
                    Logs.e("else 33333333333333");
                    ft.show(tabThreeFragment);
                }
                break;
        }
        ft.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (tabOneFragment != null) {
            transaction.hide(tabOneFragment);
            Logs.e("hide   ----------one");
        }
        if (tabTwoFragment != null) {
            Logs.e("hide   ----------two");
            transaction.hide(tabTwoFragment);
        }
        if (tabThreeFragment != null) {
            Logs.e("hide   ----------three");
            transaction.hide(tabThreeFragment);
        }
    }
}
