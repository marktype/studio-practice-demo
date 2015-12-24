package anim.secordview;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import fragment.R;

public class FrameMainActivity extends AppCompatActivity {
        private ImageView mImage;
    private AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_main_layout);

        //此种实现方式可以采用progressbar实现，则不用采用下列代码，只用将drawable中的文件放到anim中就好了
        mImage = (ImageView) findViewById(R.id.animator_img);
        animationDrawable = (AnimationDrawable) mImage.getDrawable();
        animationDrawable.start();
    }
}
