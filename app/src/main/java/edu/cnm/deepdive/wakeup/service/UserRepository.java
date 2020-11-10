package edu.cnm.deepdive.wakeup.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.wakeup.model.dao.UserDao;
import edu.cnm.deepdive.wakeup.model.entity.User;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import java.util.List;

public class UserRepository {

  private final Context context;
  private final UserDao userDao;

  public UserRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    userDao = database.getUserDao();
  }

  public Completable save(User user) {
    return (user.getUserId() == 0)
        ? userDao.insert(user)
        .doAfterSuccess(user::setUserId)
        .ignoreElement()
        : userDao.update(user)
            .ignoreElement();
  }

  public Completable delete(User user) {
    return (user.getUserId() == 0)
        ? Completable.complete()
        : userDao.delete(user)
            .ignoreElement();
  }

  LiveData<User> selectById(long userId) {
    return userDao.getById(userId);
  }


  Single<User> getUserByOauthKey(String oauthKey) {
    return userDao.getUserByOauthKey(oauthKey);
  }

  // TODO get users
}
