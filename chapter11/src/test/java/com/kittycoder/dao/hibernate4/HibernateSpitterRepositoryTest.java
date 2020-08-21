package com.kittycoder.dao.hibernate4;

import com.kittycoder.RepositoryTestConfig;
import com.kittycoder.dao.SpitterRepository;
import com.kittycoder.po.Spitter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by shucheng on 2020/7/16 23:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryTestConfig.class)
public class HibernateSpitterRepositoryTest {

    @Autowired
    // @Qualifier("hibernateSpitterRepository")
    private SpitterRepository spitterRepository;

    @Test
    @Transactional
    public void addSpitter() {
        assertEquals(4, spitterRepository.count());
        Spitter spitter = new Spitter(null, "newbee", "letmein", "New Bee",
                "newbee@habuma.com", true);
        spitterRepository.addSpitter(spitter);
        assertEquals(5, spitterRepository.count());
        assertSpitter(4, spitter);
        assertSpitter(4, spitterRepository.findOne(5L));
    }

    @Test
    @Transactional
    public void saveSpitter() {
        assertEquals(4, spitterRepository.count());
        Spitter spitter = new Spitter(4L, "arthur", "letmein", "Arthur Names",
                "arthur@habuma.com", false);
        spitterRepository.saveSpitter(spitter);
        assertEquals(4, spitterRepository.count());
        assertSpitter(5, spitter);
        List<Spitter> list = spitterRepository.findAll();
        System.out.println(list);
    }

    // 说明：做查询时：要加上@Transactional注解，不然会报错“org.hibernate.HibernateException: Could not obtain transaction-synchronized Session for current thre”
    @Test
    @Transactional
    public void findOne() {
        assertSpitter(0, spitterRepository.findOne(1L));
        assertSpitter(1, spitterRepository.findOne(2L));
        assertSpitter(2, spitterRepository.findOne(3L));
        assertSpitter(3, spitterRepository.findOne(4L));
    }

    @Test
    @Transactional
    public void findByUsername() {
        assertSpitter(0, spitterRepository.findByUsername("habuma"));
        assertSpitter(1, spitterRepository.findByUsername("mwalls"));
        assertSpitter(2, spitterRepository.findByUsername("chuck"));
        assertSpitter(3, spitterRepository.findByUsername("artnames"));
    }

    @Test
    @Transactional
    public void findAll() {
        List<Spitter> spitters = spitterRepository.findAll();
        assertEquals(4, spitters.size());
        assertSpitter(0, spitters.get(0));
        assertSpitter(1, spitters.get(1));
        assertSpitter(2, spitters.get(2));
        assertSpitter(3, spitters.get(3));
    }

    @Test
    @Transactional
    public void count() {
        assertEquals(4, spitterRepository.count());
    }

    private static void assertSpitter(int expectedSpitterIndex, Spitter actual) {
        Spitter expected = SPITTERS[expectedSpitterIndex];
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected.getUsername(), actual.getUsername());
        assertEquals(expected.getPassword(), actual.getPassword());
        assertEquals(expected.getFullName(), actual.getFullName());
        assertEquals(expected.getEmail(), actual.getEmail());
        assertEquals(expected.isUpdateByEmail(), actual.isUpdateByEmail());
    }

    private static Spitter[] SPITTERS = new Spitter[6];

    @BeforeClass
    public static void before() {
        SPITTERS[0] = new Spitter(1L, "habuma", "password", "Craig Walls",
                "craig@habuma.com", false);
        SPITTERS[1] = new Spitter(2L, "mwalls", "password", "Michael Walls",
                "mwalls@habuma.com", true);
        SPITTERS[2] = new Spitter(3L, "chuck", "password", "Chuck Wagon",
                "chuck@habuma.com", false);
        SPITTERS[3] = new Spitter(4L, "artnames", "password", "Art Names",
                "art@habuma.com", true);
        SPITTERS[4] = new Spitter(5L, "newbee", "letmein", "New Bee",
                "newbee@habuma.com", true);
        SPITTERS[5] = new Spitter(4L, "arthur", "letmein", "Arthur Names",
                "arthur@habuma.com", false);
    }
}
