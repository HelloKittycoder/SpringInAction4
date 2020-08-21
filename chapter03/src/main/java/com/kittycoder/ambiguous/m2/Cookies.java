package com.kittycoder.ambiguous.m2;

import com.kittycoder.ambiguous.Dessert;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by shucheng on 2020/6/27 9:51
 */
@Component
@Qualifier("crispy")
public class Cookies implements Dessert {
}
