package edu.cnm.deepdive.wakeup.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.wakeup.model.dao.MotivatorDao;
import edu.cnm.deepdive.wakeup.model.entity.Motivator;
import edu.cnm.deepdive.wakeup.model.entity.Todo;
import io.reactivex.Completable;
import java.util.List;

/**
 * The CRUD operations and queries on {@link Motivator} entity instances.
 */
public class MotivatorRepository {

  private final Context context;
  private final MotivatorDao motivatorDao;

  /**
   * The constructor initializes the context, the app database and the motivator dao.
   * @param context The app context.
   */
  public MotivatorRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    motivatorDao = database.getMotivatorDao();
  }

  /**
   * Saves a motivator and indicates whether it completed or failed.
   * @param motivator The user to be saved.
   * @return A Completable indicating if the motivator saved into the database or not.
   */
  public Completable save(Motivator motivator) {
    return (motivator.getMotivatorId() == 0)
        ? motivatorDao.insert(motivator).
        doAfterSuccess(motivator::setMotivatorId)
        .ignoreElement()
        : motivatorDao.update(motivator)
            .ignoreElement();
  }

  /**
   * Deletes a motivator from the database.
   * @param motivator  The user to be deleted from the database.
   * @return  A Completable which indicated if the motivator was deleted or not.
   */
  public Completable delete(Motivator motivator) {
    return (motivator.getMotivatorId() == 0) ?
        Completable.complete()
        : motivatorDao.delete(motivator)
            .ignoreElement();
  }

  /**
   * Returns LiveData on a motivator by the id.
   * @param id The motivator id
   */
  public LiveData<Motivator> selectMotivator(long id) {
    return motivatorDao.selectMotivator(id);
  }

  /**
   * Returns a List of LiveData of motivators by their names.
   * @param name The name of the motivator
   */
  public LiveData<List<Motivator>> getMotivators(String name) {
    return motivatorDao.getMotivators(name);
  }

}
