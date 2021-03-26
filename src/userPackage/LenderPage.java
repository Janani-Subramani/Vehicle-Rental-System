/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userPackage;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import com.toedter.calendar.JCalendar;

import mainPackage.FeedbackRating;
import mainPackage.LoginPage;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Color;

public class LenderPage
{
	private JTextField UsernameTf,RcNumberTf,VehicleNumberTf,LocationTf ,BrandTf,FromDateTf,ToDateTf,FromTimeTf,ToTimeTf,PaymentTf;
	private JButton ProceedBtn,BackBtn;
	private JLabel UsernameLab,RcNumberLab,VehicleTypeLab,LocationLab,VehicleNumberLab,BrandNameLab,FromLab,ToLab,RentLab,ContactNoLab;
	private JComboBox VehiclesTypeCbox;
	
	private JCalendar FromCalendar,ToCalendar;
	private JSpinner FromSpinner,ToSpinner;
	private JTextField ContactNoTfs;
	private JLabel lblNewLabel;
	String User;
	public LenderPage(String user)
	{
		    this.User=user;
		
			JFrame LenderFrame = new JFrame("Lender Details");
			LenderFrame.setResizable(false);
			LenderFrame.setEnabled(true);
			LenderFrame.setSize(800,600);
            //lender_frame.setBounds(100, 100, 809, 601);
			Font LabelFont=new Font("Footlight MT Light", Font.BOLD, 16);
			Font ButtonFont=new Font("Century", Font.PLAIN, 16);
			
			LenderFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			LenderFrame.getContentPane().setLayout(null);
			
		     UsernameLab = new JLabel("Username");
		     UsernameLab.setForeground(new Color(0, 0, 0));
			UsernameLab.setBounds(40, 83, 112, 14);
			UsernameLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(UsernameLab);
			
			UsernameTf = new JTextField();
			UsernameTf.setText(User);
		  UsernameTf.setEditable(false);
			UsernameTf.setBounds(224, 80, 170, 20);
			LenderFrame.getContentPane().add(UsernameTf);
			
			RcNumberLab = new JLabel("RC Number");
			RcNumberLab.setBounds(40, 127, 136, 20);
			RcNumberLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(RcNumberLab);
			
			RcNumberTf = new JTextField();
			RcNumberTf.setBounds(224, 127, 170, 20);
			LenderFrame.getContentPane().add(RcNumberTf);
			
			VehicleTypeLab = new JLabel("Vehicle Type");
			VehicleTypeLab.setBounds(40, 221, 112, 17);
			VehicleTypeLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(VehicleTypeLab);
                        
			String Type[] = { "car", "bike" };
			VehiclesTypeCbox = new JComboBox(Type);
			VehiclesTypeCbox.setBounds(224, 219, 170, 20);
			LenderFrame.getContentPane().add(VehiclesTypeCbox);
			
			
			
			LocationLab = new JLabel("Location");
			//LocationLab.setForeground(new Color(255, 255, 255));
			LocationLab.setBounds(430, 175, 80, 14);
			LocationLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(LocationLab);
			
			
			LocationTf = new JTextField();
			LocationTf.setBounds(578, 172, 170, 20);
			LenderFrame.getContentPane().add(LocationTf);

			VehicleNumberLab = new JLabel("Vehicle Number");
			VehicleNumberLab.setBounds(40, 172, 136, 20);
			VehicleNumberLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(VehicleNumberLab);

			VehicleNumberTf = new JTextField();
			VehicleNumberTf.setColumns(10);
			VehicleNumberTf.setBounds(224, 172, 170, 17);
			LenderFrame.getContentPane().add(VehicleNumberTf);

			BrandNameLab = new JLabel("Vehicle Model");
			//BrandNameLab.setForeground(new Color(255, 255, 255));
			BrandNameLab.setBounds(430, 130, 119, 14);
			BrandNameLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(BrandNameLab);

			BrandTf = new JTextField();
			BrandTf.setBounds(578, 127, 170, 20);
			LenderFrame.getContentPane().add(BrandTf);

			FromLab = new JLabel("From");
			FromLab.setBounds(40, 265, 104, 14);
			FromLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(FromLab);

			FromCalendar = new JCalendar();
			FromCalendar.setBounds(101, 275, 247, 135);
			LenderFrame.getContentPane().add(FromCalendar);

			FromDateTf = new JTextField();
			FromDateTf.setEditable(false);
			FromDateTf.setBounds(101, 421, 136, 20);
			LenderFrame.getContentPane().add(FromDateTf);

			Date from_date_model = new Date();
			SpinnerDateModel from_sm = new SpinnerDateModel(from_date_model, null, null, Calendar.HOUR_OF_DAY);
			FromSpinner = new JSpinner(from_sm);
			FromCalendar.getYearChooser().add(FromSpinner, BorderLayout.EAST);
			JSpinner.DateEditor de_FromSpinner = new JSpinner.DateEditor(FromSpinner, "H:mm:ss");
			FromSpinner.setEditor(de_FromSpinner);

			SimpleDateFormat date_format = new SimpleDateFormat("dd/MM/yyyy");
			FromCalendar.addPropertyChangeListener(new PropertyChangeListener() {
                                @Override
				public void propertyChange(PropertyChangeEvent e) {
					Date from_date = FromCalendar.getDate();
					String format_from_date = date_format.format(from_date);
					FromDateTf.setText(format_from_date);
				}
			});

			FromSpinner.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent arg0) {
					String from_time = FromSpinner.getModel().getValue().toString();
					FromTimeTf.setText(from_time.substring(11, 19));
				}
			});

			ToLab = new JLabel("To");
			ToLab.setBounds(379, 265, 46, 14);
			ToLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(ToLab);

			ToCalendar = new JCalendar();
			ToCalendar.setBounds(430, 273, 258, 135);
			LenderFrame.getContentPane().add(ToCalendar);

			Date to_date_model = new Date();
			SpinnerDateModel to_sm = new SpinnerDateModel(to_date_model, null, null, Calendar.HOUR_OF_DAY);
			ToSpinner = new JSpinner(to_sm);
			ToCalendar.getYearChooser().add(ToSpinner, BorderLayout.EAST);
			JSpinner.DateEditor de_ToSpinner = new JSpinner.DateEditor(ToSpinner, "H:mm:ss");
			ToSpinner.setEditor(de_ToSpinner);

			ToCalendar.addPropertyChangeListener(new PropertyChangeListener() {
                                @Override
				public void propertyChange(PropertyChangeEvent e) {
					Date to_date = ToCalendar.getDate();
					String format_to_date = date_format.format(to_date);
					ToDateTf.setText(format_to_date);
				}
			});

			ToSpinner.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent arg0) {
					String to_time = ToSpinner.getModel().getValue().toString();
					ToTimeTf.setText(to_time.substring(11, 19));
				}

			});

			RentLab = new JLabel("Rent expected for an hour RS:");
			RentLab.setBounds(40, 466, 247, 22);
			RentLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(RentLab);

			PaymentTf = new JTextField();

			PaymentTf.setBounds(358, 463, 136, 29);
			LenderFrame.getContentPane().add(PaymentTf);

			ProceedBtn = new JButton("PROCEED");
			ProceedBtn.addActionListener(new ActionListener() {
                                @Override
				public void actionPerformed(ActionEvent e) {
					String rcnum = RcNumberTf.getText();
					String vnum = VehicleNumberTf.getText();
					int flag = 1;
					if (!RcNoIsValid(rcnum)) {
						flag = 0;
						JOptionPane.showMessageDialog(LenderFrame, "Enter a valid Registration Number !! ");
					}
					if (!vehicleno_isValid(vnum)) {
						flag = 0;
						JOptionPane.showMessageDialog(LenderFrame, "Enter a valid Vehicle Number !! ");
					}
					String mobile_str = ContactNoTfs.getText();
					if (!MobileIsValid(mobile_str)) {
						flag = 0;
						JOptionPane.showMessageDialog(LenderFrame, "Enter a valid Contact Number !! ");
					}
					String brand_name = BrandTf.getText();
					if (!BrandNameIsValid(brand_name)) {
						flag = 0;
						JOptionPane.showMessageDialog(LenderFrame, "Enter a valid Vehicle Model !! ");

					}
					String Location = LocationTf.getText();
					if (!LocationIsValid(Location)) {
						flag = 0;
						JOptionPane.showMessageDialog(LenderFrame, "Enter a valid Location !! ");

					}
					String From_time = FromTimeTf.getText();

					String to_time = ToTimeTf.getText();

					if (!FromTimeIsValid(From_time)) {
						flag = 0;
						JOptionPane.showMessageDialog(LenderFrame, "Enter a valid From Time !! ");

					}
					if (!ToTimeIsValid(to_time)) {
						flag = 0;
						JOptionPane.showMessageDialog(LenderFrame, "Enter a valid To Time !! ");
					}
					String rent = PaymentTf.getText();
					if (!RentIsValid(to_time)) {
						flag = 0;
						JOptionPane.showMessageDialog(LenderFrame, "Enter a valid expected rent !! ");
					}

					if (flag == 1) {
						try {

							Class.forName("com.mysql.jdbc.Driver");
							Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Project",
									"Bootathon", "12345678");
							Statement statement = connection.createStatement();
							//String Username = UsernameTf.getText();
							String vehicletype = VehiclesTypeCbox.getSelectedItem().toString();

							String From_date = FromDateTf.getText();
							String to_date = ToDateTf.getText();
							String Available="Available";

							String Contact_no = ContactNoTfs.getText();
							String query2 = "select * from Register where Username=? ";
							PreparedStatement statement1 = connection.prepareStatement(query2);
							statement1.setString(1, User);

							ResultSet rs = statement1.executeQuery();
							if (rs.next()) {

								String query = "insert into Lender values('" + User + "','" + Contact_no + "','"
										+ rcnum + "','" + brand_name + "','" + vnum + "','" + Location + "','"
										+ vehicletype + "','" + From_date + "','" + to_date + "','" + From_time + "','"
										+ to_time + "','" + rent + "','" + Available + "')";
								statement.executeUpdate(query);
								connection.close();
								JOptionPane.showMessageDialog(LenderFrame, "THANK YOU FOR LENDERING!!!");
								new FeedbackRating();

							} else {
								JOptionPane.showMessageDialog(LenderFrame, "Enter valid Username");
							}

						} catch (Exception e1) {
							System.out.print(e1);
						}

					} else {

					}
				}
			});
			ProceedBtn.setBounds(487, 523, 136, 23);
			ProceedBtn.setFont(ButtonFont);
			LenderFrame.getContentPane().add(ProceedBtn);

			BackBtn = new JButton("LOGOUT");
			BackBtn.addActionListener(new ActionListener() {
                                @Override
				public void actionPerformed(ActionEvent arg0) {
					LenderFrame.dispose();
					new LoginPage();
				}
			});
			BackBtn.setBounds(176, 523, 112, 23);
			BackBtn.setFont(ButtonFont);
			LenderFrame.getContentPane().add(BackBtn);

			FromTimeTf = new JTextField();
			FromTimeTf.setEditable(false);
			FromTimeTf.setBounds(262, 421, 86, 20);
			LenderFrame.getContentPane().add(FromTimeTf);

			ToTimeTf = new JTextField();
			ToTimeTf.setEditable(false);
			ToTimeTf.setBounds(595, 421, 86, 20);
			LenderFrame.getContentPane().add(ToTimeTf);

			ToDateTf = new JTextField();
			ToDateTf.setText("");
			ToDateTf.setEditable(false);
			ToDateTf.setBounds(430, 421, 136, 20);
			LenderFrame.getContentPane().add(ToDateTf);

			ContactNoLab = new JLabel("Contact Number");
			//ContactNoLab.setForeground(new Color(255, 255, 255));
			ContactNoLab.setBounds(430, 83, 136, 14);
			ContactNoLab.setFont(LabelFont);
			LenderFrame.getContentPane().add(ContactNoLab);

			ContactNoTfs = new JTextField();
			ContactNoTfs.setBounds(579, 80, 169, 20);
			LenderFrame.getContentPane().add(ContactNoTfs);
			
			JLabel BGImage = new JLabel("");
			BGImage.setIcon(new ImageIcon("E:\\AppTemplate.jpeg"));
			BGImage.setBounds(0, 0, 784, 573);
			LenderFrame.getContentPane().add(BGImage);
			
			/*BGImage = new JLabel("");
			BGImage.setIcon(new ImageIcon("C:\\Users\\Trini\\Desktop\\Theo\\BootathonImages\\3.0.jpg"));
			BGImage.setBounds(0, 0, 784, 561);
			LenderFrame.getContentPane().add(BGImage);*/

			LenderFrame.setVisible(true);
		}

		public static boolean MobileIsValid(String str) {
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

		public static boolean BrandNameIsValid(String str) {
			try {
				if (str.isEmpty())
					return false;
				else
					return true;

			} catch (Exception e) {

			}
			return false;
		}

		public static boolean RentIsValid(String str) {
			try {
				if (str.isEmpty())
					return false;
				else
					return true;

			} catch (Exception e) {

			}
			return false;
		}

		public static boolean LocationIsValid(String str) {
			try {
				if (str.isEmpty())
					return false;
				else
					return true;

			} catch (Exception e) {

			}
			return false;
		}

		public static boolean FromTimeIsValid(String str) {
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

		public static boolean ToTimeIsValid(String str) {
			try {
				if (str.isEmpty())
					return false;
				else
					return true;

			} catch (Exception e) {

			}
			return false;
		}

		public static boolean RcNoIsValid(String str) {
			if (str.isEmpty())
				return false;
			else {

				String regex = "TN[0-9]{2}[A-Z]{2}[0-9]{4}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(str);
				return m.matches();
			}
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
		 * @return the rc_no_tf
		 */
		public JTextField getRc_no_tf() {
			return RcNumberTf;
		}

		/**
		 * @param rc_no_tf the rc_no_tf to set
		 */
		public void setRc_no_tf(JTextField rc_no_tf) {
			this.RcNumberTf = rc_no_tf;
		}

		/**
		 * @return the vehicle_no_tf
		 */
		public JTextField getVehicle_no_tf() {
			return VehicleNumberTf;
		}

		/**
		 * @param vehicle_no_tf the vehicle_no_tf to set
		 */
		public void setVehicle_no_tf(JTextField vehicle_no_tf) {
			this.VehicleNumberTf = vehicle_no_tf;
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
		 * @return the brand_tf
		 */
		public JTextField getBrand_tf() {
			return BrandTf;
		}

		/**
		 * @param brand_tf the brand_tf to set
		 */
		public void setBrand_tf(JTextField brand_tf) {
			this.BrandTf = brand_tf;
		}

		/**
		 * @return the avail_time_tf
		 */
		public JTextField getAvail_time_tf() {
			return PaymentTf;
		}

		/**
		 * @param avail_time_tf the avail_time_tf to set
		 */
		public void setAvail_time_tf(JTextField avail_time_tf) {
			this.PaymentTf = avail_time_tf;
		}

		/**
		 * @return the contact_no_tf
		 */
		public JTextField getContact_no_tf() {
			return ContactNoTfs;
		}

		/**
		 * @param contact_no_tf the contact_no_tf to set
		 */
		public void setContact_no_tf(JTextField contact_no_tf) {
			this.ContactNoTfs = contact_no_tf;
		}

		public static boolean vehicleno_isValid(String str) {
			if (str == null)
				return false;
			else {

				String regex = "^TN [0-9]{2} [A-Z]{1,2} [0-9]{4}$";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(str);
				return m.matches();
			}
		}
		public static void main(String args[])
		{
			new LenderPage("");
		}	
	}
