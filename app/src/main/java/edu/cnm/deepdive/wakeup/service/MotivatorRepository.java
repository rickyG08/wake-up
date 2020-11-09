package edu.cnm.deepdive.wakeup.service;

import android.content.Context;
import edu.cnm.deepdive.wakeup.model.dao.MotivatorDao;

public class MotivatorRepository {

  private final Context context;
  private final MotivatorDao motivatorDao;

  public MotivatorRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    motivatorDao = database.getMotivatorDao();
  }
}
