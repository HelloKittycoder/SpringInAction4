package com.kittycoder.environment;

/**
 * Created by shucheng on 2020/6/26 21:12
 */
public class DataSource {

    private String name;

    public DataSource() {
    }

    public DataSource(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DataSource{" +
                "name='" + name + '\'' +
                '}';
    }
}
