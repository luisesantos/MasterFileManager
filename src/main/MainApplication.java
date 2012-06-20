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
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class MainApplication {

	private JFrame frame;
	private JTextField srcTextField;
	private JTable masterCreationTable;
	private JTable table_1;
	private JTextField masterFileSourceText;
	private JTextField txtScannedfiletext;
	private JTable maintenanceTable;
	private JTextField maintenanceSourceFile;
	private JTable fileToAddTable;
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
		
		JPanel masterFilePanel = new JPanel();
		tabbedPane.addTab("Master File", null, masterFilePanel, null);
		masterFilePanel.setLayout(new BorderLayout(0, 0));
		
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
		
		masterCreationTable = new JTable(data, columnNames);
		
		masterFilePanel.add(masterCreationTable, BorderLayout.CENTER);
		
		JPanel controlBarPanel = new JPanel();
		masterFilePanel.add(controlBarPanel, BorderLayout.SOUTH);
		
		JButton btnCreate = new JButton("Create");
		controlBarPanel.add(btnCreate);
		
		JButton btnCleanAll = new JButton("Clean All");
		controlBarPanel.add(btnCleanAll);
		
		JPanel findFileToAddPanel = new JPanel();
		masterFilePanel.add(findFileToAddPanel, BorderLayout.WEST);
		findFileToAddPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel findSourcePanel = new JPanel();
		findFileToAddPanel.add(findSourcePanel, BorderLayout.NORTH);
		
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
		
		JPanel addToMasterButtonPanel = new JPanel();
		findFileToAddPanel.add(addToMasterButtonPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Add To Master ->");
		addToMasterButtonPanel.add(btnNewButton);
		
		JPanel fileToAddTablePanel = new JPanel();
		findFileToAddPanel.add(fileToAddTablePanel, BorderLayout.CENTER);
		fileToAddTablePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		fileToAddTable = new JTable(data,columnNames);
		fileToAddTablePanel.add(fileToAddTable);
		
		JPanel separator = new JPanel();
		findFileToAddPanel.add(separator, BorderLayout.EAST);
		
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
		westMasterFileVerificationPanel.add(masterFileVerificationTable);
		
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
		tablePanel.setLayout(new BorderLayout(0, 0));
		
		scannedTable = new JTable(data,columnNames);
		tablePanel.add(scannedTable);
		
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
		centralResultPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel resultTablePanel = new JPanel();
		centralResultPanel.add(resultTablePanel, BorderLayout.NORTH);
		resultTablePanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		resultOneTable = new JTable(data,columnNames);
		resultTablePanel.add(resultOneTable);
		
		JPanel resultTablePanel2 = new JPanel();
		centralResultPanel.add(resultTablePanel2);
		resultTablePanel2.setLayout(new GridLayout(0, 2, 0, 0));
		
		resultTwoTable = new JTable(data,columnNames);
		resultTablePanel2.add(resultTwoTable);
		
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
		
		maintenanceTable = new JTable(data,columnNames);
		maintenancePanel.add(maintenanceTable, BorderLayout.CENTER);
		
		JPanel maintenanceControlBarPanel = new JPanel();
		maintenancePanel.add(maintenanceControlBarPanel, BorderLayout.SOUTH);
		
		JButton btnSave_1 = new JButton("Save");
		maintenanceControlBarPanel.add(btnSave_1);
	}
}
