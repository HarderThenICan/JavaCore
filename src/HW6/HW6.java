package HW6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HW6 {
    public static void main(String[] args) throws IOException {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", "9oDoWIqglhXLe2HnztZKSW64f9COkVi6")
                .addQueryParameter("language", "ru")
                .addQueryParameter("q", "Санкт Петербург")
                .build();


        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();


        Response response = okHttpClient.newCall(request).execute();
        String res = response.body().string();
        System.out.println(res);

        // Погода на 5 дней
        OkHttpClient okHttpClientTwo = new OkHttpClient().newBuilder()
                .readTimeout(10, TimeUnit.SECONDS)
                .build();

        HttpUrl urlTwo = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment("295212")
                .addQueryParameter("apikey", "9oDoWIqglhXLe2HnztZKSW64f9COkVi6")
                .addQueryParameter("language", "ru")
                .build();

        Request requestTwo = new Request.Builder()
                .url(urlTwo)
                .get()
                .build();

        Response responseTwo = okHttpClientTwo.newCall(requestTwo).execute();
        String result = responseTwo.body().string();
        System.out.println(result);

    }


}