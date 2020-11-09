package edu.cnm.deepdive.wakeup.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
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

  @Delete
  Single<Integer> delete(Todo todo);

 @Delete
 Single<Integer> delete(Todo... todos);

 @Delete
 Single<Integer> delete(Collection<Todo> todos);

  @Update
  Single<Integer> update(Todo todo);

  @Update
  Single<Integer> update(Todo... todos);

  @Update
  Single<Integer> update(Collection<Todo> todos);

  @Query("SELECT * FROM Todo WHERE todo_id = :id")
  LiveData<Todo> selectTodo(long id);
}
