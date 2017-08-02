import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailSender {

    public static void main(String[] args) {
        MailSender mailSender = new MailSender();
        mailSender.sendEmailToMyself();
    }

    private void sendEmailToMyself(){
        JavaMailSenderImpl javaMailSender = getJavaMailSender();
        String messageContent = "dit is de inhoud van de boodschap";
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("ik@mijnmail.nl");
            helper.setTo("simone.kamer@gmail.com");
            helper.setSubject("123test");
            helper.setText(messageContent);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(message);
    }

    private JavaMailSenderImpl getJavaMailSender() {
        String wachtwoord = "wachtwoord";
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(587);
        javaMailSender.setUsername("simone.kamer@gmail.com");
        javaMailSender.setPassword(wachtwoord);

        Properties javaMailProperties = new Properties();
        javaMailProperties.setProperty("mail.smtp.auth", "true");
        javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
        javaMailSender.setJavaMailProperties(javaMailProperties);
        return javaMailSender;
    }
}
