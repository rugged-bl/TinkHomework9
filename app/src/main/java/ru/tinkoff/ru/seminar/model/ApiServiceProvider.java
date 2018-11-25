package ru.tinkoff.ru.seminar.model;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.tinkoff.ru.seminar.BuildConfig;

public class ApiServiceProvider {
    private static ApiService apiService;

    private ApiServiceProvider() {
    }

    public static ApiService provideApiService() {
        if (apiService == null) {
            synchronized (ApiService.class) {
                if (apiService == null) {
                    apiService = provideRetrofit(provideOkHttpClient()).create(ApiService.class);
                }
            }
        }
        return apiService;
    }

    private static Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .baseUrl(BuildConfig.API_URL)

                .build();
    }

    private static OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().
                        setLevel((BuildConfig.DEBUG) ?
                                HttpLoggingInterceptor.Level.BODY :
                                HttpLoggingInterceptor.Level.NONE))
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build();
    }
}
