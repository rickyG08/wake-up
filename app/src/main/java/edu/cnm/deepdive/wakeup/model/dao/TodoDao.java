package edu.cnm.deepdive.wakeup.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.wakeup.model.entity.Todo;
import edu.cnm.deepdive.wakeup.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 *   The interface which provides the data access objects of the {@link Todo}.
 */
@Dao
public interface TodoDao {

  /**
   * Inserts a single todo into the database.
   * @param todo  The todo to be inserted.
   * @return  A Single of the todo that was inserted.
   */
  @Insert
  Single<Long> insert(Todo todo);

  /**
   * Inserts multiple todos into the database.
   * @param todos The todos to be inserted.
   * @return  A Single holding a list of todos that were inserted.
   */
  @Insert
  Single<List<Long>> insert(Todo... todos);

  /**
   * Inserts multiple todos into the database.
   * @param todos The todos to be inserted.
   * @return  A Single holding a list of todos that were inserted.
   */
  @Insert
  Single<List<Long>> insert(Collection<Todo> todos);

  /**
   * Deletes a single todo from the database.
   * @param todo  The todo to be deleted.
   * @return  A Single which holds the todo that was deleted.
   */
  @Delete
  Single<Integer> delete(Todo todo);

  /**
   * Deletes multiple todos from the database.
   * @param todos The collection of todos to be deleted.
   * @return  A Single that holds the deleted todos.
   */
  @Delete
  Single<Integer> delete(Todo... todos);

  /**
   * Deletes multiple todos from the database.
   * @param todos The collection of todos to be deleted.
   * @return  A Single that holds the deleted collection of todos.
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
   * @return A Single that holds a collection of the updated todos.
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
