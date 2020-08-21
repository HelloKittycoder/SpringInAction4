package com.kittycoder.alert;

import com.kittycoder.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by shucheng on 2020/7/27 22:46
 */
public class AlertServiceImpl implements AlertService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public String sendStr(String str) {
        logger.info("============收到的信息============" + str);
        return "来自服务端的返回信息，我接收到数据了...";
    }

    @Override
    public void printStr(String str) {
        logger.info("============收到的信息============" + str);
    }

    @Override
    public User findById(int id) {
        return new User(1, "张三");
    }
}
