package com.example.android.mvp_dagger2_rx;

import android.app.Activity;
import android.app.Application;

import com.example.android.mvp_dagger2_rx.di.component.ApplicationComponent;
import com.example.android.mvp_dagger2_rx.di.component.DaggerApplicationComponent;
import com.example.android.mvp_dagger2_rx.di.module.ContextModule;


public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        applicationComponent.injectApplication(this);
    }

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }
    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }
}
