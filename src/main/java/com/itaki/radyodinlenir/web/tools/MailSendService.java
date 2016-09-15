package com.itaki.radyodinlenir.web.tools;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailSendService {

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void sendMail(String from, String to, String subject, String msg) {
		MimeMessage message = javaMailSender.createMimeMessage();
		String encodingOptions = "text/html; charset=UTF-8";
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");

			message.setHeader("Content-Type", encodingOptions);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(msg, true);
		} catch (MessagingException e) {
			throw new MailParseException(e);
		}
		javaMailSender.send(message);

	}

}
