package com.kittycoder.dao.jpa;

import com.kittycoder.dao.SpitterRepository;
import com.kittycoder.po.Spitter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by shucheng on 2020/7/17 10:11
 */
@Repository
public class JpaSpitterRepository implements SpitterRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addSpitter(Spitter spitter) {
        entityManager.persist(spitter);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        entityManager.merge(spitter);
    }

    @Override
    public Spitter findOne(long id) {
        return entityManager.find(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) entityManager.createQuery("select s from Spitter s where s.username = ?")
                .setParameter(1, username).getSingleResult();
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) entityManager.createQuery("select s from Spitter s").getResultList();
    }

    @Override
    public long count() {
        return findAll().size();
    }
}
