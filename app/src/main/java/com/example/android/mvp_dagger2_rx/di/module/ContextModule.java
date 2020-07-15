package com.example.android.mvp_dagger2_rx.di.module;

import android.content.Context;

import com.example.android.mvp_dagger2_rx.di.qualifier.ApplicationContext;
import com.example.android.mvp_dagger2_rx.di.scopes.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    @ApplicationContext
    public Context providerContext() {
        return context;
    }
}
