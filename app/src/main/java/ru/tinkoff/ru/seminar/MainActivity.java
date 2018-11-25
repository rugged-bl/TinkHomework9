package ru.tinkoff.ru.seminar;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ru.tinkoff.ru.seminar.model.Weather;

/**
 * Реализовать приложение, показывающее текущую погоду в городе из предложенного списка.
 * Часть 1. Подготавливаем окружение для взаимодействия с сервером.
 * 1) Сперва получаем ключ для разработчика (Достаточно зарегистрироваться на сайте, он бесплатный) инструкция: https://openweathermap.org/appid
 * <p>
 * 2) Выполнить 2 запроса для получения текущий погоды и прогноза одного из следующих городов:
 * Moscow,RU
 * Sochi,RU
 * Vladivostok,RU
 * Chelyabinsk,RU
 * API запроса By city name можно прочитать тут:
 * https://openweathermap.org/current#name
 * <p>
 * 1) Шаблон запроса на текущую погоду: api.openweathermap.org/data/2.5/weather?q={city name},{country code}
 * Пример: http://api.openweathermap.org/data/2.5/weather?q=Moscow,ru&APPID=7910f4948b3dcb251ebc828f28d8b30b
 * <p>
 * 2) Шаблон запроса на прогноз погоды: api.openweathermap.org/data/2.5/forecast?q={city name},{country code}
 * Пример: http://api.openweathermap.org/data/2.5/forecast?q=Moscow,ru&APPID=7910f4948b3dcb251ebc828f28d8b30b
 * <p>
 * Важно: Данные с сервера должны приходить в json формате (прим.: значение температуры в градусах Цельсия). Также можно добавить локализацию языка: https://openweathermap.org/current#other
 * <p>
 * Часть 2. Разработка мобильного приложения.
 * Шаблон проекта находиться в ветке: homework_9_network
 * UI менять не надо, используем уже реализованные методы MainActivity.
 * Написать код выполнения запроса в методе performRequest(@NonNull String city).
 * <p>
 * Реализовать следующий функционал:
 * a) С помощью Retrofit, Gson и других удобных для вас инструментов, написать запросы для получения текущий и прогнозы погоды в конкретном городе, используя метод API By city name.
 * б) Реализовать JsonDeserializer, который преобразует json структуру пришедшую с сервера в модель Weather (Также и для прогноза погоды). в) Во время загрузки данных показывать прогресс бар, в случае ошибки выводить соотвествующее сообщение.
 * г) Если у пользователя нет доступа в интернет, кнопка выполнить запрос не активна. При его появлении/отсутствии необходимо менять состояние кнопки;
 * д) (Дополнительное задание) Улучшить форматирование вывода данных на свое усмотрение, текущий погоды и прогноза. Оценивается UI интерфейс.
 */

@SuppressWarnings("unused")
public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Button performBtn;
    private ProgressBar progressBar;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        spinner = findViewById(R.id.spinner);
        performBtn = findViewById(R.id.performBtn);
        progressBar = findViewById(R.id.progressBar);
        resultTextView = findViewById(R.id.resultTextView);
        performBtn.setOnClickListener(v -> performRequest(spinner.getSelectedItem().toString()));
    }

    private void setEnablePerformButton(boolean enable) {
        performBtn.setEnabled(enable);
    }

    @SuppressLint("DefaultLocale")
    private void printResult(@NonNull Weather weather, @NonNull List<Weather> forecast) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                String.format(
                        "CurrentWeather\nDesc: %s \nTimeUnix: %d\nTemp: %.1f\nSpeed wind: %.1f",
                        weather.description,
                        weather.time,
                        weather.temp,
                        weather.speedWind
                )
        );

        if (!forecast.isEmpty()) {
            Weather firstForecastWeather = forecast.get(0);
            stringBuilder.append("\n");
            stringBuilder.append(String.format(
                    "Forecast\nDesc: %s \nTimeUnix: %d\nTemp: %.1f\nSpeed wind: %.1f",
                    firstForecastWeather.description,
                    firstForecastWeather.time,
                    firstForecastWeather.temp,
                    firstForecastWeather.speedWind
            ));
        }
        resultTextView.setText(stringBuilder.toString());
    }

    private void showProgress(boolean visible) {
        progressBar.setVisibility(visible ? View.VISIBLE : View.INVISIBLE);
    }

    private void showError(@NonNull String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    private void performRequest(@NonNull String city) {
        // Здесь необходимо написать свой код.
        // Вызываем нужные методы в нужном порядке.
    }
}

