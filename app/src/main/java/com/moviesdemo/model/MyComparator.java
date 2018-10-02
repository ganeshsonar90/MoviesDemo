package com.moviesdemo.model;

import java.util.Comparator;

/**
 * Created by gboss on 02/10/18.
 */

public class MyComparator implements Comparator<String> {
  @Override
  public int compare(String o1, String o2) {
    return o2.compareTo(o1); // magic line
  }
}
