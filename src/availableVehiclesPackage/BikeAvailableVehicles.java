/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package availableVehiclesPackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import selectionPackage.CarOrBike;
import userPackage.BorrowerPage;
import javax.swing.ImageIcon;

public class BikeAvailableVehicles {

	private JFrame frame;
	private JTable table;
	private JTextField veh_no_tf,username_tf,contact_tf;
	String User;
	public BikeAvailableVehicles(String user){
		this.User=user;
		frame = new JFrame("BIKE AVAILABLE VEHICLES");
	        frame.setSize(800,600);
                frame.setResizable(false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 158, 719, 133);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
               // String cols[]={"Username", "Location", "Vehicle Number", "Brand  Name", "Rent for an hour"};
      // DefaultTableModel tmodel=new DefaultTableModel(null,cols);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Username", "Location", "Vehicle Number", "Vehicle Model", "Contact Number", "Rent for an hour","Availability"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(89);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(2).setPreferredWidth(104);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(103);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setPreferredWidth(131);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setPreferredWidth(97);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(29, 384, 722, 105);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		 String Type[] = { "Chennai", "Coimbatore", "Madurai", "Tiruppur", "Tuticorin" };
			JComboBox ComboBox = new JComboBox(Type);
			ComboBox.setBounds(370, 85, 182, 22);
			frame.getContentPane().add(ComboBox);
			
			JLabel LocationLab = new JLabel("Select your Location");
			LocationLab.setFont(new Font("Tahoma", Font.PLAIN, 20));
			LocationLab.setBounds(32, 85, 340, 22);
			frame.getContentPane().add(LocationLab);

			String city=(String) ComboBox.getSelectedItem();
			//System.out.println(city);
			
			JButton SearchBtn = new JButton("SEARCH");
			SearchBtn.addActionListener(new ActionListener() {
                                @Override
				public void actionPerformed(ActionEvent e) {
					
					String q=new String("");
					if(ComboBox.getSelectedItem()=="Chennai")
					{
						
			               q="select Username,Location,Vehicle_no,Vehicle_model,Contact_no,Rent from Lender "
			                		+ "where Vehicle_type='bike' and Availability='Available' and Location='Chennai'";
			                
					}
					if(ComboBox.getSelectedItem()=="Coimbatore")
					{
						
			               q="select Username,Location,Vehicle_no,Vehicle_model,Contact_no,Rent from Lender "
			                		+ "where Vehicle_type='bike' and Availability='Available' and Location='Coimbatore'";
			                
					}
					if(ComboBox.getSelectedItem()=="Madurai")
					{
						
			               q="select Username,Location,Vehicle_no,Vehicle_model,Contact_no,Rent from Lender "
			                		+ "where Vehicle_type='bike' and Availability='Available' and Location='Madurai'";
			                
					}
					if(ComboBox.getSelectedItem()=="Tiruppur")
					{
						
			               q="select Username,Location,Vehicle_no,Vehicle_model,Contact_no,Rent from Lender "
			                		+ "where Vehicle_type='bike' and Availability='Available' and Location='Tiruppur'";
			                
					}
					if(ComboBox.getSelectedItem()=="Tuticorin")
					{
						
			               q="select Username,Location,Vehicle_no,Vehicle_model,Contact_no,Rent from Lender "
			                		+ "where Vehicle_type='bike' and Availability='Available' and Location='Tuticorin'";
			                
					}
					
					  try{
			                Class.forName("com.mysql.jdbc.Driver");
			                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
			                PreparedStatement p=connection.prepareStatement(q);
			                ResultSet rs=p.executeQuery();
			                table.setModel(DbUtils.resultSetToTableModel(rs));
			                connection.close();                     
			            }
			            catch(Exception e1)
			            {
			                System.out.println(e1);
			                
			            }
				}
			});
			SearchBtn.setBounds(604, 85, 114, 22);
			frame.getContentPane().add(SearchBtn);
			
//                try{
//                Class.forName("com.mysql.jdbc.Driver");
//                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
//                String q="select Username,Location,Vehicle_no,Vehicle_model,Contact_no,Rent from Lender where Vehicle_type='bike' and Availability='Available'";
//                PreparedStatement p=connection.prepareStatement(q);
//                ResultSet rs=p.executeQuery();
//                table.setModel(DbUtils.resultSetToTableModel(rs));
//                connection.close();
//               
//                
//                            
//            }
//            catch(Exception e1)
//            {
//                System.out.println(e1);
//                
//            }
			
                veh_no_tf = new JTextField();
                veh_no_tf.setEditable(false);
        		veh_no_tf.setBounds(95, 36, 140, 20);
        		panel.add(veh_no_tf);
		
                
        username_tf = new JTextField();
        username_tf.setEditable(false);
		username_tf.setBounds(292, 36, 140, 20);
		panel.add(username_tf);
                
        contact_tf = new JTextField();
        contact_tf.setEditable(false);
		contact_tf.setBounds(480, 36, 140, 20);
		panel.add(contact_tf);
		
                table.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                    	//DefaultTableModel model = (DefaultTableModel)table.getModel();	
                    	
                    	int vno_row=table.getSelectedRow();
                	    int vno_col=2;
                		String sel_vno=table.getModel().getValueAt(vno_row,vno_col).toString();
                		veh_no_tf.setText(sel_vno);
                		
                		int uname_row=table.getSelectedRow();
                	    int uname_col=0;
                		String sel_uname=table.getModel().getValueAt(uname_row,uname_col).toString();
                		username_tf.setText(sel_uname);
                		
                		int cno_row=table.getSelectedRow();
                	    int cno_col=4;
                		String sel_cno=table.getModel().getValueAt(cno_row,cno_col).toString();
                		contact_tf.setText(sel_cno);
               
                    }
                });
 
                
		
		JButton okay_btn = new JButton("GO");
		okay_btn.setBounds(416, 71,100, 23);
		panel.add(okay_btn);
                
                  okay_btn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
                            String vehicleNum = veh_no_tf.getText();
                            String userName = username_tf.getText();
                            String contactNumber = contact_tf.getText();
                             try
                            {
                                Class.forName("com.mysql.jdbc.Driver"); 
                                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Project","Bootathon","12345678");
                                String query2="select * from Lender where Vehicle_no=? and Username=? and Contact_no=?";
                                PreparedStatement statement=connection.prepareStatement(query2);
                                statement.setString(1,vehicleNum);
                                statement.setString(2,userName);
                                statement.setString(3,contactNumber);
                                
                                
                                
                                
                                ResultSet rs=statement.executeQuery();
                                if(rs.next())
                                {
                                    
                                  frame.dispose();
			                      new BorrowerPage( vehicleNum,userName,contactNumber,User );
                                    
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(frame,"Enter valid details");

                                }

                            }
                            catch(Exception e1)
                                    {
                                        System.out.println(e1);
                                    }
                           
                            
                          
			  
			}
		});

            JButton back_btn = new JButton("BACK");
			back_btn.addActionListener(new ActionListener() {
                                @Override
				public void actionPerformed(ActionEvent arg0) {
					frame.dispose();
                                        new CarOrBike("");
                                }
			});
			back_btn.setBounds(216, 71,100, 23);
			panel.add(back_btn);
			
			JLabel vehno_lab = new JLabel("Vehicle Number");
			vehno_lab.setBounds(123, 11, 112, 14);
			panel.add(vehno_lab);
			
			JLabel uname_lab = new JLabel("Username");
			uname_lab.setBounds(330, 11, 81, 14);
			panel.add(uname_lab);
			
			JLabel con_lab = new JLabel("Contact Number");
			con_lab.setBounds(480, 11, 145, 14);
			panel.add(con_lab);
			
			JLabel sel_lab = new JLabel("Selected \r\n");
			sel_lab.setBounds(10, 11, 64, 29);
			panel.add(sel_lab);
			
			JLabel velab = new JLabel("Vehicle\r\n");
			velab.setBounds(10, 39, 64, 14);
			panel.add(velab);
			
			JLabel det_lab = new JLabel("Details");
			det_lab.setBounds(10, 60, 46, 14);
			panel.add(det_lab);
			
			JLabel BGImage = new JLabel("");
			BGImage.setIcon(new ImageIcon("E:\\AppTemplate.jpeg"));
			BGImage.setBounds(0, 0, 784, 592);
			frame.getContentPane().add(BGImage);

		frame.setVisible(true);
	}
	public static void main(String[] args)
	{
		new BikeAvailableVehicles("");
	}
}
