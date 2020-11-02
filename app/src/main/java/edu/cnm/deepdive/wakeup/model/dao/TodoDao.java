package edu.cnm.deepdive.wakeup.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Update;
import edu.cnm.deepdive.wakeup.model.entity.Todo;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface TodoDao {

  @Insert
  Single<Long> insert(Todo todo);

  @Insert
  Single<List<Long>> insert(Todo... todos);

  @Insert
  Single<List<Long>> insert(Collection<Todo> todos);

  @Update
  Single<Boolean> update(Todo todo);

  @Update
  Single<List<Boolean>> update(Todo... todos);

  @Update
  Single<List<Boolean>> update(Collection<Todo> todos);
}
