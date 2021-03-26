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

public class BorrowerDetails {

	private JFrame BrwrDetframe;
	private JTable BrwrDetTable;
	private JButton BackBtn;
	private JLabel BGImage;
	
	public BorrowerDetails() {
		BrwrDetframe = new JFrame();
		BrwrDetframe.setTitle("Borrower Details over here");
		BrwrDetframe.setResizable(false);
		BrwrDetframe.setSize(800,600);
        BrwrDetframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BrwrDetframe.getContentPane().setLayout(null);
		
		JScrollPane ScrollPane = new JScrollPane();
		ScrollPane.setBounds(27, 101, 732, 352);
		BrwrDetframe.getContentPane().add(ScrollPane);
		
		BrwrDetTable = new JTable();
		BrwrDetTable.setFont(new Font("Tahoma", Font.PLAIN, 8));
        String cols[]={"Username", "Vehicle Type", "Vehicle Number", "Brand  Name", "Rent for an hour"};
		DefaultTableModel tmodel=new DefaultTableModel(null,cols);
		BrwrDetTable.setModel(new DefaultTableModel(
			new Object[][] {},
			new String[] {"Username", "Contact Number", "Vehicle Type", "Location", "From Date", "To Date", "From Time", "To Time"})
		{
			boolean[] columnEditables = new boolean[] {false, false, false, false, false, false, false, false};
                        @Override
			public boolean isCellEditable(int row, int column)
			{
				return columnEditables[column];
			}
		});
		BrwrDetTable.getColumnModel().getColumn(0).setResizable(false);
		BrwrDetTable.getColumnModel().getColumn(0).setPreferredWidth(93);
		BrwrDetTable.getColumnModel().getColumn(1).setResizable(false);
		BrwrDetTable.getColumnModel().getColumn(1).setPreferredWidth(124);
		BrwrDetTable.getColumnModel().getColumn(2).setResizable(false);
		BrwrDetTable.getColumnModel().getColumn(2).setPreferredWidth(112);
		BrwrDetTable.getColumnModel().getColumn(3).setResizable(false);
		BrwrDetTable.getColumnModel().getColumn(3).setPreferredWidth(89);
		BrwrDetTable.getColumnModel().getColumn(4).setResizable(false);
		BrwrDetTable.getColumnModel().getColumn(5).setResizable(false);
		BrwrDetTable.getColumnModel().getColumn(6).setResizable(false);
		BrwrDetTable.getColumnModel().getColumn(7).setResizable(false);
		ScrollPane.setViewportView(BrwrDetTable);
		
		BackBtn = new JButton("BACK");
		BackBtn.setBounds(460, 503, 89, 23);
		BrwrDetframe.getContentPane().add(BackBtn);
                BackBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BrwrDetframe.dispose();
                new AdminAccess();
            }
                });
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
                String q="select * from borrower";
                PreparedStatement p=connection.prepareStatement(q);
                ResultSet rs=p.executeQuery();
                BrwrDetTable.setModel(DbUtils.resultSetToTableModel(rs));
                
                BGImage = new JLabel("");
                BGImage.setIcon(new ImageIcon("E:\\TemplateAdmin.jpeg"));
                BGImage.setBounds(0, 0, 804, 604);
                BrwrDetframe.getContentPane().add(BGImage);
                connection.close();                
            }
            catch(Exception e1)
            {
                System.out.println(e1);
            }
		BrwrDetframe.setVisible(true);
	}
	/**
	 * @return the table
	 */
	public JTable getTable() {
		return BrwrDetTable;
	}
	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.BrwrDetTable = table;
	}
	public static void main(String args[])
	{
		new BorrowerDetails();
	}
	
}

