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

/**
 * Abstract class that holds the database for the application and hold the type converters for dates.
 */
@Database(entities = {Todo.class, User.class, Motivator.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class WakeUpDatabase extends RoomDatabase {

  private static final String DB_NAME = "wakeup_db";

  private static Application context;

  /**
   * The Application context for the database.
   * @param context The context of the app
   */
  public static void setContext(Application context) {
    WakeUpDatabase.context = context;
  }

  /**
   * Returns the instance of the database.
   */
  public static WakeUpDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  /**
   * Returns the {@link MotivatorDao}
   */
  public abstract MotivatorDao getMotivatorDao();

  /**
   * Returns the {@link TodoDao}
   */
  public abstract TodoDao getTodoDao();

  /**
   * Returns the {@link UserDao}
   */
  public abstract UserDao getUserDao();

  private static class InstanceHolder {

    private static final WakeUpDatabase INSTANCE =
        Room.databaseBuilder(context, WakeUpDatabase.class, DB_NAME)
            .build();

  }

  /**
   * Converter class for date values.
   */
  public static class Converters {

    /**
     * Returns a date into a Long
     *
     * @param value The value of the date
     */
    @TypeConverter
    public static Long dateToLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    /**
     * Returns a Long into a date.
     * @param value The value of the Long
     */
    @TypeConverter
    public static Date longToDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }

  }

}