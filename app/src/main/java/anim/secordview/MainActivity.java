package anim.secordview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import fragment.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "main";
    private BiuEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biu_layout);
//        editText = (BiuEditText) findViewById(R.id.biucontainer);
    }


}
