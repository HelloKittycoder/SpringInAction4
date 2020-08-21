package com.kittycoder.pointcutadvice.po;

/**
 * Created by shucheng on 2020/8/7 9:29
 */
public class Foo {
    private Long id;
    private String name;

    public Foo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
