package com.kittycoder.concert;

import com.kittycoder.config.ConcertConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class ConcertConfigTest {

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
