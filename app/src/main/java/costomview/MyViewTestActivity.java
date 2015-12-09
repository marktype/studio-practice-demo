package costomview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import fragment.R;

/**
 * Created by FJ on 2015/12/8.
 */
public class MyViewTestActivity extends Activity {
    private MyOwnView myOwnView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myview_layout);


        myOwnView = (MyOwnView) findViewById(R.id.my_title_view);

        myOwnView.setMyViewOnClickListener(new View.OnClickListener() {   //实现监听
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.own_first_txt:
                        finish();
                        break;
                    case R.id.own_three_txt:
                        Toast.makeText(MyViewTestActivity.this,"点击成功",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
