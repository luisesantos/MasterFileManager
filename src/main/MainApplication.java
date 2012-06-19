package main;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainApplication {

	private JFrame frame;
	private JTextField srcTextField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication window = new MainApplication();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainApplication() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 669, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel welcomePanel = new JPanel();
		tabbedPane.addTab("Welcome", null, welcomePanel, null);
		welcomePanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel masterFilePanel = new JPanel();
		tabbedPane.addTab("Master File", null, masterFilePanel, null);
		GridBagLayout gbl_masterFilePanel = new GridBagLayout();
		gbl_masterFilePanel.rowHeights = new int[]{0, 302, 0};
		gbl_masterFilePanel.rowWeights = new double[]{0.0, 1.0, 1.0};
		gbl_masterFilePanel.columnWeights = new double[]{1.0};
		masterFilePanel.setLayout(gbl_masterFilePanel);
		
		GridBagConstraints gbc_findSourcePanel = new GridBagConstraints();
		gbc_findSourcePanel.insets = new Insets(0, 0, 5, 0);
		gbc_findSourcePanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_findSourcePanel.gridx = 0;
		gbc_findSourcePanel.gridy = 0;
		gbc_findSourcePanel.gridheight = 1;
		
		JPanel findSourcePanel = new JPanel();
		masterFilePanel.add(findSourcePanel, gbc_findSourcePanel);
		
		JLabel srcLabel = new JLabel("Source:");
		findSourcePanel.add(srcLabel);
		
		srcTextField = new JTextField();
		findSourcePanel.add(srcTextField);
		srcTextField.setColumns(10);
		
		JButton btnUpload = new JButton("Find");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		findSourcePanel.add(btnUpload);
		
		JButton btnFind = new JButton("Upload");
		findSourcePanel.add(btnFind);
		
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		
		table = new JTable(data, columnNames);
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 0);
		//gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		gbc_table.gridheight = 1;
		
		masterFilePanel.add(table, gbc_table);
		
		JPanel controlVarPanel = new JPanel();
		GridBagConstraints gbc_controlVarPanel = new GridBagConstraints();
		gbc_controlVarPanel.anchor = GridBagConstraints.EAST;
		gbc_controlVarPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_controlVarPanel.gridx = 0;
		gbc_controlVarPanel.gridy = 2;
		gbc_controlVarPanel.gridheight = 1;
		masterFilePanel.add(controlVarPanel, gbc_controlVarPanel);
		
		JPanel verificationPanel = new JPanel();
		tabbedPane.addTab("Scanned Files Verification", null, verificationPanel, null);
		
		JPanel maintenancePanel = new JPanel();
		tabbedPane.addTab("Maintenance", null, maintenancePanel, null);
	}
}
