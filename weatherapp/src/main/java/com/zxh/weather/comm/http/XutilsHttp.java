package com.zxh.weather.comm.http;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by xiaohu on 2016/3/26.
 */
public class XutilsHttp {


    //doget请求
    public static void doGet(String url, final MyCallBack callBack){
        RequestParams requestParams=new RequestParams(url,null,null,null);
        x.http().get(requestParams, new Callback.ProgressCallback<String>() {
            @Override
            public void onSuccess(String result) {
                    callBack.onSuccess(result);
            }
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                    callBack.onError(ex,isOnCallback);
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                    callBack.onFinished();
            }

            @Override
            public void onWaiting() {
                    callBack.onWaiting();
            }

            @Override
            public void onStarted() {
                    callBack.onStarted();
            }

            @Override
            public void onLoading(long total, long current, boolean isDownloading) {
                    callBack.onLoading(total,current,isDownloading);
            }
        });
    }

}
