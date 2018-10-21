package com.apgred;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nagendrasrivastava on 10/06/18.
 */

public final class ApgredNetworkClient {

    private static final String BASE_URL = "http://apgred.com/api/";
    private static ApgredNetworkClient INSTANCE;

    public static ApgredNetworkClient getInstance() {
        synchronized (ApgredNetworkClient.class) {
            if (INSTANCE == null) {
                INSTANCE = new ApgredNetworkClient();
            }
        }
        return INSTANCE;
    }

    public ApgredRestClient getRestClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.addInterceptor(loggingInterceptor);
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(clientBuilder.build()).build();
        return retrofit.create(ApgredRestClient.class);

    }
}
