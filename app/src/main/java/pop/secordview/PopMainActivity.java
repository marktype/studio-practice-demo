package pop.secordview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.warmtel.expandtab.ExpandPopTabView;
import com.warmtel.expandtab.KeyValueBean;
import com.warmtel.expandtab.PopOneListView;
import com.warmtel.expandtab.PopTwoListView;

import java.util.ArrayList;
import java.util.List;

import fragment.R;

public class PopMainActivity extends AppCompatActivity {
    private ExpandPopTabView mExpandTabView;
    private List<KeyValueBean> mPrice; //价格
    private List<KeyValueBean> mSort;  //排序
    private List<KeyValueBean> mFavor; //优惠
    private List<KeyValueBean> mParentLists = new ArrayList<>();//父区域
    private List<ArrayList<KeyValueBean>> mChildrenListLists = new ArrayList<>();//子区域
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_main);
        mExpandTabView = (ExpandPopTabView)findViewById(R.id.pop_tab_view);




        setDataList();   //设置数据源

        addItem(mExpandTabView, mPrice, "", "价格");

        addItem(mExpandTabView, mParentLists,mChildrenListLists, "自然排序","随机","排序");


    }
    /*
    * 只有一级下拉列表
    * */
    public void addItem(ExpandPopTabView expandTabView, List<KeyValueBean> lists, String defaultSelect, String defaultShowText) {
        PopOneListView popOneListView = new PopOneListView(this);     //自定义一级下拉列表（此处为listview）
        popOneListView.setDefaultSelectByValue(defaultSelect);    //设置默认选中项
        popOneListView.setCallBackAndData(lists, expandTabView, new PopOneListView.OnSelectListener() {
            @Override
            public void getValue(String key, String value) {
                //弹出框选项点击选中回调方法
                Toast.makeText(PopMainActivity.this,""+value,Toast.LENGTH_SHORT).show();
            }
        });
        expandTabView.addItemToExpandTab(defaultShowText, popOneListView);    //添加title

    }
    /*
    * 一级、二级下拉列表设置
    * */
    public void addItem(ExpandPopTabView expandTabView, List<KeyValueBean> parentLists,
                        List<ArrayList<KeyValueBean>> childrenListLists, String defaultParentSelect, String defaultChildSelect, String defaultShowText) {
        PopTwoListView popTwoListView = new PopTwoListView(this);//自定义二级下拉列表（此处为listview）
		popTwoListView.setDefaultSelectByValue(defaultParentSelect, defaultChildSelect);     //设置默认选中项，不然会报数组越位
        popTwoListView.setCallBackAndData(expandTabView, parentLists, childrenListLists, new PopTwoListView.OnSelectListener() {
            @Override
            public void getValue(String showText, String parentKey, String childrenKey) {
                //弹出框选项点击选中回调方法
                Toast.makeText(PopMainActivity.this,""+showText,Toast.LENGTH_SHORT).show();
            }
        });
        expandTabView.addItemToExpandTab(defaultShowText, popTwoListView);
    }



    public void setDataList(){
        //一级列表菜单
        mPrice = new ArrayList<>();
        KeyValueBean bean = new KeyValueBean("111","0");
        mPrice.add(bean);
        bean = new KeyValueBean("122","10元");
        mPrice.add(bean);
        bean = new KeyValueBean("133","100元");
        mPrice.add(bean);

        //=============================================一级列表菜单加上二级列表菜单，注意顺序
        bean = new KeyValueBean("211","自然排序");
        mParentLists.add(bean);
        bean = new KeyValueBean("222","按时间");
        mParentLists.add(bean);
        bean = new KeyValueBean("233","按价格");
        mParentLists.add(bean);
        //自然排序
        ArrayList<KeyValueBean> item = new ArrayList<>();
        bean = new KeyValueBean("2111","随机");
        item.add(bean);
        bean = new KeyValueBean("2221","评价");
        item.add(bean);
        bean = new KeyValueBean("2331","评分");
        item.add(bean);
        //按价格
        ArrayList<KeyValueBean> item1 = new ArrayList<>();
        bean = new KeyValueBean("21112","1");
        item1.add(bean);
        bean = new KeyValueBean("22212","2");
        item1.add(bean);
        bean = new KeyValueBean("23312","3");
        item1.add(bean);
        //按时间
        ArrayList<KeyValueBean> item2 = new ArrayList<>();
        bean = new KeyValueBean("1","顺序");
        item2.add(bean);
        bean = new KeyValueBean("2","最近");
        item2.add(bean);
        bean = new KeyValueBean("31","昨天");
        item2.add(bean);

        //添加顺序应与mParentLists添加顺序对应
        mChildrenListLists.add(item);
        mChildrenListLists.add(item2);
        mChildrenListLists.add(item1);

    }
}
