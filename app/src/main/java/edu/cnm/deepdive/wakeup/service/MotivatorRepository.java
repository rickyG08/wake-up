package edu.cnm.deepdive.wakeup.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.wakeup.model.dao.MotivatorDao;
import edu.cnm.deepdive.wakeup.model.entity.Motivator;
import edu.cnm.deepdive.wakeup.model.entity.Todo;
import io.reactivex.Completable;
import java.util.List;

public class MotivatorRepository {

  private final Context context;
  private final MotivatorDao motivatorDao;

  public MotivatorRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    motivatorDao = database.getMotivatorDao();
  }

  public Completable save(Motivator motivator) {
    return (motivator.getMotivatorId() == 0)
        ? motivatorDao.insert(motivator).
        doAfterSuccess(motivator::setMotivatorId)
        .ignoreElement()
        : motivatorDao.update(motivator)
            .ignoreElement();
  }
  public Completable delete(Motivator motivator){
    return (motivator.getMotivatorId() == 0)?
        Completable.complete()
        : motivatorDao.delete(motivator)
            .ignoreElement();
  }
  public LiveData<Motivator> selectByName(String name) {
    return motivatorDao.getMotivators(name);
  }
}
