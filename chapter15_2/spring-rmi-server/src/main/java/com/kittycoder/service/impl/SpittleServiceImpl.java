package com.kittycoder.service.impl;

import com.kittycoder.service.SpittleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shucheng on 2020/7/23 8:13
 */
@Service
public class SpittleServiceImpl implements SpittleService {
    @Override
    public List<String> getAllSpittles() {
        System.out.println("调用SpittleServiceImpl#getAllSpittles");
        List<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        return list;
    }
}
