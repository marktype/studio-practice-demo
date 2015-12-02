package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by FJ on 2015/12/1.
 */
public class MainFragmentActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_layout);


        //动态设置fragment
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.my_fragment,BlankFragmentB.newIntance());
//        fragmentTransaction.commit();

        //简化写法
        getSupportFragmentManager().beginTransaction().add(R.id.my_fragment,BlankFragmentB.newIntance()).commit();

    }
}
