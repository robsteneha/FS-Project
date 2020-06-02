import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class AddDataDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldCountry;
	private JTextField textFieldPhNo;
	private JTextField textFieldName;
	private JTextField textFieldResult;
	private String cName;
	private String phno;
	private String name;

	/**
	 * Create the dialog.
	 */
	public AddDataDialog() {
		setTitle("Add New Entry");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel CNameLabel = new JLabel("Country Name");
		CNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		CNameLabel.setForeground(new Color(255, 255, 240));
		CNameLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		CNameLabel.setBounds(185, 179, 216, 43);
		contentPanel.add(CNameLabel);

		JLabel PhNoLabel = new JLabel("Full Phone Number");
		PhNoLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		PhNoLabel.setForeground(new Color(255, 255, 255));
		PhNoLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		PhNoLabel.setBounds(185, 280, 216, 43);
		contentPanel.add(PhNoLabel);

		JLabel lblNewLabel_2 = new JLabel("Caller Name");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_2.setForeground(new Color(255, 255, 240));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(168, 385, 216, 43);
		contentPanel.add(lblNewLabel_2);

		textFieldCountry = new JTextField();
		textFieldCountry.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCountry.setBounds(430, 181, 367, 43);
		contentPanel.add(textFieldCountry);
		textFieldCountry.setColumns(10);

		textFieldPhNo = new JTextField();
		textFieldPhNo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPhNo.setBounds(430, 282, 367, 43);
		contentPanel.add(textFieldPhNo);
		textFieldPhNo.setColumns(10);

		textFieldName = new JTextField();
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setBounds(430, 385, 367, 43);
		contentPanel.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldResult = new JTextField();
		textFieldResult.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldResult.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		textFieldResult.setBounds(147, 490, 711, 59);
		contentPanel.add(textFieldResult);
		textFieldResult.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						addMore();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

		}
		
		JLabel lblAdmin = new JLabel("ADMIN");
		lblAdmin.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAdmin.setForeground(Color.WHITE);
		lblAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblAdmin.setBackground(Color.WHITE);
		lblAdmin.setBounds(854, 25, 103, 29);
		contentPanel.add(lblAdmin);
		
		JLabel lblWhocalled = new JLabel("WHOCALLED?");
		lblWhocalled.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 34));
		lblWhocalled.setForeground(Color.WHITE);
		lblWhocalled.setBounds(21, 11, 260, 66);
		contentPanel.add(lblWhocalled);
		
		JLabel lblAddDetails = new JLabel("ADD DETAILS");
		lblAddDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddDetails.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblAddDetails.setForeground(Color.WHITE);
		lblAddDetails.setBounds(404, 79, 206, 43);
		contentPanel.add(lblAddDetails);
		
		JLabel lblContentBg = new JLabel("");
		lblContentBg.setBackground(Color.LIGHT_GRAY);
		lblContentBg.setIcon(new ImageIcon("D:\\4ISE1JAVA\\File structures project\\water.jpg"));
		lblContentBg.setBounds(0, -80, 1137, 878);
		contentPanel.add(lblContentBg);
	}

	private void addMore() {
		textFieldResult.setText("");
		cName = textFieldCountry.getText().trim();
		if (cName.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter the country name");
			return;
		}
		if (!isAllLetters(cName)) {
			JOptionPane.showMessageDialog(null, "please enter a valid country name");
			return;
		}

		phno = textFieldPhNo.getText().trim();
		if (phno.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter the phone number");
			return;
		}
		
		if (!(phno.length() == 12)) {
			if((phno.length()==11) && (phno.charAt(0)==1))
			{
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "please enter a valid phone number");
				return;
			}
		}

		name = textFieldName.getText().trim();
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter the name");
			return;
		}
		if (!isAllLetters(name)) {
			JOptionPane.showMessageDialog(null, "please enter a valid name");
			return;
		}

		String finalToString = cName + " " + phno + " " + name;
		File file = new File("D:\\4ISE1JAVA\\File structures project\\src\\data.txt");
		FileWriter fr = null;
		try {
			fr = new FileWriter(file, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter br = new BufferedWriter(fr);
		PrintWriter pr = new PrintWriter(br);
		pr.println(finalToString);
		try {
			pr.close();
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textFieldResult.setText("New Phone Entry Successfully added to the database!");

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
