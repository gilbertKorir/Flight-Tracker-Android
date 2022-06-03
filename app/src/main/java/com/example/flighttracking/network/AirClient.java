package com.example.flighttracking.network;


import static com.example.flighttracking.Constants.AIR_API_KEY;
import static com.example.flighttracking.Constants.AIR_BASE_URL;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AirClient {

    private static Retrofit retrofit = null;

    public static AirApi getClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AIR_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(AirApi.class);
    }

}
