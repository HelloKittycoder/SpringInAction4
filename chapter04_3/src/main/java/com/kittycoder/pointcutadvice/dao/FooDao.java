package com.kittycoder.pointcutadvice.dao;

import com.kittycoder.pointcutadvice.po.Foo;
import org.springframework.stereotype.Repository;

/**
 * Created by shucheng on 2020/8/7 9:25
 */
@Repository
public class FooDao {

    public String findById(Long id) {
        return "Bazz";
    }

    public Foo create(Long id, String name) {
        return new Foo(id, name);
    }

    public Foo merge(Foo foo) {
        return foo;
    }
}
