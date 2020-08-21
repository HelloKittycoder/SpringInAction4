package com.kittycoder.ambiguous.m2;

import com.kittycoder.ambiguous.Dessert;
import com.kittycoder.ambiguous.m2.annotation.Cold;
import com.kittycoder.ambiguous.m2.annotation.Creamy;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/6/27 9:52
 */
@Component
@Cold
@Creamy
public class IceCream implements Dessert {
}
