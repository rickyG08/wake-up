package edu.cnm.deepdive.wakeup.service;

import android.content.Context;

/**
 * Weather repository that gets the instance of {@link WebService} for weather.
 */
public class WeatherRepository {

  private final Context context;
  private final WebService webService;

  public WeatherRepository(Context context) {
    this.context = context;
    webService = WebService.getInstance();
  }

}
