package com.kittycoder.email;

import com.kittycoder.po.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by shucheng on 2020/7/30 10:16
 * 参考链接：https://blog.csdn.net/wang_97/article/details/79851437（主要看的这篇）
 * https://blog.csdn.net/feiyangtianyao/article/details/86620928
 */
@Service
public class SpitterMailServiceImpl implements SpitterMailService {

    @Autowired
    private JavaMailSender mailSender;
    @Value("${mailserver.username}")
    private String from;

    /* 创建一封简单的邮件 */
    @Override
    public void sendSimpleSpittleEmail(String to, Spittle spittle) {
        // 通过这个对象封装信息，相当于信封
        SimpleMailMessage message = new SimpleMailMessage();
        // 获取spittle对象中的收件人名字
        String spitterName = spittle.getSpitter().getFullName();
        // 发件人
        message.setFrom(from);
        // 收件人
        message.setTo(to);
        // 邮件主题
        message.setSubject("New spittle from " + spitterName);
        // 邮件内容
        message.setText(spitterName + " says:" + spittle.getText());
        // 发送邮件
        mailSender.send(message);
    }

    /* 创建一封带有图片附件的邮件 */
    @Override
    public void sendSpittleEmailWithAttachment(String to, Spittle spittle) throws MessagingException {
        // 通过邮件发送器的createMimeMessage方法构建可含附件的邮件
        MimeMessage message = mailSender.createMimeMessage();
        // 第一个参数是邮件的对象
        // 第二个参数为true表示这个消息是multipart类型的消息（表示是带有附件的邮件）
        // 第三个参数是防止中文乱码
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        // 获取收件人名，用于后面发送邮件做主题
        String spitterName = spittle.getSpitter().getFullName();
        // 发件人
        helper.setFrom(from);
        // 收件人
        helper.setTo(to);
        // 邮件的主题内容
        helper.setSubject("New spittle from " + spitterName);
        // 邮件的发送内容
        helper.setText(spitterName + " says:" + spittle.getText());
        // 通过路径获取图片附件
        ClassPathResource logoImage = new ClassPathResource("/images/spitter_logo.png");
        // 第一个参数是图片的名称，到时候收到的附件名
        // 第二个参数是图片附件的资源
        helper.addAttachment("Spitter_logo.png", logoImage);
        // 发送邮件
        mailSender.send(message);
    }

    /* 创建一封嵌套图片的文本邮件 */
    @Override
    public void sendRichSpittleEmail(String to, Spittle spittle) throws MessagingException {
        // 创建一封富文本邮件
        MimeMessage message = mailSender.createMimeMessage();
        // 第二个参数表明传递进来的第一个参数是html文本
        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        String spitterName = spittle.getSpitter().getFullName();
        // 发件人
        helper.setFrom(from);
        // 收件人
        helper.setTo(to);
        // 发送的邮件主题
        helper.setSubject("New spittle from " + spitterName);
        // cid:spitterLogo，标记一个变量，后面为这个变量添加一张图片
        // 第二个参数表示传递的第一个参数是html
        helper.setText("<html><body><img src='cid:spittleLogo'/>" +
                "<h4>" + spitterName + "says...</h4>" +
                "<i>" + spittle.getText() + "</i>" +
                "</body></html>", true);
        // 创建一个变量存放图片
        ClassPathResource image = new ClassPathResource("/images/spitter_logo.png");
        // 为消息添加嵌入式的图片
        helper.addInline("spittleLogo", image);
        // 发送邮件
        mailSender.send(message);
    }
}
