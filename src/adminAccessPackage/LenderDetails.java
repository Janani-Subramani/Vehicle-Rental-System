/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminAccessPackage;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import adminPackage.AdminAccess;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class LenderDetails {

	private JFrame LenderDetFrame;
	private JTable LenderDetTable;
	private JButton BackBtn;
	private JLabel BGImage;
	
	public LenderDetails(){

		LenderDetFrame = new JFrame();
		LenderDetFrame.setTitle("Lender Details over here");
		LenderDetFrame.setResizable(false);
		LenderDetFrame.setSize(812,600);
		LenderDetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LenderDetFrame.getContentPane().setLayout(null);
		
		JScrollPane ScrollPane = new JScrollPane();
		ScrollPane.setBounds(24, 101, 727, 349);
		LenderDetFrame.getContentPane().add(ScrollPane);
		
		LenderDetTable = new JTable();
		LenderDetTable.setFont(new Font("Tahoma", Font.PLAIN, 13));
        //String cols[]={"Username", "Vehicle Type", "Vehicle Number", "Brand  Name", "Rent for an hour"};
		//DefaultTableModel tmodel=new DefaultTableModel(null,cols);
		LenderDetTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Username", "Contact Number", "RC Number", "Brand Name", "Vehicle Number", "Location", "From Date", "To Date", "From Time", "To Time", "Rent for an hour"}	) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, false, false, false, false, false, false, false, false
			};
                        @Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		LenderDetTable.getColumnModel().getColumn(0).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(0).setPreferredWidth(93);
		LenderDetTable.getColumnModel().getColumn(1).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(1).setPreferredWidth(124);
		LenderDetTable.getColumnModel().getColumn(2).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(2).setPreferredWidth(113);
		LenderDetTable.getColumnModel().getColumn(3).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(3).setPreferredWidth(115);
		LenderDetTable.getColumnModel().getColumn(4).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(4).setPreferredWidth(112);
		LenderDetTable.getColumnModel().getColumn(5).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(5).setPreferredWidth(89);
		LenderDetTable.getColumnModel().getColumn(6).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(7).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(8).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(9).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(10).setResizable(false);
		LenderDetTable.getColumnModel().getColumn(10).setPreferredWidth(105);
		//LenderDetTable.getColumnModel().getColumn(10).setMinWidth(20);
		ScrollPane.setViewportView(LenderDetTable);
		
		try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
            String q="select * from Lender";
            PreparedStatement p=connection.prepareStatement(q);
            ResultSet rs=p.executeQuery();
            //LenderDetTable.setModel(DbUtils.resultSetToTableModel(rs));
            LenderDetTable.setModel(DbUtils.resultSetToTableModel(rs));
            connection.close();          
        }
        catch(Exception e1)
        {
            System.out.println(e1);
            
        }   
		BackBtn = new JButton("BACK");
		BackBtn.setBounds(362, 501, 89, 23);
		LenderDetFrame.getContentPane().add(BackBtn);
		
		BGImage = new JLabel("");
		BGImage.setIcon(new ImageIcon("E:\\TemplateAdmin.jpeg"));
		BGImage.setBounds(0, -13, 798, 626);
		LenderDetFrame.getContentPane().add(BGImage);
                BackBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                LenderDetFrame.dispose();
                new AdminAccess();
            }
                });
                
         
		
		LenderDetFrame.setVisible(true);
	}
	/**
	 * @return the table
	 */
	public JTable getTable() {
		return LenderDetTable;
	}
	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.LenderDetTable = table;
	}
	public static void main(String args[])
	{
		new LenderDetails();
	}
}
