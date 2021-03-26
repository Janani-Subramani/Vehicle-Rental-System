package mainPackage;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Button;


public class HomePage 
{
	private JFrame HomeFrame;
	private JButton LoginBtn,RegisterBtn;
	private JLabel BGImage;
	public HomePage()
	{
		HomeFrame = new JFrame("Welcome!!!");
		HomeFrame.setTitle("Welcome Youu!!!");
		HomeFrame.setResizable(false);
		HomeFrame.setSize(800,500);
		HomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HomeFrame.getContentPane().setLayout(null);
		
		Font GrandFont=new Font("Rockwell", Font.PLAIN, 20);
		
		RegisterBtn = new JButton();
		RegisterBtn.setBackground(new Color(255, 0, 0));
		RegisterBtn.setForeground(new Color(255, 255, 255));
		RegisterBtn.setFont(GrandFont);
		RegisterBtn.setText("REGISTER");
		RegisterBtn.setBounds(589,315,163,30);
		HomeFrame.getContentPane().add(RegisterBtn);
                
               RegisterBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
             HomeFrame.dispose();
			  new RegistrationPage();
			  
			}
		});     
                
                JLabel RegisterLab = new JLabel("Don't have an account?");
                RegisterLab.setFont(new Font("Tahoma", Font.PLAIN, 19));
                RegisterLab.setBounds(568,252,260,30);
                HomeFrame.getContentPane().add(RegisterLab);
                
               LoginBtn=new JButton();
               LoginBtn.setBackground(new Color(255, 0, 0));
               LoginBtn.setForeground(new Color(255, 255, 255));
               LoginBtn.setFont(GrandFont);
               LoginBtn.setText("LOGIN");
                LoginBtn.setBounds(614,170,106,48);  
                HomeFrame.getContentPane().add(LoginBtn);
                
                BGImage = new JLabel("");
                BGImage.setIcon(new ImageIcon("E:\\final2.jpg"));
                
                BGImage.setBounds(0, -225, 786, 939);
                HomeFrame.getContentPane().add(BGImage);
                
                LoginBtn.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) 
			{
              HomeFrame.dispose();
			  new LoginPage();
			  
			}
		});

		
		HomeFrame.setVisible(true);
	}
	public static void main(String[] args)
	{
		new HomePage();
	}
}

