package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@SuppressWarnings({"NullableProblems", "NotNullFieldNotInitialized"})
@Entity(
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
  @NonNull
  @ColumnInfo(name = "todo_id")
  private int id;

  @NonNull
  @ColumnInfo(index = true)
  private boolean todo;

  @NonNull
  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  @NonNull
  @ColumnInfo(index = true)
  private Date created;

  @NonNull
  @ColumnInfo(name = "calendar_date", index = true)
  private Date calendarDate;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public boolean isTodo() {
    return todo;
  }

  public void setTodo(boolean todo) {
    this.todo = todo;
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
