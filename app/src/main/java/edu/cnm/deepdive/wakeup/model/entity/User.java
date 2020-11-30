package edu.cnm.deepdive.wakeup.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

/**
 * This entity class holds the data for the database of the users of the WakeUp app.
 */
@SuppressWarnings("NotNullFieldNotInitialized")
@Entity(
    tableName = "user_profile",
    indices = {
        @Index(value = {"oauth_key"}, unique = true)
    }
)
public class User {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "user_id")
  private long userId;

  @NonNull
  @ColumnInfo(name = "oauth_key")
  private String oauthKey;

  /**
   * Returns the auto-generated id for the user.
   */
  public long getUserId() {
    return userId;
  }

  /**
   * Sets the auto-generated id of the user.
   * @param userId  the id of the user.
   */
  public void setUserId(long userId) {
    this.userId = userId;
  }

  /**
   * Returns the oauth 2.0 key for the user.
   */
  @NonNull
  public String getOauthKey() {
    return oauthKey;
  }

  /**
   * Sets the oauth 2.0 key of the user.
   * @param oauthKey  The oauth 2.0 key from the user.
   */
  public void setOauthKey(@NonNull String oauthKey) {
    this.oauthKey = oauthKey;
  }
}
