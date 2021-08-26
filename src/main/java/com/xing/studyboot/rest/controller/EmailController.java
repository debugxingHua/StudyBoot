package com.xing.studyboot.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xing.studyboot.email.EmailService;
import com.xing.studyboot.entity.dto.EmailDto;

/**
 * 
 * @author xing
 * @createTime
 */
@RestController
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@PostMapping("/send")
	public String getName(@RequestBody EmailDto emailDto) {
		String to = emailDto.getTo();
		String subject = emailDto.getSubject();
		String text = emailDto.getText();
		System.out.println(emailDto);
		emailService.sendMail(to, subject, text);
		return "邮件【"+subject+"】发送到【"+to+"】成功!";
	}
	
	@PostMapping("/sendWithAttachment")
	public String sendMailWithAttachment(@RequestBody EmailDto emailDto) {
		String to = emailDto.getTo();
		String subject = emailDto.getSubject();
		String text = emailDto.getText();
		System.out.println(emailDto);
		String filePath = "";
		if(emailDto.getFile() != null && !"".equals(emailDto.getFile())) {
			filePath = emailDto.getFile();
		}else {
			filePath = "D:\\code\\SpringBoot\\StudyBoot\\src\\main\\resources\\static\\car.png";
		}
		System.out.println("filePath->"+filePath);
		emailService.sendMailWithAttachment(to, subject, text, filePath);
		return "邮件【"+subject+"】发送到【"+to+"】成功!";
	}
}
