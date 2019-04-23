package com.ali.weathermap.data.network;

import java.util.Map;

public interface ApiModelListener {

    interface OnFinishedListener {
        void onFinished(Object responseObjects);

        void onFailure(Throwable t);
    }

    void getObjects(String endPoint, Map<String, Object> QueriesMap
            , OnFinishedListener onFinishedListener);
}
