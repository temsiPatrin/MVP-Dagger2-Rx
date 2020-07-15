package com.example.android.mvp_dagger2_rx.di.module;

import androidx.recyclerview.widget.RecyclerView;

import com.example.android.mvp_dagger2_rx.MainActivity;
import com.example.android.mvp_dagger2_rx.RecyclerViewAdapter;
import com.example.android.mvp_dagger2_rx.di.scopes.ActivityScope;

import dagger.Module;
import dagger.Provides;

@Module(includes = {MainActivityContextModule.class})
public class AdapterModule {
    @Provides
    @ActivityScope
    public RecyclerViewAdapter getCoinList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
    }
    @Provides
    @ActivityScope
    public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
    }

}
