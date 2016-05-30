package com.example.yangzhe.testleakcanary;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by yangzhe on 16-5-30.
 */
public class TestLeakCanary extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
