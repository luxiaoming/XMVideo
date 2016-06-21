package cn.xm.xmvideoplayer.data.api;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.xm.xmvideoplayer.core.MyApp;
import cn.xm.xmvideoplayer.utils.NetWorkUtil;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 作者：ximencx on 2016/6/13 17:00
 * 邮箱：454366460@qq.com
 * 获得retrofit对象
 */
public class RRVideoService {

    /**
     * baseurl
     */
    private static final String RRVideoHost = "http://api.rrmj.tv/";

    private static final int CACHE_TIME_LONG = 60 * 60 * 24 * 7;

    private static OkHttpClient mOkHttpClient;

    public static RRVideoService builder() {

        return new RRVideoService();
    }

    public RRVideoService() {
        provideOkHttpClient();
    }

    /**
     * 实例化apiservice
     *
     * @return
     */
    public RRVideoApi RRVideoApi() {
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RRVideoHost)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(RRVideoApi.class);
    }


    /**
     * 获得
     */
    private void provideOkHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RRVideoService.class) {
                if (mOkHttpClient == null) {
                    //设置Http缓存
                    Cache cache = new Cache(new File(MyApp.getContext().getCacheDir(), "HttpCache"), 1024 * 1024 * 100);

                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(mRewriteCacheControlInterceptor)
                            .addNetworkInterceptor(mRewriteCacheControlInterceptor)
                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(15, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }


    private Interceptor mRewriteCacheControlInterceptor = new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request request = chain.request();
            if (!NetWorkUtil.isNetworkConnected()) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }
            Response originalResponse = chain.proceed(request);
            if (NetWorkUtil.isNetworkConnected()) {
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder().header("Cache-Control", cacheControl).removeHeader("Pragma").build();
            } else {
                return originalResponse.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + CACHE_TIME_LONG)
                        .removeHeader("Pragma").build();
            }
        }
    };


}
