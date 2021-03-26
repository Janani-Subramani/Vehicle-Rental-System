
package mainPackage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class FeedbackRating {

	private JFrame frame;
	private JTextArea TextArea;
	public FeedbackRating() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 803, 603);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Font LabelFont = new Font("Footlight MT Light", Font.BOLD, 20);
		Font ButtonFont = new Font("Century", Font.PLAIN, 20);
		
		StringBuffer rate=new StringBuffer("You have rated us with");
		
		JButton Rate1Btn = new JButton("");
		Rate1Btn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				rate.append("Five stars :) :)Thanks alot we are glad to have a customer like you");
			}
		});
		Rate1Btn.setIcon(new ImageIcon("C:\\Users\\Trini\\Desktop\\Theo\\BootathonImages\\r1.png"));
		Rate1Btn.setBounds(69, 153, 101, 100);
		frame.getContentPane().add(Rate1Btn);
		
		JButton Rate2Btn = new JButton("");
		Rate2Btn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				rate.append("Four stars !! Okay thanks much we shall target for one more star next time");
			}
		});
		Rate2Btn.setIcon(new ImageIcon("C:\\Users\\Trini\\Desktop\\Theo\\BootathonImages\\r2.png"));
		Rate2Btn.setBounds(195, 153, 101, 100);
		frame.getContentPane().add(Rate2Btn);
		
		JButton Rate3Btn = new JButton("");
		Rate3Btn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				rate.append("Three stars ...Two more stars to to go");
			}
		});
		Rate3Btn.setIcon(new ImageIcon("C:\\Users\\Trini\\Desktop\\Theo\\BootathonImages\\r3.png"));
		Rate3Btn.setBounds(329, 150, 101, 103);
		frame.getContentPane().add(Rate3Btn);
		
		JButton Rate4Btn = new JButton("");
		Rate4Btn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				rate.append("Two stars !! Is it surely we will rectify our mistakes");
			}
		});
		Rate4Btn.setIcon(new ImageIcon("C:\\Users\\Trini\\Desktop\\Theo\\BootathonImages\\r4.png"));
		Rate4Btn.setBounds(467, 153, 101, 100);
		frame.getContentPane().add(Rate4Btn);
		
		JButton Rate5Btn = new JButton("");
		Rate5Btn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				rate.append("One star ...Thanks for the honest compliment...");
			}
		});
		Rate5Btn.setIcon(new ImageIcon("C:\\Users\\Trini\\Desktop\\Theo\\BootathonImages\\r5.png"));
		Rate5Btn.setBounds(596, 153, 101, 100);
		frame.getContentPane().add(Rate5Btn);
		
		JRadioButton SuggestionRBtn = new JRadioButton("Suggestion");
		SuggestionRBtn.setBounds(69, 331, 174, 23);
		SuggestionRBtn.setFont(ButtonFont);
		frame.getContentPane().add(SuggestionRBtn);
		
		JRadioButton NotrightRbtn = new JRadioButton("Something is not quite right");
		NotrightRbtn.setBounds(258, 331, 310, 23);
		NotrightRbtn.setFont(ButtonFont);
		frame.getContentPane().add(NotrightRbtn);
		
		JRadioButton ComplimentRBtn = new JRadioButton("Compliment");
		ComplimentRBtn.setBounds(592, 331, 167, 23);
		ComplimentRBtn.setFont(ButtonFont);
		frame.getContentPane().add(ComplimentRBtn);
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(SuggestionRBtn);
		bg.add(NotrightRbtn);
		bg.add(ComplimentRBtn);
		
		JTextArea TextArea = new JTextArea();
		TextArea.setBounds(69, 425, 632, 71);
		frame.getContentPane().add(TextArea);
		
		rate.append(" ");
		rate.append(TextArea.getText());
		
		JLabel FeedLab = new JLabel("WE WOULD LIKE TO HAVE YOUR FEEDBACK");
		FeedLab.setBounds(153, 71, 592, 24);
		FeedLab.setFont(LabelFont);
		frame.getContentPane().add(FeedLab);
		
		JLabel OpinionLab = new JLabel("What's your Opinion of our Application ??");
		OpinionLab.setBounds(174, 119, 467, 23);
		OpinionLab.setFont(LabelFont);
		frame.getContentPane().add(OpinionLab);
		
		JLabel CategoryLab = new JLabel("Your Feedback Category");
		CategoryLab.setBounds(69, 280, 329, 23);
	    CategoryLab.setFont(LabelFont);
		frame.getContentPane().add(CategoryLab);
		
		JLabel FeedbackLab = new JLabel("Please leave your feedback below");
		FeedbackLab.setBounds(69, 391, 361, 23);
		FeedbackLab.setFont(LabelFont);
		frame.getContentPane().add(FeedbackLab);

		JButton SendBtn = new JButton("SEND");
		SendBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(frame, rate);
				JOptionPane.showConfirmDialog(frame,"Happy sharing !! ", "Greeting from Crizon Rental Groups",JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE );
				frame.dispose();
			}
		});
		SendBtn.setBounds(631, 517, 129, 23);
		SendBtn.setFont(ButtonFont);
		frame.getContentPane().add(SendBtn);
		
		JLabel BGImage = new JLabel("");
		BGImage.setIcon(new ImageIcon("C:\\Users\\Trini\\Desktop\\Theo\\BootathonImages\\AppTemplate.jpeg"));
		BGImage.setBounds(0, -15, 787, 627);
		frame.getContentPane().add(BGImage);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FeedbackRating();
	}
}

