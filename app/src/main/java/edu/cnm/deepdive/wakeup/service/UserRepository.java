package edu.cnm.deepdive.wakeup.service;

import android.content.Context;
import edu.cnm.deepdive.wakeup.model.dao.UserDao;

public class UserRepository {

  private final Context context;
  private final UserDao userDao;

  public UserRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    userDao = database.getUserDao();
  }

}
