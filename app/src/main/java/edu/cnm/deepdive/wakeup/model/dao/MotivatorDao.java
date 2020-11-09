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

@Dao
public interface MotivatorDao {

  @Insert
  Single<Long> insert(Motivator motivator);

  @Insert
  Single<List<Long>> insert(Motivator... motivators);

  @Insert
  Single<List<Long>> insert(Collection<Motivator> motivators);

  @Update
  Single<Integer> update(Motivator motivator);

  @Update
  Single<Integer> update(Motivator... motivators);

  @Update
  Single<Integer> update(Collection<Motivator> motivators);

  @Delete
  Single<Integer> delete(Motivator motivator);

  @Delete
  Single<Integer> delete(Motivator... motivators);

  @Delete
  Single<Integer> delete(Collection<Motivator> motivators);

  @Query("SELECT * FROM Motivator WHERE motivator_id = :id")
  LiveData<Motivator> selectMotivator(long id);

  @Query("SELECT * FROM Motivator WHERE motivator = :name")
  LiveData<Motivator> getMotivators(String name);

}
