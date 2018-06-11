package com.apgred;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nagendrasrivastava on 10/06/18.
 */

public class ApgredNetworkClient {

    private String BASE_URL = "somthing over here ";
    private static ApgredNetworkClient INSTANCE;

    private OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static ApgredNetworkClient getInstance() {
        synchronized (ApgredNetworkClient.class) {
            if (INSTANCE == null) {
                INSTANCE = new ApgredNetworkClient();
            }
        }
        return INSTANCE;
    }

    public ApgredRestClient getRestClient() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(ApgredRestClient.class);

    }
}
