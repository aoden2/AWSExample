package com.tdt.aws.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class MailUtils {

	public static void sendSimpleEmail(String subject, String message, String from, String to) throws Exception{
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		//put your email credentials here
		email.setAuthentication("email", "password");
		email.setSSLOnConnect(true);
		email.setFrom(from);
		email.setSubject(subject);
		email.setMsg(message);
		email.addTo(to);
		email.send();
	}
}
