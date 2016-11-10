package com.blue.blueskyleap.utils;

import android.widget.Toast;

import com.blue.blueskyleap.app.MyApp;


/**
 * Created by XiDong on 2016/7/20.
 */
public class ToastUtil {
    public static void shotShortToast(String str){
        Toast.makeText(MyApp.getApp(),str,Toast.LENGTH_SHORT).show();
    }
    //MyApp.getApp() 禁止内存邪路
    public static void shotLongToast(String str){
        Toast.makeText(MyApp.getApp(),str,Toast.LENGTH_LONG).show();
    }
}
