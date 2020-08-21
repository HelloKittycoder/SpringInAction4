package com.kittycoder.introducer;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by shucheng on 2020/7/1 17:46
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "com.kittycoder.concert.Performance+",
                    defaultImpl = DefaultEncoreableImpl.class)
    public static Encoreable encoreable;
}
