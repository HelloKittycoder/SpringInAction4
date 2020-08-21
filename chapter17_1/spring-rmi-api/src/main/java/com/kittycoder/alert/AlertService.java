package com.kittycoder.alert;

import com.kittycoder.po.User;

/**
 * Created by shucheng on 2020/7/27 22:45
 */
public interface AlertService {

    String sendStr(String str);

    void printStr(String str);

    User findById(int id);
}
