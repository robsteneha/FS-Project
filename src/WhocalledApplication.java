import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;

public class WhocalledApplication {

	private JFrame frmWhocalled;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WhocalledApplication window = new WhocalledApplication();
					window.frmWhocalled.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WhocalledApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWhocalled = new JFrame();
		//frmWhocalled.setLocation(screenSize.width/2-frmWhocalled.getSize().width/2,screenSize.height/2-frmWhocalled.getSize().height/2);
		//frmWhocalled.setLocationRelativeTo(null);
		//int x = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		//int y = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		frmWhocalled.setTitle("WHOCALLED");
		frmWhocalled.setBounds(100, 100, 1000, 650);
		frmWhocalled.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWhocalled.setLocationRelativeTo(null);
		frmWhocalled.getContentPane().setLayout(null);
		JButton btnAdminLogin = new JButton("User Login");
		btnAdminLogin.setForeground(Color.BLACK);
		btnAdminLogin.setBackground(Color.LIGHT_GRAY);
		btnAdminLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLoginDialog userLoginDialog = new UserLoginDialog();
				userLoginDialog.setModal(true);
				userLoginDialog.setVisible(true);
			}
		});
		btnAdminLogin.setBounds(610, 379, 214, 62);
		frmWhocalled.getContentPane().add(btnAdminLogin);
		
		JButton btnUserLogin = new JButton("Admin Login");
		btnUserLogin.setForeground(Color.BLACK);
		btnUserLogin.setBackground(new Color(192, 192, 192));
		btnUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdminLoginDialog adminLoginDialog = new AdminLoginDialog();
				adminLoginDialog.setModal(true);
				adminLoginDialog.setVisible(true);
			}
		});
		btnUserLogin.setBounds(153, 379, 214, 62);
		frmWhocalled.getContentPane().add(btnUserLogin);
		
		JLabel lblWhocalled = new JLabel("WHOCALLED?");
		lblWhocalled.setForeground(new Color(255, 255, 255));
		lblWhocalled.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblWhocalled.setBounds(367, 128, 276, 98);
		frmWhocalled.getContentPane().add(lblWhocalled);
		
		JLabel lblContentBg = new JLabel("");
		lblContentBg.setBackground(Color.LIGHT_GRAY);
		lblContentBg.setIcon(new ImageIcon("D:\\4ISE1JAVA\\File structures project\\blackBoy.jpg"));
		lblContentBg.setBounds(-153, 0, 1137, 650);
		frmWhocalled.getContentPane().add(lblContentBg);
	}
}
