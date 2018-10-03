package com.moviesdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by gboss on 02/10/18.
 */

public class ApiClient {

  private static Retrofit retrofit = null;


  public static Retrofit getClient() {
    if (retrofit==null) {
      retrofit = new Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build();
    }
    return retrofit;
  }
}
