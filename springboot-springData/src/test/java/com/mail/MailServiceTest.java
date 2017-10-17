package com.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


/**
 * Created by conglin.liu on 2017/10/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailService.sendTextMail("conglin.liu@quantgroup.cn","test simple mail"," hello this is simple mail");
    }

    @Test
    public void testPictureMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "e:\\微信图片_20171013100113.jpg";

        mailService.sendPictureMail("conglin.liu@quantgroup.cn", "主题：这是有图片的邮件", content, imgPath, rscId);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath="e:\\1.txt";
        mailService.sendAttachmentsMail("conglin.liu@quantgroup.cn", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }


    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("conglin.liu@quantgroup.cn","主题：这是模板邮件",emailContent);
    }
}