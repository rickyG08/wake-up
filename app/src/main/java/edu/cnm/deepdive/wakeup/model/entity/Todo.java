package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * This entity class holds the data for the database for the todo.
 */
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

  /**
   * Returns the auto-generated id of the todo.
   */
  public long getTodoId() {
    return todoId;
  }

  /**
   * Set the auto-generated id.
   * @param todoId  The id of the todo.
   */
  public void setTodoId(long todoId) {
    this.todoId = todoId;
  }

  /**
   * Returns a boolean of the task.
   */
  public boolean isTask() {
    return task;
  }

  /**
   * Sets the task which is a boolean.
   * @param task  The boolean task
   */
  public void setTask(boolean task) {
    this.task = task;
  }

  /**
   * Returns the name of the task.
   */
  public String getTaskName() {
    return taskName;
  }

  /**
   * Sets the name of the task.
   * @param taskName  The name of the task
   */
  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  /**
   * Returns the user id from the {@link User} entity class.
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Sets the id of the user from the {@link User}.
   * @param userId  The id of the user
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Returns the created Date of the task.
   */
  @NonNull
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the created Date of the task.
   * @param created The Date of the task.
   */
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  /**
   * Returns the calendar Date of the task.
   */
  @NonNull
  public Date getCalendarDate() {
    return calendarDate;
  }

  /**
   * Sets the calendar Date of the task.
   * @param calendarDate  The calendar Date of the task.
   */
  public void setCalendarDate(@NonNull Date calendarDate) {
    this.calendarDate = calendarDate;
  }

}
