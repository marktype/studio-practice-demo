package costomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import fragment.R;

public class MyView extends View {
    private String textContent;
    private Drawable bankground;
    private int location;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MyView);
        textContent = ta.getString(R.styleable.MyView_textcontent);
        bankground = ta.getDrawable(R.styleable.MyView_textbankground);
//        location = ta.getDimensionPixelSize(R.styleable.MyView_textlocation,1);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(40);


        canvas.drawText(textContent,120,240,paint);
//        canvas.drawPoint(100,200,paint);

    }
    /*
     * 检测View组件及其子组件的大小
     * */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

}
