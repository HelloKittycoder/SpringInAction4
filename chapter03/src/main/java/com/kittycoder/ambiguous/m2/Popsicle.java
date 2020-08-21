package com.kittycoder.ambiguous.m2;

import com.kittycoder.ambiguous.Dessert;
import com.kittycoder.ambiguous.m2.annotation.Cold;
import com.kittycoder.ambiguous.m2.annotation.Fruity;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/6/27 12:18
 */
@Component
@Cold
@Fruity
public class Popsicle implements Dessert {
}
