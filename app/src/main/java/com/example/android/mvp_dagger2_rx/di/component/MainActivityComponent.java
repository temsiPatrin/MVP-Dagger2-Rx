package com.example.android.mvp_dagger2_rx.di.component;


import android.content.Context;

import com.example.android.mvp_dagger2_rx.MainActivity;
import com.example.android.mvp_dagger2_rx.di.module.AdapterModule;
import com.example.android.mvp_dagger2_rx.di.module.MainActivityMvpModule;
import com.example.android.mvp_dagger2_rx.di.qualifier.ActivityContext;
import com.example.android.mvp_dagger2_rx.di.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    @ActivityContext
    Context getContext();
    void injectMainActivity(MainActivity mainActivity);
}
