package sms.send;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import fragment.R;

public class SendMessageActivity extends AppCompatActivity {
        private Button mSendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message_layout);

        mSendBtn = (Button) findViewById(R.id.sms_send_btn);
        mSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsContent = "你好！";
                // note: SMS must be divided before being sent
                SmsManager sms = SmsManager.getDefault();
                List<String> texts = sms.divideMessage(smsContent);
                for (String text : texts) {
                    sms.sendTextMessage("18328434957", null, text, null, null);
                }
                // note: not checked success or failure yet
                Toast.makeText(
                        SendMessageActivity.this,
                        "短信已发送",
                        Toast.LENGTH_SHORT ).show();
            }

        });
    }
}
