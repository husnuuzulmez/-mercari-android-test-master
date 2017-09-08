package com.mercari.mercaritest;

import android.app.Application;


public class MercariApp extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = AppComponent.Initializer.init(this);
        appComponent.inject(this);
    }
}
