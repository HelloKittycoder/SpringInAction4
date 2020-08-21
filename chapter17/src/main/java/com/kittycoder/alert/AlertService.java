package com.kittycoder.alert;

import com.kittycoder.domain.Spittle;

/**
 * Created by shucheng on 2020/7/27 16:00
 */
public interface AlertService {

    void sendSpittleAlert(Spittle spittle);

    Spittle retrieveSpittleAlert();
}
