package mainPackage;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Payment {

	Payment()
	{
		final JFrame frame = new JFrame("Payment through Google Pay");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(800, 643);
		frame.getContentPane().setLayout(null);
		final JFXPanel fxpanel = new JFXPanel();
		fxpanel.setBounds(10, 11, 764, 535);
		frame.getContentPane().add(fxpanel);
		
		JButton BackBtn = new JButton("BACK");
		BackBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		BackBtn.setBounds(337, 570, 89, 23);
		frame.getContentPane().add(BackBtn);
		
		/*JButton BackBtn = new JButton("BACK");
		BackBtn.setBounds(96, 511, 113, 34);
		frame.getContentPane().add(BackBtn);*/

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				WebEngine engine;
				WebView wv = new WebView();
				engine = wv.getEngine();
				fxpanel.setScene(new Scene(wv));
				engine.load("https://pay.google.com/");
			}
		});
		frame.setVisible(true);
	}
	public static void main(String args[]) {
		new Payment();
	}
}	

