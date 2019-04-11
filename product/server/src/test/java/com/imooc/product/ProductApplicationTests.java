package com.imooc.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ProductApplicationTests {
    
    @Autowired
    private JavaMailSender mailSender;

	@Test
	public void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1016177061@qq.com");
        message.setTo("8777487@qq.com");
        message.setSubject("主题：邮件");
        message.setText("测试内容");
        mailSender.send(message);
	    
	    
    }

    @Test
    public void sendAttachmentsMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("dyc87112@qq.com");
        helper.setTo("dyc87112@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file);

        mailSender.send(mimeMessage);

    }

}
