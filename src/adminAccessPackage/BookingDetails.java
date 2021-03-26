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

public class BookingDetails {

	private JFrame BookingDetFrame;
	private JTable BookingDetTable;
	private JButton BackBtn;
	private JLabel BGImage;
	
	public BookingDetails(){

		BookingDetFrame = new JFrame();
		BookingDetFrame.setTitle("Booking Details over here");
		BookingDetFrame.setResizable(false);
        BookingDetFrame.setSize(807,600);
		BookingDetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BookingDetFrame.getContentPane().setLayout(null);
		
		JScrollPane ScrollPane = new JScrollPane();
		ScrollPane.setBounds(24, 100, 740, 362);
		BookingDetFrame.getContentPane().add(ScrollPane);
		
		BookingDetTable = new JTable();
		BookingDetTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
		BookingDetTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Lender  Username", "Lender Contact Number", "Vehicle Number", "Available Date", "Borrower Username", "Borrower Contact Number"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, false, false, true, true, false
			};
                        @Override

                        public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		BookingDetTable.getColumnModel().getColumn(0).setResizable(false);
		BookingDetTable.getColumnModel().getColumn(0).setPreferredWidth(108);
		BookingDetTable.getColumnModel().getColumn(1).setResizable(false);
		BookingDetTable.getColumnModel().getColumn(1).setPreferredWidth(139);
		BookingDetTable.getColumnModel().getColumn(2).setResizable(false);
		BookingDetTable.getColumnModel().getColumn(2).setPreferredWidth(112);
		BookingDetTable.getColumnModel().getColumn(3).setPreferredWidth(89);
		BookingDetTable.getColumnModel().getColumn(4).setPreferredWidth(113);
		BookingDetTable.getColumnModel().getColumn(5).setResizable(false);
		BookingDetTable.getColumnModel().getColumn(5).setPreferredWidth(144);
		ScrollPane.setViewportView(BookingDetTable);
		
		BackBtn = new JButton("BACK");
		BackBtn.setBounds(365, 495, 89, 23);
		BookingDetFrame.getContentPane().add(BackBtn);
                
                
            BackBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                BookingDetFrame.dispose();
                new AdminAccess();
            }
                });
              try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
                String q="select * from Bookingdetails";
                PreparedStatement p=connection.prepareStatement(q);
                ResultSet rs=p.executeQuery();
                BookingDetTable.setModel(DbUtils.resultSetToTableModel(rs));
                
                BGImage = new JLabel("");
                BGImage.setIcon(new ImageIcon("E:\\TemplateAdmin.jpeg"));
                BGImage.setBounds(0, 0, 984, 607);
                BookingDetFrame.getContentPane().add(BGImage);
                connection.close();
               
                
                            
            }
            catch(Exception e1)
            {
                System.out.println(e1);
                
            }

               

		
		BookingDetFrame.setVisible(true);
	}
	/**
	 * @return the table
	 */
	public JTable getTable() {
		return BookingDetTable;
	}
	/**
	 * @param table the table to set
	 */
	public void setTable(JTable table) {
		this.BookingDetTable = table;
	}
	public static void main(String args[])
	{
		new BookingDetails();
	}
	
}

