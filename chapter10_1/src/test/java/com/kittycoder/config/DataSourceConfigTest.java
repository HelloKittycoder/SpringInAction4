package com.kittycoder.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(classes = com.kittycoder.config.DataSourceConfig.class)
@ContextConfiguration(locations = {"classpath:com/kittycoder/config/datasource-config.xml"})
public class DataSourceConfigTest {
    @Resource
    private DataSource poolDataSource;
    @Resource
    private DataSource jdbcDataSource;
    @Resource
    private DataSource embedDataSource;

    @Test
    public void shouldAnswerWithTrue() {
        try (
             Connection connection = poolDataSource.getConnection();
             Connection connection2 = jdbcDataSource.getConnection();
             Connection connection3 = embedDataSource.getConnection();
             ) {
            System.out.println(connection);
            System.out.println(connection2);
            System.out.println(connection3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
    }
}
