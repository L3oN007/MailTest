
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

    public static void main(String[] args) throws MessagingException {
        final String fromEmail = "lily.plantshop@outlook.com";
        // Mat khai email cua ban
        final String password = "Password@1234";
        // dia chi email nguoi nhan
        final String toEmail = "minhnhatt0908@gmail.com";
        final String subject = "Java Example Test";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
        message.setSubject(subject);
        message.setSubject("HTML Message");
        String htmlContent = "<h1>Html Tag</h1>";
        message.setContent(htmlContent, "text/html");
        Transport.send(message);
        System.out.println("Gui mail thanh cong");
    }
}
