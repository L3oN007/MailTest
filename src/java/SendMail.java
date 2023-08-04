
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
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
                + "    <title>Password Reset - Apple Design</title>"
                + "    <style>"
                + "        body {"
                + "            font-family: \"Helvetica Neue\", Helvetica, Arial, sans-serif;"
                + "            background-color: #f5f5f5;"
                + "            line-height: 1.6;"
                + "            margin: 0;"
                + "            padding: 0;"
                + "        }"
                + "        .container {"
                + "            max-width: 600px;"
                + "            margin: 0 auto;"
                + "            padding: 20px;"
                + "            background-color: #fff;"
                + "            border-radius: 8px;"
                + "            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);"
                + "        }"
                + "        .logo {"
                + "            text-align: center;"
                + "            margin-bottom: 20px;"
                + "        }"
                + "        .logo img {"
                + "            max-width: 150px;"
                + "        }"
                + "        .message {"
                + "            padding: 20px;"
                + "            background-color: #f9f9f9;"
                + "            border-radius: 8px;"
                + "            margin-bottom: 20px;"
                + "        }"
                + "        .message p {"
                + "            margin: 0;"
                + "        }"
                + "        .new-password {"
                + "            font-size: 24px;"
                + "            font-weight: bold;"
                + "            color: #0070c9;"
                + "            background-color: #f0f7ff;"
                + "            border: 2px solid #0070c9;"
                + "            padding: 15px;"
                + "            border-radius: 8px;"
                + "            text-align: center;"
                + "            margin-top: 15px;"
                + "        }"
                + "        .action-button {"
                + "            display: inline-block;"
                + "            width: 100%;"
                + "            text-align: center;"
                + "            text-decoration: none;"
                + "            padding: 15px 0;"
                + "            background-color: #0070c9;"
                + "            color: #fff;"
                + "            border-radius: 8px;"
                + "            font-weight: bold;"
                + "            transition: background-color 0.3s;"
                + "        }"
                + "        .action-button:hover {"
                + "            background-color: #005ea0;"
                + "        }"
                + "        .footer {"
                + "            text-align: center;"
                + "            color: #666;"
                + "            font-size: 12px;"
                + "            margin-top: 20px;"
                + "        }"
                + "        .footer p {"
                + "            margin: 5px 0;"
                + "        }"
                + "    </style>"
                + "</head>"
                + "<body>"
                + "    <div class=\"container\">"
                + "        <div class=\"logo\">"
                + "            <img src=\"https://example.com/apple_logo.png\" alt=\"Apple Logo\">"
                + "        </div>"
                + "        <div class=\"message\">"
                + "            <p>Hello [Username],</p>"
                + "            <p>We have received a request to reset your password.</p>"
                + "            <div class=\"new-password\">[NewPassword]</div>"
                + "            <p>Please make sure to change this password after logging in for security purposes.</p>"
                + "        </div>"
                + "        <a class=\"action-button\" href=\"https://example.com/login\">Log In Now</a>"
                + "        <div class=\"footer\">"
                + "            <p>This email was sent by [YourCompany]. If you did not request a password reset, please ignore this message.</p>"
                + "            <p>[YourCompany] | Address, City, Country | Phone: +123 456 7890</p>"
                + "        </div>"
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
