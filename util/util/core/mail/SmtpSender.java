package util.core.mail;


import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class SmtpSender {
	
	public void sendSMTP(String host, String port, String tls, String username, String password, Boolean debug,
						 String from, List<String> tos, List<String> ccs, List<String> bccs, String subject, String text) {
		
		try {
			
			Properties props = new Properties();
			props.setProperty("mail.smtp.host", host);
			props.setProperty("mail.smtp.port", port);
			props.setProperty("mail.smtp.starttls.enable", tls);
			props.setProperty("mail.transport.protocol", "smtp");
			//props.setProperty("mail.smtp.auth", "true");
			if (username != null) {
				if (!username.isEmpty()) {
					props.setProperty("mail.smtp.user", username);	
				}	
			}
			if (password != null) {
				if (!password.isEmpty()) {
					props.setProperty("mail.smtp.password", password);	
				}
			}
			
			Session session = Session.getDefaultInstance(props, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
	            }
			});		
			
			if(debug != null){
				if(debug == true){
					session.setDebug(true);
				}
			}
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			if(tos!=null){
				for(String to : tos){
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
				}
			}
			if(ccs!=null){
				for(String cc : ccs){
					message.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
				}
			}
			if(bccs!=null){
				for(String bcc : bccs){
					message.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
				}
			}
			message.setSubject(subject);
			message.setText(text,"UTF-8","html");		
			
			
			Transport transport = session.getTransport("smtp");
	        transport.connect(host, username, password);
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}


}
