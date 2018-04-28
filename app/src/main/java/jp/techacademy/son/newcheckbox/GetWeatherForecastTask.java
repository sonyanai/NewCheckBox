package jp.techacademy.son.newcheckbox;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by taiso on 2018/04/28.
 */

public class GetWeatherForecastTask extends AsyncTask<String, Void, WeatherForecast> {

    Exception exception;

    @Override
    protected WeatherForecast doInBackground(String... params) {

        try {
            return WeatherApi.getWeather(params[0]);
        } catch (IOException | JSONException e) {
            exception = e;
        }
        return null;
    }
}
