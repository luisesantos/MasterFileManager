package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import main.panels.MasterFileMainPanel;

public class MainApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField masterFileSourceText;
	private JTextField txtScannedfiletext;
	private JTable maintenanceTable;
	private JTextField maintenanceSourceFile;
	private JTable scannedTable;
	private JTable masterFileVerificationTable;
	private JTable resultOneTable;
	private JTable resultTwoTable;

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
		tabbedPane.addTab("New tab", null, welcomePanel, null);
		
		MasterFileMainPanel masterFilePanel = new MasterFileMainPanel();
		tabbedPane.addTab("Master File", null, masterFilePanel, null);
		
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
		
		
		JPanel verificationPanel = new JPanel();
		tabbedPane.addTab("Scanned Files Verification", null, verificationPanel, null);
		verificationPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel controlVerificationBarPanel = new JPanel();
		verificationPanel.add(controlVerificationBarPanel, BorderLayout.SOUTH);
		
		JButton btnSave = new JButton("Save");
		controlVerificationBarPanel.add(btnSave);
		
		JPanel masterFileWestPanel = new JPanel();
		verificationPanel.add(masterFileWestPanel, BorderLayout.WEST);
		masterFileWestPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel masterFileVerificationPanel = new JPanel();
		masterFileWestPanel.add(masterFileVerificationPanel, BorderLayout.NORTH);
		
		JLabel lblSource = new JLabel("Master:");
		masterFileVerificationPanel.add(lblSource);
		
		masterFileSourceText = new JTextField();
		masterFileVerificationPanel.add(masterFileSourceText);
		masterFileSourceText.setColumns(10);
		
		JButton btnFind_1 = new JButton("Find");
		masterFileVerificationPanel.add(btnFind_1);
		
		JPanel westMasterFileVerificationPanel = new JPanel();
		masterFileWestPanel.add(westMasterFileVerificationPanel, BorderLayout.CENTER);
		westMasterFileVerificationPanel.setLayout(new BorderLayout(0, 0));
		
		masterFileVerificationTable = new JTable(data,columnNames);
		westMasterFileVerificationPanel.add(masterFileVerificationTable.getTableHeader(),BorderLayout.PAGE_START);
		westMasterFileVerificationPanel.add(masterFileVerificationTable,BorderLayout.CENTER);
		
		JPanel separatorPanel = new JPanel();
		westMasterFileVerificationPanel.add(separatorPanel, BorderLayout.EAST);
		
		JPanel scannedVerificationPanel = new JPanel();
		verificationPanel.add(scannedVerificationPanel, BorderLayout.CENTER);
		scannedVerificationPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel scannedFileVerificationPanel = new JPanel();
		scannedVerificationPanel.add(scannedFileVerificationPanel, BorderLayout.NORTH);
		
		JLabel lblScanned = new JLabel("Scanned");
		scannedFileVerificationPanel.add(lblScanned);
		
		txtScannedfiletext = new JTextField();
		scannedFileVerificationPanel.add(txtScannedfiletext);
		txtScannedfiletext.setColumns(10);
		
		JButton btnFind_2 = new JButton("Find");
		scannedFileVerificationPanel.add(btnFind_2);
		
		JPanel tablePanel = new JPanel();
		scannedVerificationPanel.add(tablePanel, BorderLayout.CENTER);
		tablePanel.setLayout(new BorderLayout());
		
		scannedTable = new JTable(data,columnNames);
		tablePanel.add(scannedTable.getTableHeader(),BorderLayout.PAGE_START);
		tablePanel.add(scannedTable,BorderLayout.CENTER);
		
		JPanel separatorPanel2 = new JPanel();
		scannedVerificationPanel.add(separatorPanel2, BorderLayout.EAST);
		
		JPanel resultPanel = new JPanel();
		verificationPanel.add(resultPanel, BorderLayout.EAST);
		resultPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel verifyButtonPanel = new JPanel();
		resultPanel.add(verifyButtonPanel,BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Verify");
		verifyButtonPanel.add(btnNewButton_1);
		
		JPanel centralResultPanel = new JPanel();
		resultPanel.add(centralResultPanel, BorderLayout.CENTER);
		centralResultPanel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel resultTablePanel = new JPanel();
		centralResultPanel.add(resultTablePanel);
		resultTablePanel.setLayout(new BorderLayout());
		
		resultOneTable = new JTable(data,columnNames);
		resultOneTable.setFillsViewportHeight(true);
		resultTablePanel.add(resultOneTable.getTableHeader(),BorderLayout.PAGE_START);
		resultTablePanel.add(resultOneTable,BorderLayout.CENTER);
		
		JPanel resultTablePanel2 = new JPanel();
		centralResultPanel.add(resultTablePanel2);
		resultTablePanel2.setLayout(new BorderLayout());
		
		resultTwoTable = new JTable(data,columnNames);
		resultTwoTable.setFillsViewportHeight(true);
		resultTablePanel2.add(resultTwoTable.getTableHeader(),BorderLayout.PAGE_START);
		resultTablePanel2.add(resultTwoTable,BorderLayout.CENTER);
		
		JPanel maintenancePanel = new JPanel();
		tabbedPane.addTab("Maintenance", null, maintenancePanel, null);
		maintenancePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel maintenanceSourceFilePanel = new JPanel();
		maintenancePanel.add(maintenanceSourceFilePanel, BorderLayout.NORTH);
		
		JLabel lblSourceFile = new JLabel("Source File: ");
		maintenanceSourceFilePanel.add(lblSourceFile);
		
		maintenanceSourceFile = new JTextField();
		maintenanceSourceFilePanel.add(maintenanceSourceFile);
		maintenanceSourceFile.setColumns(10);
		
		JButton btnFind_3 = new JButton("Find");
		maintenanceSourceFilePanel.add(btnFind_3);
		
		JPanel maintenanceControlBarPanel = new JPanel();
		maintenancePanel.add(maintenanceControlBarPanel, BorderLayout.SOUTH);
		
		JButton btnSave_1 = new JButton("Save");
		maintenanceControlBarPanel.add(btnSave_1);
		
		JPanel maintenanceTablePanel = new JPanel();
		maintenancePanel.add(maintenanceTablePanel, BorderLayout.CENTER);
		maintenanceTablePanel.setLayout(new BorderLayout(0, 0));
		
		maintenanceTable = new JTable(data,columnNames);
		maintenanceTablePanel.add(maintenanceTable.getTableHeader(),BorderLayout.PAGE_START);
		maintenanceTablePanel.add(maintenanceTable,BorderLayout.CENTER);
	}
}
