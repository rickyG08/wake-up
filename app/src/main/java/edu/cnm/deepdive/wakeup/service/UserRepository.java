package edu.cnm.deepdive.wakeup.service;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import edu.cnm.deepdive.wakeup.model.dao.UserDao;
import edu.cnm.deepdive.wakeup.model.entity.User;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * The repository class which
 */
public class UserRepository {

  private final Context context;
  private final UserDao userDao;
//  private final GoogleSignInService signInService;

  public UserRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    userDao = database.getUserDao();
  }

//  public Single<User> createUser(@NonNull GoogleSignInAccount account) {
//    return Single.fromCallable(() -> {
//      User user = new User();
//      user.setUserId(account.getDisplayName());
//      user.setOauthKey(account.getId());
//      return user;
//    })
//        .flatMap((user) ->
//            userDao.insert(user)
//                .map((id) -> {
//                  if (id > 0) {
//                    user.setUserId(id);
//                  }
//                  return user;
//                })
//        )
//        .subscribeOn(Schedulers.io());
//  }

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

}
