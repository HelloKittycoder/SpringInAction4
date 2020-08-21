package com.kittycoder.email;

import com.kittycoder.config.MailConfig;
import com.kittycoder.po.Spitter;
import com.kittycoder.po.Spittle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.MessagingException;
import java.util.Date;

/**
 * Created by shucheng on 2020/7/30 11:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MailConfig.class)
public class SpitterMailServiceImplTest {

    @Autowired
    private SpitterMailService spitterMailService;

    @Test
    public void sendSimpleSpittleEmail() throws MessagingException {
        Spitter spitter = new Spitter(1L, "habuma", null, "coffie", "recipients_email_address", true);
        Spittle spittle = new Spittle(1L, spitter, "Hiya!", new Date());

        spitterMailService.sendSimpleSpittleEmail(spitter.getEmail(), spittle);
        spitterMailService.sendSpittleEmailWithAttachment(spitter.getEmail(), spittle);
        spitterMailService.sendRichSpittleEmail(spitter.getEmail(), spittle);
    }
}
