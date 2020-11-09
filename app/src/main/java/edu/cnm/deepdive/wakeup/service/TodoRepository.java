package edu.cnm.deepdive.wakeup.service;

import android.content.Context;
import edu.cnm.deepdive.wakeup.model.dao.TodoDao;

public class TodoRepository {

  private final Context context;
  private final TodoDao todoDao;


  public TodoRepository(Context context) {
    this.context = context;
    WakeUpDatabase database = WakeUpDatabase.getInstance();
    todoDao = database.getTodoDao();
  }
}
