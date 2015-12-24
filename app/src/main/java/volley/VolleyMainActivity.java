package volley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import fragment.R;


public class VolleyMainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mVolleyBtn;
    private TextView mContentTxt;
    private String url = "http://c.m.163.com/nc/article/headline/T1348647909107/0-20.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_main_layout);
        mContentTxt = (TextView) findViewById(R.id.volley_content_txt);
        mVolleyBtn  = (Button) findViewById(R.id.volley_btn);

        mVolleyBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.volley_btn:
                StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        mContentTxt.setText(s);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Toast.makeText(VolleyMainActivity.this,volleyError.toString(),Toast.LENGTH_SHORT).show();
                    }
                });
                RequestQueue queue = Volley.newRequestQueue(this);   //可以将其定义在继承Application的类中，那么此时就作为，整个应用都能使用
                queue.add(request);
                break;
        }
    }
}
