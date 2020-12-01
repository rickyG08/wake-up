package edu.cnm.deepdive.wakeup.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.wakeup.model.entity.Motivator;
import edu.cnm.deepdive.wakeup.model.entity.User;
import io.reactivex.Single;
import java.util.Collection;
import java.util.List;

/**
 * The interface which provides the data access objects of the {@link Motivator}.
 */
@Dao
public interface MotivatorDao {

  /**
   * Inserts a single motivator into the database.
   * @param motivator The motivator to be inserted.
   * @return  A single of the motivator that was inserted.
   */
  @Insert
  Single<Long> insert(Motivator motivator);

  /**
   * Inserts multiple motivators to the database.
   * @param motivators  The motivators to be inserted.
   * @return  A Single holding a list of motivators that were inserted.   */
  @Insert
  Single<List<Long>> insert(Motivator... motivators);

  /**
   * Inserts multiple motivators to the database.
   * @param motivators  The motivators to be inserted.
   * @return  A Single holding a list of motivators that were inserted.
   */
  @Insert
  Single<List<Long>> insert(Collection<Motivator> motivators);

  /**
   * Updates a single motivator to the database.
   * @param motivator The motivator to be updated.
   * @return  A single that holds the updated motivator.
   */
  @Update
  Single<Integer> update(Motivator motivator);

  /**
   * Updates multiple motivators in the database.
   * @param motivators  The motivators to be updated.
   * @return  A Single that holds the updated motivators.
   */
  @Update
  Single<Integer> update(Motivator... motivators);

  /**
   * Updates multiple motivators in the database.
   * @param motivators  The motivators to be updated.
   * @return  A Single that holds the collection of motivators updated.
   */
  @Update
  Single<Integer> update(Collection<Motivator> motivators);

  /**
   * Deletes a single motivator from the database.
   * @param motivator The motivator to be deleted.
   * @return  A Single that holds the deleted motivator.
   */
  @Delete
  Single<Integer> delete(Motivator motivator);

  /**
   * Deletes multiple motivators from the database.
   * @param motivators  The motivators to be deleted.
   * @return  A Single that holds the deleted motivators.
   */
  @Delete
  Single<Integer> delete(Motivator... motivators);

  /**
   * Deletes multiple motivators from the database.
   * @param motivators  The collection of motivators to be deleted.
   * @return  A Single that holds the deleted collection of motivators.
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
