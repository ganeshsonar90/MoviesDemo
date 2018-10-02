package com.moviesdemo;

import com.moviesdemo.model.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by gboss on 02/10/18.
 */

public interface ApiInterface {

  //https://jsonmock.hackerrank.com/api/movies/search/?Title=spiderman&page=1

  @GET()
  Call<MovieResponse> getMovies(
      @Query("Title") String title,
      @Query("page") int pageIndex
  );

}
