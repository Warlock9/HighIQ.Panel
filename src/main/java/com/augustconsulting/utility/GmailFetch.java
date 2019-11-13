package com.augustconsulting.utility;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.*;
//
public class GmailFetch {

  public static void main( String[] args ) {
		try {

			Properties props = new Properties();
			    
			    props.setProperty("mail.transport.protocol", "smtp");
				props.setProperty("mail.host", "mail.softwaysys.com");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", 25);
				props.put("mail.debug", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("prafulla@softwaysys.com", "Softway@123");
				}
			});
			Transport transport = session.getTransport();
			System.out.println("prafulla@softwaysys.com"+"From Mail"+"al");
			InternetAddress addressFrom = new InternetAddress("prafulla@softwaysys.com");

			MimeMessage message = new MimeMessage(session);
			message.setSender(addressFrom);
			message.setSubject("test");
			message.setContent("test", "text/plain");
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("aashish.verma@ripplesinfomatics.com"));

			transport.connect();
			Transport.send(message);
			transport.close();
			System.out.println("Mail Sent");
		} catch (Exception ex) {
			System.out.println("Mail fail");
			ex.printStackTrace();
			
		}
}
  
}