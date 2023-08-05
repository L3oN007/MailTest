
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

        String htmlContent = "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>Steam Password Reset</title>"
                + "    <style>"
                + "        /* Steam-style CSS */"
                + "        body {"
                + "            font-family: 'Arial', sans-serif;"
                + "            background-color: #f0f2f5;"
                + "            color: #4a4a4a;"
                + "            margin: 0;"
                + "            padding: 0;"
                + "        }"
                + "        .card-container {"
                + "            max-width: 600px;"
                + "            margin: 0 auto;"
                + "            padding: 20px;"
                + "            border-radius: 10px;"
                + "            background-color: #ffffff;"
                + "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);"
                + "        }"
                + "        .logo {"
                + "            display: block;"
                + "            max-width: 200px;"
                + "            margin: 0 auto;"
                + "        }"
                + "        .password-container {"
                + "            margin-top: 30px;"
                + "            padding: 10px;"
                + "            background-color: #f7f9fb;"
                + "            border-radius: 5px;"
                + "        }"
                + "        .password-label {"
                + "            display: block;"
                + "            font-size: 18px;"
                + "            font-weight: bold;"
                + "            margin-bottom: 10px;"
                + "        }"
                + "        .password-value {"
                + "            display: inline-block;"
                + "            padding: 8px;"
                + "            background-color: #e1e8ed;"
                + "            color: #4a4a4a;"
                + "            font-family: 'Courier New', monospace;"
                + "            font-size: 16px;"
                + "            border-radius: 5px;"
                + "        }"
                + "    </style>"
                + "</head>"
                + "<body>"
                + "    <div class=\"card-container\">"
                + "        <img class=\"logo\" src=\"https://seeklogo.com/images/S/steam-logo-73274B19E3-seeklogo.com.png\" alt=\"Steam Logo\">"
                + ""
                + "        <h1>Reset Your Password</h1>"
                + ""
                + "        <p>Hi there,</p>"
                + ""
                + "        <p>We received a request to reset your Steam account password. Don't worry; if you didn't make this request, you can ignore this email.</p>"
                + ""
                + "        <p>If the button above doesn't work, you can also copy and paste the following link into your web browser:</p>"
                + ""
                + "        <p>{YOUR PASSWORD RESET LINK}</p>"
                + ""
                + "        <div class=\"password-container\">"
                + "            <span class=\"password-label\">Your new password:</span>"
                + "            <span class=\"password-value\">{NEW PASSWORD}</span>"
                + "        </div>"
                + ""
                + "        <p>Thanks,</p>"
                + "        <p>The Steam Team</p>"
                + ""
                + "        <p style=\"text-align: center; margin-top: 30px;\">Please do not reply to this email. It is a system-generated message.</p>"
                + "    </div>"
                + "</body>"
                + "</html>";

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

        message.setContent(htmlContent, "text/html");
        Transport.send(message);
        System.out.println("Gui mail thanh cong");
    }
}
