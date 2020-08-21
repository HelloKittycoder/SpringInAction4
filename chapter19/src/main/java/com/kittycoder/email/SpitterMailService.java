package com.kittycoder.email;

import com.kittycoder.po.Spittle;

import javax.mail.MessagingException;

/**
 * Created by shucheng on 2020/7/30 10:14
 */
public interface SpitterMailService {

    void sendSimpleSpittleEmail(String to, Spittle spittle);
    void sendSpittleEmailWithAttachment(String to, Spittle spittle) throws MessagingException;
    void sendRichSpittleEmail(String to, Spittle spittle) throws MessagingException;
}
