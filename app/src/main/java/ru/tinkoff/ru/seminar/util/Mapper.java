package ru.tinkoff.ru.seminar.util;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.ru.seminar.model.ForecastEntity.ForecastListElement;
import ru.tinkoff.ru.seminar.model.ForecastEntity.ForecastResponse;
import ru.tinkoff.ru.seminar.model.Weather;
import ru.tinkoff.ru.seminar.model.WeatherEntity.WeatherResponse;

public class Mapper {
    Weather mapWeatherFromWeatherResponse(WeatherResponse weatherResponse) {
        return new Weather(
                weatherResponse.getWeather().get(0).description,
                weatherResponse.getDt(),
                weatherResponse.getWeather().get(0).temp,
                (float) weatherResponse.getWind().getSpeed());
    }

    List<Weather> mapForecastFromForecastResponse(ForecastResponse forecastResponse) {
        List<ForecastListElement> list = forecastResponse.getList();
        List<Weather> weatherList = new ArrayList<>(list.size());

        for (ForecastListElement forecastListElement : list) {
            weatherList.add(new Weather(
                    forecastListElement.getWeather().get(0).getDescription(),
                    forecastListElement.getDt(),
                    (float) forecastListElement.getMain().getTemp(),
                    (float) forecastListElement.getWind().getSpeed()
            ));
        }

        return weatherList;
    }
}
