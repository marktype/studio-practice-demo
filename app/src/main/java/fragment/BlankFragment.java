package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
public class BlankFragment extends Fragment {
    private ListView mListview;
    private String[] info = {"新闻","娱乐","导航"};
    public static Fragment newIntance(){
        BlankFragment blankFragment = new BlankFragment();
        return blankFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(fragment.R.layout.fragment_blank, container, false);
        mListview = (ListView) v.findViewById(R.id.fragment_listview);

        FragmentAdapter adapter = new FragmentAdapter(getActivity());
        adapter.setData(info);
        mListview.setAdapter(adapter);
        return v;
    }


    public class FragmentAdapter extends BaseAdapter{
        private String[] info = new String[]{};
        private LayoutInflater layoutInflater;
        public FragmentAdapter(Context context){
            layoutInflater = LayoutInflater.from(context);
        }


        private void setData(String[] info){
            this.info = info;
            notifyDataSetChanged();
        }
        @Override
        public int getCount() {
            return info.length;
        }

        @Override
        public Object getItem(int position) {
            return info[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
          if (convertView == null){
              convertView = layoutInflater.inflate(android.R.layout.simple_list_item_1,null);
          }

            TextView textView = (TextView) convertView;
            textView.setText(info[position]);

            return convertView;
        }
    }
}
