package com.kittycoder.pointcutadvice.service.impl;

import com.kittycoder.pointcutadvice.po.Foo;
import com.kittycoder.pointcutadvice.service.FooService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shucheng on 2020/8/7 9:32
 */
@Service
public class FooServiceImpl implements FooService {
    @Override
    public List<Foo> queryFooList() {
        List<Foo> list = new ArrayList<>();
        list.add(new Foo(1L, "张三"));
        list.add(new Foo(2L, "李四"));
        return list;
    }

    @Override
    public Foo queryFooById(Long id) {
        return new Foo(3L, "王五");
    }
}
