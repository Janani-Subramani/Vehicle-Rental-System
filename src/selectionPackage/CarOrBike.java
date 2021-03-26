/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selectionPackage;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import availableVehiclesPackage.BikeAvailableVehicles;
import availableVehiclesPackage.BikeAvailableVehicles;
import availableVehiclesPackage.CarAvailableVehicles;
import mainPackage.LoginPage;


public class CarOrBike {
	private JFrame CarOrBikeFrame;
	private JLabel CarLab, BikeLab;
	private JButton CarImg, BikeImg, BackBtn;
	private JLabel BGImage;
	String User;
	public CarOrBike(String user) {
		this.User=user;

		CarOrBikeFrame = new JFrame("Vehicle Type");

		Icon car_img = new ImageIcon("E:\\car1.png");
		CarImg = new JButton(car_img);
		CarImg.setBounds(88, 219, 213, 131);
		CarOrBikeFrame.getContentPane().add(CarImg);
		CarLab = new JLabel("CAR");
		CarLab.setBounds(157, 361, 75, 30);
		CarLab.setFont(new Font("Bell MT", Font.PLAIN, 20));
		CarOrBikeFrame.getContentPane().add(CarLab);

		Icon bike_img = new ImageIcon("E:\\bike1.png");
		BikeImg = new JButton(bike_img);
		BikeImg.setBounds(459, 219, 204, 131);
		CarOrBikeFrame.getContentPane().add(BikeImg);
		BikeLab = new JLabel("BIKE");
		BikeLab.setBounds(537, 361, 80, 30);
		BikeLab.setFont(new Font("Bell MT", Font.PLAIN, 20));
		CarOrBikeFrame.getContentPane().add(BikeLab);

		BackBtn = new JButton("BACK");
		BackBtn.setBounds(323, 447, 100, 30);
		CarOrBikeFrame.getContentPane().add(BackBtn);

		CarOrBikeFrame.setSize(800, 583);
		CarOrBikeFrame.getContentPane().setLayout(null);
		
		BGImage = new JLabel("");
		BGImage.setIcon(new ImageIcon("E:\\AppTemplate.jpeg"));
		BGImage.setBounds(0, 0, 784, 579);
		CarOrBikeFrame.getContentPane().add(BGImage);
		CarOrBikeFrame.setVisible(true);
		CarOrBikeFrame.setResizable(false);
		BackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CarOrBikeFrame.dispose();
				new LoginPage();
			}
		});

		BikeImg.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CarOrBikeFrame.dispose();
				new BikeAvailableVehicles(User);
			}
		});
		CarImg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CarOrBikeFrame.dispose();
				new CarAvailableVehicles(User);
			}
		});

	}
    public static void main(String args[])
    {
    	new CarOrBike("");
    }

    
	
}
