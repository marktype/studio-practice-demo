package fragment.alertdialog;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import fragment.R;

public class AlertDialogFragment extends DialogFragment {
    private String mArgs;

    public static AlertDialogFragment newInstance(String msg) {

        Bundle args = new Bundle();
        args.putCharSequence("msg", msg);
        AlertDialogFragment fragment = new AlertDialogFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mArgs = getArguments().getCharSequence("msg").toString();
        }

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setIcon(R.mipmap.ic_launcher).setMessage("欢迎来到" + mArgs);


        return dialog.create();
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_alert_dialog_layout, container, false);
//    }


}
