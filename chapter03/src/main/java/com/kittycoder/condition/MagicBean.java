package com.kittycoder.condition;

/**
 * Created by shucheng on 2020/6/26 22:24
 */
public class MagicBean {

    private String name;

    public MagicBean(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MagicBean{" +
                "name='" + name + '\'' +
                '}';
    }
}
