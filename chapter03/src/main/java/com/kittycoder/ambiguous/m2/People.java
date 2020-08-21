package com.kittycoder.ambiguous.m2;

import com.kittycoder.ambiguous.Dessert;
import com.kittycoder.ambiguous.m2.annotation.Cold;
import com.kittycoder.ambiguous.m2.annotation.Fruity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/6/27 9:57
 */
@Component
public class People {

    private Dessert dessert;

    @Autowired
    @Cold
    // @Creamy
    @Fruity
    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }
}
