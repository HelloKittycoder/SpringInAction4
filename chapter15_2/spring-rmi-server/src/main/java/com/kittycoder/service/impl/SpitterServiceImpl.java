package com.kittycoder.service.impl;

import com.kittycoder.service.SpitterService;
import org.springframework.stereotype.Service;

/**
 * Created by shucheng on 2020/7/22 13:32
 */
@Service
public class SpitterServiceImpl implements SpitterService {
    @Override
    public String sayHello() {
        System.out.println("调用SpitterServiceIml#sayHello");
        return "Hello World";
    }
}
