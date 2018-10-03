package com.moviesdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.moviesdemo.model.Datum;
import com.moviesdemo.model.MovieResponse;
import com.moviesdemo.model.MyComparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private int totalPages;
  int currentPage = 1;
  List<String> titleList = new ArrayList<>();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getMovieData(currentPage);
  }

  private void getMovieData(int pagenumber) {
    ApiInterface apiService =
        ApiClient.getClient().create(ApiInterface.class);

    Call<MovieResponse> call = apiService.getMovies("Spiderman", pagenumber);
    call.enqueue(new Callback<MovieResponse>() {
      @Override
      public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
        MovieResponse movieResult = response.body();

        currentPage = Integer.parseInt(movieResult.getPage());
        totalPages = movieResult.getTotalPages();

        List<Datum> movies = response.body().getData();
        addMovieTitleList(movies);

        if (currentPage == totalPages) {
          sorting(movies);
        } else {
          getMovieData(currentPage+1);
        }


      }

      @Override
      public void onFailure(Call<MovieResponse> call, Throwable t) {
        // Log error here since request failed

      }
    });
  }


  void addMovieTitleList(List<Datum> movies) {
    for (Datum item : movies) {
      titleList.add(item.getTitle());
    }

  }

  void sorting(List<Datum> movies) {

    // before sorting
    System.out.println(titleList);

    // sort the list
    MyComparator myComparator = new MyComparator();
    Collections.sort(titleList, myComparator);

    // after sorting
    System.out.println(titleList);

  }


}
