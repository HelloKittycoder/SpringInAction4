package com.kittycoder.dao;

import com.kittycoder.po.Spitter;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by shucheng on 2020/7/16 12:51
 */
public interface SpitterRepository extends JpaRepository<Spitter, Long> {
}
