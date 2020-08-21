package com.kittycoder.dao.impl;

import com.kittycoder.dao.SpittleRepository;
import com.kittycoder.po.Spittle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by shucheng on 2020/7/25 21:31
 */
@Repository
public class SpittleRepositoryImpl implements SpittleRepository {
    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    @Override
    public Spittle findOne(long id) {
        Spittle spittle = new Spittle(id, "Hello", new Date(), null, null);
        return spittle;
    }
}
