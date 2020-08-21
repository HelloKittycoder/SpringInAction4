package com.kittycoder.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/kittycoder/concert/concert-config2.xml")
public class ConcertXmlConfigTest2 {

    @Autowired
    private Performance performance;

    @Test
    public void test() {
        try {
            performance.perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
