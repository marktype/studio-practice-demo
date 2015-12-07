package fragment.list;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import fragment.Logs;


public class ListMainFragment extends ListFragment {
    private String[] str = {"北京","上海","成都"};
    private  listAdapter mAdapter;
    private OnFragmentDialogListener mListener;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAdapter = new listAdapter(getActivity());
        setListAdapter(mAdapter);
        mAdapter.setlist(str);

    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String msg = (String) mAdapter.getItem(position);
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();

        onButtonPressed(msg);


    }
    public void onButtonPressed(String msg) {
        Logs.e("--------"+msg);
        if (mListener != null) {
            mListener.onFragmentDialog(msg);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Logs.e("aaaaaaaaaaaaaa");
        if (activity instanceof OnFragmentDialogListener) {
            mListener = (OnFragmentDialogListener) activity;
        } else {
            throw new RuntimeException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        Logs.e("aaaaaaaaaaaaaa");
//        if (context instanceof OnFragmentDialogListener) {
//            mListener = (OnFragmentDialogListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentDialogListener {
        // TODO: Update argument type and name
        void onFragmentDialog(String msg);
    }


    public class listAdapter extends BaseAdapter {
        String[] list = new String[]{};
        private Context context;
        private LayoutInflater inflater;

        public listAdapter(Context context) {
            this.context = context;

            inflater = LayoutInflater.from(context);
        }

        public void setlist(String[] list) {
            this.list = list;
            notifyDataSetChanged();   //网络取数据时必须加上，不然无法获取数据
        }


        @Override
        public int getCount() {// 目录数量
            return list.length;
        }

        @Override
        public Object getItem(int position) {
            return list[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = null;
            if (convertView == null) {
                // 解析xml
                v = inflater.inflate(
                        android.R.layout.simple_list_item_1, null);

            } else {
                v = convertView;
            }

            String msg = (String) getItem(position);
            TextView msgTxt = (TextView) v;
            msgTxt.setText(msg);
            return v;
        }

    }}
