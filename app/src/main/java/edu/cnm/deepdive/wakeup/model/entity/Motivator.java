package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * The entity class that holds the data for the database of the motivators.
 */
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

  /**
   * Returns the id of the motivator which is auto-generated.
   */
  public long getMotivatorId() {
    return motivatorId;
  }

  /**
   * Sets the id of the motivator which is auto-generated.
   * @param motivatorId The id of the motivator.
   */
  public void setMotivatorId(long motivatorId) {
    this.motivatorId = motivatorId;
  }

  /**
   * Returns the name of the activity.
   */
  @NonNull
  public String getActivity() {
    return activity;
  }

  /**
   * Sets the name of the specified {@code activity}.
   */
  public void setActivity(@NonNull String activity) {
    this.activity = activity;
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
   * Returns the motivator name.
   */
  @NonNull
  public String getMotivator() {
    return motivator;
  }

  /**
   * Sets the motivator.
   * @param motivator The motivator
   */
  public void setMotivator(@NonNull String motivator) {
    this.motivator = motivator;
  }

}
