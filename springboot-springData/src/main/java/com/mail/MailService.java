package com.mail;

/**
 * Created by conglin.liu on 2017/10/16.
 */
public interface MailService {

    /**
     * 最简单的邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendMail(String to, String subject, String content);

}
