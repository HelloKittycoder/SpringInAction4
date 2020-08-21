package com.kittycoder;

import com.kittycoder.jdbc.JdbcSpitter;
import com.kittycoder.po.Spitter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by shucheng on 2020/7/16 11:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = com.kittycoder.config.DataSourceConfig.class)
public class JdbcSpitterTest {

    @Resource
    private DataSource embedDataSource;
    @Autowired
    private JdbcSpitter jdbcSpitter;

    @Test
    public void shouldAnswerWithTrue() {
        try (
                Connection connection = embedDataSource.getConnection();
        ) {
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insert() {
        jdbcSpitter.addSpitter(new Spitter("zs", "abcde", "zhangsan"));
        System.out.println(jdbcSpitter.findOne(5));
    }

    @Test
    public void save() {
        jdbcSpitter.saveSpitter(new Spitter(1L, "王五", "password", "Craig Walls"));
        System.out.println(jdbcSpitter.findOne(1));
    }

    @Test
    public void findOne() {
        Spitter spitter = jdbcSpitter.findOne(1);
        System.out.println(spitter);
    }
}
