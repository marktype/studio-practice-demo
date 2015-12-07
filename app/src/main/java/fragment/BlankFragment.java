package fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class BlankFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView mListview;
    public static final String TAG_A = "a";
    public static final String TAG_B = "b";
    public static final String TAG_C = "c";
    private String[] info = {"新闻","娱乐","导航"};
    private OnFragmentInteractionListener mListener;
    private String mBundle;
    public static Fragment newIntance(String message){
        BlankFragment blankFragment = new BlankFragment();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("message",message);
        blankFragment.setArguments(bundle);
        return blankFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    if (getArguments() != null){
        mBundle = getArguments().getString("message");
    }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(fragment.R.layout.fragment_blank, container, false);
        mListview = (ListView) v.findViewById(R.id.fragment_listview);
        mListview.setOnItemClickListener(this);
        FragmentAdapter adapter = new FragmentAdapter(getActivity());
        adapter.setData(info);
        mListview.setAdapter(adapter);

//        String msg = mBundle.getString("meaasge");

        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //获取item字符串
//        FragmentAdapter fragmentAdapter = (FragmentAdapter) parent.getAdapter();
//        String message = (String) fragmentAdapter.getItem(position);
//        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
        //传递标记
        switch (position){
            case 0:
                onButtonPressed(TAG_A);
                break;
            case 1:
                onButtonPressed(TAG_B);
                break;
            case 2:
                onButtonPressed(TAG_C);
                break;

        }

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

    public void onButtonPressed(String msg) {
        if (mListener != null) {
            mListener.onFragmentInteraction(msg);
        }
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String msg);
    }
}
