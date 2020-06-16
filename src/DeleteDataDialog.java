import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class DeleteDataDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textAreaDeleteResult;
	private JTextField textFieldNumber;
	private JTextField textFieldCountryCode;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			DeleteDataDialog dialog = new DeleteDataDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public DeleteDataDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Delete Details");
		setBounds(100, 100, 1000, 650);
		this.setLocationRelativeTo(null);
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
				JButton deleteButton = new JButton("DELETE");
				deleteButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						deleteData();
					}
				});
				deleteButton.setActionCommand("OK");
				buttonPane.add(deleteButton);
				getRootPane().setDefaultButton(deleteButton);
			}
		}
		
		{
			JLabel lblDeleteDetails = new JLabel("Delete Details");
			lblDeleteDetails.setHorizontalAlignment(SwingConstants.CENTER);
			lblDeleteDetails.setForeground(Color.WHITE);
			lblDeleteDetails.setFont(new Font("Times New Roman", Font.BOLD, 27));
			lblDeleteDetails.setBounds(382, 55, 228, 54);
			getContentPane().add(lblDeleteDetails);
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
		textFieldCountryCode.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCountryCode.setBounds(458, 171, 275, 49);
		getContentPane().add(textFieldCountryCode);
		textFieldCountryCode.setColumns(10);

		textFieldNumber = new JTextField();
		textFieldNumber.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNumber.setBounds(458, 257, 275, 49);
		getContentPane().add(textFieldNumber);
		textFieldNumber.setColumns(10);

		JLabel lblEnterNumber = new JLabel("Enter the number");
		lblEnterNumber.setForeground(new Color(245, 255, 250));
		lblEnterNumber.setBackground(new Color(255, 255, 255));
		lblEnterNumber.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblEnterNumber.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEnterNumber.setBounds(212, 264, 206, 42);
		getContentPane().add(lblEnterNumber);

		textAreaDeleteResult = new JTextArea();
		textAreaDeleteResult.setFont(new Font("Monospaced", Font.PLAIN, 22));
		textAreaDeleteResult.setBounds(212, 367, 568, 156);
		getContentPane().add(textAreaDeleteResult);
		
		{
			JLabel lblContentBg = new JLabel("");
			lblContentBg.setBackground(Color.LIGHT_GRAY);
			lblContentBg.setIcon(new ImageIcon("D:\\4ISE1JAVA\\File structures project\\water.jpg"));
			lblContentBg.setBounds(0, 0, 984, 578);
			getContentPane().add(lblContentBg);
		}
		
	}

	protected void deleteData() {
		// TODO Auto-generated method stub
		textAreaDeleteResult.setText("");
		String countryCode = textFieldCountryCode.getText().trim();
		if (countryCode.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter country code");
			return;
		}
		if (Integer.parseInt(countryCode) >= 100 || Integer.parseInt(countryCode) <=0) {
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
		
		//String goodPhoneNumber = (countryCode + restOfNumStr);
		long goodPhoneNumber = Long.parseLong((countryCode + restOfNumStr));
		boolean foundNumber = false;
		try {
			BufferedReader file = new BufferedReader(new FileReader("D:\\4ISE1JAVA\\File structures project\\src\\data.txt"));
			StringBuffer inputBuffer = new StringBuffer();
	        String line;
	        
	        while ((line = file.readLine()) != null) {
	            // replace the line here
	        	String[] s = line.split(" ");
	        	if(Long.parseLong(s[1])==goodPhoneNumber)
	        	{
	        		foundNumber = true;
	        		continue;
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
			textAreaDeleteResult.append("Record deleted successfully!");
		} else {
			textAreaDeleteResult.append("Phone number doesn't exist in database.");
		}
		return;
	}
}
