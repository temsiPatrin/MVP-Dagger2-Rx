package com.example.android.mvp_dagger2_rx.mvp;

import com.example.android.mvp_dagger2_rx.pojo.CryptoData;

import java.util.List;

public interface MainActivityContract {
    interface View{
        void showData(List<CryptoData> data);
        void showError(String message);
        void showComplete();
        void showProgress();
        void hideProgress();
    }
    interface Presenter {
        void loadData();
    }
}
