package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Date;

/**
 * This is the {@code }
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
   * Returns the the todo id.
   */
  public long getTodoId() {
    return todoId;
  }

  /**
   * Set the
   * @param todoId
   */
  public void setTodoId(long todoId) {
    this.todoId = todoId;
  }

  /**
   *
   * @return
   */
  public boolean isTask() {
    return task;
  }

  /**
   *
   * @param task
   */
  public void setTask(boolean task) {
    this.task = task;
  }

  /**
   *
   * @return
   */
  public String getTaskName() {
    return taskName;
  }

  /**
   *
   * @param taskName
   */
  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  /**
   *
   * @return
   */
  public long getUserId() {
    return userId;
  }

  /**
   *
   * @param userId
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  @NonNull
  public Date getCreated() {
    return created;
  }

  /**
   *
   * @param created
   */
  public void setCreated(@NonNull Date created) {
    this.created = created;
  }

  /**
   *
   * @return
   */
  @NonNull
  public Date getCalendarDate() {
    return calendarDate;
  }

  /**
   *
   * @param calendarDate
   */
  public void setCalendarDate(@NonNull Date calendarDate) {
    this.calendarDate = calendarDate;
  }

}
