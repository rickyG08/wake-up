package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Motivator {

  @PrimaryKey(autoGenerate = true)
  @NonNull
  @ColumnInfo(name = "motivatorId")
  private int id;

  private String activity;

  private int userId;

  public Motivator(String name, int userId) {
    this.id = id;
    this.activity = activity;
    this.userId = userId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

}
