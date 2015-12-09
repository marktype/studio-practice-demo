package costomview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import fragment.R;

/*
* 自定义控件实现及监听
* */
public class MyOwnView extends RelativeLayout implements View.OnClickListener{
    private LayoutInflater mInflater;
    private OnClickListener mClickListener;
    private String firstTxt,twoTxt,threeTxt;
    public void setMyViewOnClickListener(OnClickListener l){   //activity中注册所调用的方法，接口采用系统定义接口（也可自定义一个接口）
        mClickListener = l;
    }

    public MyOwnView(Context context) {
        super(context);
    }

    public MyOwnView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public MyOwnView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

   public void init(Context context, AttributeSet attrs){
       mInflater = LayoutInflater.from(context);
       View v = mInflater.inflate(R.layout.own_view_layout,this,true);    //联系上下文解析原始布局
       TypedArray a = null;
       try {
           a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.MyOwnView,0,0);
           //获取新布局中引用自定义控件设置的值
           firstTxt = a.getString(R.styleable.MyOwnView_text_first);
          twoTxt = a.getString(R.styleable.MyOwnView_text_two);
          threeTxt = a.getString(R.styleable.MyOwnView_text_three);
       }finally {
           a.recycle();   //回收
       }


       if (firstTxt != null){
           TextView first = (TextView) v.findViewById(R.id.own_first_txt);   //设置值在原始布局中
           first.setText(firstTxt);
           first.setOnClickListener(this);     //此处采用系统接口注册
       }
       if (twoTxt != null){
           TextView two = (TextView) v.findViewById(R.id.own_two_txt);
           two.setText(twoTxt);

       }

       if (threeTxt != null){
           TextView three = (TextView) v.findViewById(R.id.own_three_txt);
           three.setText(threeTxt);
           three.setOnClickListener(this);
       }
   }

    @Override
    public void onClick(View v) {
        if (mClickListener != null){
            mClickListener.onClick(v);
        }
    }
}
