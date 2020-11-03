package edu.cnm.deepdive.wakeup.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import edu.cnm.deepdive.wakeup.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface UserDao {

  @Insert
  Single<Long> insert(User user);

  @Insert
  Single<List<Long>> insert(User... users);

  @Insert
  Single<List<Long>> insert(Collection<User> users);
}
