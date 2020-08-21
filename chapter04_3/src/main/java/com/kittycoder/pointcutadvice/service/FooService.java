package com.kittycoder.pointcutadvice.service;

import com.kittycoder.pointcutadvice.po.Foo;

import java.util.List;

/**
 * Created by shucheng on 2020/8/7 9:31
 */
public interface FooService {

    List<Foo> queryFooList();

    Foo queryFooById(Long id);
}
