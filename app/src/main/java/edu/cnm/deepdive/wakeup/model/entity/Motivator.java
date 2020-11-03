package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@SuppressWarnings("ALL")
@Entity(
    indices = {
      @Index(value = {"activity"}, unique = true)
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
public class Motivator {

  @SuppressWarnings("NullableProblems")
  @PrimaryKey(autoGenerate = true)
  @NonNull
  @ColumnInfo(name = "motivator_id")
  private int id;

  @NonNull
  @ColumnInfo
  private String activity;

  @NonNull
  @ColumnInfo(name = "user_id", index = true)
  private long userId;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @NonNull
  public String getActivity() {
    return activity;
  }

  public void setActivity(@NonNull String activity) {
    this.activity = activity;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

}
