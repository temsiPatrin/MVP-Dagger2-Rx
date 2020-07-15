package com.example.android.mvp_dagger2_rx.retrofit;

import com.example.android.mvp_dagger2_rx.pojo.CryptoData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {
    @GET("ticker/?")
    Observable<List<CryptoData>> getData(@Query("limit") String limit);
}
