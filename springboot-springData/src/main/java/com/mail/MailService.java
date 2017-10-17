package com.mail;

/**
 * Created by conglin.liu on 2017/10/16.
 */
public interface MailService {

    /**
     * 发送文本邮件
     *
     * @param to  收件人
     * @param subject  邮件主题
     * @param content  邮件内容
     */
    void sendTextMail(String to, String subject, String content);


    /**
     * 发送带图片的邮件 (图片属于静态文件)
     *
     * @param to  收件人
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param path  图片地址
     * @param id 图片id
     */
     void sendPictureMail(String to, String subject, String content, String path, String id);


    /**
     * 发送带附件的邮件
     *
     * @param to  收件人
     * @param subject  邮件主题
     * @param content  邮件内容
     * @param filePath 附件地址
     */
     void sendAttachmentsMail(String to, String subject, String content, String filePath);

    /**
     * 发送html格式邮件
     *
     * @param to  收件人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendHtmlMail(String to, String subject, String content);





}
