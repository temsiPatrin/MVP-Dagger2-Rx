package com.example.android.mvp_dagger2_rx.di.module;

import com.example.android.mvp_dagger2_rx.di.scopes.ActivityScope;
import com.example.android.mvp_dagger2_rx.mvp.MainActivityContract;

import dagger.Module;
import dagger.Provides;

@Module
public class MainActivityMvpModule {
    private final MainActivityContract.View mView;


    public MainActivityMvpModule(MainActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    MainActivityContract.View provideView() {
        return mView;
    }
}
