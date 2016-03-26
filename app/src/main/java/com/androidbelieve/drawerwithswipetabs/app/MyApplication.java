package com.androidbelieve.drawerwithswipetabs.app;


import android.app.Application;

import com.androidbelieve.drawerwithswipetabs.helper.ParseUtils;

public class MyApplication extends Application {

    private static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        // register with parse
        ParseUtils.registerParse(this);
    }


    public static synchronized MyApplication getInstance() {
        return mInstance;
    }
}
