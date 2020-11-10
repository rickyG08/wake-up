package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@SuppressWarnings("NotNullFieldNotInitialized")
@Entity(
    indices = {
        @Index(value = {"activity"}, unique = true),
        @Index({"user_id", "motivator"})
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

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "motivator_id")
  private long motivatorId;

  @NonNull
  @ColumnInfo
  private String activity;

  @ColumnInfo(name = "user_id")
  private long userId;

  @NonNull
  private String motivator;

  public long getMotivatorId() {
    return motivatorId;
  }

  public void setMotivatorId(long motivatorId) {
    this.motivatorId = motivatorId;
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

  @NonNull
  public String getMotivator() {
    return motivator;
  }

  public void setMotivator(@NonNull String motivator) {
    this.motivator = motivator;
  }

}
