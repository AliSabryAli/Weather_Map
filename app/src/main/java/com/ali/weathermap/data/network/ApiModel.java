package com.ali.weathermap.data.network;


import android.util.Log;

import com.ali.weathermap.BuildConfig;
import com.ali.weathermap.utils.NetworkUtils;


import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * business logic for fetching data from a server
 */
public class ApiModel implements ApiModelListener {
    public static final String TAG = "Api Model";
    private Call<Object> call;

    @Override
    public void getObjects(String endPoint, Map<String, Object> QueriesMap,
                           final OnFinishedListener onFinishedListener) {

        call = NetworkUtils.getApiServices()
                .getObjects(endPoint, BuildConfig.API_KEY, QueriesMap);
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

                if (response.code() == 200) {
                    onFinishedListener.onFinished(response.body());
                } else {
                    try {
                        onFinishedListener.onError(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });
    }
}
