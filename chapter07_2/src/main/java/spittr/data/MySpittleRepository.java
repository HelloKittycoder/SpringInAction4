package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spittle;

import java.util.List;

/**
 * Created by shucheng on 2020/7/4 20:56
 */
@Repository
public class MySpittleRepository implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    @Override
    public Spittle findOne(long id) {
        return null;
    }
}
