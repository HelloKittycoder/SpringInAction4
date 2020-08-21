package spittr.data;

import spittr.Spitter;

/**
 * Created by shucheng on 2020/7/3 23:16
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
