import java.awt.FlowLayout;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

public class searchByNumberDialog extends JDialog {
	private JTextField textFieldCountryCode;
	private JTextField textFieldNumber;
	private JTextArea textAreaSearchNumber;
	private String countryCode;

	/**
	 * Create the dialog.
	 */
	public searchByNumberDialog() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		getContentPane().setForeground(Color.BLACK);
		setTitle("Search By Number");
		setBounds(100, 100, 1000, 650);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setBounds(0, 578, 984, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton searchButton = new JButton("SEARCH");
				searchButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						searchMobile();
					}

				});
				searchButton.setActionCommand("OK");
				buttonPane.add(searchButton);
				getRootPane().setDefaultButton(searchButton);
			}
			/*
			 * { JButton cancelButton = new JButton("Cancel");
			 * cancelButton.setActionCommand("Cancel"); buttonPane.add(cancelButton); }
			 */
		}

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

		JLabel lblNewLabel = new JLabel("Enter the number");
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(212, 264, 206, 42);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(212, 367, 568, 156);
		getContentPane().add(scrollPane);

		textAreaSearchNumber = new JTextArea();
		scrollPane.setViewportView(textAreaSearchNumber);
		textAreaSearchNumber.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		JLabel lblSearchByNumber = new JLabel("Search By Number");
		lblSearchByNumber.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblSearchByNumber.setForeground(Color.WHITE);
		lblSearchByNumber.setBounds(364, 47, 236, 59);
		getContentPane().add(lblSearchByNumber);
		
		JLabel lblContentBg = new JLabel("");
		lblContentBg.setBackground(Color.LIGHT_GRAY);
		lblContentBg.setIcon(new ImageIcon("D:\\4ISE1JAVA\\File structures project\\water.jpg"));
		lblContentBg.setBounds(-113, -80, 1137, 691);
		getContentPane().add(lblContentBg);
	}

	private void searchMobile() {
		// TODO Auto-generated method stub
		textAreaSearchNumber.setText("");
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
		//
		File file = new File("D:\\4ISE1JAVA\\File structures project\\src\\data.txt");
		Scanner scanner = null;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HashMap<Long, String> names = new HashMap<>();
		RBTree tree = new RBTree(0);
		String finalToString = "";
		String countryName = "";
		while (scanner.hasNext()) {
			String country = scanner.next();
			long phoneNum = scanner.nextLong();
			String name = scanner.next();
			tree.insert(phoneNum);
			names.put(phoneNum, name);
		}
		scanner.close();
		//
		//
		long goodPhoneNumber = Long.parseLong((countryCode + restOfNumStr));
		int countryCodeInt = Integer.parseInt(countryCode);
		boolean isThere = tree.search(goodPhoneNumber);

		switch (countryCodeInt) {
		case (1):
					countryName = "USA/Canada";
					break;
		case (91):
					countryName = "India";
					break;
		case (52):
					countryName = "Mexico";
					break;
		case (61):
					countryName = "Australia";
					break;
		case (55):
					countryName = "Brazil";
					break;
		case (44):
					countryName = "England";
					break;
		case (81):
					countryName = "Japan";
					break;
		case (49):
					countryName = "Germany";
			break;

		default:
					countryName = "unlisted";
		}

		if (isThere) {
			finalToString += "Search Successful!\nCountry: " + countryName + "\n";
			String callerName = names.get(goodPhoneNumber);
			finalToString += "Caller Name: " + callerName + "\n";
			finalToString += "Phone Number: " + (countryCode + restOfNumStr) + "\n";
			textAreaSearchNumber.append(finalToString);
			// System.out.println(finalToString);
			// System.out.print("To begin new search, type \"begin\". Type \"exit\" to
			// quit.\n");
		} else {

			textAreaSearchNumber.append("The search was inconclusive,\nthe call originated from " + countryName+".");
		}

	}
}
