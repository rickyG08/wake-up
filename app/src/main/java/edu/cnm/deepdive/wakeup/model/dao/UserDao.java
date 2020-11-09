package edu.cnm.deepdive.wakeup.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.wakeup.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface UserDao {

  @Insert
  Single<Long> insert(User user);

  @Update
  Single<Integer> update(User user);

  @Delete
  Single<Integer> delete(User... users);

  @Query("SELECT * FROM User WHERE user_id = :userId")
  LiveData<User> selectById(long userId);
}
