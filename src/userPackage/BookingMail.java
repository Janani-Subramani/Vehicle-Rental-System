package userPackage;


import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.mail.Session; 
import javax.mail.Transport; 
  
public class BookingMail 
{ 
    public static void SendEmail(String Lender,String LenderContactNo,String LenderMail,String Borrower,String BorrowerContactNo,String BorrowerMail)
    {
    	String sender = "crizonrentals32@gmail.com"; 
        String Lrecipient =LenderMail;  
        String Brecipient=BorrowerMail;
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
           MimeMessage Lmessage = new MimeMessage(session);         
           Lmessage.setFrom(new InternetAddress(sender)); 
           Lmessage.addRecipient(Message.RecipientType.TO, new InternetAddress(Lrecipient)); 
           Lmessage.setSubject("Vehicle Booking Borrower Details"); 
           Lmessage.setText("Hai "+Lender+" Greetings from Crizon Rental Groups \n Happiee to have you as our customer !!! The following are your Borrower details "
           		+ "\n NAME  "+Borrower+"\n CONTACT NUMBER  "+BorrowerContactNo+"\n EMAIL ADDRESS  "+BorrowerMail); 
           Transport.send(Lmessage); 
           System.out.println("Lender Mail successfully sent"); 
           
           MimeMessage Bmessage = new MimeMessage(session);         
           Bmessage.setFrom(new InternetAddress(sender)); 
           Bmessage.addRecipient(Message.RecipientType.TO, new InternetAddress(Brecipient)); 
           Bmessage.setSubject("Vehicle Booking Lender Details"); 
           Bmessage.setText("Hai "+Borrower+" Happiee to have you as our customer !!! The following are your Lender details "
           		+ "\n NAME  "+Lender+"\n CONTACT NUMBER  "+LenderContactNo+"\n EMAIL ADDRESS  "+LenderMail); 
           Transport.send(Bmessage); 
           System.out.println("Borrower Mail successfully sent"); 
        } 
        catch (Exception e)  
        { 
           e.printStackTrace(); 
        } 
    }
	public static void main(String [] args)  
   {     
	  SendEmail("","","","", "", "");
   } 
} 