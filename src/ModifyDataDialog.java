import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class ModifyDataDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCountryCode;
	private JTextField textFieldNumber;
	private JTextArea textAreaModifyResult;
	private String countryCode;
	private JTextField textFieldName;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ModifyDataDialog dialog = new ModifyDataDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ModifyDataDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Modify Data");
		setBounds(100, 100, 1000, 650);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 578, 984, 33);
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton modifyButton = new JButton("MODIFY");
				modifyButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						modifyData();
					}
				});
				modifyButton.setActionCommand("OK");
				buttonPane.add(modifyButton);
				getRootPane().setDefaultButton(modifyButton);
			}
		}
		{
			JLabel lblModifyDetails = new JLabel("Modify Details");
			lblModifyDetails.setHorizontalAlignment(SwingConstants.CENTER);
			lblModifyDetails.setForeground(Color.WHITE);
			lblModifyDetails.setFont(new Font("Times New Roman", Font.BOLD, 27));
			lblModifyDetails.setBounds(382, 54, 228, 54);
			getContentPane().add(lblModifyDetails);
		}
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAdmin.setBackground(Color.WHITE);
		lblAdmin.setBounds(854, 25, 103, 29);
		getContentPane().add(lblAdmin);
		
		JLabel lblWhocalled = new JLabel("WHOCALLED?");
		lblWhocalled.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblWhocalled.setForeground(Color.WHITE);
		lblWhocalled.setBounds(21, 11, 260, 66);
		getContentPane().add(lblWhocalled);
		
		JLabel lblEnterTheCounty = new JLabel("Enter the County Code");
		lblEnterTheCounty.setForeground(new Color(255, 255, 255));
		lblEnterTheCounty.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblEnterTheCounty.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnterTheCounty.setBounds(212, 178, 206, 33);
		getContentPane().add(lblEnterTheCounty);

		textFieldCountryCode = new JTextField();
		textFieldCountryCode.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldCountryCode.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCountryCode.setBounds(458, 171, 275, 49);
		getContentPane().add(textFieldCountryCode);
		textFieldCountryCode.setColumns(10);

		textFieldNumber = new JTextField();
		textFieldNumber.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldNumber.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumber.setBounds(458, 257, 275, 49);
		getContentPane().add(textFieldNumber);
		textFieldNumber.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldName.setBounds(458, 360, 275, 49);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblEnterNumber = new JLabel("Enter the number");
		lblEnterNumber.setForeground(new Color(245, 255, 250));
		lblEnterNumber.setBackground(new Color(255, 255, 255));
		lblEnterNumber.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEnterNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnterNumber.setBounds(212, 264, 206, 42);
		getContentPane().add(lblEnterNumber);

		textAreaModifyResult = new JTextArea();
		textAreaModifyResult.setFont(new Font("Monospaced", Font.PLAIN, 22));
		textAreaModifyResult.setBounds(212, 463, 568, 84);
		getContentPane().add(textAreaModifyResult);
		
		JLabel lblEnterNewName = new JLabel("Enter new Name");
		lblEnterNewName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnterNewName.setForeground(Color.WHITE);
		lblEnterNewName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEnterNewName.setBounds(212, 360, 206, 49);
		getContentPane().add(lblEnterNewName);
		
		{
			JLabel lblContentBg = new JLabel("");
			lblContentBg.setBackground(Color.LIGHT_GRAY);
			lblContentBg.setIcon(new ImageIcon("D:\\4ISE1JAVA\\File structures project\\water.jpg"));
			lblContentBg.setBounds(0, 0, 984, 578);
			getContentPane().add(lblContentBg);
		}
	}

	protected void modifyData() {
		// TODO Auto-generated method stub
		//input validation
		textAreaModifyResult.setText("");
		countryCode = textFieldCountryCode.getText().trim();
		if (countryCode.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter country code");
			return;
		}
		if (countryCode.length() != 2) {
			JOptionPane.showMessageDialog(null, "please enter a valid country code");
			return;
		}
		String restOfNumStr = textFieldNumber.getText().trim();
		if (restOfNumStr.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter phone number");
			return;
		}
		if (restOfNumStr.length() != 10) {
			JOptionPane.showMessageDialog(null, "please enter a valid phone number");
			return;
		}
		String newName = textFieldName.getText().trim();
		if (newName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter a new Name");
			return;
		}
		if (!isAllLetters(newName)) {
			JOptionPane.showMessageDialog(null, "Name can only contain letters");
			return;
		}
		String goodPhoneNumber = (countryCode + restOfNumStr);
		boolean foundNumber = false;
		try {
			BufferedReader file = new BufferedReader(new FileReader("D:\\4ISE1JAVA\\File structures project\\src\\data.txt"));
			StringBuffer inputBuffer = new StringBuffer();
	        String line;
	        
	        while ((line = file.readLine()) != null) {
	            // replace the line here
	        	String[] s = line.split(" ");
	        	if(s[1].equals(goodPhoneNumber))
	        	{
	        		foundNumber = true;
	        		line = s[0]+" "+s[1]+" "+newName;
	        	}
	            inputBuffer.append(line);
	            inputBuffer.append('\n');
	        }
	        file.close();

	        // write the new string with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("D:\\4ISE1JAVA\\File structures project\\src\\data.txt");
	        fileOut.write(inputBuffer.toString().getBytes());
	        fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(foundNumber) {
			textAreaModifyResult.append("Details modified successfully!");
		} else {
			textAreaModifyResult.append("Phone number doesn't exist in database.");
		}
		return;
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
