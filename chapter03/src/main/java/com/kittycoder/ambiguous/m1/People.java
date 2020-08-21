package com.kittycoder.ambiguous.m1;

import com.kittycoder.ambiguous.Dessert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/6/27 9:57
 */
@Component
public class People {

    private Dessert dessert;

    @Autowired
    @Qualifier("cookies")
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
