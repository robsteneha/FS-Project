import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UserLoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldUsername;
	private JPasswordField passwordField;
	private String userEmail;
	private String password;
	private String passwordFoundInFile;
	private String nameFoundInFile;
	boolean emailFound;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			UserLoginDialog dialog = new UserLoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public UserLoginDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("User Login");
		setBounds(100, 100, 1000, 650);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblWhocalled = new JLabel("WHOCALLED?");
			lblWhocalled.setForeground(Color.WHITE);
			lblWhocalled.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
			lblWhocalled.setBounds(34, 23, 278, 44);
			contentPanel.add(lblWhocalled);
		}
		{
			JLabel lblNewLabel = new JLabel("User Login");
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
			JLabel lblDontHaveAn = new JLabel("Don't have an account?");
			lblDontHaveAn.setForeground(Color.WHITE);
			lblDontHaveAn.setHorizontalAlignment(SwingConstants.TRAILING);
			lblDontHaveAn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			lblDontHaveAn.setBounds(320, 490, 240, 14);
			contentPanel.add(lblDontHaveAn);
		}
		{
			JButton btnRegister = new JButton("Register");
			btnRegister.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//TODO open the register Dialog
					RegistrationDialog resgitrationDialog = new RegistrationDialog();
					resgitrationDialog.setModal(true);
					resgitrationDialog.setVisible(true);
				}
			});
			btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 17));
			btnRegister.setBounds(570, 482, 121, 29);
			contentPanel.add(btnRegister);
		}
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
						loginUser();
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

	private void loginUser() {
		// TODO Auto-generated method stub
		userEmail = textFieldUsername.getText().trim();
		if (userEmail.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter an email id");
			return;
		}
		else
		{
			//email id is valid 
			if(validateEmail(userEmail))
			{
				password = String.valueOf(passwordField.getPassword());
				if(password.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Password is empty");
					return;
				}
				//create hashmap
				Stream<String> lines = null;
				try {
					lines = Files.lines(Paths.get("D:\\4ISE1JAVA\\File structures project\\src\\users.txt"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				passwordFoundInFile="";
				nameFoundInFile="";
				emailFound=false;
				if(lines!=null)
				{
					lines.forEach(line -> {
						  // Do anything line by line 
						String[] p = line.split(",");
						if(p[0].equals(userEmail))
						{
							passwordFoundInFile=p[1];
							nameFoundInFile=p[2];
							emailFound=true;
						}
						});
				}
				//email is found
				if(emailFound)
				{
					//System.out.println(password+" "+adminLogins.get(adminEmail)+":"+adminLogins.get(adminEmail).equals(password));
					if(passwordFoundInFile.equals(password))
					{
						//successfullLogin
						UserHomeFrm userHome = new UserHomeFrm(nameFoundInFile);
						this.setVisible(false);
						userHome.setVisibility(true);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Incorrect Password!!!");
						return;
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Unregistered email!");
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
