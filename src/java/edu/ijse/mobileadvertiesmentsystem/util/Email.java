/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ijse.mobileadvertiesmentsystem.util;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author Ashan Tharuka
 */
public class Email {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

   
    public static boolean generateAndSendEmail(String email,String password) throws AddressException, MessagingException {
     
            if (email == null || email.isEmpty()) {

            } else {
                // Step1
                System.out.println("\n 1st ===> setup Mail Server Properties..");
                mailServerProperties = System.getProperties();
                mailServerProperties.put("mail.smtp.port", "587");
                mailServerProperties.put("mail.smtp.auth", "true");
                mailServerProperties.put("mail.smtp.starttls.enable", "true");
                System.out.println("Mail Server Properties have been setup successfully..");

                // Step2
                System.out.println("\n\n 2nd ===> get Mail Session..");
                getMailSession = Session.getDefaultInstance(mailServerProperties, null);
                generateMailMessage = new MimeMessage(getMailSession);
                System.out.println("my E mail :" + email);
                generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(email));
                generateMailMessage.setSubject("Teck.lk Forgot Password");
                //String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
                generateMailMessage.setContent(password, "text/html");
                System.out.println("Mail Session has been created successfully..");

                // Step3
                System.out.println("\n\n 3rd ===> Get Session and Send mail");
                Transport transport = getMailSession.getTransport("smtp");

                // Enter your correct gmail UserID and Password
                // if you have 2FA enabled then provide App Specific Password
                transport.connect("smtp.gmail.com", "email", "password");
                transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
                transport.close();

            }

      
        return true;

    }
}
