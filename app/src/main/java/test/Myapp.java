package test;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;


public class Myapp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SDKInitializer.initialize(getApplicationContext());
    }
}
