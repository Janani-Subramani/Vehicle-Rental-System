/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminAccessPackage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import adminPackage.AdminAccess;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class NewAdmin {
	private JFrame frame;
	private JLabel name, contact, username, password;
	private JTextField name_t, contact_t, username_t, password_t;
	private JButton Add;
	private JLabel BGImage;

	public NewAdmin() {
		frame = new JFrame("REGISTER FORM");
		frame.getContentPane().setLayout(null);
		frame.setSize(800, 599);
		frame.setResizable(false);

		name = new JLabel("NAME");
		name.setBounds(187, 165, 100, 30);
		frame.getContentPane().add(name);
		name_t = new JTextField();
		name_t.setBounds(390, 165, 150, 30);
		frame.getContentPane().add(name_t);

		// name.setColumns(10);
		contact = new JLabel("CONTACT NO");
		contact.setBounds(187, 227, 100, 30);
		frame.getContentPane().add(contact);
		contact_t = new JTextField();
		contact_t.setBounds(390, 227, 150, 30);
		frame.getContentPane().add(contact_t);

		username = new JLabel("USERNAME");
		username.setBounds(187, 287, 100, 30);
		frame.getContentPane().add(username);
		username_t = new JTextField();
		username_t.setBounds(390, 287, 150, 30);
		frame.getContentPane().add(username_t);

		password = new JLabel("PASSWORD");
		password.setBounds(187, 353, 100, 30);
		frame.getContentPane().add(password);
		password_t = new JTextField();
		password_t.setBounds(390, 353, 150, 30);
		frame.getContentPane().add(password_t);

		Add = new JButton("SUBMIT");
		Add.setBounds(277, 430, 150, 30);
		// Add.setBackground(SystemColor.controlHighlight);
		frame.getContentPane().add(Add);

		BGImage = new JLabel("");
		BGImage.setIcon(new ImageIcon("E:\\TemplateAdmin.jpeg"));
		BGImage.setBounds(0, -58, 784, 699);
		frame.getContentPane().add(BGImage);
		Add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = name_t.getText();
				String contact = contact_t.getText();
				String username = username_t.getText();
				String password = password_t.getText();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project",
							"Bootathon", "12345678");
					Statement statement = connection.createStatement();
					String q1 = "insert into Admin values('" + name + "','" + contact + "','" + username + "','"
							+ password + "')";
					statement.executeUpdate(q1);
					JOptionPane.showMessageDialog(frame, "New  Admin added Successfully");
					frame.dispose();
					new AdminAccess();
				} catch (Exception ex) {

				}
			}

		});
		frame.setVisible(true);
	}

	public static void main(String args[]) {
		new NewAdmin();
	}

}

