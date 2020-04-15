package com.cartoaware.mvvm.data;

import com.cartoaware.mvvm.utils.Constants;
import com.cartoaware.mvvmdemo.BuildConfig;
import com.pixplicity.easyprefs.library.Prefs;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))
            .addInterceptor(new Interceptor() {
                @NotNull
                @Override
                public Response intercept(@NotNull Chain chain) throws IOException {
                    Request og = chain.request();
                    if(Prefs.getString(Constants.AUTH_TOKEN, null) != null) {
                        Request newRequest = og.newBuilder()
                                .header("Authorization", "JWT " + Prefs.getString(Constants.AUTH_TOKEN, null))
                                .build();
                        return chain.proceed(newRequest);
                    }else{
                        return chain.proceed(og);
                    }
                }
            }).build();

    private static Retrofit retrofit = new Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static <S> S createApiService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
