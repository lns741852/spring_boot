package com.jay;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	JavaMailSenderImpl mailSender;

	@Test
	void mailTest() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("標題");
		message.setText("內文");

		message.setTo("a0978725050@gmail.com");
		message.setFrom("endurance6677@gmail.com");

		mailSender.send(message);
	}


	@Test
	void complexMessage() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setSubject("標題");
		helper.setText("<b style='color:red'>內容</b>");

		helper.setTo("a0978725050@gmail.com");
		helper.setFrom("endurance6677@gmail.com");

		helper.addAttachment("picture.jpg",new File("C:\\"));

		mailSender.send(mimeMessage);
	}

}
