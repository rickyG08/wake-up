package edu.cnm.deepdive.wakeup;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.wakeup.service.GoogleSignInService;
import edu.cnm.deepdive.wakeup.service.WakeUpDatabase;
import io.reactivex.schedulers.Schedulers;

/**
 * The main application class that initializes the app, Google Sign-in service, Stetho and the WakeUp
 * database.
 */
public class WakeUpApplication extends Application {

  // CHECK stetho now

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    GoogleSignInService.setContext(this);
    WakeUpDatabase.setContext(this);
    WakeUpDatabase.getInstance().getTodoDao().delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }
}
