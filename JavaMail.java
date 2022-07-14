import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
/**implements javamail api for automated sending of email upon creation of each new program**/
public class JavaMail {
	//most of the code shown here is ope-sourced with the exception of a few tweaks for
	//send/receive address as well as passing client name to subject line
	private String clientName;
	private String clientEmail;
	
	
	public JavaMail(String clientName, String clientEmail) {
		this.clientName = clientName;
		this.clientEmail = clientEmail;
	}
	
	public void sendMail(String x) {
		final String username = "config.MAIL_ID"; // enter your mail id
		final String password = "config.PASSWORD";// enter ur password

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("mytalents13@gmail.com")); // same email id
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(clientEmail));// whom u have to send mails that person id
			message.setSubject(clientName);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText("");
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			DataSource source = new FileDataSource(x);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(x);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}
