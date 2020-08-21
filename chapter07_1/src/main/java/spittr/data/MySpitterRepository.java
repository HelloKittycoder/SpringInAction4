package spittr.data;

import org.springframework.stereotype.Repository;
import spittr.Spitter;

/**
 * Created by shucheng on 2020/7/4 20:56
 */
@Repository
public class MySpitterRepository implements SpitterRepository {
    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }
}
