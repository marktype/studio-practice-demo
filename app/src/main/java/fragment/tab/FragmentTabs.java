package fragment.tab;

import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import fragment.BlankFragment;
import fragment.BlankFragmentB;
import fragment.R;

public class FragmentTabs extends AppCompatActivity implements BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_my_own_layout);

        FragmentTabHost tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //使用fragment代替activity转换实现
        tabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);


        tabHost.addTab(tabHost.newTabSpec("tab1").setIndicator(setTabMenu("团购", R.drawable.tab_item1_selector)), BlankFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab2").setIndicator(setTabMenu("商家", R.drawable.tab_item2_selector)), BlankFragmentB.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab3").setIndicator(setTabMenu("我的", R.drawable.tab_item3_selector)), TabOneFragment.class, null);
        tabHost.addTab(tabHost.newTabSpec("tab4").setIndicator(setTabMenu("更多", R.drawable.tab_item4_selector)), TabTwoFragment.class, null);
    }

    //自定义tab
    public View setTabMenu(String name, int image) {
        View v = LayoutInflater.from(this).inflate(R.layout.tab_own_item_layout, null);
        TextView menuText = (TextView) v.findViewById(R.id.tab_menu_txt);
        ImageView menuImg = (ImageView) v.findViewById(R.id.tab_image);
        menuText.setText(name);
        menuImg.setImageResource(image);
        return v;
    }

    @Override
    public void onFragmentInteraction(String msg) {

    }
}
