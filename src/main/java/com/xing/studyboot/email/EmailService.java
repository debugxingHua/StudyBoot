package com.xing.studyboot.email;

import java.io.File;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {
	
	@Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    /**
     * 发送纯文本邮件
     * @param to 发送目标邮箱
     * @param subject 主题
     * @param text 内容
     */
    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
    
    /**
     * 发送带附件的邮件
     * @param to 发送目标邮箱
     * @param subject 主题
     * @param text 内容
     * @param filePath 附件
     */
    public void sendMailWithAttachment(String to, String subject, String text, String filePath) {
		try {
			File attachment = new File(filePath);
	        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
			helper.setFrom(from);
	        helper.setTo(to);
	        helper.setSubject(subject);
	        helper.setText(text);
	        helper.addAttachment(attachment.getName(),attachment);//添加附件
	        helper.addInline(attachment.getName(),attachment);//添加内联元素
	        javaMailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
    }
}
