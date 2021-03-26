/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminPackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

import mainPackage.LoginPage;

public class AdminLogin {
	
    private JFrame AdminFrame;
    private JLabel UsernameLab,PasswordLab;
    private JTextField UsernameTf;
    private JPasswordField PasswordTf;
    private JButton BackBtn,LoginBtn;
    
    public AdminLogin(){

    	Font LabelFont=new Font("Footlight MT Light", Font.PLAIN, 20);
		Font ButtonFont=new Font("Century", Font.PLAIN, 15);
    	
        AdminFrame = new JFrame("Admin Login");
        AdminFrame.setResizable(false);
        AdminFrame.setTitle("Hey Admin !!");
        AdminFrame.setSize(799,600);
        
        UsernameLab=new JLabel("Username");
        UsernameLab.setFont(LabelFont);
        UsernameLab.setBounds(156,181,100,30);
        AdminFrame.getContentPane().add(UsernameLab);
        UsernameTf=new JTextField();
        UsernameTf.setBounds(433,182,130,30);
        AdminFrame.getContentPane().add(UsernameTf);
        
        PasswordLab=new JLabel("Password");
        PasswordLab.setFont(LabelFont);
        PasswordLab.setBounds(156,281,100,30);
        AdminFrame.getContentPane().add(PasswordLab);
        PasswordTf=new JPasswordField();
        PasswordTf.setBounds(433,282,130,30);
        AdminFrame.getContentPane().add(PasswordTf);
        PasswordTf.setEchoChar('*');
        
        BackBtn=new JButton("BACK");
        BackBtn.setFont(ButtonFont);
        BackBtn.setBounds(168,447,100,30);
        AdminFrame.getContentPane().add(BackBtn);
        LoginBtn=new JButton("LOGIN");
        LoginBtn.setFont(ButtonFont);
        LoginBtn.setBounds(488,447,94,30);
        AdminFrame.getContentPane().add(LoginBtn);
        
        AdminFrame.getContentPane().setLayout(null);
        
        JLabel BGImage = new JLabel("");
        BGImage.setIcon(new ImageIcon("E:\\TemplateAdmin.jpeg"));
        BGImage.setBounds(0, 0, 783, 585);
        AdminFrame.getContentPane().add(BGImage);
        AdminFrame.setVisible(true);
        BackBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
                          AdminFrame.dispose();
			  new LoginPage();
			}
		});
        LoginBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
                            String user=UsernameTf.getText();
                            @SuppressWarnings("deprecation")
							String pass=PasswordTf.getText();
                            try
                            {
                               
                                Class.forName("com.mysql.jdbc.Driver"); 
                                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
                                String query2="select * from Admin where Username=? and Password=?";
                                PreparedStatement statement=connection.prepareStatement(query2);
                                statement.setString(1,user);
                                statement.setString(2,pass);
                                ResultSet rs=statement.executeQuery();
                                if(rs.next())
                                {
                                    
                                    AdminFrame.setVisible(false);
                                    new AdminAccess();
                                    
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(AdminFrame,"Enter valid username or password");

                                }

                            }
                            catch(Exception e1)
                                    {
                                        System.out.println(e1);
                                    }
                           

			  			  
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
		new AdminLogin();
	}
}

