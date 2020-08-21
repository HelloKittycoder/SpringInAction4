package com.kittycoder.po;

import java.util.Date;

/**
 * Created by shucheng on 2020/7/30 10:10
 */
public class Spittle {
    // 编号
    private final Long id;
    // 邮件的内容
    private final String text;
    // 发送的时间
    private final Date postedTime;
    // 邮件信息的对象
    private Spitter spitter;

    public Spittle(Long id, Spitter spitter, String text, Date postedTime) {
        this.id = id;
        this.spitter = spitter;
        this.text = text;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public Spitter getSpitter() {
        return spitter;
    }
}
