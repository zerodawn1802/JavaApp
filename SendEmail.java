import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*;  
  
public class SendEmail{  
    public void sendEmail(){
        String to = "phuongacma1802@gmail.com"; 
        final String user = "checkercontest@gmail.com"; 
        final String password = "whzero1802";
   
        //1) get the session object     
        Properties properties = new Properties();  
        properties.setProperty("mail.smtp.host", "smtp.gmail.com");  
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.auth", "true");  
        properties.put("mail.smtp.port", "587");
  
        Session session = Session.getDefaultInstance(properties,  
        new javax.mail.Authenticator() {  
        protected PasswordAuthentication getPasswordAuthentication() {  
        return new PasswordAuthentication(user, password);  
        }  
    });  
     
    //2) compose message     
    try{  
        MimeMessage message = new MimeMessage(session);  
        message.setFrom(new InternetAddress(user));  
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  
        message.setSubject("Contest Check");  
       
        BodyPart messageBodyPart1 = new MimeBodyPart();  
        messageBodyPart1.setText("File check.");  
          
        MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
        MimeBodyPart messageBodyPart3 = new MimeBodyPart();
        MimeBodyPart messageBodyPart4 = new MimeBodyPart();
        String filename = "screen.jpg";
        DataSource source = new FileDataSource(filename);  
        messageBodyPart2.setDataHandler(new DataHandler(source));  
        messageBodyPart2.setFileName(filename);  
        String filename2 = "miniKey.txt";
        DataSource source2 = new FileDataSource(filename2);  
        messageBodyPart3.setDataHandler(new DataHandler(source2));  
        messageBodyPart3.setFileName(filename2);
        String filename4 = "check.txt";
        DataSource source4 = new FileDataSource(filename4);  
        messageBodyPart4.setDataHandler(new DataHandler(source4));  
        messageBodyPart4.setFileName(filename4);
     
      
        Multipart multipart = new MimeMultipart();  
        multipart.addBodyPart(messageBodyPart1);  
        multipart.addBodyPart(messageBodyPart2);  
        multipart.addBodyPart(messageBodyPart3);
        multipart.addBodyPart(messageBodyPart4);
        message.setContent(multipart );  
     
        Transport.send(message);  
   
        System.out.println("message sent....");  
        }catch (MessagingException ex) {ex.printStackTrace();}  
    }  
}  