package com.kittycoder.dao;

import com.kittycoder.po.Spitter;

import java.util.List;

/**
 * Created by shucheng on 2020/7/16 12:51
 */
public interface SpitterRepository {

    // 新增
    void addSpitter(Spitter spitter);
    void addSpitter2(Spitter spitter);

    // 修改
    void saveSpitter(Spitter spitter);

    // 查询单个
    Spitter findOne(long id);

    // 查询所有
    List<Spitter> findAll();
}
