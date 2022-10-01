package com.kittycoder.dao;

import com.kittycoder.po.Spittle;

import java.util.List;

/**
 * Created by shucheng on 2020/8/2 10:00
 */
public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);
}
