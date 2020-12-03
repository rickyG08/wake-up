package edu.cnm.deepdive.wakeup.service;

import android.content.Context;

public class WeatherRepository {

  private final Context context;
  private final WebService webService;

  public WeatherRepository(Context context) {
    this.context = context;
    webService = WebService.getInstance();
  }


}
