package edu.cnm.deepdive.wakeup.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.wakeup.model.entity.Motivator;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 *
 */
@Dao
public interface MotivatorDao {

  /**
   * Add a single movitator
   * @param motivator
   * @return
   */
  @Insert
  Single<Long> insert(Motivator motivator);

  /**
   *
   * @param motivators
   * @return
   */
  @Insert
  Single<List<Long>> insert(Motivator... motivators);

  /**
   *
   * @param motivators
   * @return
   */
  @Insert
  Single<List<Long>> insert(Collection<Motivator> motivators);

  /**
   *
   * @param motivator
   * @return
   */
  @Update
  Single<Integer> update(Motivator motivator);

  /**
   *
   * @param motivators
   * @return
   */
  @Update
  Single<Integer> update(Motivator... motivators);

  /**
   *
   * @param motivators
   * @return
   */
  @Update
  Single<Integer> update(Collection<Motivator> motivators);

  /**
   *
   * @param motivator
   * @return
   */
  @Delete
  Single<Integer> delete(Motivator motivator);

  /**
   *
   * @param motivators
   * @return
   */
  @Delete
  Single<Integer> delete(Motivator... motivators);

  /**
   *
   * @param motivators
   * @return
   */
  @Delete
  Single<Integer> delete(Collection<Motivator> motivators);

  /**
   * Queries a motivator by its id.
   * @param id    the motivator id.
   * @return    a single motivator id.
   */
  @Query("SELECT * FROM Motivator WHERE motivator_id = :id")
  LiveData<Motivator> selectMotivator(long id);

  /**
   * Queries a list of activities by the name..
   * @param name    The name of the activity.
   * @return    A list of activities.
   */
  @Query("SELECT * FROM Motivator WHERE activity = :name")
  LiveData<List<Motivator>> getMotivators(String name);

}
