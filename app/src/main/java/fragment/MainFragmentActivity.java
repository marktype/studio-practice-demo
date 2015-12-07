package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import fragment.test.MarchtFragment;

/**
 * Created by FJ on 2015/12/1.
 */
public class MainFragmentActivity extends FragmentActivity implements
        BlankFragment.OnFragmentInteractionListener,MarchtFragment.OnFragmentItemListener{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_layout);


        //动态设置fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.my_fragment,BlankFragmentB.newIntance());
//        fragmentTransaction.commit();

        //简化写法（动态创建）
//        getSupportFragmentManager().beginTransaction().add(R.id.my_fragment,BlankFragmentB.newIntance()).commit();

    }

    //跳转，用fragment将界面替换
    @Override public void onFragmentInteraction(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        switch (msg){
            case BlankFragment.TAG_A:
                getSupportFragmentManager().beginTransaction().replace(R.id.my_fragment,BlankFragmentB.newIntance()).commit();
                break;
            case BlankFragment.TAG_B:
                getSupportFragmentManager().beginTransaction().add(R.id.my_fragment, MarchtFragment.newInstance()).addToBackStack(null).commit();
                break;
            case BlankFragment.TAG_C:
                getSupportFragmentManager().beginTransaction().add(R.id.my_fragment, BlankFragment.newIntance("c")).addToBackStack(null).commit();
                break;

        }
    }

    //添加回退栈跳转（addToBackStack加入回退栈）getSupportFragmentManager().popBackStack()退栈操作

    @Override
    public void onFragmentInteraction() {
        getSupportFragmentManager().beginTransaction().add(R.id.my_fragment,BlankFragmentB.newIntance()).addToBackStack(null).commit();
    }
}

