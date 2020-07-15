package com.example.android.mvp_dagger2_rx.di.module;

import android.content.Context;

import com.example.android.mvp_dagger2_rx.MainActivity;
import com.example.android.mvp_dagger2_rx.di.qualifier.ActivityContext;
import com.example.android.mvp_dagger2_rx.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityContextModule {
    private MainActivity mainActivity;

    public Context context;

    public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
    }

    @Provides
    @ActivityScope
    public MainActivity providesMainActivity() {
        return mainActivity;
    }
    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }
}
