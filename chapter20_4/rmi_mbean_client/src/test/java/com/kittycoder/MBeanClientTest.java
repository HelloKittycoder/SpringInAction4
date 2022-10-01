package com.kittycoder;

import com.kittycoder.config.MBeanClientConfig;
import com.kittycoder.config.SpittleControllerManagedOperations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.management.*;
import java.util.Set;

/**
 * @author shucheng
 * @date 2022/10/1 16:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MBeanClientConfig.class)
public class MBeanClientTest {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private MBeanServerConnection mBeanServerConnection;

    @Test
    public void test() throws Exception {
        // 获取远程MBean服务器上有多少已注册的MBean
        int mBeanCount = mBeanServerConnection.getMBeanCount();
        logger.info("There are {} MBeans", mBeanCount);

        // 查询远程MBean服务器中所有MBean的名称
        Set<ObjectName> mbeanNames = mBeanServerConnection.queryNames(null, null);
        logger.info("all MBean names: {}", mbeanNames);

        // 注意：下面获取和设置MBean属性的值时，MBean服务器上会把属性的首字母改成大写，这里如果用原始的首字母小写的属性名，会直接报错，根本取不到值
        // 获取MBean属性的值
        int spittersPerPage = (int) mBeanServerConnection.getAttribute(new ObjectName("spitter:name=SpittleController"),
                "SpittersPerPage");
        logger.info("spittersPerPage的值为：{}", spittersPerPage);

        // 设置MBean属性的值
        mBeanServerConnection.setAttribute(new ObjectName("spitter:name=SpittleController"),
                new Attribute("SpittersPerPage", 10));

        // 直接调用MBean中的方法
        mBeanServerConnection.invoke(new ObjectName("spitter:name=SpittleController"), "setSpittersPerPage",
                new Object[]{100}, new String[]{"int"});
    }
}
