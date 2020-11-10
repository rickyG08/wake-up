package edu.cnm.deepdive.wakeup.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.wakeup.model.entity.User;
import io.reactivex.Single;

@Dao
public interface UserDao {

  @Insert
  Single<Long> insert(User user);

  @Update
  Single<Integer> update(User user);

  @Delete
  Single<Integer> delete(User... users);

  @Query("SELECT * FROM user_profile WHERE user_id = :userId")
  LiveData<User> getById(long userId);

  @Query("SELECT * FROM user_profile WHERE oauth_key = :oauthKey")
  Single<User> getUserByOauthKey(String oauthKey);

}
