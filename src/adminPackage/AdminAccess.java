/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

import adminAccessPackage.BookingDetails;
import adminAccessPackage.BorrowerDetails;
import adminAccessPackage.LenderDetails;
import adminAccessPackage.NewAdmin;
import adminAccessPackage.RegistrationDetails;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class AdminAccess {
    private JFrame AdminAccessFrame;
    private JButton RegisterImg,LenderImg,BorrowerImg,BookingImg,LogoutBtn;
    private JLabel RegisterLab,LenderLab,BorrowerLab,BookingLab;
    private JButton AdminAddBtn;
    private JLabel AdminAddLab;
    private JLabel BGImage;
    
    public AdminAccess()
    {
        AdminAccessFrame=new JFrame("Admin Access");
        AdminAccessFrame.setTitle("Control over all the details");
        AdminAccessFrame.setSize(802,605);
                
        Icon Register_img=new ImageIcon("E:\\regis.png");
        RegisterImg=new JButton(Register_img);
        RegisterImg.setBounds(143,125,110,110);
        AdminAccessFrame.getContentPane().add(RegisterImg);
        RegisterLab=new JLabel("Registration Details");
        RegisterLab.setBounds(143,246,120,30);
        AdminAccessFrame.getContentPane().add(RegisterLab);
        
        Icon lender_img=new ImageIcon("E:\\lender1.png");
        LenderImg=new JButton(lender_img);
        LenderImg.setBounds(523,125,110,110);
        AdminAccessFrame.getContentPane().add(LenderImg);
        LenderLab=new JLabel("Lender Details");
        LenderLab.setBounds(533,246,120,30);
        AdminAccessFrame.getContentPane().add(LenderLab);
        
        Icon borrower_img=new ImageIcon("E:\\borrower1.png");
        BorrowerImg=new JButton(borrower_img);
        BorrowerImg.setBounds(143,328,110,110);
        AdminAccessFrame.getContentPane().add(BorrowerImg);
        BorrowerLab=new JLabel("Borrower Details");
        BorrowerLab.setBounds(159,449,120,30);
        AdminAccessFrame.getContentPane().add(BorrowerLab);
        
        Icon Book_img=new ImageIcon("E:\\book.png");
        BookingImg=new JButton(Book_img);
        BookingImg.setBounds(523,328,110,110);
        AdminAccessFrame.getContentPane().add(BookingImg);
        BookingLab=new JLabel("Booked Details");
        BookingLab.setBounds(533,449,120,30);
        AdminAccessFrame.getContentPane().add(BookingLab);
        
        LogoutBtn=new JButton("Logout");
        LogoutBtn.setBounds(354,514,75,30);
        AdminAccessFrame.getContentPane().add(LogoutBtn);
        
        AdminAccessFrame.getContentPane().setLayout(null);
        
        AdminAddBtn = new JButton("");
        AdminAddBtn.setIcon(new ImageIcon("E:\\adminadd.png"));
        AdminAddBtn.addActionListener(new ActionListener() {
                @Override
        	public void actionPerformed(ActionEvent e) {
        		new NewAdmin();
        	}
        });
        AdminAddBtn.setBounds(317, 247, 112, 96);
        AdminAccessFrame.getContentPane().add(AdminAddBtn);
        
        AdminAddLab = new JLabel("ADD ADMIN");
        AdminAddLab.setBounds(339, 368, 102, 14);
        AdminAccessFrame.getContentPane().add(AdminAddLab);
        
        BGImage = new JLabel("");
        BGImage.setIcon(new ImageIcon("E:\\TemplateAdmin.jpeg"));
        BGImage.setBounds(0, -11, 786, 627);
        AdminAccessFrame.getContentPane().add(BGImage);
        AdminAccessFrame.setResizable(false);
        AdminAccessFrame.setVisible(true);
        LogoutBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
                          AdminAccessFrame.dispose();
			  new AdminLogin();
			}
		});
        RegisterImg.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
                          AdminAccessFrame.dispose();
			  new RegistrationDetails();
			}
		});
        LenderImg.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
                          AdminAccessFrame.dispose();
			  new LenderDetails();
			}
		});
        BookingImg.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
                          AdminAccessFrame.dispose();
			  new BookingDetails();
			}
		});
        BorrowerImg.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
                          AdminAccessFrame.dispose();
			  new BorrowerDetails();
			}
		});

    }
    public static void main(String args[])
    {
    	new AdminAccess();
    }
    
}


