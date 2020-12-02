package edu.cnm.deepdive.wakeup.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.wakeup.model.dao.TodoDao;
import edu.cnm.deepdive.wakeup.model.entity.Motivator;
import edu.cnm.deepdive.wakeup.model.entity.Todo;
import io.reactivex.Completable;
import java.util.List;

/**
 * The CRUD operations and queries on {@link Todo} entity instances.
 */
public class TodoRepository {

  private final Context context;
  private final TodoDao todoDao;

  /**
   * The constructor initializes the context, the app database and the todo dao.
   * @param context The app context.
   */
  public TodoRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    todoDao = database.getTodoDao();
  }

  /**
   * Saves a todo and indicates whether it completed or failed.
   * @param todo The user to be saved.
   * @return A Completable indicating if the todo was saved into the database or not.
   */
  public Completable save(Todo todo) {
    return (todo.getTodoId() == 0)
        ? todoDao.insert(todo).
        doAfterSuccess(todo::setTodoId)
        .ignoreElement()
        : todoDao.update(todo)
            .ignoreElement();
  }

  /**
   * Deletes a todo from the database.
   * @param todo The user to be deleted from the database.
   * @return  A Completable which indicated if the todo was deleted or not.
   */
  public Completable delete(Todo todo) {
    return (todo.getTodoId() == 0) ?
        Completable.complete()
        : todoDao.delete(todo)
            .ignoreElement();
  }

  /**
   * Returns LiveData on a todo by its id.
   * @param id The id of the todo.
   */
  public LiveData<Todo> selectTodo(long id) {
    return todoDao.selectTodo(id);
  }

  /**
   * Returns a List of LiveData of all the tasks by date.
   */
  public LiveData<List<Todo>> getAllTasksByDate() {
    return todoDao.getAllTasksByDate();
  }

  /**
   * Returns a List of LiveData of all the tasks by the task name
   * @param taskName The name of the task.
   */
  public LiveData<List<Todo>> getAll(String taskName) {
    return todoDao.getAll(taskName);
  }

}
