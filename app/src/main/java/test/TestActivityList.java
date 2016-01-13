package test;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.baidumap.BaiduMapActivity;

import java.util.ArrayList;
import java.util.HashMap;

import anim.secordview.FrameMainActivity;
import anim.secordview.GestureActivity;
import anim.secordview.MainActivity;
import costomview.MyViewTestActivity;
import fragment.MainFragmentActivity;
import fragment.list.ListMainActivity;
import fragment.tab.FragmentTabs;
import fragment.tab.MyTabActivity;
import fragment.test.TestActivity;
import pop.secordview.PopMainActivity;
import slidingmenu.test.slidingmenuActivity;
import sms.send.SendMessageActivity;
import volley.VolleyMainActivity;

public class TestActivityList extends ListActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 记录界面（后面一键退出）
		ActivityExitAll main = ActivityExitAll.getInstance();
		main.addActivity(this);
		
		String[] from = { "title" };
		int[] to = { android.R.id.text1 };
		SimpleAdapter adapter = new SimpleAdapter(this, setData(),
				android.R.layout.simple_list_item_1, from, to);

		setListAdapter(adapter);
		
	}
	public ArrayList<HashMap<String, Object>> setData(){
		ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();
		addItem(data, "MainFragmentActivity", MainFragmentActivity.class);
		addItem(data, "TestActivity", TestActivity.class);
		addItem(data, "ListMainActivity", ListMainActivity.class);
		addItem(data, "FragmentTabs", FragmentTabs.class);
		addItem(data, "MyTabActivity", MyTabActivity.class);
		addItem(data, "MyViewTestActivity", MyViewTestActivity.class);
		addItem(data, "slidingmenuActivity", slidingmenuActivity.class);
		addItem(data, "volley框架", VolleyMainActivity.class);
		addItem(data, "弹框二级菜单", PopMainActivity.class);
		addItem(data, "图片动画，逐帧实现", FrameMainActivity.class);
		addItem(data, "baidu地图测试", BaiduMapActivity.class);
		addItem(data, "飞行文字", MainActivity.class);
		addItem(data, "手势测试", GestureActivity.class);
		addItem(data, "自动发送短信", SendMessageActivity.class);

		return data;
	}
	
	

	public void addItem(ArrayList<HashMap<String, Object>> data, String name, Class<?> c) {
		addItem(data, name, new Intent(this, c));
	} 
	
	public void addItem(ArrayList<HashMap<String,Object>> data,String name,Intent intent){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("title", name);
		map.put("intent", intent);
		data.add(map);
	}
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		@SuppressWarnings("unchecked")
		HashMap<String, Object> map = (HashMap<String, Object>) l.getItemAtPosition(position);
		Intent intent = (Intent) map.get("intent");
		startActivity(intent);

		
		
	}
}
