package com.kittycoder.dao.jdbc;

import com.kittycoder.config.DataSourceConfig;
import com.kittycoder.po.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by shucheng on 2020/7/16 13:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
public class JdbcSpitterRepositoryTest {

    @Autowired
    private JdbcSpitterRepository jdbcSpitterRepository;

    @Test
    public void test() {
        System.out.println(jdbcSpitterRepository);
    }

    @Test
    public void addSpitter() {
        jdbcSpitterRepository.addSpitter(new Spitter("zs", "abcde", "zhangsan"));
        System.out.println(jdbcSpitterRepository.findOne(5));
    }

    @Test
    public void addSpitter2() {
        jdbcSpitterRepository.addSpitter(new Spitter("zs", "abcde", "zhangsan"));
        System.out.println(jdbcSpitterRepository.findOne(5));
    }

    @Test
    public void saveSpitter() {
        jdbcSpitterRepository.saveSpitter(new Spitter(1L, "王五", "password", "Craig Walls"));
        System.out.println(jdbcSpitterRepository.findOne(1));
    }

    @Test
    public void findOne() {
        Spitter spitter = jdbcSpitterRepository.findOne(2);
        System.out.println(spitter);
    }

    @Test
    public void findAll() {
        List<Spitter> list = jdbcSpitterRepository.findAll();
        System.out.println(list);
    }
}
