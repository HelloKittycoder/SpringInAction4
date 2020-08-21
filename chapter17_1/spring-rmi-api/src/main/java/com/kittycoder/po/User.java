package com.kittycoder.po;

import java.io.Serializable;

/**
 * Created by shucheng on 2020/7/27 22:45
 */
public class User implements Serializable {

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
