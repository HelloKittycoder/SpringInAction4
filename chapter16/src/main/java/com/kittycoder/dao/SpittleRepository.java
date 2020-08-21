package com.kittycoder.dao;

import com.kittycoder.po.Spittle;

import java.util.List;

/**
 * Created by shucheng on 2020/7/2 22:17
 */
public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long id);
}
