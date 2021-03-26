package mainPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

import adminPackage.AdminLogin;
import selectionPackage.LenderOrBorrower;
import java.awt.Font;
import java.awt.Color;
import java.awt.Button;
	
public class LoginPage {

	private JLabel UsernameLab, PasswordLab, AdminLab;
	private JTextField UsernameTf;
	private JPasswordField PasswordTf;
	private JButton ClearBtn, AdminLoginBtn, LogoutBtn;
	private JTextField OTPTf;
	private JLabel BGImage;

	public LoginPage() {

		JFrame LoginFrame = new JFrame("Login");
		LoginFrame.setTitle("Welcome Back User !!");
		

		Font LabelFont = new Font("Footlight MT Light", Font.PLAIN, 20);
		Font ButtonFont = new Font("Century", Font.PLAIN, 20);

		UsernameLab = new JLabel("Username");
		
		UsernameLab.setBounds(260, 222, 100, 30);
		LoginFrame.getContentPane().add(UsernameLab);
		UsernameLab.setFont(LabelFont);
		UsernameTf = new JTextField();
		UsernameTf.setBounds(447, 223, 142, 30);
		LoginFrame.getContentPane().add(UsernameTf);

		PasswordLab = new JLabel("Password");
		
		PasswordLab.setBounds(260, 309, 113, 30);
		LoginFrame.getContentPane().add(PasswordLab);
		PasswordLab.setFont(LabelFont);
		PasswordTf = new JPasswordField();
		PasswordTf.setBounds(447, 310, 142, 30);
		LoginFrame.getContentPane().add(PasswordTf);
		PasswordTf.setEchoChar('*');

		ClearBtn = new JButton("CLEAR");
		ClearBtn.setBounds(281, 470, 130, 30);
		LoginFrame.getContentPane().add(ClearBtn);
		ClearBtn.setFont(ButtonFont);

		
		AdminLoginBtn = new JButton(new ImageIcon("E:\\admin3.png"));
		AdminLoginBtn.setBounds(90, 213, 113, 152);
		LoginFrame.getContentPane().add(AdminLoginBtn);
		AdminLab = new JLabel("Admin?");
		
		AdminLab.setFont(new Font("Century", Font.PLAIN, 25));
		AdminLab.setBounds(100, 391, 90, 30);
		LoginFrame.getContentPane().add(AdminLab);

		LogoutBtn = new JButton("Home");
		LogoutBtn.setBounds(648, 90, 107, 30);
		LoginFrame.getContentPane().add(LogoutBtn);
		LogoutBtn.setFont(ButtonFont);
		LoginFrame.getContentPane().setLayout(null);
		
		LoginFrame.setResizable(false);
		LoginFrame.setVisible(true);
		LoginFrame.setSize(800,620);
		
		JButton LoginBtn = new JButton("LOGIN");
		LoginBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				String user=UsernameTf.getText();
                @SuppressWarnings("deprecation")
				String pass=PasswordTf.getText();
                try
                {

                    Class.forName("com.mysql.jdbc.Driver"); 
                    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
                    String query2="select * from register where Username=? and Password=?";
                    PreparedStatement statement=connection.prepareStatement(query2);
                    statement.setString(1,user);
                    statement.setString(2,pass);
                    ResultSet rs=statement.executeQuery();
                    if(rs.next())
                    {
                        
                        LoginFrame.dispose();
                        new LenderOrBorrower(user);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(LoginFrame,"Enter valid username or password");

                    }

                }
                catch(Exception e1)
                        {
                            System.out.println(e1);
                        }
               

			}
		});
		LoginBtn.setFont(new Font("Century", Font.PLAIN, 20));
		LoginBtn.setBounds(509, 470, 130, 30);
		LoginFrame.getContentPane().add(LoginBtn);
		
		LoginFrame.setResizable(false);
		LoginFrame.setSize(801, 598);
		BGImage = new JLabel("");
		BGImage.setIcon(new ImageIcon("E:\\AppTemplate.jpeg"));
		BGImage.setBounds(0, 0, 784, 581);
		LoginFrame.getContentPane().add(BGImage);

		
		
		LoginFrame.setResizable(false);
		LoginFrame.setVisible(true);
		AdminLoginBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame.dispose();
				new AdminLogin();

			}
		});
		LogoutBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				LoginFrame.dispose();
				new HomePage();

			}
		});
		ClearBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {

				UsernameTf.setText("");
				PasswordTf.setText("");

			}
		});

	}

	/**
	 * @return the username
	 */
	public JTextField getUsername() {
		return UsernameTf;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(JTextField username) {
		UsernameTf = username;
	}

	/**
	 * @return the password
	 */
	public JPasswordField getPassword() {
		return PasswordTf;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(JPasswordField password) {
		PasswordTf = password;
	}
	public static void main(String args[])
	{
		new LoginPage();
	}
}

