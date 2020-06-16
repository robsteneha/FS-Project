import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminViewAllData extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldFilterCountry;
	private FileHandlerImplementation fileHandlerImplementation;
	JTextArea textAreaViewDetails;
	private String format;
	private TreeMap<Long, LineContents> allLinesMap;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			AdminViewAllData dialog = new AdminViewAllData();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public AdminViewAllData() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("View Details");
		setBounds(100, 100, 1000, 650);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.BLACK);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton viewButton = new JButton("VIEW");
				viewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						viewDetails();
					}
				});
				viewButton.setActionCommand("OK");
				buttonPane.add(viewButton);
				getRootPane().setDefaultButton(viewButton);
			}
		}
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(110, 198, 766, 354);
		contentPanel.add(scrollPane);
		
		textAreaViewDetails = new JTextArea();
		textAreaViewDetails.setFont(new Font("Monospaced", Font.PLAIN, 14));
		scrollPane.setViewportView(textAreaViewDetails);
		
		textFieldFilterCountry = new JTextField();
		textFieldFilterCountry.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldFilterCountry.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		textFieldFilterCountry.setBounds(293, 132, 200, 35);
		contentPanel.add(textFieldFilterCountry);
		textFieldFilterCountry.setColumns(10);
		
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
		
		JLabel lblViewData = new JLabel("View Data");
		lblViewData.setHorizontalAlignment(SwingConstants.CENTER);
		lblViewData.setForeground(Color.WHITE);
		lblViewData.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblViewData.setBounds(412, 39, 212, 66);
		contentPanel.add(lblViewData);
		
		JLabel lblFilterByCountry = new JLabel("Filter by Country Name");
		lblFilterByCountry.setForeground(Color.WHITE);
		lblFilterByCountry.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblFilterByCountry.setBounds(530, 131, 166, 35);
		contentPanel.add(lblFilterByCountry);
		
		JLabel lblContentBg = new JLabel("");
		lblContentBg.setBackground(Color.LIGHT_GRAY);
		lblContentBg.setIcon(new ImageIcon("D:\\4ISE1JAVA\\File structures project\\water.jpg"));
		lblContentBg.setBounds(-115, 0, 1280, 720);
		contentPanel.add(lblContentBg);
	}

	protected void viewDetails() {
		// TODO Auto-generated method stub
		fileHandlerImplementation = new FileHandlerImplementation("data.txt");
		fileHandlerImplementation.initialize();
		allLinesMap = fileHandlerImplementation.getAllLines();
		format = " %1$-15s%2$-18s%3$-50s\n";
		textAreaViewDetails.setText("");
		
		//System.out.format(format,"Country", "Phone Number", "Name");
		String filteredCountryName = textFieldFilterCountry.getText().trim();
		if(filteredCountryName.isEmpty())
		{
			//show all details
			textAreaViewDetails.append(String.format(format, "Country", "Phone Number", "Name"));
			textAreaViewDetails.append(String.format(format, "-------", "------------", "----"));
			for (Entry<Long, LineContents> entry : allLinesMap.entrySet()) {
				//System.out.format(format,entry.getValue().getCountryName(), entry.getKey(), entry.getValue().getName());  
				textAreaViewDetails.append(String.format(format,entry.getValue().getCountryName(), entry.getKey(), entry.getValue().getName()));
			} 
			return;
		}
		else
		{
			//validate filtered country
			
			if(!isAllLetters(filteredCountryName))
			{
				JOptionPane.showMessageDialog(null, "Country name can only contain letters!");
				return;
			}
			
			//show details of filtered country
			switch (filteredCountryName.toLowerCase()) {
			case ("usa/canada"):
				
			case ("canada"):
						
			case ("usa"):
				
			case ("india"):
						
			case ("mexico"):

			case ("australia"):
						
			case ("brazil"):
						
			case ("england"):
						
			case ("japan"):
						
			case ("germany"): displayFilteredData(filteredCountryName);
								break;

			default:
				textAreaViewDetails.append(" Unlisted Country!");
				return;
			}
			
		}
		return;
	}
	
	private void displayFilteredData(String filteredCountryName) {
		// TODO Auto-generated method stub
		textAreaViewDetails.append(String.format(format, "Country", "Phone Number", "Name"));
		textAreaViewDetails.append(String.format(format, "-------", "------------", "----"));
		for (Entry<Long, LineContents> entry : allLinesMap.entrySet()) {
			if(filteredCountryName.equalsIgnoreCase(entry.getValue().getCountryName()
					)) 
			textAreaViewDetails.append(String.format(format,entry.getValue().getCountryName(), entry.getKey(), entry.getValue().getName()));
		} 
		return;
	}

	private boolean isAllLetters(String name) {
		char[] chars = name.toCharArray();

		for (char c : chars) {
			if (!Character.isLetter(c)) {
				if(c!='/') {
					return false;
				}
			}
		}

		return true;
	}
}
