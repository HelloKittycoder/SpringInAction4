package spittr.db;

import org.springframework.data.jpa.repository.JpaRepository;
import spittr.domain.Spitter;

/**
 * Created by shucheng on 2020/7/16 12:51
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long> {
}
