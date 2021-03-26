package userPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.toedter.calendar.JCalendar;

import mainPackage.FeedbackRating;
import mainPackage.LoginPage;
import selectionPackage.CarOrBike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class BorrowerPage
{
	private JTextField UsernameTf,LocationTf,ContactNoTf,FromDateTf,ToDateTf,FromTimeTf,ToTimeTf,vehicle_no_tf;
	private JButton FetchBtn,BackBtn;
	private JLabel UsernameLab,vehicle_type_lab,LocationLab,FromLab,ToLab,ContactNoLab;
	private JLabel vehicle_no_lab;
	private JComboBox Type_Of_Vehicles;
    private JCalendar FromCalendar,ToCalendar;
	private JSpinner FromSpinner,ToSpinner;

	String vehicleNumber,UserName, contactNumber,User;
	private JLabel BGImage;
	//private JLabel BGImg;
	
	public BorrowerPage( String VehicleNumber, String username, String contact,String user )
	{

			this.vehicleNumber = VehicleNumber;
            this.UserName = username;
            this.contactNumber = contact;
            this.User=user;
            	
			JFrame BorrowerFrame = new JFrame("Borrower details..");
			BorrowerFrame.setForeground(new Color(255, 255, 255));
			
			Font LabelFont=new Font("Footlight MT Light", Font.BOLD, 16);
			Font ButtonFont=new Font("Bell MT", Font.PLAIN, 16);
			
			BorrowerFrame.setResizable(false);
			BorrowerFrame.setEnabled(true);
			BorrowerFrame.setSize(805,600);
			BorrowerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			BorrowerFrame.getContentPane().setLayout(null);
			
		        UsernameLab = new JLabel("Username");
		        UsernameLab.setFont(LabelFont);
			UsernameLab.setBounds(86, 83, 104, 14);
			BorrowerFrame.getContentPane().add(UsernameLab);
			
			UsernameTf = new JTextField();
			UsernameTf.setText(user);
			UsernameTf.setEditable(false);
			UsernameTf.setBounds(250, 80, 170, 20);
			BorrowerFrame.getContentPane().add(UsernameTf);
			
			ContactNoLab = new JLabel("Contact Number");
			ContactNoLab.setBounds(86, 188,129, 17);
			ContactNoLab.setFont(LabelFont);
			BorrowerFrame.getContentPane().add(ContactNoLab);
			
			
			ContactNoTf = new JTextField();
			ContactNoTf.setBounds(250,186, 170, 20);
			BorrowerFrame.getContentPane().add(ContactNoTf);
			
			FromLab = new JLabel("From");
			FromLab.setBounds(10, 258, 104, 14);
			FromLab.setFont(LabelFont);
			BorrowerFrame.getContentPane().add(FromLab);
			
			FromCalendar = new JCalendar();
			FromCalendar.setBounds(101, 268, 247, 169);
			BorrowerFrame.getContentPane().add(FromCalendar);
			
			FromDateTf = new JTextField();
			FromDateTf.setEditable(false);
			FromDateTf.setBounds(86, 460, 136, 20);
			BorrowerFrame.getContentPane().add(FromDateTf);
			
			Date from_date_model=new Date();
			SpinnerDateModel from_sm=new SpinnerDateModel(from_date_model,null,null,Calendar.HOUR_OF_DAY);
			FromSpinner = new JSpinner(from_sm);
			FromCalendar.getYearChooser().add(FromSpinner, BorderLayout.EAST);
			JSpinner.DateEditor de_FromSpinner=new JSpinner.DateEditor(FromSpinner, "H:mm:ss");
			FromSpinner.setEditor(de_FromSpinner);

            					
			SimpleDateFormat date_format=new SimpleDateFormat("dd/MM/yyyy");
			FromCalendar.addPropertyChangeListener(new PropertyChangeListener() {
                                @Override
				public void propertyChange(PropertyChangeEvent e) {
					 Date from_date=FromCalendar.getDate();
					 String format_from_date=date_format.format(from_date);
		             FromDateTf.setText(format_from_date);
		          }
			});
			
		  FromSpinner.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				String from_time=FromSpinner.getModel().getValue().toString();
				FromTimeTf.setText(from_time.substring(11,19));
			}  
		  });
			
			ToLab = new JLabel("To");
			ToLab.setBounds(374, 258, 46, 14);
			ToLab.setFont(LabelFont);
			BorrowerFrame.getContentPane().add(ToLab);
			
			ToCalendar = new JCalendar();
			ToCalendar.setBounds(430, 268, 258, 169);
			BorrowerFrame.getContentPane().add(ToCalendar);
			
			Date to_date_model=new Date();
			SpinnerDateModel to_sm=new SpinnerDateModel(to_date_model,null,null,Calendar.HOUR_OF_DAY);
			ToSpinner = new JSpinner(to_sm);
			ToCalendar.getYearChooser().add(ToSpinner, BorderLayout.EAST);
			JSpinner.DateEditor de_ToSpinner=new JSpinner.DateEditor(ToSpinner, "H:mm:ss");
			ToSpinner.setEditor(de_ToSpinner);
			
			ToCalendar.addPropertyChangeListener(new PropertyChangeListener() {
                                @Override
				public void propertyChange(PropertyChangeEvent e) {
					 Date to_date=ToCalendar.getDate();
					  String format_to_date=date_format.format(to_date);
		              ToDateTf.setText(format_to_date);
		          }
			});
			
			ToSpinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent arg0) {
					String to_time=ToSpinner.getModel().getValue().toString();
					ToTimeTf.setText(to_time.substring(11,19));	
				}
				  
			  });
					
				FetchBtn = new JButton("BOOK");
				FetchBtn.setBounds(608, 516, 112, 23);
				BorrowerFrame.getContentPane().add(FetchBtn);
				FetchBtn.setFont(ButtonFont);
				JButton LogoutBtn = new JButton("LOGOUT");
				LogoutBtn.setBounds(374, 516, 123, 23);
				BorrowerFrame.getContentPane().add(LogoutBtn);
				LogoutBtn.setFont(ButtonFont);
				LogoutBtn.addActionListener(new ActionListener() {
                                        @Override
					public void actionPerformed(ActionEvent arg0) {
						BorrowerFrame.dispose();
						new LoginPage();

					}
				});

				BackBtn = new JButton("BACK");
				BackBtn.setFont(ButtonFont);
				BackBtn.addActionListener(new ActionListener() {
                                        @Override
					public void actionPerformed(ActionEvent arg0) {
						BorrowerFrame.dispose();
						new CarOrBike("");

					}
				});
				BackBtn.setBounds(147, 516, 112, 23);
				BorrowerFrame.getContentPane().add(BackBtn);

				FromTimeTf = new JTextField();
				FromTimeTf.setEditable(false);
				FromTimeTf.setBounds(262, 460, 86, 20);
				BorrowerFrame.getContentPane().add(FromTimeTf);

				ToTimeTf = new JTextField();
				ToTimeTf.setEditable(false);
				ToTimeTf.setBounds(590, 460, 86, 20);
				BorrowerFrame.getContentPane().add(ToTimeTf);

				ToDateTf = new JTextField();
				ToDateTf.setEditable(false);
				ToDateTf.setBounds(431, 460, 136, 20);
				BorrowerFrame.getContentPane().add(ToDateTf);

				LocationTf = new JTextField();
				LocationTf.setBounds(250, 137, 170, 20);
				BorrowerFrame.getContentPane().add(LocationTf);
			
				LocationLab = new JLabel("Location");
				LocationLab.setFont(LabelFont);
				LocationLab.setBounds(86, 140, 100, 14);
				BorrowerFrame.getContentPane().add(LocationLab);

				BGImage = new JLabel("");
				BGImage.setIcon(new ImageIcon("E:\\AppTemplate.jpeg"));
				BGImage.setBounds(0, 0, 789, 574);
				BorrowerFrame.getContentPane().add(BGImage);
				BorrowerFrame.setVisible(true);

				FetchBtn.addActionListener(new ActionListener() {
                                        @Override
					public void actionPerformed(ActionEvent e) {
						int flag = 1;
						String location = LocationTf.getText();
						if (!location_isValid(location)) {
							flag = 0;
							JOptionPane.showMessageDialog(BorrowerFrame, "Enter the valid location");
						}
						String contact = ContactNoTf.getText();
						if (!mobile_isValid(contact)) {
							flag = 0;
							JOptionPane.showMessageDialog(BorrowerFrame, "Enter the valid contact number");
						}
						String fromtime = FromTimeTf.getText();
						String totime = ToTimeTf.getText();
						if (!fromtime_isValid(fromtime)) {
							flag = 0;
							JOptionPane.showMessageDialog(BorrowerFrame, "Enter the valid From Time");
						}
						if (!totime_isValid(fromtime)) {
							flag = 0;
							JOptionPane.showMessageDialog(BorrowerFrame, "Enter the valid To Time");
						}

						try {

							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project",
									"Bootathon", "12345678");
							Statement statement = connection.createStatement();
							// String username=UsernameTf.getText();
							//String BrwrEmail="select EmailAddress from register where Username=username";	
							
							// String vehicletype= Type_Of_Vehicles.getSelectedItem().toString();
							String fromdate = FromDateTf.getText();
							String todate = ToDateTf.getText();

							String query2 = "select * from Register where Username=? ";
							PreparedStatement statement1 = connection.prepareStatement(query2);
							statement1.setString(1, username);

							ResultSet rs = statement1.executeQuery();
							if (rs.next()) {
								String query = "insert into Borrower values('" + User + "','" + contact + "','"
										+ location + "','" + fromdate + "','" + todate + "','" + fromtime + "','"
										+ totime + "')";
								statement.executeUpdate(query);
								String query1 = "insert into bookingdetails values('" + UserName + "','" + contactNumber
										+ "','" + vehicleNumber + "','" + fromdate + "','" + User + "','" + contact
										+ "')";
								statement.executeUpdate(query1);
								String query3 = "update Lender set Availability='Not Available' where Username=?";
								PreparedStatement statement2 = connection.prepareStatement(query3);
								statement2.setString(1, User);
								statement2.execute();
	
								 JOptionPane.showMessageDialog(BorrowerFrame, "Booked Succesfully");
								 JOptionPane.showMessageDialog(BorrowerFrame, "Check your mail to know about your booking details");
								    String LenderConNo=contactNumber;
								    String LenderQuery="select EmailAddress as LE from Register where Username=?";	
	                                PreparedStatement statement11=connection.prepareStatement(LenderQuery); 
	                                statement11.setString(1,UserName);
	                                statement11.execute();
	                                ResultSet rs1 = statement11.executeQuery();
	                                String LendEmail="";
	                                String BrwrEmail="";
	                                if(rs1.next())
	                                {
	                                	LendEmail=rs1.getString(1);
	                                }
	                                String Lender=UserName;
	                                 String BrwrQuery="select EmailAddress as BE from Register where Username=?";
									 PreparedStatement statement13=connection.prepareStatement(BrwrQuery);
									 statement13.setString(1,User);
									 statement13.execute();
									 ResultSet rs2 = statement13.executeQuery();
								     if(rs2.next())
								     {
								        BrwrEmail=rs2.getString(1);
								     }
								     String BrwrConNo=ContactNoTf.getText();
								     String Borrower=User;
								     BookingMail.SendEmail(Lender, LenderConNo, LendEmail, Borrower,BrwrConNo,BrwrEmail);
								     //System.out.println(LenderConNo+"  "+LendEmail+" "+BrwrConNo+"  "+BrwrEmail);
								     //mainPackage.Email.SendEmail(recipient, name);
								connection.close();
								new FeedbackRating();
							} else {
								JOptionPane.showMessageDialog(BorrowerFrame, "Enter valid username ");

							}
                           
						} catch (Exception e1) {
							System.out.print(e1);
						}
					}
				});
			}

			public static boolean location_isValid(String str) {
				try {
					if (str.isEmpty())
						return false;
					else
						return true;

				} catch (Exception e) {

				}
				return false;
			}

			public static boolean mobile_isValid(String str) {
				try {
					if (str.isEmpty())
						return false;
					else {
						String regex = "^91[6-9][0-9]{9}$";
						Pattern p = Pattern.compile(regex);
						Matcher m = p.matcher(str);
						return m.matches();
					}
				} catch (Exception e) {

				}
				return false;
			}

			public static boolean fromtime_isValid(String str) {
				try {
					if (str.isEmpty()) {
						return false;
					} else {
						return true;
					}

				} catch (Exception e) {

				}
				return false;
			}

			public static boolean totime_isValid(String str) {
				try {
					if (str.isEmpty()) {
						return false;
					} else {
						return true;
					}

				} catch (Exception e) {

				}
				return false;
			}

   

			/**
			 * @return the username_tf
			 */
			public JTextField getUsername_tf() {
				return UsernameTf;
			}

			/**
			 * @param username_tf the username_tf to set
			 */
			public void setUsername_tf(JTextField username_tf) {
				this.UsernameTf = username_tf;
			}

			/**
			 * @return the location_tf
			 */
			public JTextField getLocation_tf() {
				return LocationTf;
			}

			/**
			 * @param location_tf the location_tf to set
			 */
			public void setLocation_tf(JTextField location_tf) {
				this.LocationTf = location_tf;
			}

			/**
			 * @return the brand_name_tf
			 */
			public JTextField getContact_no_tf() {
				return ContactNoTf;
			}

			/**
			 * @param contact_no_tf the brand_name_tf to set
			 */
			public void setContact_no_tf(JTextField contact_no_tf) {
				this.ContactNoTf = contact_no_tf;
			}

			/**
			 * @return the vehicle_no_tf
			 */
			public JTextField getVehicle_no_tf() {
				return vehicle_no_tf;
			}

			/**
			 * @param vehicle_no_tf the vehicle_no_tf to set
			 */
			public void setVehicle_no_tf(JTextField vehicle_no_tf) {
				this.vehicle_no_tf = vehicle_no_tf;
			}

			public static void main(String args[]) {
				System.out.println("tssdjg");
				new BorrowerPage("", "", "", "");
			}

		}
