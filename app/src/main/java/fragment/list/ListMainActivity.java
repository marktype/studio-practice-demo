package fragment.list;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import fragment.R;
import fragment.alertdialog.AlertDialogFragment;

public class ListMainActivity extends Activity implements ListMainFragment.OnFragmentDialogListener {
    private Button mDialogBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_main_layout);
        mDialogBtn = (Button) findViewById(R.id.fragment_btn);

        mDialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().add(AlertDialogFragment.newInstance(""),null).commit();
            }
        });
    }

    @Override
    public void onFragmentDialog(String msg) {
        getFragmentManager().beginTransaction().add(AlertDialogFragment.newInstance(msg),null).commit();
    }


//    @Override
//    public void onFragmentDialog(String msg) {
//        Logs.e("2222222222222222");
//        getFragmentManager().beginTransaction().add(AlertDialogFragment.newInstance(msg),null).commit();
//    }
}
