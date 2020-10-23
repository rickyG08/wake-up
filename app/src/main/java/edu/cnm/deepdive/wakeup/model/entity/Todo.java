package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Todo {

  @PrimaryKey(autoGenerate = true)
  @NonNull
  @ColumnInfo(name = "todoId")
  private int id;

  @ForeignKey()
  private Long userId;

  private int dateTime;




}
