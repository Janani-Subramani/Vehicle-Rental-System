package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;	
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import selectionPackage.LenderOrBorrower;
import java.awt.Font;
import java.awt.Color;

public class RegistrationPage {
	private JFrame RegistrationFrame;
	private JLabel NameLab, AadharNoLab, LicenceNoLab, ContactNoLab, UsernameLab, PasswordLab, AddressLab, OTPLab;
	private JTextField AadharNoTf, LicenseNoTf, ContactNoTf, UsernameTf;
	private static JTextField OTPTf;
	private JTextField NameTf;
	private JTextArea AddressTa;
	private JPasswordField PasswordTf;
	private JButton SubmitBtn, PaymentBtn;
	private JButton button;
 
	public  RegistrationPage() {
		RegistrationFrame = new JFrame("REGISTER FORM");
		RegistrationFrame.setTitle("Hey enter your Credentials ");
		RegistrationFrame.getContentPane().setLayout(null);

		Font LabelFont = new Font("Footlight MT Light", Font.BOLD, 20);
		Font ButtonFont = new Font("Century", Font.PLAIN, 20);
		// Color LabelColor=new Color(0,0,0,0);

		NameLab = new JLabel("Name");
		NameLab.setFont(LabelFont);
		NameLab.setBounds(40, 92, 100, 30);
		RegistrationFrame.getContentPane().add(NameLab);
		NameTf = new JTextField();
		NameTf.setBounds(238, 80, 150, 30);
		RegistrationFrame.getContentPane().add(NameTf);

		AadharNoLab = new JLabel("Aadhar Number");
		AadharNoLab.setBounds(40, 160, 160, 30);
		AadharNoLab.setFont(LabelFont);
		// AadharNoLab.setForeground(LabelColor);
		RegistrationFrame.getContentPane().add(AadharNoLab);
		AadharNoTf = new JTextField();
		AadharNoTf.setBounds(238, 161, 150, 30);
		RegistrationFrame.getContentPane().add(AadharNoTf);

		LicenceNoLab = new JLabel("Licence Number");
		LicenceNoLab.setBounds(40, 239, 180, 30);
		LicenceNoLab.setFont(LabelFont);
		// LicenceNoLab.setForeground(LabelColor);
		RegistrationFrame.getContentPane().add(LicenceNoLab);
		LicenseNoTf = new JTextField();
		LicenseNoTf.setBounds(238, 240, 150, 30);
		RegistrationFrame.getContentPane().add(LicenseNoTf);

		ContactNoLab = new JLabel("Contact Number");
		ContactNoLab.setBounds(40, 311, 180, 30);
		ContactNoLab.setFont(LabelFont);
		// ContactNoLab.setForeground(LabelColor);
		RegistrationFrame.getContentPane().add(ContactNoLab);
		ContactNoTf = new JTextField();
		ContactNoTf.setBounds(238, 312, 150, 30);
		RegistrationFrame.getContentPane().add(ContactNoTf);
		UsernameTf = new JTextField();
		UsernameTf.setBounds(600, 161, 150, 30);
		RegistrationFrame.getContentPane().add(UsernameTf);

		PasswordLab = new JLabel("Password");
		PasswordLab.setBounds(410, 239, 144, 30);
		PasswordLab.setFont(LabelFont);
		// PasswordLab.setForeground(LabelColor);
		RegistrationFrame.getContentPane().add(PasswordLab);
		PasswordTf = new JPasswordField();
		PasswordTf.setBounds(600, 240, 150, 30);
		RegistrationFrame.getContentPane().add(PasswordTf);
		PasswordTf.setEchoChar('*');

		AddressLab = new JLabel("Address");
		AddressLab.setBounds(410, 311, 122, 30);
		AddressLab.setFont(LabelFont);
		// AddressLab.setForeground(LabelColor);
		RegistrationFrame.getContentPane().add(AddressLab);
		AddressTa = new JTextArea();
		AddressTa.setBounds(590, 311, 160, 30);
		RegistrationFrame.getContentPane().add(AddressTa);
        
		UsernameLab = new JLabel("Username");
		UsernameLab.setBounds(410, 160, 144, 30);
		RegistrationFrame.getContentPane().add(UsernameLab);
		UsernameLab.setFont(LabelFont);

		button = new JButton("BACK");
		button.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				RegistrationFrame.dispose();
				new HomePage();
			}
		});
		button.setBounds(122, 508, 138, 30);
		RegistrationFrame.getContentPane().add(button);
		button.setFont(new Font("Century", Font.PLAIN, 20));
		
		EmailTf = new JTextField();
		EmailTf.setBounds(600, 80, 150, 30);
		RegistrationFrame.getContentPane().add(EmailTf);
		EmailTf.setColumns(10);
		
		EmailLab = new JLabel("Email address");
		EmailLab.setBounds(410, 79, 180, 31);
		EmailLab.setFont(LabelFont);
		RegistrationFrame.getContentPane().add(EmailLab);
		
		JPanel Panel = new JPanel();
		Panel.setBackground(new Color(255, 250, 240));
		Panel.setBounds(10, 369, 768, 117);
		RegistrationFrame.getContentPane().add(Panel);
		Panel.setLayout(null);
		
				PaymentBtn = new JButton("Click me to proceed for payment");
				PaymentBtn.setBounds(361, 11, 282, 32);
				Panel.add(PaymentBtn);
				
						OTPTf = new JTextField();
						OTPTf.setBounds(361, 74, 164, 32);
						Panel.add(OTPTf);
						OTPTf.setFont(new Font("Tahoma", Font.PLAIN, 25));
						OTPTf.setColumns(10);
						Font LabelFont2 = new Font("Footlight MT Light", Font.PLAIN, 15);
						Font ButtonFont2 = new Font("Century", Font.PLAIN, 15);
						
								JLabel PaymentLab = new JLabel("Please pay your Brokerage amount Rs. 100");
								PaymentLab.setFont(LabelFont2);
								PaymentLab.setBounds(21, 12, 318, 30);
								Panel.add(PaymentLab);
								
										OTPLab = new JLabel("Enter your OTP here !!");
										OTPLab.setFont(LabelFont2);
										OTPLab.setBounds(21, 76, 318, 30);
										Panel.add(OTPLab);
										
										JButton SendOTPBtn = new JButton("SEND OTP");
										SendOTPBtn.setBounds(598, 57, 142, 32);
										SendOTPBtn.setFont(ButtonFont2);
										Panel.add(SendOTPBtn);
										SendOTPBtn.addActionListener(new ActionListener() {
                                                                                        @Override
											public void actionPerformed(ActionEvent e) {
												String mobile_str = ContactNoTf.getText();
												SendOTP(mobile_str);
												
											}
										});
										PaymentBtn.setFont(ButtonFont2);
				PaymentBtn.addActionListener(new ActionListener() {
                                        @Override
					public void actionPerformed(ActionEvent arg0) {
//						new Payment();
					}
				});
		
				SubmitBtn = new JButton("SUBMIT");
				SubmitBtn.setBounds(452, 508, 138, 30);
                                SubmitBtn.setEnabled(false);
				RegistrationFrame.getContentPane().add(SubmitBtn);
				SubmitBtn.setFont(ButtonFont);
				SubmitBtn.setFont(ButtonFont);
				
				RegistrationFrame.setResizable(false);
				RegistrationFrame.setVisible(true);
				RegistrationFrame.setSize(800,620);
				
				JLabel BGImage = new JLabel("");
				BGImage.setIcon(new ImageIcon("E:\\AppTemplate.jpeg"));
				BGImage.setBounds(0, 0, 800, 600);
				RegistrationFrame.getContentPane().add(BGImage);

		SubmitBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {

				int flag = 0;
				String aadhar_str = AadharNoTf.getText();
				if (!AadharIsValid(aadhar_str)) {
					flag = 1;
					JOptionPane.showMessageDialog(RegistrationFrame, "Enter a valid Aadhar Number !! ");
				}
				String license_str = LicenseNoTf.getText();
				if (!LicenseIsValid(license_str)) {
					flag = 1;
					JOptionPane.showMessageDialog(RegistrationFrame, "Enter a valid License Number !! ");
				}
				String mobile_str = ContactNoTf.getText();
				if (!MobileIsValid(mobile_str)) {
					flag = 1;
					JOptionPane.showMessageDialog(RegistrationFrame, "Enter a valid Contact Number !! ");
				}
				@SuppressWarnings("deprecation")
				String pswrd_str = PasswordTf.getText();
				if (!PswrdIsStrong(pswrd_str)) {
					flag = 1;
					JOptionPane.showMessageDialog(RegistrationFrame, "Comeon keep a stronger password !! ");
				}
				String Name = NameTf.getText();
				String Username = UsernameTf.getText();
				String Address = AddressTa.getText();
                String email=EmailTf.getText();
				if (!NameIsValid(Name)) {
					flag = 1;
					JOptionPane.showMessageDialog(RegistrationFrame, "Enter valid Name");
				}
				if (!UsernameIsValid(Name)) {
					flag = 1;
					JOptionPane.showMessageDialog(RegistrationFrame, "Enter valid Username");
				}
				if (!AddressIsValid(Name)) {
					flag = 1;
					JOptionPane.showMessageDialog(RegistrationFrame, "Enter valid Address");
				}
				String Email= EmailTf.getText();
				if(!EmailIsValid(Email)) {
					flag = 1;
					JOptionPane.showMessageDialog(RegistrationFrame, "Enter valid Email Address");
				}
				if (OTPIsValid(mobile_str)) {
					flag = 1;
					JOptionPane.showMessageDialog(RegistrationFrame, "Enter correct and valid OTP");
				}
				String SenderMailAddress=EmailTf.getText();
				mainPackage.Email.SendEmail(SenderMailAddress,Name);
				
				if (flag == 0) {
					try {

						Class.forName("com.mysql.jdbc.Driver");
						Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project",
								"Bootathon", "12345678");
						Statement statement = connection.createStatement();

						String query = "insert into Register values('" + Name + "','" + aadhar_str + "','" + license_str
								+ "','" + mobile_str + "','" + Username + "','" + pswrd_str + "','" + Address + "','"+Email + "')";
						statement.executeUpdate(query);
						connection.close();
						JOptionPane.showMessageDialog(RegistrationFrame, "Registration success");
						RegistrationFrame.dispose();
						new LenderOrBorrower(Username);

					} catch (Exception e1) {
						System.out.print(e1);
						//JOptionPane.showMessageDialog(RegisterationFrame, "Username is already exists");
					}

				} else {
					JOptionPane.showMessageDialog(RegistrationFrame, "Registration failed");

				}
			}

		});

		

		RegistrationFrame.setSize(804, 600);

	}

	/**
	 * @return the nameTf
	 */
	public JTextField getNameTf() {
		return NameTf;
	}

	/**
	 * @param nameTf the nameTf to set
	 */
	public void setNameTf(JTextField nameTf) {
		NameTf = nameTf;
	}

	/**
	 * @return the aadharNoTf
	 */
	public JTextField getAadharNoTf() {
		return AadharNoTf;
	}

	/**
	 * @param aadharNoTf the aadharNoTf to set
	 */
	public void setAadharNoTf(JTextField aadharNoTf) {
		AadharNoTf = aadharNoTf;
	}

	/**
	 * @return the licenseNoTf
	 */
	public JTextField getLicenseNoTf() {
		return LicenseNoTf;
	}

	/**
	 * @param licenseNoTf the licenseNoTf to set
	 */
	public void setLicenseNoTf(JTextField licenseNoTf) {
		LicenseNoTf = licenseNoTf;
	}

	/**
	 * @return the contactNoTf
	 */
	public JTextField getContactNoTf() {
		return ContactNoTf;
	}

	/**
	 * @param contactNoTf the contactNoTf to set
	 */
	public void setContactNoTf(JTextField contactNoTf) {
		ContactNoTf = contactNoTf;
	}

	/**
	 * @return the usernameTf
	 */
	public JTextField getUsernameTf() {
		return UsernameTf;
	}

	/**
	 * @param usernameTf the usernameTf to set
	 */
	public void setUsernameTf(JTextField usernameTf) {
		UsernameTf = usernameTf;
	}

	/**
	 * @return the addressTa
	 */
	public JTextArea getAddressTa() {
		return AddressTa;
	}

	/**
	 * @param addressTa the addressTa to set
	 */
	public void setAddressTa(JTextArea addressTa) {
		AddressTa = addressTa;
	}

	/**
	 * @return the passwordTf
	 */
	public JPasswordField getPasswordTf() {
		return PasswordTf;
	}

	/**
	 * @param passwordTf the passwordTf to set
	 */
	public void setPasswordTf(JPasswordField passwordTf) {
		PasswordTf = passwordTf;
	}

	public static boolean AadharIsValid(String str) {
		try {
			if (str.isEmpty())
				return false;
			else {
				String regex = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(str);
				return m.matches();
			}
		} catch (Exception e) {

		}
		return false;
	}

	public static boolean MobileIsValid(String str) {
		try {
			if (str.isEmpty())
				return false;
			else {
				String regex = "^91[6-9][0-9]{9}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(str);
				return m.matches();
			}
		} catch (Exception e) {

		}
		return false;
	}

	public static boolean NameIsValid(String str) {
		try {
			if (str.isEmpty())
				return false;
			else if (!str.isEmpty()) {
				String regex = "^[a-zA-Z]{3,20}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(str);
				return m.matches();
			} else
				return true;

		} catch (Exception e) {

		}
		return false;
	}
	public static boolean UsernameIsValid(String str) {
		try {
			if (str.isEmpty())
				return false;
			else
				return true;

		} catch (Exception e) {

		}
		return false;
	}


	public static boolean AddressIsValid(String str) {
		try {
			if (str.isEmpty())
				return false;
			else
				return true;

		} catch (Exception e) {

		}
		return false;
	}

	public static boolean LicenseIsValid(String str) {
		try {
			if (str.isEmpty())
				return false;
			else {
				String regex = "^((TN[0-9]{2})( )|([A-Z]{2}[0-9]{2}))((19|20)[0-9][0-9])[0-9]{7}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(str);
				return m.matches();
			}
		} catch (Exception e) {

		}
		return false;
	}
	public static boolean EmailIsValid(String str) {
		try {
			if (str.isEmpty())
				return false;
			else {
				String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(str);
				return m.matches();
			}
		} catch (Exception e) {

		}
		return false;
	}
	public static boolean OTPIsValid(String str) {
		int EnteredOTP = Integer.parseInt(OTPTf.getText());
		if (EnteredOTP == SentOTP) {
			// JOptionPane.showMessageDialog(frame, "Registered Successfully ");
			return true;

		} else
			// JOptionPane.showMessageDialog(frame, "Registered fail ..Try again ");
			return false;
	}

	public static boolean PswrdIsStrong(String str) {
		try {
			if (str.isEmpty())
				return false;
			else {
				String regex = "(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.[^/s])" + "(?=.*[!@#$%^&*]).{8,20}";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(str);
				return m.matches();
			}
		} catch (Exception e) {

		}
		return false;
	}
   
	protected static final int SentOTP = 0;
	private JTextField EmailTf;
	private JLabel EmailLab;
	public static void SendOTP(String PhoneNumber) {

		try {
			int SentOTP = 9999;
			String apiKey = "apikey=" + "uZQY/YeLpGk-32ZcJVwJYpoO9M3QnhMuFaqRlvdyfw";
			Random rand = new Random();
			SentOTP = rand.nextInt(9999);
			String message = "&message=" + URLEncoder.encode("Your Crizon Rental Group OTP is " + SentOTP, "UTF-8");
			// String sender = "&sender=" + "Crizon Rental";
			String numbers = "&numbers=" + PhoneNumber;

			String apiURL = "https://api.textlocal.in/send/?" + apiKey + message + numbers;

			URL url = new URL(apiURL);
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line = "";
			StringBuilder sb = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				sb.append(line).append("\n");
			}

			System.out.println(sb.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}
	public static void main(String args[])
	{
		new RegistrationPage();
	}
}
