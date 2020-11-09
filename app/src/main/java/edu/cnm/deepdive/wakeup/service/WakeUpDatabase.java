package edu.cnm.deepdive.wakeup.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.wakeup.model.dao.MotivatorDao;
import edu.cnm.deepdive.wakeup.model.dao.TodoDao;
import edu.cnm.deepdive.wakeup.model.dao.UserDao;
import edu.cnm.deepdive.wakeup.model.entity.Motivator;
import edu.cnm.deepdive.wakeup.model.entity.Todo;
import edu.cnm.deepdive.wakeup.model.entity.User;
import edu.cnm.deepdive.wakeup.service.WakeUpDatabase.Converters;
import java.util.Date;

@Database(entities = {Todo.class, User.class, Motivator.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class WakeUpDatabase extends RoomDatabase {

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

  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final WakeUpDatabase INSTANCE =
        Room.databaseBuilder(context, WakeUpDatabase.class, DB_NAME)
            .build();

  }

  public static class Converters {

    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }


  }
}