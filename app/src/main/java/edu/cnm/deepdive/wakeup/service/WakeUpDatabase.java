package edu.cnm.deepdive.wakeup.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import edu.cnm.deepdive.wakeup.model.dao.MotivatorDao;
import edu.cnm.deepdive.wakeup.model.dao.TodoDao;
import edu.cnm.deepdive.wakeup.model.entity.Motivator;
import edu.cnm.deepdive.wakeup.model.entity.Todo;
import edu.cnm.deepdive.wakeup.model.entity.User;

@Database(entities = {Todo.class, User.class, Motivator.class}, version = 1, exportSchema = true)
public abstract class WakeUpDatabase {

  private static final String DB_NAME = "wakeup_db";

  private static Application context;

  public static void setContext(Application context) {
    WakeUpDatabase.context = context;
  }

  public static WakeUpDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract MotivatorDao getMotivatorDao();

  public abstract TodoDao getTodoDao();

  private static class InstanceHolder {

    private static final WakeUpDatabase INSTANCE;

    static {
      INSTANCE = Room.databaseBuilder(context, WakeUpDatabase.class, DB_NAME)
          .build();
    }

  }

}
