package edu.cnm.deepdive.wakeup;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class WakeUpApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
  }
}
