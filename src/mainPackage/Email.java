
package mainPackage;


import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.mail.Session; 
import javax.mail.Transport; 
  
public class Email  
{ 
    public static void SendEmail(String recipient,String name)
	//public static void SendEmail()
    {
    	String sender = "crizonrentals32@gmail.com"; 
       // String recipient = "18eucs046@skcet.ac.in";  
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port",587);
        
      
   
        Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {
      	   protected PasswordAuthentication getPasswordAuthentication()
      	   {
      		  return new PasswordAuthentication("crizonrentals32@gmail.com","CrizonRentals@T32");
      	   }
        }); 
    
        try 
        { 
           MimeMessage message = new MimeMessage(session);         
           message.setFrom(new InternetAddress(sender)); 
           message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
           message.setSubject("Greetings from Crizon Rental Group....."); 
           message.setText("Hai  Happiee to have you as our customer !!! Crizon Rental Goups is one trustworthy online vehicle "
           		+ "rental system.You can be our customer either as a lender or borrower...Let your vehicles make money "
           		+ "for you...Yor account has been activated...Stay safe and stay in touch.You are customer have aggreed that any defects to the vehicle after "
           		+ "borrowing either big or small you are solely responsible for it"); 
           Transport.send(message); 
           System.out.println("Mail successfully sent"); 
        } 
        catch (Exception e)  
        { 
           e.printStackTrace(); 
        } 
    }
	public static void main(String [] args)  
   {     
	  SendEmail("","");
   } 
} 