package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Date;

@Entity
public class Todo {

  @PrimaryKey(autoGenerate = true)
  @NonNull
  @ColumnInfo(name = "todoId")
  private int id;

  @ForeignKey(entity = User userId, parentColumns = {}, childColumns = {})
  private Long id;

  @NonNull
  private Date created;

  @NonNull
  private Date calendarDate;


  public Todo() {
  }
}
