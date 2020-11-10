package edu.cnm.deepdive.wakeup.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.wakeup.model.dao.TodoDao;
import edu.cnm.deepdive.wakeup.model.entity.Todo;
import io.reactivex.Completable;
import java.util.List;

public class TodoRepository {

  private final Context context;
  private final TodoDao todoDao;


  public TodoRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    todoDao = database.getTodoDao();
  }

  public Completable save(Todo todo) {
    return (todo.getTodoId() == 0)
        ? todoDao.insert(todo).
        doAfterSuccess(todo::setTodoId)
        .ignoreElement()
        : todoDao.update(todo)
            .ignoreElement();
  }

  public Completable delete(Todo todo) {
    return (todo.getTodoId() == 0) ?
        Completable.complete()
        : todoDao.delete(todo)
            .ignoreElement();
  }

  public LiveData<Todo> selectTodo(long id) {
    return todoDao.selectTodo(id);
  }

  public LiveData<List<Todo>> getAllTasksByDate() {
    return todoDao.getAllTasksByDate();
  }

  public LiveData<List<Todo>> getAll(String taskName) {
    return todoDao.getAll(taskName);
  }

}
