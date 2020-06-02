import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class AdminLoginDialog extends JDialog {

	//private static final Stream<String> NULL = null;
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private String adminEmail;
	private String password;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			AdminLoginDialog dialog = new AdminLoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public AdminLoginDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Admin Login");
		setBounds(100, 100, 1000, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblWhocalled = new JLabel("WHOCALLED?");
			lblWhocalled.setForeground(Color.WHITE);
			lblWhocalled.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 26));
			lblWhocalled.setBounds(34, 23, 194, 44);
			contentPanel.add(lblWhocalled);
		}
		{
			JLabel lblNewLabel = new JLabel("Admin Login");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
			lblNewLabel.setBounds(421, 140, 194, 58);
			contentPanel.add(lblNewLabel);
		}
		{
			textFieldUsername = new JTextField();
			textFieldUsername.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldUsername.setToolTipText("");
			textFieldUsername.setBounds(372, 266, 278, 52);
			contentPanel.add(textFieldUsername);
			textFieldUsername.setColumns(10);
		}
		{
			JLabel lblEnterUsername = new JLabel("Enter Email id");
			lblEnterUsername.setForeground(Color.WHITE);
			lblEnterUsername.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterUsername.setHorizontalAlignment(SwingConstants.TRAILING);
			lblEnterUsername.setBounds(191, 285, 139, 14);
			contentPanel.add(lblEnterUsername);
		}
		{
			JLabel lblEnterPassword = new JLabel("Enter Password");
			lblEnterPassword.setForeground(Color.WHITE);
			lblEnterPassword.setHorizontalAlignment(SwingConstants.TRAILING);
			lblEnterPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblEnterPassword.setBounds(182, 398, 148, 14);
			contentPanel.add(lblEnterPassword);
		}
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(372, 380, 278, 52);
		contentPanel.add(passwordField);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Login");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TODO login after authorization
						loginAdmin();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JLabel lblContentBg = new JLabel("");
		lblContentBg.setBackground(Color.LIGHT_GRAY);
		lblContentBg.setIcon(new ImageIcon("D:\\4ISE1JAVA\\File structures project\\blackBoy.jpg"));
		lblContentBg.setBounds(-153, 0, 1137, 650);
		contentPanel.add(lblContentBg);
	}

	private void loginAdmin() {
		// TODO Auto-generated method stub
		adminEmail = textFieldUsername.getText().trim();
		if (adminEmail.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter an email id");
			return;
		}
		else
		{
			//email id is valid 
			if(validateEmail(adminEmail))
			{
				password = String.valueOf(passwordField.getPassword());
				if(password.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Password is empty");
					return;
				}
				//create hashmap
				Stream<String> lines = null;
				HashMap<String, String> adminLogins = new HashMap<>();
				try {
					lines = Files.lines(Paths.get("D:\\4ISE1JAVA\\File structures project\\src\\admins.txt"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(lines!=null)
				{
					lines.forEach(line -> {
						  // Do anything line by line 
						String[] p = line.split(",");
						adminLogins.put(p[0], p[1]);
						});
				}
				//email is valid
				if(adminLogins.containsKey(adminEmail))
				{
					//System.out.println(password+" "+adminLogins.get(adminEmail)+":"+adminLogins.get(adminEmail).equals(password));
					if(adminLogins.get(adminEmail).equals(password))
					{
						//successfullLogin
						AdminHome adminHome = new AdminHome();
						this.setVisible(false);
						adminHome.setVisibility(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect Password!!!");
						return;
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unauthorized email!");
					return;
				}
			}
			else
			{
				JOptionPane.showMessageDialog(null, "please enter a valid email id");
				return;
			}
		}
	}

	private boolean validateEmail(String adminEmail) {
		// TODO Auto-generated method stub
		 String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		 boolean result = adminEmail.matches(regex);
		return result;
	}
}
