import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AdminHome {

	private JFrame frmAdminHome;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome window = new AdminHome();
					window.frmAdminHome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public AdminHome() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminHome = new JFrame();
		frmAdminHome.setTitle("Admin Home");
		frmAdminHome.setBounds(100, 100, 1000, 650);
		frmAdminHome.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdminHome.getContentPane().setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(198, 609, 786, -557);
		frmAdminHome.getContentPane().add(layeredPane);
		
		JLabel lblWhocalled = new JLabel("WHOCALLED?");
		lblWhocalled.setForeground(Color.WHITE);
		lblWhocalled.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhocalled.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 29));
		lblWhocalled.setBounds(359, 123, 246, 89);
		frmAdminHome.getContentPane().add(lblWhocalled);
		
		JButton btnAddDetails = new JButton("Add Details");
		btnAddDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddDataDialog ad = new AddDataDialog();
				ad.setModal(true);
				ad.setVisible(true);
			}
		});
		btnAddDetails.setBounds(117, 271, 246, 63);
		frmAdminHome.getContentPane().add(btnAddDetails);
		
		JButton btnDeleteDetails = new JButton("Delete Details");
		btnDeleteDetails.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteDataDialog deleteDataDialog = new DeleteDataDialog();
				deleteDataDialog.setModal(true);
				deleteDataDialog.setVisible(true);
			}
		});
		btnDeleteDetails.setBounds(610, 271, 246, 63);
		frmAdminHome.getContentPane().add(btnDeleteDetails);
		
		JButton btnNewButton = new JButton("View Details");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminViewAllData adminViewAllData = new AdminViewAllData();
				adminViewAllData.setModal(true);
				adminViewAllData.setVisible(true);
			}
		});
		btnNewButton.setBounds(117, 459, 246, 63);
		frmAdminHome.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modify Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyDataDialog modifyDataDialog = new ModifyDataDialog();
				modifyDataDialog.setModal(true);
				modifyDataDialog.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(610, 459, 246, 63);
		frmAdminHome.getContentPane().add(btnNewButton_1);
		
		JLabel lblContentBg = new JLabel("");
		lblContentBg.setBackground(Color.LIGHT_GRAY);
		lblContentBg.setIcon(new ImageIcon("D:\\4ISE1JAVA\\File structures project\\blackBoy.jpg"));
		lblContentBg.setBounds(-153, 0, 1137, 650);
		frmAdminHome.getContentPane().add(lblContentBg);
	}

	public void setVisibility(boolean b) {
		// TODO Auto-generated method stub
		try {
			AdminHome window = new AdminHome();
			window.frmAdminHome.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
