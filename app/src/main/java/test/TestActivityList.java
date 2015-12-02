package test;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import fragment.MainFragmentActivity;
import fragment.test.TestActivity;

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
