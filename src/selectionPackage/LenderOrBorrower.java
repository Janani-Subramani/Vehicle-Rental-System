/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionPackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

import userPackage.LenderPage;

import java.awt.event.ActionListener;
import java.awt.Color;

public class LenderOrBorrower {
	JFrame LendOrBrwrFrame;
	JLabel QuesnLab, LenderLab, BorrowerLab;
	JButton LenderImg, BorrowImg;
	private JLabel BGImg;
	String User;
	public LenderOrBorrower(String user) {
		this.User=user;
		LendOrBrwrFrame = new JFrame("SELECTION");
		LendOrBrwrFrame.setTitle("Lender OR Borrower ??");

		QuesnLab = new JLabel("WILLING TO BE...??");
		QuesnLab.setForeground(new Color(139, 0, 139));
		QuesnLab.setBounds(74, 82, 254, 75);

		QuesnLab.setFont(new Font("Footlight MT Light", Font.PLAIN, 27));
		LendOrBrwrFrame.getContentPane().add(QuesnLab);

		//Icon lender = new ImageIcon("");
		LenderImg = new JButton(new ImageIcon("E:\\\\lender1.png"));
		LenderImg.setBounds(100, 222, 200, 109);
		LendOrBrwrFrame.getContentPane().add(LenderImg);
		LenderLab = new JLabel("Lender");
		LenderLab.setBounds(172, 389, 88, 30);
		LenderLab.setFont(new Font("Bell MT", Font.PLAIN, 20));
		LendOrBrwrFrame.getContentPane().add(LenderLab);

//		Icon borrower = new ImageIcon();
		BorrowImg = new JButton(new ImageIcon("E:\\borrower1.png"));
		BorrowImg.setBounds(470, 221, 176, 109);
		LendOrBrwrFrame.getContentPane().add(BorrowImg);
		BorrowerLab = new JLabel("Borrower");
		BorrowerLab.setBounds(536, 389, 80, 30);
		BorrowerLab.setFont(new Font("Bell MT", Font.PLAIN, 20));
		LendOrBrwrFrame.getContentPane().add(BorrowerLab);

		LendOrBrwrFrame.setSize(760, 598);
		LendOrBrwrFrame.getContentPane().setLayout(null);
		
		JLabel BGImage = new JLabel("");
		BGImage.setIcon(new ImageIcon("E:\\AppTemplate.jpeg"));
		BGImage.setBounds(0, -36, 785, 665);
		LendOrBrwrFrame.getContentPane().add(BGImage);
		
		/*BGImg = new JLabel("New label");
		BGImg.setIcon(new ImageIcon("C:\\Users\\Trini\\Desktop\\Theo\\BootathonImages\\LendBrw.jpg"));
		BGImg.setBounds(0, 0, 747, 563);
		LendOrBrwrFrame.getContentPane().add(BGImg);*/
		LendOrBrwrFrame.setVisible(true);
		LendOrBrwrFrame.setResizable(false);
		
		LendOrBrwrFrame.setResizable(false);
		LendOrBrwrFrame.setSize(801, 598);

		BorrowImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LendOrBrwrFrame.dispose();
				new CarOrBike(User);
			}
		});
		LenderImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LendOrBrwrFrame.dispose();
				new LenderPage(User);
			}
		});

	}

	/**
	 * @return the lend
	 */
	public JButton getLend() {
		return LenderImg;
	}

	/**
	 * @param lend the lend to set
	 */
	public void setLend(JButton lend) {
		this.LenderImg = lend;
	}

	/**
	 * @return the borrow
	 */
	public JButton getBorrow() {
		return BorrowImg;
	}

	/**
	 * @param borrow the borrow to set
	 */
	public void setBorrow(JButton borrow) {
		this.BorrowImg = borrow;
	}
   public static void main(String args[])
   {
	   new LenderOrBorrower("");
   }
}

