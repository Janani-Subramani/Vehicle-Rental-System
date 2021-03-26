
package mainPackage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Random;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OTPVerification {

	
	private static JFrame frame;
	private static JTextField OTPTf;
    private static JLabel OTPLab;
    
	public   OTPVerification( )
    {
    	try
    	{
    		  int SentOTP=9999;
			  String apiKey = "apikey=" + "uZQY/YeLpGk-32ZcJVwJYpoO9M3QnhMuFaqRlvdyfw";
				Random rand=new Random();
				SentOTP=rand.nextInt(9999);
			    String message = "&message=" + URLEncoder.encode("Your Crizon Rental Group OTP is " + SentOTP,"UTF-8");
			   //String sender = "&sender=" + "Crizon Rental";
			 //  String numbers = "&numbers=" + PhoneNumber;
			   String numbers="9787445056";
			   String apiURL = "https://api.textlocal.in/send/?" + apiKey + message + numbers;
			   
			   URL url = new URL(apiURL);
			   URLConnection connection = url.openConnection();
			   connection.setDoOutput(true);
			   
			   BufferedReader reader = new BufferedReader(new 
			     InputStreamReader(connection.getInputStream()));
			   
			   String line = "";
			   StringBuilder sb = new StringBuilder();
			   
			   while ( (line = reader.readLine()) != null) 
			   {
			    sb.append(line).append("\n");
			   }
			   
			   System.out.println(sb.toString());
		 

	
	OTPLab = new JLabel("Enter your OTP");
	OTPLab.setBounds(48, 40, 94, 34);
	frame.add(OTPLab);
	
	OTPTf = new JTextField();
	OTPTf.setBounds(150, 89, 164, 39);
	frame.add(OTPTf);
	//OTPTf.setColumns(10);
	final int SentOTP1 = 0;
	JButton VerifyBtn = new JButton("Verify");
	VerifyBtn.addActionListener(new ActionListener() {
                @Override
		public void actionPerformed(ActionEvent arg0) {
			int EnteredOTP=Integer.parseInt(OTPTf.getText());
			if(EnteredOTP!=SentOTP1)
			{
				JOptionPane.showMessageDialog(frame, "Registered Successfully ");
			}
			else
				JOptionPane.showMessageDialog(frame, "Registered fail ..Try again ");
		}
	});
	VerifyBtn.setBounds(287, 171, 89, 23);
	frame.getContentPane().add(VerifyBtn);	
	frame.setVisible(true);
	
    	}
		catch(Exception e)
    	{
		  e.printStackTrace();
    	}
				   
				
		
    }

	public static void main(String[] args) {

		new OTPVerification();
	}
}