package ru.tinkoff.ru.seminar.model;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.tinkoff.ru.seminar.model.ForecastEntity.ForecastResponse;
import ru.tinkoff.ru.seminar.model.WeatherEntity.WeatherResponse;

public interface ApiService {
    @GET("/data/2.5/weather")
    Single<WeatherResponse> getWeather(@Query("q") String city, @Query("APPID") String appId);

    @POST("/data/2.5/forecast")
    Single<ForecastResponse> getForecast(@Query("q") String city, @Query("APPID") String appId);
}
