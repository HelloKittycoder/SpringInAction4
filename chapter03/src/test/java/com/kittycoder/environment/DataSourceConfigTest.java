package com.kittycoder.environment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/**
 * Created by shucheng on 2020/6/26 21:22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataSourceConfig.class)
@ActiveProfiles(value = {"dev"})
public class DataSourceConfigTest {

    @Autowired
    private ApplicationContext context;

    @Test
    public void test() {
        try {
            /*DataSource dataSource = context.getBean(DataSource.class);
            System.out.println(dataSource);*/
            Map<String, DataSource> dataSources = context.getBeansOfType(DataSource.class);
            System.out.println(dataSources);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
