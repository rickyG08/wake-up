package edu.cnm.deepdive.wakeup.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.wakeup.model.entity.User;
import io.reactivex.Single;

/**
 * The interface which provides the data access objects of the {@link User}.
 */
@Dao
public interface UserDao {

  /**
   * Inserts a single user into the databse.
   * @param user  The user being inserted.
   * @return  A Single holding the inserted user.
   */
  @Insert
  Single<Long> insert(User user);

  /**
   * Updates a single user into the databse.
   * @param user  The user being updated.
   * @return  A Single holding the updated user.
   */
  @Update
  Single<Integer> update(User user);

  /**
   * Deletes users from the database.
   * @param users The users to be deleted.
   * @return A Single holding the deleted users.
   */
  @Delete
  Single<Integer> delete(User... users);

  /**
   * A query which returns a user by their user id.
   * @param userId  The id of the user being queried.
   * @return  The id of the user.
   */
  @Query("SELECT * FROM user_profile WHERE user_id = :userId")
  LiveData<User> getById(long userId);

  /**
   * A query which returns the users oauth key.
   * @param oauthKey  The oauth key from the user.
   * @return  A single users oauth key.
   */
  @Query("SELECT * FROM user_profile WHERE oauth_key = :oauthKey")
  Single<User> getUserByOauthKey(String oauthKey);

}
