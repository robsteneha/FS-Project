import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class RegistrationDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldCountryCode;
	private JTextField textFieldPhoneNumber;
	private JPasswordField confirmPasswordField;
	private JPasswordField passwordField;
	private String name;
	private String phoneNumber;
	private String email;
	private String countryCode;
	private String password;
	private String confirmPassword;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			RegistrationDialog dialog = new RegistrationDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public RegistrationDialog() {
		setTitle("User Registration");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
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
			lblWhocalled.setBounds(24, 22, 253, 54);
			contentPanel.add(lblWhocalled);
		}
		{
			JLabel lblRegistration = new JLabel("Registeration");
			lblRegistration.setForeground(Color.WHITE);
			lblRegistration.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistration.setFont(new Font("Times New Roman", Font.BOLD, 25));
			lblRegistration.setBounds(406, 98, 164, 44);
			contentPanel.add(lblRegistration);
		}
		{
			textFieldName = new JTextField();
			textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldName.setBounds(445, 208, 220, 32);
			contentPanel.add(textFieldName);
			textFieldName.setColumns(10);
		}
		{
			textFieldEmail = new JTextField();
			textFieldEmail.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldEmail.setBounds(445, 267, 220, 32);
			contentPanel.add(textFieldEmail);
			textFieldEmail.setColumns(10);
		}
		{
			textFieldCountryCode = new JTextField();
			textFieldCountryCode.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldCountryCode.setBounds(445, 324, 220, 32);
			contentPanel.add(textFieldCountryCode);
			textFieldCountryCode.setColumns(10);
		}
		{
			textFieldPhoneNumber = new JTextField();
			textFieldPhoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldPhoneNumber.setBounds(445, 381, 220, 32);
			contentPanel.add(textFieldPhoneNumber);
			textFieldPhoneNumber.setColumns(10);
		}
		{
			confirmPasswordField = new JPasswordField();
			confirmPasswordField.setHorizontalAlignment(SwingConstants.CENTER);
			confirmPasswordField.setBounds(445, 487, 220, 32);
			contentPanel.add(confirmPasswordField);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setHorizontalAlignment(SwingConstants.CENTER);
			passwordField.setBounds(445, 437, 220, 32);
			contentPanel.add(passwordField);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 0, 0, 220));
			panel.setBounds(193, 162, 592, 405);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblEnterYourEmail = new JLabel("Enter your email");
				lblEnterYourEmail.setForeground(Color.WHITE);
				lblEnterYourEmail.setBounds(69, 104, 139, 32);
				panel.add(lblEnterYourEmail);
				lblEnterYourEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblEnterYourEmail.setHorizontalAlignment(SwingConstants.TRAILING);
			}
			{
				JLabel lblEnterYourCountryCode = new JLabel("Enter your country code");
				lblEnterYourCountryCode.setForeground(Color.WHITE);
				lblEnterYourCountryCode.setBounds(69, 164, 139, 27);
				panel.add(lblEnterYourCountryCode);
				lblEnterYourCountryCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblEnterYourCountryCode.setHorizontalAlignment(SwingConstants.TRAILING);
			}
			{
				JLabel lblEnterYourPhoneNumber = new JLabel("Enter your phone number");
				lblEnterYourPhoneNumber.setForeground(Color.WHITE);
				lblEnterYourPhoneNumber.setBounds(10, 218, 198, 32);
				panel.add(lblEnterYourPhoneNumber);
				lblEnterYourPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblEnterYourPhoneNumber.setHorizontalAlignment(SwingConstants.TRAILING);
			}
			{
				JLabel lblEnterYourPassword = new JLabel("Enter your password");
				lblEnterYourPassword.setForeground(Color.WHITE);
				lblEnterYourPassword.setBounds(44, 274, 164, 32);
				panel.add(lblEnterYourPassword);
				lblEnterYourPassword.setHorizontalAlignment(SwingConstants.TRAILING);
				lblEnterYourPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
			}
			{
				JLabel lblConfirmPassword = new JLabel("Confirm password");
				lblConfirmPassword.setForeground(Color.WHITE);
				lblConfirmPassword.setBounds(32, 317, 176, 38);
				panel.add(lblConfirmPassword);
				lblConfirmPassword.setHorizontalAlignment(SwingConstants.TRAILING);
				lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
			}
			{
				JLabel lblEnterYourName = new JLabel("Enter your name");
				lblEnterYourName.setForeground(Color.WHITE);
				lblEnterYourName.setBounds(69, 45, 139, 32);
				panel.add(lblEnterYourName);
				lblEnterYourName.setHorizontalAlignment(SwingConstants.TRAILING);
				lblEnterYourName.setFont(new Font("Tahoma", Font.PLAIN, 13));
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("REGISTER");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						registerUser();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		
		JLabel lblContentBg = new JLabel("");
		lblContentBg.setBackground(UIManager.getColor("Button.background"));
		lblContentBg.setIcon(new ImageIcon("D:\\4ISE1JAVA\\File structures project\\blackBoy.jpg"));
		lblContentBg.setBounds(-153, 0, 1137, 650);
		contentPanel.add(lblContentBg);
	}

	protected void registerUser() {
		// TODO Auto-generated method stub
		name = textFieldName.getText().trim();
		if(name.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Enter a name");
			return;
		}
		if (!isAllLetters(name)) {
			JOptionPane.showMessageDialog(null, "please enter a valid name");
			return;
		}
		email = textFieldEmail.getText().trim();
		if(email.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Enter an email id");
			return;
		}
		else
		{
			if(!validateEmail(email))
			{
				JOptionPane.showMessageDialog(null, "Enter a valid email id");
				return;
			}
		}
		countryCode = textFieldCountryCode.getText().trim();
		if(countryCode.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Enter a Country Code");
			return;
		}
		else if(countryCode.length()>2)
		{
			JOptionPane.showMessageDialog(null, "Enter a valid Country Code");
			return;
		}
		phoneNumber = textFieldPhoneNumber.getText().trim();
		if(phoneNumber.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Enter a phone number");
			return;
		}
		else if(phoneNumber.length()!=10)
		{
			JOptionPane.showMessageDialog(null, "Enter a valid phone number");
			return;
		}
		password = String.valueOf(passwordField.getPassword());
		if(password.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Password can't be empty");
			return;
		}
		confirmPassword = String.valueOf(confirmPasswordField.getPassword());
		if(confirmPassword.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Confirm password can't be empty");
			return;
		}
		if(password.equals(confirmPassword))
		{
			//add the details
			String finalToStringToAddToUsers = email + "," + password + "," + name + "," + countryCode + phoneNumber;
			String finalToStringToAddToData = findCountry(countryCode) + " " + countryCode + phoneNumber + " " + name;
			File file = new File("D:\\4ISE1JAVA\\File structures project\\src\\data.txt");
			FileWriter fr = null;
			try {
				fr = new FileWriter(file, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			BufferedWriter br = new BufferedWriter(fr);
			PrintWriter pr = new PrintWriter(br);
			pr.println(finalToStringToAddToData);
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//adding data to users
			file = new File("D:\\4ISE1JAVA\\File structures project\\src\\users.txt");
			fr = null;
			try {
				fr = new FileWriter(file, true);
			} catch (IOException e) {
				e.printStackTrace();
			}
			br = new BufferedWriter(fr);
			pr = new PrintWriter(br);
			pr.println(finalToStringToAddToUsers);
			try {
				pr.close();
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			dispose();
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Confirm Password is not the same as Password!");
			return;
		}
	}
	private String findCountry(String countryCode) {
		// TODO Auto-generated method stub
		String country;
		int countryCodeInt = Integer.parseInt(countryCode);
		switch (countryCodeInt) {
		case (1):
			country = "USA/Canada";
					break;
		case (91):
			country = "India";
					break;
		case (52):
			country = "Mexico";
					break;
		case (61):
			country = "Australia";
					break;
		case (55):
			country = "Brazil";
					break;
		case (44):
			country = "England";
					break;
		case (81):
			country = "Japan";
					break;
		case (49):
			country = "Germany";
			break;

		default:
			country = "unlisted";
		}
		return country;
	}

	private boolean validateEmail(String adminEmail) {
		// TODO Auto-generated method stub
		 String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		 boolean result = adminEmail.matches(regex);
		return result;
	}
	
	private boolean isAllLetters(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c)) {
				return false;
			}
		}

		return true;
	}
}
