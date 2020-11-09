package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity(
    indices = {
        @Index({"task", "task_name", "user_id", "created", "calendar_date"})
    },
    foreignKeys = {
        @ForeignKey(
            entity = User.class,
            parentColumns = "user_id",
            childColumns = "user_id",
            onDelete = ForeignKey.CASCADE
        )
    }

)
public class Todo {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "todo_id")
  private long todoId;

  private boolean task;

  @ColumnInfo(name = "task_name")
  private String taskName;

  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @NonNull
  private Date created = new Date();

  @NonNull
  @ColumnInfo(name = "calendar_date")
  private Date calendarDate;

  public long getTodoId() {
    return todoId;
  }

  public void setTodoId(long todoId) {
    this.todoId = todoId;
  }

  public boolean isTask() {
    return task;
  }

  public void setTask(boolean task) {
    this.task = task;
  }

  public String getTaskName() {
    return taskName;
  }

  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  @NonNull
  public Date getCalendarDate() {
    return calendarDate;
  }

  public void setCalendarDate(@NonNull Date calendarDate) {
    this.calendarDate = calendarDate;
  }
}
