package HW7.App;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;


public class AccuweatherModel implements WeatherModel {
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/295212
    private static final String PROTOCOL = "https";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECASTS = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY = "5day";
    private static final String API_KEY = "9oDoWIqglhXLe2HnztZKSW64f9COkVi6";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LANGUAGE = "language";
    private static final String LANGUAGE_PARAM = "ru";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private DataBaseRepository dataBaseRepository = new DataBaseRepository();


    public void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(ONE_DAY)
                        .addPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE, LANGUAGE_PARAM)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();

                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse);
                //TODO: сделать человекочитаемый вывод погоды. Выбрать параметры для вывода на свое усмотрение
                //Например: Погода в городе Москва - 5 градусов по цельсию Expect showers late Monday night


                String infoMin = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature/Minimum/Value").asText();
                String infoMax = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asText();
                String infoDay = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Day/IconPhrase").asText();
                String infoNight = objectMapper.readTree(weatherResponse).at("/DailyForecasts").get(0).at("/Night/IconPhrase").asText();

                System.out.println("Максимальная температура в F " + infoMin + " Минимальная в F " + infoMax + " Днем " + infoDay + " Ночью " + infoNight);
                break;

            case FIVE_DAYS:
                //TODO*: реализовать вывод погоды на 5 дней

                HttpUrl httpUrlFive = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addPathSegment(FORECASTS)
                        .addPathSegment(VERSION)
                        .addPathSegment(DAILY)
                        .addPathSegment(FIVE_DAY)
                        .addPathSegment("295212")
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .addQueryParameter(LANGUAGE, LANGUAGE_PARAM)
                        .build();

                Request requestFive = new Request.Builder()
                        .url(httpUrlFive)
                        .build();

                Response fiveDayForecastResponse = okHttpClient.newCall(requestFive).execute();
                String weatherResponseFive = fiveDayForecastResponse.body().string();

                String infoMinOne = objectMapper.readTree(weatherResponseFive).at("/DailyForecasts").get(0).at("/Temperature/Minimum/Value").asText();
                String infoMaxOne = objectMapper.readTree(weatherResponseFive).at("/DailyForecasts").get(0).at("/Temperature/Maximum/Value").asText();
                String infoDayOne = objectMapper.readTree(weatherResponseFive).at("/DailyForecasts").get(0).at("/Day/IconPhrase").asText();
                String infoNightOne = objectMapper.readTree(weatherResponseFive).at("/DailyForecasts").get(0).at("/Night/IconPhrase").asText();

                System.out.println("Максимальная температура в F " + infoMinOne + " Минимальная в F " + infoMaxOne + " Днем " + infoDayOne + " Ночью " + infoNightOne);

                break;
        }
    }
    @Override
    public List<Weather> getSavedToDBWeather() {
        return dataBaseRepository.getSavedToDBWeather();
    }


    private String detectCityKey(String selectCity) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();

        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();

        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;
    }
}
