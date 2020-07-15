package com.example.android.mvp_dagger2_rx.di.component;

import android.content.Context;

import com.example.android.mvp_dagger2_rx.MyApplication;
import com.example.android.mvp_dagger2_rx.di.module.ContextModule;
import com.example.android.mvp_dagger2_rx.di.module.RetrofitModule;
import com.example.android.mvp_dagger2_rx.di.qualifier.ApplicationContext;
import com.example.android.mvp_dagger2_rx.di.scopes.ActivityScope;
import com.example.android.mvp_dagger2_rx.di.scopes.ApplicationScope;
import com.example.android.mvp_dagger2_rx.retrofit.APIInterface;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {
    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}
