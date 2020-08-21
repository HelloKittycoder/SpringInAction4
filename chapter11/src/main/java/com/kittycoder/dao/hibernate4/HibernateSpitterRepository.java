package com.kittycoder.dao.hibernate4;

import com.kittycoder.dao.SpitterRepository;
import com.kittycoder.po.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by shucheng on 2020/7/16 22:52
 */
@Repository
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().save(spitter);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        // https://blog.csdn.net/u014038534/article/details/50595627
        // update：要求在已有的spitter（session.load出来的）上修改
        // currentSession().update(spitter);
        // merge：不要求在已有的spitter上修改
        currentSession().merge(spitter);
    }

    // 疑问：id为什么是Serializable的
    @Override
    public Spitter findOne(long id) {
        return (Spitter) currentSession().get(Spitter.class, id);
    }

    @Override
    public Spitter findByUsername(String username) {
        return (Spitter) currentSession()
                .createCriteria(Spitter.class)
                .add(Restrictions.eq("username", username))
                .list().get(0);
    }

    @Override
    public List<Spitter> findAll() {
        return (List<Spitter>) currentSession()
                .createCriteria(Spitter.class).list();
    }

    @Override
    public long count() {
        return findAll().size();
    }
}
