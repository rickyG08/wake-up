package edu.cnm.deepdive.wakeup.model.dao;

import androidx.room.Dao;
import androidx.room.Insert;
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


}
