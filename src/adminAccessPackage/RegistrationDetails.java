/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminAccessPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import adminPackage.AdminAccess;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.sql.Statement;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class RegistrationDetails {

	private JFrame frame;
	private JTable table;
	private JTextField NameTf,AadharNoTf,LicenceNoTf,ContactNoTf,UsernameTf,PasswordTf,AddressTf,EmailTf;
	
	public RegistrationDetails() {

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 108, 729, 217);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Aadhar Number", "Licence Number", "Contact Number", "Username", "Password", "Address", "Email"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(103);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(111);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(76);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(91);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(81);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(7).setPreferredWidth(106);
		
		scrollPane.setViewportView(table);
		

		JPanel panel = new JPanel();
		panel.setBounds(29, 359, 722, 138);
		panel.setLayout(null);
		
		NameTf = new JTextField();
		NameTf.setBounds(147, 11, 119, 20);
		panel.add(NameTf);
		NameTf.setColumns(10);
		
		AadharNoTf = new JTextField();
		AadharNoTf.setBounds(147, 42, 119, 20);
		panel.add(AadharNoTf);
		AadharNoTf.setColumns(10);
		
		LicenceNoTf = new JTextField();
		LicenceNoTf.setBounds(147, 73, 119, 20);
		panel.add(LicenceNoTf);
		LicenceNoTf.setColumns(10);
		
		ContactNoTf = new JTextField();
		ContactNoTf.setBounds(147, 104, 119, 20);
		panel.add(ContactNoTf);
		ContactNoTf.setColumns(10);
		
		EmailTf = new JTextField();
		EmailTf.setColumns(10);
		EmailTf.setBounds(449, 11, 119, 20);
		panel.add(EmailTf);
		
		UsernameTf = new JTextField();
		UsernameTf.setColumns(10);
		UsernameTf.setBounds(449, 42, 119, 20);
		panel.add(UsernameTf);
		
		PasswordTf = new JTextField();
		PasswordTf.setColumns(10);
		PasswordTf.setBounds(449, 73, 119, 20);
		panel.add(PasswordTf);
		
		AddressTf = new JTextField();
		AddressTf.setColumns(10);
		AddressTf.setBounds(449, 104, 119, 20);
		panel.add(AddressTf);
		
		JLabel NameLab = new JLabel("Name");
		NameLab.setBounds(10, 14, 127, 14);
		panel.add(NameLab);
		
		JLabel AadharNoLab = new JLabel("Aadhar Number");
		AadharNoLab.setBounds(10, 45, 127, 14);
		panel.add(AadharNoLab);
		
		JLabel LicenceNoLab = new JLabel("Licence Number");
		LicenceNoLab.setBounds(10, 76, 127, 14);
		panel.add(LicenceNoLab);
		
		JLabel ContactNoLab = new JLabel("Contact Number");
		ContactNoLab.setBounds(10, 107, 127, 14);
		panel.add(ContactNoLab);
		
		JLabel EmailLab = new JLabel("Email Address");
		EmailLab.setBounds(311, 14, 119, 14);
		panel.add(EmailLab);
		
		JLabel UsernameLab = new JLabel("Username");
		UsernameLab.setBounds(311, 45, 119, 14);
		panel.add(UsernameLab);
		
		JLabel PasswordLab = new JLabel("Password");
		PasswordLab.setBounds(311, 76, 119, 14);
		panel.add(PasswordLab);
		
		JLabel Address = new JLabel("Address");
		Address.setBounds(311, 107, 119, 14);
		panel.add(Address);

		frame.getContentPane().add(panel);
		
		JButton AddUserLab = new JButton("ADD USER");
		AddUserLab.setBounds(632, 508, 119, 36);
		frame.getContentPane().add(AddUserLab);
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
                String q="select * from Register";
                PreparedStatement p=connection.prepareStatement(q);
                ResultSet rs=p.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
                
                connection.close();
                
                
                            
            }
            catch(Exception e1)
            {
                System.out.println(e1);
                
            }
		
		JButton BackBtn = new JButton("BACK");
		BackBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
                             frame.dispose();
                             new AdminAccess();
			}
		});
                JButton DeleteBtn = new JButton("DELETE");
                DeleteBtn.setBounds(330, 508, 98, 36);
		frame.getContentPane().add(DeleteBtn);
		DeleteBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
                             String UsernameTf1=UsernameTf.getText();
                             try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
                 Statement statement=connection.createStatement();
                String q1="delete  from Register where Username=?";
                PreparedStatement statement2=connection.prepareStatement(q1);
                         statement2.setString(1,UsernameTf1);
                         statement2.execute();

                
                String q="select * from Register";
                
                PreparedStatement p=connection.prepareStatement(q);
                ResultSet rs=p.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
                JOptionPane.showMessageDialog(frame, "User deleted successfully !!");
                UsernameTf.setText("");
                connection.close();
                
                
                            
            }
            catch(Exception e1)
            {
                System.out.println(e1);
                
            }
			    
                             
			}
		});

                
                
		BackBtn.setBounds(487, 508, 98, 36);
		frame.getContentPane().add(BackBtn);
		
		JLabel BGImage = new JLabel("");
		BGImage.setIcon(new ImageIcon("E:\\TemplateAdmin.jpeg"));
		BGImage.setBounds(0, -18, 784, 639);
		frame.getContentPane().add(BGImage);
              
		AddUserLab.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
//				DefaultTableModel model=(DefaultTableModel) table.getModel();
//				Vector<String> row=new Vector<String>();
//				row.add(NameTf.getText());
//				row.add(AadharNoTf.getText());
//				row.add(LicenceNoTf.getText());
//				row.add(ContactNoTf.getText());
////				row.add(EmailTf.getText());
//				row.add(UsernameTf.getText());
//				row.add(PasswordTf.getText());
//				row.add(AddressTf.getText());
//				model.addRow(row);
                                String NameTf1=NameTf.getText();
                                String AadharNoTf1=AadharNoTf.getText();
                                String LicenceNoTf1=LicenceNoTf.getText();
                                String ContactNoTf1=ContactNoTf.getText();
                                String UsernameTf1=UsernameTf.getText();
                                String PasswordTf1=PasswordTf.getText();
                                String AddressTf1=AddressTf.getText();
                                String EmailTf1=EmailTf.getText();
                                
                                
                                
                                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
                 Statement statement=connection.createStatement();
                String q1="insert into Register values('"+NameTf1+"','"+AadharNoTf1+"','"+LicenceNoTf1+"','"+ContactNoTf1+
                		"','"+UsernameTf1+"','"+PasswordTf1+"','"+AddressTf1+"','"+EmailTf1+"')";
                statement.executeUpdate(q1);
                String q="select * from Register";
                PreparedStatement p=connection.prepareStatement(q);
                ResultSet rs=p.executeQuery();
                table.setModel(DbUtils.resultSetToTableModel(rs));
                NameTf.setText("");
                AadharNoTf.setText("");
                LicenceNoTf.setText("");
                ContactNoTf.setText("");
                UsernameTf.setText("");
                PasswordTf.setText("");
                AddressTf.setText("");
                EmailTf.setText("");
                JOptionPane.showMessageDialog(frame, "User added successfully !!");
                connection.close();
               
                
                            
            }
            catch(Exception e1)
            {
                System.out.println(e1);
                
            }
			    
			}
		});
		

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new RegistrationDetails();
	}
}
