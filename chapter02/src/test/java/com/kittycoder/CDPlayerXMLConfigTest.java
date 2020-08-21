package com.kittycoder;

import com.kittycoder.soundsystem.CompactDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by shucheng on 2020/6/25 20:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:META-INF/spring/soundsystem.xml")
public class CDPlayerXMLConfigTest {

    @Autowired
    private CompactDisc cd;

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void cdShouldNotBeNull() {
        assertNotNull(cd);
        String[] beanNamesForType = ctx.getBeanNamesForType(CompactDisc.class);
        System.out.println(beanNamesForType);
    }
}
