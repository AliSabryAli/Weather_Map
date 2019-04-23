package com.ali.weathermap.data.network;

import com.ali.weathermap.utils.NetworkUtils;

import java.util.Map;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ApiInterface {
    /**
     * defining the end points
     */
    @GET("{end_point}")
    Call<Object> getObjects(
            @Path("end_point") String endPoint,
            @Query(NetworkUtils.Q_KEY) String key,
            @QueryMap Map<String,Object> map);

}
