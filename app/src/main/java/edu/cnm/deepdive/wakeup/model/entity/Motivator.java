package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity
public class Motivator {

  @PrimaryKey(autoGenerate = true)
  @NonNull
  @ColumnInfo(name = "motivatorId")
  private int motivatorId;

  private String activity;

  @ForeignKey(entity = Class<User>)
  private Long userId;

  public Motivator(String name, Long userId) {
    this.motivatorId = motivatorId;
    this.activity = activity;
    this.userId = userId;
  }

  public int getId() {
    return motivatorId;
  }

  public String getActivity() {
    return activity;
  }

  public void setActivity(String activity) {
    this.activity = activity;
  }


}
