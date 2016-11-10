package com.blue.blueskyleap.app;

import android.app.Application;

/**
 * Created by XiDong on 2016/7/18.
 */
public class MyApp extends Application {

    private static MyApp app;


    public static MyApp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.app= this;



    }


}
