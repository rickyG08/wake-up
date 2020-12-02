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
 * The CRUD operations and queries on a {@link User} entity instance.
 */
public class UserRepository {

  private final Context context;
  private final UserDao userDao;
  private final GoogleSignInService signInService;

  /**
   * The constructor initializes the context, the app database the user dao and the Google Sign-in
   * service.
   * @param context The app context.
   */
  public UserRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    userDao = database.getUserDao();
    signInService = GoogleSignInService.getInstance();
  }

  /**
   * Creates the user record into the database by the Google Sign-in account.
   * @param account The users Google account
   * @return A Single user which was created.
   */
  @SuppressWarnings("ConstantConditions")
  public Single<User> createUser(@NonNull GoogleSignInAccount account) {
    return Single.fromCallable(() -> {
      User user = new User();
      user.setOauthKey(account.getId());
      return user;
    })
        .flatMap((user) ->
            userDao.insert(user)
                .map((id) -> {
                  if (id > 0) {
                    user.setUserId(id);
                  }
                  return user;
                })
        )
        .subscribeOn(Schedulers.io());
  }

  /**
   * Saves a user and indicates whether it completed or failed.
   * @param user The user to be saved.
   * @return A Completable indicating if the user saved into the database or not.
   */
  public Completable save(User user) {
    return (user.getUserId() == 0)
        ? userDao.insert(user)
        .doAfterSuccess(user::setUserId)
        .ignoreElement()
        : userDao.update(user)
            .ignoreElement();
  }

  /**
   * Deletes a user from the database.
   * @param user  The user to be deleted from the database.
   * @return  A Completable which indicated if the user was deleted or not.
   */
  public Completable delete(User user) {
    return (user.getUserId() == 0)
        ? Completable.complete()
        : userDao.delete(user)
            .ignoreElement();
  }

  /**
   * Returns LiveData on a user by their id.
   * @param userId The id of the user.
   */
  LiveData<User> selectById(long userId) {
    return userDao.getById(userId);
  }

  /**
   * Returns a Single of a user by their oauth key.
   * @param oauthKey The oauth key of a user.
   */
  Single<User> getUserByOauthKey(String oauthKey) {
    return userDao.getUserByOauthKey(oauthKey);
  }

}
