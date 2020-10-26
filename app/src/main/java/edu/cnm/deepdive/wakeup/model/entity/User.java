package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

  @PrimaryKey
  @NonNull
  @ColumnInfo(name = "userId")
  private Long id;

  public User(String name, Long userId) {
   this.id = id;
  }

  @NonNull
  public Long getId() {
    return id;
  }

}
