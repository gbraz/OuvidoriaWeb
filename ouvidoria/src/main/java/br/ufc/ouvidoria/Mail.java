package br.ufc.ouvidoria;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Mail {
	
	public void sendMail(String Text, String subject,String from, String to){
		Properties properties = createProperties();
		Session session = createSession(properties);
		
		try {
		  Message message = new MimeMessage(session);
		  message.setFrom(new InternetAddress(from));
			
		  message.setRecipients(Message.RecipientType.TO,
		               InternetAddress.parse(to));
		  
		  message.setSubject(subject);
		  message.setText(Text);

		  Transport.send(message);
		  
		} catch (MessagingException e) {
		         throw new RuntimeException(e);
		}
	}
	
	
	private Properties createProperties(){

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.mandrillapp.com");
		props.put("mail.smtp.port", "587");
		
		return props;
	}
	
	private Session createSession(Properties properties){
		final String username = Info.USERNAME;
		final String password = Info.PASSWORD;
		
		Session session = Session.getInstance(properties,
		         new javax.mail.Authenticator() {
		            protected PasswordAuthentication getPasswordAuthentication() {
		               return new PasswordAuthentication(username, password);
			   }		         });
		
		return session;
	}
}
