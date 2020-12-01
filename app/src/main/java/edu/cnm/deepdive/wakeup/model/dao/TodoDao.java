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

/**
 *
 */
@Dao
public interface TodoDao {

  /**
   *
   * @param todo
   * @return
   */
  @Insert
  Single<Long> insert(Todo todo);

  /**
   *
   * @param todos
   * @return
   */
  @Insert
  Single<List<Long>> insert(Todo... todos);

  /**
   *
   * @param todos
   * @return
   */
  @Insert
  Single<List<Long>> insert(Collection<Todo> todos);

  /**
   *
   * @param todo
   * @return
   */
  @Delete
  Single<Integer> delete(Todo todo);

  /**
   *
   * @param todos
   * @return
   */
  @Delete
  Single<Integer> delete(Todo... todos);

  /**
   * Deletes multiple todos from the database.
   * @param todos
   * @return
   */
  @Delete
  Single<Integer> delete(Collection<Todo> todos);

  /**
   * Updates a singe todo in the database.
   * @param todo  The todo to be updated.
   * @return  A Single that holds the updated todo.
   */
  @Update
  Single<Integer> update(Todo todo);

  /**
   * Updates multiple todos in the database.
   * @param todos The todos to be updated.
   * @return A Single that holds the updated todos.
   */
  @Update
  Single<Integer> update(Todo... todos);

  /**
   * Updates multiple todos in the database.
   * @param todos The todos to be updated.
   * @return A Single that holds the updated todos.
   */
  @Update
  Single<Integer> update(Collection<Todo> todos);

  /**
   * A query that returns a todo from its id.
   * @param id  The id of the todo.
   */
  @Query("SELECT * FROM Todo WHERE todo_id = :id")
  LiveData<Todo> selectTodo(long id);

  /**
   * A query the returns a list of all the tasks by descending date
   * @return    A list of tasks by the date descending.
   */
  @Query("SELECT * FROM Todo WHERE task ORDER BY calendar_date DESC")
  LiveData<List<Todo>> getAllTasksByDate();

  /**
   * A query that gets a list of all tasks by their names.
   * @param taskName    The name of a task
   * @return    A list of all tasks by the task name.
   */
  @Query("SELECT * FROM Todo WHERE task_name = :taskName")
  LiveData<List<Todo>> getAll(String taskName);

}
